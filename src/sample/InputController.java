package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class InputController implements Subject{
    @FXML
    TextField inputText;
    @FXML
    ChoiceBox unitSelector;
    @FXML
    Button submitBtn;
    private ArrayList<Observer> observers;


    public void initialize(){

        observers = new ArrayList<>();
        createEnglishStage();
        createMetricStage();
        createThaiStage();
        unitSelector.getItems().addAll("kg", "lb","tamleung");
        unitSelector.setValue("kg");
        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                notifyObserver();
            }
        });

    }

    public void createEnglishStage(){
        Stage engStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("englishSystem.fxml"));
            engStage.setTitle("EnglishSystem");
            engStage.setScene(new Scene(loader.load(), 300, 275));
            engStage.setX(0);
            engStage.setY(0);
            EnglishSystemController englishSystemController = (EnglishSystemController) loader.getController();
            registerObserver(englishSystemController);
            engStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createMetricStage(){
        Stage metricStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("metricSystem.fxml"));
            metricStage.setTitle("MetricSystem");
            metricStage.setScene(new Scene(loader.load(), 300, 275));
            metricStage.setX(0);
            metricStage.setY(310);
            MetricSystemController metricSystemController = (MetricSystemController) loader.getController();
            registerObserver(metricSystemController);
            metricStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createThaiStage(){
        Stage thaiStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("thaiSystem.fxml"));
            thaiStage.setTitle("ThaiSystem");
            thaiStage.setScene(new Scene(loader.load(), 600, 400));
            thaiStage.setX(300);
            thaiStage.setY(0);
            ThaiSystemController thaiSystemController = (ThaiSystemController) loader.getController();
            registerObserver(thaiSystemController);
            thaiStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers){
            o.update((String)unitSelector.getValue(),Double.parseDouble(inputText.getText()));
        }
    }


}
