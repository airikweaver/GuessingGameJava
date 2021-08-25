/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapracapp;

import java.io.FileInputStream;
import javafx.scene.image.Image ;
import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author aweaver
 */
public class JavaPracApp extends Application {
    int Score = 0;
    Random x = new Random();
    
    Button closeBtn = new Button();
    Button restartBtn = new Button();
    Button guessBtn = new Button();
    
    Label score = new Label("Score = " + Score);
    Label lbl = new Label("Enter your guess here!");
    TextField numEnterField = new TextField();
    String Random = Integer.toString(x.nextInt(100)+ 1);

    
    Image upArrow = new Image(getClass().getResourceAsStream("UpArrow.png"));
    Image downArrow = new Image(getClass().getResourceAsStream("DownArrow.png"));
    Image correctArrow = new Image(getClass().getResourceAsStream("CorrectArrow.png"));
    
    @Override
    public void start(Stage primaryStage) {
        lbl.setLayoutX(40);
        lbl.setLayoutY(70);

        numEnterField.setLayoutX(30);
        numEnterField.setLayoutY(90);

        ImageView UpArrow = new ImageView(upArrow);
        UpArrow.setVisible(false);
        
        ImageView DownArrow = new ImageView(downArrow);
        DownArrow.setVisible(false);
        
        ImageView CorrectArrow = new ImageView(correctArrow);
        CorrectArrow.setVisible(false);
        
        
        restartBtn.setVisible(false);
        restartBtn.setText("Restart");
        restartBtn.setLayoutX(75);
        restartBtn.setLayoutY(120);
        restartBtn.setOnAction((ActionEvent event) ->
        {
            UpArrow.setVisible(false);
            DownArrow.setVisible(false);
            CorrectArrow.setVisible(false);
            restartBtn.setVisible(false);
            lbl.setText("Enter your guess here!");
            numEnterField.clear();
            Score++;
            score.setText("Score = " + Score);
            Random = Integer.toString(x.nextInt(100)+ 1);
        });
       
        
        guessBtn.setText("Guess!");
        guessBtn.setLayoutX(5);
        guessBtn.setLayoutY(120);
        guessBtn.setOnAction((ActionEvent event) ->
        {
            UpArrow.setVisible(false);
            DownArrow.setVisible(false);
            CorrectArrow.setVisible(false);
            restartBtn.setVisible(false);
            if (numEnterField.getText().equals(Random))
            {
                CorrectArrow.setVisible(true);
                restartBtn.setVisible(true);
                lbl.setText("Congratulations!");
            }
            else
            {
                try 
                {
                    int ran=Integer.parseInt(Random);
                    int numEntered = Integer.parseInt(numEnterField.getText());
                    if (ran > numEntered)
                    {
                        UpArrow.setVisible(true);
                        lbl.setText("Higher!");
                    }
                    else if (ran < numEntered)
                    {
                        DownArrow.setVisible(true);
                        lbl.setText("Lower!");
                    }
                }
                    catch(NumberFormatException e) 
                    {
                        lbl.setText("Please enter a valid int");
                    }
            }
            
        });
        
        
        UpArrow.setX(85); 
        UpArrow.setY(25);
        
        DownArrow.setX(85); 
        DownArrow.setY(25);
        
        CorrectArrow.setX(85); 
        CorrectArrow.setY(25);
        
        score.setLayoutX(145);
        score.setLayoutY(5);

        closeBtn.setText("Close");
        closeBtn.setLayoutX(150);
        closeBtn.setLayoutY(120);
        closeBtn.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        Group root = new Group();
        root.getChildren().addAll(closeBtn, guessBtn, restartBtn, numEnterField, lbl, CorrectArrow, UpArrow, DownArrow, score);
        
        Scene scene = new Scene(root, 200, 150);
        
        primaryStage.setTitle("Guessing Game!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
