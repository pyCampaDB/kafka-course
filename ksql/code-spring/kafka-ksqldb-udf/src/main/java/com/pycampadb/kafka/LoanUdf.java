package com.pycampadb.kafka;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(
        name = "loan_installment",
        category = "LOAN",
        author = "Spring & Kafka Bootcamp by @pyCampaDB",
        version = "5.0.0",
        description = "User defined function for sample scalar loan business logic"
)
public class LoanUdf {
    private static final String BASE_DESCRIPTION = "Estimate monthly loan installment for loan principal amount X, " +
            "with loan interest rate per year is Y %, over loan period Z month(s), " +
            "roundest to 2 digit decimal. All parameters are mandatory and can only " +
            "accept value greater than 1";
    @Udf(description = BASE_DESCRIPTION)
    public double estimateMonthlyLoanInstallment(
            @UdfParameter(description = "Loan principal amount") double principalLoanAmount,
            @UdfParameter(description = "Annual interest rate (in percent)") double annualInterestRate,
            @UdfParameter(description = "Loan period in month") int loanPeriodMonth
    ) {
        return LoanCalculator.calculateMonthlyInstallment(principalLoanAmount, annualInterestRate, loanPeriodMonth);
    }

    @Udf(description =BASE_DESCRIPTION + ". This assume the loan period is 12 months.")
    public double estimateMonthlyLoanInstallment(
            @UdfParameter (description = "Loan principal amount") double principalLoanAmount,
            @UdfParameter (description = "Annual interest rate (in percent)") double annualInterestRate
    ) {
        return LoanCalculator.calculateMonthlyInstallment(principalLoanAmount, annualInterestRate, 12);
    }
}
