package com.example.javafx_demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    public TextField label_weight;
    public TextField label_height;
    public TextField label_resul;
    public Text label_kq;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onCaculatorButtonClick(ActionEvent actionEvent) {
        double weight= Double.parseDouble(label_weight.getText());
        double height= Double.parseDouble(label_height.getText());

        double bmi= weight/(height*height);
        label_resul.setText("BMI= "+ bmi);
        String rs;
        if (bmi<= 18.5){
            rs="Gay";
        } else if (bmi>18.5 && bmi<25){
            rs="binh thuong";
        } else {
            rs="thua can";
        }
        label_kq.setText(rs);
    }

    public void onClearButtonClick(ActionEvent actionEvent) {
        label_weight.setText("");
        label_height.setText("");
        label_resul.setText("");
        label_resul.setText("");
    }
}