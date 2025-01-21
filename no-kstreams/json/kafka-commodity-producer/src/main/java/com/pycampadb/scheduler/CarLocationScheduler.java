package com.pycampadb.scheduler;

import com.pycampadb.entity.CarLocation;
import com.pycampadb.producer.CarLocationProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

//@Component
public class CarLocationScheduler {
    private static final Logger log = LoggerFactory.getLogger(CarLocationScheduler.class);
    private CarLocation carLocation;
    private CarLocation carLocation2;
    private CarLocation carLocation3;
    private final CarLocationProducer carLocationProducer;

    public CarLocationScheduler(CarLocationProducer carLocationProducer){
        this.carLocationProducer = carLocationProducer;
        var now = System.currentTimeMillis();

        carLocation = new CarLocation("car-one", now, 0);
        carLocation2 = new CarLocation("car-two", now, 113);
        carLocation3 = new CarLocation("car-three", now, 93);
    }

    @Scheduled(fixedRate = 5000)
    public void generateDummyData(){
        var now = System.currentTimeMillis();
        carLocation.setTimestamp(now);
        carLocation2.setTimestamp(now);
        carLocation3.setTimestamp(now);

        carLocation.setDistance(carLocation.getDistance() + 1);
        carLocation2.setDistance(carLocation2.getDistance() - 1);
        carLocation3.setDistance(carLocation3.getDistance() + 1);

        sendCarLocation(carLocation);
        sendCarLocation(carLocation2);
        sendCarLocation(carLocation3);
    }

    private void sendCarLocation(CarLocation carLocation){
        carLocationProducer.sendMessage(carLocation);
        log.info("Sent car location: {}", carLocation);
    }
}
