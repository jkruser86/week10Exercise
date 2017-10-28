package edu.matc.week10Exercise;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        House house = new House();

        Riley riley = new Riley(house);
        Thread thriley = new Thread(riley);
        thriley.start();
        TrickOrTreaterGenerator generator = new TrickOrTreaterGenerator(house);

        Thread thgenerator = new Thread(generator);
        thgenerator.start();
    }
}
