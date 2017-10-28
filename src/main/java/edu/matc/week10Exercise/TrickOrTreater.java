package edu.matc.week10Exercise;

public class TrickOrTreater implements Runnable {
    private String name;
    private House house;

    public TrickOrTreater(House house) {
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        getCandy();
    }

    private synchronized void getCandy() {
        house.add(this);
    }
}
