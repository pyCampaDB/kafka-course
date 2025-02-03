package com.pycampadb.kafka;

import io.confluent.ksql.function.udaf.Udaf;
import io.confluent.ksql.function.udaf.UdafDescription;
import io.confluent.ksql.function.udaf.UdafFactory;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

@UdafDescription(
        name = "loan_rating",
        category = "LOAN",
        author = "Spring & Kafka Bootcamp by @pyCampaDB",
        version = "5.0.0",
        description = "User defined function for sample tabular loan business logic"
)
public class LoanUdaf {
    private LoanUdaf(){

    }

    private static final String GOOD_PAYMENT = "goodPayment";
    private static final String BAD_PAYMENT = "badPayment";
    public static final String LOAN_SUBMISSION_SCHEMA_DESCRIPTOR = "STRUCT<" +
            "`principalLoanAmount` DOUBLE, " +
            "`annualInterestRate` DOUBLE, " +
            "`loanPeriodMonth` INT, " +
            "`loanApprovedDate` VARCHAR" +
            ">";

    private static final String AGGREGATE_SCHEMA_DESCRIPTOR = "STRUCT<`goodPayment` INT, `badPayment` INT>";

    private static final Schema AGGREGATE_SCHEMA = SchemaBuilder
            .struct()
            .optional()
            .field(GOOD_PAYMENT, Schema.OPTIONAL_INT32_SCHEMA)
            .field(BAD_PAYMENT, Schema.OPTIONAL_INT32_SCHEMA)
            .build();

    @UdafFactory(
            description = "Compute loan rating based on payment latency. The smaller the latency, the better.",
            aggregateSchema = AGGREGATE_SCHEMA_DESCRIPTOR
    )
    public static Udaf<Integer, Struct, String> createUdaf() {
        return new LoanUdafImpl();
    }

    private static class LoanUdafImpl implements Udaf<Integer, Struct, String> {

        @Override
        public Struct initialize() {
            var initializer = new Struct(AGGREGATE_SCHEMA);

            initializer.put(GOOD_PAYMENT, 0);
            initializer.put(BAD_PAYMENT, 0);

            return initializer;
        }

        @Override
        public Struct aggregate(Integer current, Struct aggregate) {
            if (current <= 0){
                var currentGoodPayment = aggregate.getInt32(GOOD_PAYMENT);
                aggregate.put(GOOD_PAYMENT, (currentGoodPayment + 1));
            } else {
                var currentBadPayment = aggregate.getInt32(BAD_PAYMENT);
                aggregate.put(BAD_PAYMENT, (currentBadPayment + 1));
            }
            return aggregate;
        }

        @Override
        public Struct merge(Struct aggOne, Struct aggTwo) {
            return aggOne;
        }

        @Override
        public String map(Struct agg) {
            var goodPayment = (double) agg.getInt32(GOOD_PAYMENT);
            var badPayment = (double) agg.getInt32(BAD_PAYMENT);
            var totalPayment = goodPayment + badPayment;

            var goodPaymentPercentage = (goodPayment/totalPayment) * 100d;

            if (goodPaymentPercentage <= 25)
                return "VERY BAD : " + LoanCalculator.round(goodPaymentPercentage, 2) + "%";
            else if (goodPaymentPercentage <= 50)
                return "BAD : " + LoanCalculator.round(goodPaymentPercentage, 2) + "%";
            else if (goodPaymentPercentage <= 75)
                return "MODERATE : " + LoanCalculator.round(goodPaymentPercentage, 2) + "%";
            else
                return "GOOD : " + LoanCalculator.round(goodPaymentPercentage, 2) + "%";
        }
    }
}
