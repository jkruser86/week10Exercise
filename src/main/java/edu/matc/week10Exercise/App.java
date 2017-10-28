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
        TrickOrTreaterGenerator generator = new TrickOrTreaterGenerator(house);

        Thread thriley = new Thread(riley);
        Thread thgenerator = new Thread(generator);
        thgenerator.start();
        thriley.start();
    }
}
