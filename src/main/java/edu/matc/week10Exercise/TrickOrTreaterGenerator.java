package edu.matc.week10Exercise;

import java.util.concurrent.TimeUnit;

public class TrickOrTreaterGenerator implements Runnable {
    private House house;

    public TrickOrTreaterGenerator(House house) {
        this.house = house;
    }

    public void run() {
        while (true) {
            TrickOrTreater treater = new TrickOrTreater(house);
            Thread thtreater = new Thread(treater);
            treater.setName("Child " + thtreater.getId());
            thtreater.start();

            try {
                TimeUnit.SECONDS.sleep((long)(Math.random() * 10));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
