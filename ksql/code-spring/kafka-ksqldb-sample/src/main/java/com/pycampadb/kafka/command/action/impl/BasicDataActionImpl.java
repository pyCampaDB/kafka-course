package com.pycampadb.kafka.command.action.impl;

import com.pycampadb.kafka.api.request.*;
import com.pycampadb.kafka.broker.message.*;
import com.pycampadb.kafka.broker.producer.BasicDataProducer;
import com.pycampadb.kafka.command.action.BasicDataAction;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Component
public class BasicDataActionImpl implements BasicDataAction {
    private static final ZoneOffset ZONE_OFFSET = ZoneOffset.of(
            ZoneId.of("Europe/Madrid")
                    .getRules()
                    .getOffset(LocalDateTime.now())
                    .getId()
    );
    private final BasicDataProducer producer;

    public BasicDataActionImpl(BasicDataProducer producer) {
        this.producer = producer;
    }


    @Override
    public void deleteBasicDataCountry(String countryName) {
        producer.sendBasicDataCountryWithNullValue(countryName);
    }

    @Override
    public void publishBasicDataCountry(BasicDataCountryRequest request) {
        var message = toBasicCountryMessage(request);
        producer.sendBasicDataCountry(message);
    }

    @Override
    public void publishBasicDataFive(BasicDataFiveRequest request) {
        var message = toBasicFiveMessage(request);
        producer.sendBasicDataFive(message);
    }

    @Override
    public void publishBasicDataFour(BasicDataFourRequest request) {
        var message = toBasicFourMessage(request);
        producer.sendBasicDataFour(message);
    }

    @Override
    public void publishBasicDataOne(BasicDataOneRequest request) {
        var message = toBasicOneMessage(request);
        producer.sendBasicDataOne(message);
    }

    @Override
    public void publishBasicDataPerson(BasicDataPersonRequest request) {
        var message = toBasicPersonMessage(request);
        producer.sendBasicDataPerson(message);
    }

    @Override
    public void publishBasicDataThree(BasicDataThreeRequest request) {
        var message = toBasicThreeMessage(request);
        producer.sendBasicDataThree(message);
    }

    @Override
    public void publishBasicDataTwo(BasicDataTwoRequest request) {
        var message = toBasicTwoMessage(request);
        producer.sendBasicDataTwo(message);
    }

    private long toEpochDay (BasicDataTwoRequest.Date myDate){
        var dateString = String.format("%d-%2d-%2d", myDate.getYear(), myDate.getMonth(), myDate.getDate())
                .replace(' ', '0');
        return LocalDate.parse(dateString).toEpochDay();
    }

    private long toEpochMillis (BasicDataTwoRequest.Timestamp myTimestamp) {
        var dateString = String.format(
                "%d-%2d-%2dT%2d:%2d:%2d",
                myTimestamp.getYear(),
                myTimestamp.getMonth(),
                myTimestamp.getDate(),
                myTimestamp.getHour(),
                myTimestamp.getMinute(),
                myTimestamp.getSecond()
        ).replace(' ', '0');
        return LocalDateTime.parse(dateString).toInstant(ZONE_OFFSET).toEpochMilli();
    }

    private BasicDataAddressMessage toKafkaMessage (BasicDataPersonRequest.Address original) {
        var result = new BasicDataAddressMessage();

        result.setStreetAddress(original.getStreetAddress());
        result.setCountry(original.getCountry());
        result.setLocation(toKafkaMessage(original.getLocation()));

        return result;
    }

    private BasicDataLocationMessage toKafkaMessage (BasicDataPersonRequest.Location original){
        var result = new BasicDataLocationMessage();

        result.setLatitude(original.getLatitude());
        result.setLongitude(original.getLongitude());

        return result;
    }

    private BasicDataCountryMessage toBasicCountryMessage (BasicDataCountryRequest request){
        var message = new BasicDataCountryMessage();

        message.setCountryName(request.getCountryName());
        message.setPopulation(request.getPopulation());
        message.setCurrencyCode(request.getCurrencyCode());

        return message;
    }

    private BasicDataFiveMessage toBasicFiveMessage (BasicDataFiveRequest request){
        var message = new BasicDataFiveMessage();

        var mapAlpha = new TreeMap<Integer, String>();
        IntStream.range(0, request.getAlphaElementsCount())
                .forEach(i -> mapAlpha.put(i, "Map value alpha " + i));
        var mapBeta = new TreeMap<UUID, String>();
        IntStream.range(0, request.getBetaElementsCount())
                .forEach(i -> mapBeta.put(UUID.randomUUID(), "Map value beta " + i));

        message.setMyMapAlpha(mapAlpha);
        message.setMyMapBeta(mapBeta);

        return message;
    }

    private BasicDataFourMessage toBasicFourMessage (BasicDataFourRequest request){
        var message = new BasicDataFourMessage();

        var array = new String[request.getArrayElementsCount()];
        IntStream.range(0, request.getArrayElementsCount())
                .forEach(i -> array[i] = "Array element " + i);

        var list = new ArrayList<Integer>();
        IntStream.range(0, request.getListElementsCount()).forEach(list::add);

        var set = new TreeSet<Double>();
        IntStream.range(0, request.getSetElementsCount())
                .forEach(i -> set.add(ThreadLocalRandom.current().nextDouble(1000)));

        message.setMyStringArray(array);
        message.setMyIntegerList(list);
        message.setMyDoubleSet(set);

        return message;
    }

    private BasicDataOneMessage toBasicOneMessage (BasicDataOneRequest request){
        var message = new BasicDataOneMessage();

        message.setMyAnotherString(request.getMyAnotherString());
        message.setMyString(request.getMyString());
        message.setMyBigDecimal(request.getMyBigDecimal());
        message.setMyBoolean(request.isMyBoolean());
        message.setMyDouble(request.getMyDouble());
        message.setMyFloat(request.getMyFloat());
        message.setMyInteger(request.getMyInteger());
        message.setMyLong(request.getMyLong());

        return message;
    }

    private BasicDataPersonMessage toBasicPersonMessage (BasicDataPersonRequest request){
        var message = new BasicDataPersonMessage();

        message.setFirstName(request.getFirstName());
        message.setLastName(request.getLastName());
        message.setBirthDate(request.getBirthDate());
        message.setContacts(request.getContacts());

        var passport = new BasicDataPassportMessage();
        passport.setNumber(request.getPassport().getNumber());
        passport.setExpirationDate(request.getPassport().getExpirationDate());
        message.setPassport(passport);

        var addresses = request.getAddresses().stream().map(this::toKafkaMessage).toList();
        message.setAddresses(addresses);

        return message;
    }

    private BasicDataThreeMessage toBasicThreeMessage (BasicDataThreeRequest request){
        var message = new BasicDataThreeMessage();

        var localDate = toLocalDate(request.getMyDate());
        message.setMyLocalDate(localDate);
        message.setMyLocalDateCustomFormat(localDate);

        var localTime = toLocalTime(request.getMyTime());
        message.setMyLocalTime(localTime);
        message.setMyLocalTimeCustomFormat(localTime);

        var localDateTime = toLocalDateTime(request.getMyDateTime());
        message.setMyLocalDateTime(localDateTime);
        message.setMyLocalDateTimeCustomFormat(localDateTime);

        var offsetDateTime = toOffsetDateTime(request.getMyDateTimeWithTimezone());
        message.setMyOffsetDateTime(offsetDateTime);
        message.setMyOffsetDateTimeCustomFormat(offsetDateTime);

        return message;
    }

    private BasicDataTwoMessage toBasicTwoMessage (BasicDataTwoRequest request){
        var message = new BasicDataTwoMessage();

        var epochDay = toEpochDay(request.getMyDate());
        message.setMyEpochDay(epochDay);

        var millisOfDay =toMillisOfDay(request.getMyTime());
        message.setMyMillisOfDay(millisOfDay);

        var epochMillis = toEpochMillis(request.getMyTimestamp());
        message.setMyEpochMillis(epochMillis);

        return message;
    }

    private LocalDate toLocalDate (BasicDataThreeRequest.Date myDate){
        return LocalDate.of(myDate.getYear(), myDate.getMonth(), myDate.getDate());
    }

    private LocalDateTime toLocalDateTime (BasicDataThreeRequest.DateTime myDateTime){
        return LocalDateTime.of(
                myDateTime.getYear(),
                myDateTime.getMonth(),
                myDateTime.getDate(),
                myDateTime.getHour(),
                myDateTime.getMinute(),
                myDateTime.getSecond()
        );
    }

    private LocalTime toLocalTime (BasicDataThreeRequest.Time myTime){
        return LocalTime.of(myTime.getHour(), myTime.getMinute(), myTime.getSecond());
    }

    private long toMillisOfDay (BasicDataTwoRequest.Time myTime){
        return LocalTime.of(myTime.getHour(), myTime.getMinute(), myTime.getSecond()).toSecondOfDay() * 1000L;
    }

    private OffsetDateTime toOffsetDateTime (BasicDataThreeRequest.DateTimeWithTimezone myDateTimeWithTimezone) {
        return OffsetDateTime.of(
                myDateTimeWithTimezone.getYear(),
                myDateTimeWithTimezone.getMonth(),
                myDateTimeWithTimezone.getDate(),
                myDateTimeWithTimezone.getHour(),
                myDateTimeWithTimezone.getMinute(),
                myDateTimeWithTimezone.getSecond(),
                0,
                ZoneOffset.of(myDateTimeWithTimezone.getTimezone())
        );
    }
}
