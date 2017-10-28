package edu.matc.week10Exercise;

import org.apache.log4j.Logger;

public class Riley implements Runnable {
    private final Logger log = Logger.getLogger(this.getClass());
    private House house;

    public Riley(House house) {
        this.house = house;
    }

    public void run() {

        log.info("Trick-Or-Treating begins");

        while(true) {
            house.giveCandy();
        }
    }
}
