package dice_roll_statistics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Shows a visual representation of dice rolls
 *
 * @author Peter Senyk
 * @version 2024.001
 */
public class VisualRolls extends Application {

    /**
     * Create and presents a program window. Allows users to roll dice and displays the results.
     *
     * @param stage is a Stage
     */
    @Override
    public void start(Stage stage) {
        // Creates a VBox layout with spacing
        VBox root = new VBox(10);
        // Set padding around the layout
        root.setPadding(new Insets(10));

        TextField numberOfRollsField = new TextField();
        numberOfRollsField.setPromptText("Enter the number of times that you want to roll ");

        Button rollButton = new Button("Roll");
        TextArea resultsArea = new TextArea();
        resultsArea.setEditable(false);

        rollButton.setOnAction(event -> {
            // Clear previous results
            resultsArea.clear();

            // Parse the input
            int numberOfRolls = Integer.parseInt(numberOfRollsField.getText());

            // Constant number of dice, number of rolls from input
            DiceRoll roll = new DiceRoll(Die.NUMBER_OF_DICE, numberOfRolls);
            roll.rollDiceMultipleTimes();
            int[] results = roll.getRollResults();

            // Calculate frequencies of sums
            int[] frequencyOfSums = new int[13]; // Sums can range from 2 to 12 with two dice
            for (int result : results) {
                if (result >= 2 && result <= 12) frequencyOfSums[result]++;
            }


            StringBuilder resultsText = new StringBuilder();
            for (int sum = 2; sum <= 12; sum++) {
                resultsText.append("Sum ").append(sum).append(": ").append(frequencyOfSums[sum]).append(" times\n");
            }
            // Display all roll results
            resultsArea.setText(resultsText.toString());
        });

        // Add components to the layout
        root.getChildren().addAll(numberOfRollsField, rollButton, resultsArea);

        // Create the scene with the layout
        Scene scene = new Scene(root, 400, 500);
        stage.setTitle("Dice Roller");
        // Set the scene on the stage
        stage.setScene(scene);
        // Display the stage
        stage.show();
    }

    /**
     * Demonstrates the use of the program
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
