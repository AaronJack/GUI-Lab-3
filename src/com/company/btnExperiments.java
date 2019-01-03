package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class btnExperiments extends Application  {
    int numclicked = new Integer(0);
    int time = 10;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("HBox Experiment 1");

        Label label = new Label("  Not clicked");
        Button clickerBtn = new Button("Click as fast as you can");
        Button begin = new Button("Click To Start");

        HBox clicker = new HBox(clickerBtn, label);

        begin.setOnAction(value -> {
            for(int i = 0; i < 10; i++) {
                time--;
                System.out.println(time);
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Scene scene = new Scene(clicker, 200, 100);
        });

        clickerBtn.setOnAction(value ->  {
            numclicked++;
            if(time == 0){
                System.out.println(numclicked);
            }
        });
        HBox starter = new HBox(begin, label);

        Scene scene = new Scene(starter, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

