package edu.matc.week10Exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class House {
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
                System.out.println("Riley watches TV");
                try {
                    listTreater.wait();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }

            treater = (TrickOrTreater)((LinkedList<?>)listTreater).poll();
        }

        long duration = 0;

        try {
            System.out.println("Riley answers the door for " + treater.getName());
            duration = (long)(Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("Riley gives candy to " + treater.getName());
    }

    public void add(TrickOrTreater treater) {
        System.out.println(treater.getName() + " rings doorbell");

        synchronized (listTreater) {
            if(listTreater.size() == maxLineLength) {
                System.out.println(treater.getName() + " left");
                return;
            }

            ((LinkedList<TrickOrTreater>)listTreater).offer(treater);
            System.out.println(treater.getName() + " is in line");

            if(listTreater.size() == 1) {
                listTreater.notify();
            }
        }
    }
}
