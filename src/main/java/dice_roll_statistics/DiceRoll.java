package dice_roll_statistics;


import java.util.Arrays;

public class DiceRoll {
    private final Die[] dice;
    private final int[] rollResults;
    private final int numberOfRolls;

    /**
     * Constructs the dice and arrays to hold data.
     *
     * @param numberOfDice represents the number of dice to be rolled as an int
     */
    public DiceRoll(final int numberOfDice, final int numberOfRolls) {
        this.numberOfRolls = numberOfRolls;
        dice = new Die[numberOfDice];
        rollResults = new int[numberOfRolls];
        initializeDice();
    }

    private void initializeDice() {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }
    }


    /**
     * Rolls the array die and stores each result in an array.
     */
    public void rollDiceMultipleTimes() {
        for (int i = 0; i < numberOfRolls; i++) {
            int sumOfRoll = 0;
            for (Die die : dice) {
                die.roll();
                sumOfRoll += die.getFaceValue();
            }
            rollResults[i] = sumOfRoll;
        }
    }

    /**
     * Returns the list of dice roll results
     *
     * @return rollResults as an int array
     */
    public int[] getRollResults() {return rollResults;}

    /**
     * Returns a string representation of DiceRoll.
     *
     * @return toString description
     */
    @Override
    public String toString() {
        return "DiceRoll{" +
                "dice=" + Arrays.toString(dice) +
                ", rollResults=" + Arrays.toString(rollResults) +
                ", numberOfRolls=" + numberOfRolls +
                '}';
    }

    /**
     * Demonstrates the use of DiceRoll
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        int numberOfDice = 2;
        int numberOfRolls = 10;

        DiceRoll roll = new DiceRoll(numberOfDice, numberOfRolls);
        roll.rollDiceMultipleTimes();
        System.out.println(roll);
    }
}
