package dice_roll_statistics;


import java.util.Arrays;
import java.util.HashMap;

public class DiceRoll {
    private final Die[] dice;
    private final int numberOfRolls;

    /**
     * Constructs the dice and arrays to hold data.
     *
     * @param numberOfDice represents the number of dice to be rolled as an int
     */
    public DiceRoll(final int numberOfDice, final int numberOfRolls) {
        this.numberOfRolls = numberOfRolls;
        dice = new Die[numberOfDice];
        initializeDice();
    }

    private void initializeDice() {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }
    }


    /**
     * Rolls the array die and returns a frequency map of the results
     *
     * @return a HashMap where keys are the sums of dice rolls and the values are the frequency in which they are rolled
     */
    public HashMap<Integer, Integer> rollDiceMultipleTimesForFrequency() {
        HashMap<Integer, Integer> sumFrequencies = new HashMap<>();
        for (int i = 0; i < numberOfRolls; i++) {
            int sumOfRoll = 0;
            for (Die die : dice) {
                die.roll();
                sumOfRoll += die.getFaceValue();
            }
            sumFrequencies.merge(sumOfRoll, 1, Integer::sum);
        }
        return sumFrequencies;
    }

    /**
     * Returns a string representation of DiceRoll.
     *
     * @return toString description
     */
    @Override
    public String toString() {
        return "DiceRoll{" +
                "dice=" + Arrays.toString(dice) +
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
        roll.rollDiceMultipleTimesForFrequency();
        System.out.println(roll);
    }
}
