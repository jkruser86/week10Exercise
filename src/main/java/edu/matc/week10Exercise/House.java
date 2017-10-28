package edu.matc.week10Exercise;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class House {
    private final Logger log = Logger.getLogger(this.getClass());
    private int maxLineLength;
    private List<TrickOrTreater> listTreater;

    public House() {
        maxLineLength = 10;
        listTreater = new LinkedList<TrickOrTreater>();
    }

    public void giveCandy() {
        TrickOrTreater treater;
        synchronized (listTreater) {
            while(listTreater.size() == 0) {
                log.info("Riley watches TV");
                try {
                    listTreater.wait();
                } catch (InterruptedException ie) {
                    log.error("Issue in giveCandy", ie);
                }
            }

            treater = (TrickOrTreater)((LinkedList<?>)listTreater).poll();
        }

        long duration = 0;

        try {
            log.info("Riley answers the door for " + treater.getName());
            duration = (long)(Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException ie) {
            log.error("Issue in giveCandy 2", ie);
        }

        log.info("Riley gives candy to " + treater.getName());
    }

    public void add(TrickOrTreater treater) {
        log.info(treater.getName() + " rings doorbell");

        synchronized (listTreater) {
            if(listTreater.size() == maxLineLength) {
                log.info(treater.getName() + " left");
                return;
            }

            ((LinkedList<TrickOrTreater>)listTreater).offer(treater);
            log.info(treater.getName() + " is in line");

            if(listTreater.size() == 1) {
                listTreater.notify();
            }
        }
    }
}
