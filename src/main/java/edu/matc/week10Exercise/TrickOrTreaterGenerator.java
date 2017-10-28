package edu.matc.week10Exercise;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class TrickOrTreaterGenerator implements Runnable {
    private final Logger log = Logger.getLogger(this.getClass());
    private House house;

    public TrickOrTreaterGenerator(House house) {
        this.house = house;
    }

    public void run() {
        while (true) {
            TrickOrTreater treater = new TrickOrTreater(house);
            Thread thtreater = new Thread(treater);
            treater.setName("Child " + thtreater.getId());
            log.info(treater.getName() + " is created");
            thtreater.start();

            try {
                TimeUnit.SECONDS.sleep((long)(Math.random() * 10));
            } catch (InterruptedException ie) {
                log.error("Error in TrickOrTreaterGenerator", ie);
            }
        }
    }
}
