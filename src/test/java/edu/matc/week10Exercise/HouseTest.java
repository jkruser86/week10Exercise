package edu.matc.week10Exercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTest {

    @Test
    public void addTest() throws Exception {
        House house = new House();
        TrickOrTreater treater = new TrickOrTreater(house);

        treater.setName("Child 1");
        house.add(treater);
    }

}