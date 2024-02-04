package dice_roll_statistics;

import java.util.Random;

/**
 * Die represents s six-sided die.
 *
 * @author Peter Senyk
 * @version 2024.001
 */
public class Die {

    /**
     * The number of sides on a die.
     */
    public static final int NUMBER_OF_SIDES = 6;

    public static final int NUMBER_OF_DICE = 2;

    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    private int faceValue;

    /**
     * Constructs a new Die with a starting face value of 1.
     */
    public Die() {this.faceValue = 1;}

    /**
     * Returns the current face value of a Die as an int.
     *
     * @return faceValue as an int
     */
    public int getFaceValue() {return this.faceValue;}

    public void setFaceValue(final int newFaceValue) {
        if (newFaceValue > 0 && newFaceValue <= NUMBER_OF_SIDES) {
            this.faceValue = newFaceValue;
        }
    }

    /**
     * Rolls this Die and sets the face value as the result.
     */
    public void roll() {
        setFaceValue(RANDOM_NUMBER_GENERATOR.nextInt(NUMBER_OF_SIDES) + 1);
    }

    /**
     * Returns a String representation of this Die.
     *
     * @return toString description
     */
    @Override
    public String toString() {
        return "Die{" +
                "faceValue=" + faceValue +
                '}';
    }

    /**
     * Shows the use of this class.
     *
     * @param args unused
     */
    public static void main (final String[] args) {
        // Create an array to hold dice, set number to hold
        Die[] dice = new Die[NUMBER_OF_DICE];

        // Initialize each die in the array
        for (int i = 0; i < NUMBER_OF_DICE; i++) {
            dice[i] = new Die();
        }

        for (Die die : dice) {
            die.roll();
            System.out.println(die);
        }
    }
}
