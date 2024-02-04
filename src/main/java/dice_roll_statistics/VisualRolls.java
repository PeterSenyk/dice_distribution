package dice_roll_statistics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashMap;

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
        VBox root = new VBox(20);
        // Set padding around the layout
        root.setPadding(new Insets(10));

        TextField numberOfRollsField = new TextField();
        numberOfRollsField.setPromptText("Enter the number of times that you want to roll ");

        Button rollButton = new Button("Roll");
        TextArea resultsArea = new TextArea();
        resultsArea.setPrefHeight(220);
        resultsArea.setEditable(false);

        // Setup BarCart
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Roll Distribution");
        xAxis.setLabel("Value");
        yAxis.setLabel("Frequency");

        // Set action  event for roll button
        rollButton.setOnAction(event -> {
            int numberOfRolls;

            try {
                numberOfRolls = Integer.parseInt(numberOfRollsField.getText());
            } catch (NumberFormatException e) {
                System.err.println("Please enter a valid number of rolls.");
                return;
            }

            // Constant number of dice, number of rolls from input
            DiceRoll roll = new DiceRoll(Die.NUMBER_OF_DICE, numberOfRolls);
            HashMap<Integer, Integer> frequencyMap = roll.rollDiceMultipleTimesForFrequency();

            // Clear previous data from the bar chart
            barChart.getData().clear();
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Frequency of Sums");

            // Populate bar chart with frequencies
            frequencyMap.forEach((sum, frequency) -> {
                series.getData().add(new XYChart.Data<>(String.valueOf(sum), frequency));
            });

            barChart.getData().add(series);
        });


            // Builds the output string for each results
            StringBuilder resultsText = new StringBuilder();
            for (int sum = 2; sum <= 12; sum++) {
                resultsText.append("Sum ").append(sum).append("  --->  ").append(frequencyOfSums[sum])
                        .append(" rolls\n");
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
