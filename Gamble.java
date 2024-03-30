import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

/**
 * Assignment 1;
 * Picking 6 numbers from 1 to 49 for saturday's gamble game.
 *
 * @author n-c0de-r
 * @version 22-10-03
 */
public class Gamble
{
    private int[] frequencies; // Assignment 2
    /**
     * Assignment 1;
     * Constructor for objects of class Gamble Game
     */
    public Gamble Game()
    {
        /* Creates an array of numbers, to store drawn numbers.
         * 49 will be the highest index, being the 50th number.
         * index 0 will never be used (could store sum of all!).
         * Makes it easy to track, index is same as the number. */
        frequencies = new int[50];
    }
    
    /**
     * Assignment 3
     * Draws 6 numbers as often as given times.
     * @param times Amount of rounds to draw numbers.
     */
    public void drawGamble GameManyTimes(int times) {
        // Clears the frequency table
        Arrays.fill(frequencies, 0);
        for (int i=0; i<times; i++) {
            drawSixNumbers();
        }
    }
    
    /**
     * Assignment 4;
     * Prints a visual Table of all drawn numbers.
     * Maybe better with a parameter?
     */
    public void printFrequencyTable() {
        System.out.println('\u000C'); // Clear screen
        System.out.println(generateFrequencyTable());
    }
    
    /**
     * Generate a visual representation of the frequency table.
     */
    private String generateFrequencyTable() {
        // This will be returned, pre-define it empty.
        String result = "";
        result += "Total numbers drawn: " + frequencies[0]+ "\n";
        result += "Number\n";
        // Multiplying with 1.0 converts integers to doubles
        double max = 1.0 * findHighestValue(frequencies);
        double ratio = 0.0; // scale ratio
        int characterMax = 50; // Maximum characters on screen
        for (int i=1; i<frequencies.length; i++) {
            ratio = frequencies[i] / max; // Calculate ratio
            String nr = "";
            if (i<10) {
                result += "0";
            }
            // u0009 is the Unicode for a Tab Space
            result += i + ":\u0009";
            int stars = (int) Math.round(ratio * characterMax);
            for (int j=0; j<stars; j++) {
                result += "*"; // Add a star for each fraction
            }
            // Fill up rest with spaces, makes the table look nice
            for (int k=0; k<characterMax-stars; k++) {
                result += " "; // Add a star for each fraction
            }
            result += "\u0009" + frequencies[i] + "x\n"; // Add new line
        }
        return result;
    }
    
    /**
     * Finds the highest value in an given array.
     * @param table Table to check through.
     * @return The highest integer in the array.
     */
    private int findHighestValue(int[] table) {
        int result = 0;
        for (int i=1; i<table.length; i++) {
            // If a higher value is found
            if(table[i]>result) {
                result = table[i]; // Update highest value
            } 
        }
        return result;
    }
    
    /**
     * Assignment 1;
     * Draws 6 random numbers from 1 to 49
     */
    private void drawSixNumbers()
    {
        // Needed to generate random numbers
        Random rng = new Random();
        /* Sets are great here. They automatically
         * omit duplicates. Just need to check size. */
        Set<Integer> drawn = new HashSet<Integer>();
        int random;
        while (drawn.size() < 6) {
            /* Get a random integer between 1 and 50.
             * The final integer is always excluded.
             * So 49 will be the highest number. */
            random = rng.nextInt(1, 50);
            // rng.nextInt(49)+1 //does the same here
            drawn.add(random);
        }
        // Update frequencies
        updateFrequencies(drawn);
    }
    
    /**
     * Assignment 2;
     * Adds found numbers to table of frequencies.
     * @param numbers   Set of numbers to check;
     */
    private void updateFrequencies(Set<Integer> numbers) {
        // Get frequency, Assignment 2
        for (int nr : numbers) {
            /* Add 1 up at the index in the frequency table.
             * Since index is the same as the number. */
            frequencies[nr]++;
            // Sum all numbers up at position 0.
            frequencies[0]++;
        }
    }
}
