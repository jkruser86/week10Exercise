package edu.matc.week10Exercise;

public class Riley implements Runnable {
    private House house;

    public Riley(House house) {
        this.house = house;
    }

    public void run() {

        System.out.println("Trick-Or-Treating begins");

        while(true) {
            house.giveCandy();
        }
    }
}
