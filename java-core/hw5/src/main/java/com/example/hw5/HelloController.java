package com.example.hw5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;

public class HelloController {
    public TextField lb_username;
    public PasswordField lb_password;
    public Text label_result;

    @FXML
    public void onLoginButtomClick(ActionEvent actionEvent) {
        ArrayList<String> user= new ArrayList<>();
        ArrayList<String> pass= new ArrayList<>();
        user.add("NgocEri");
        pass.add("123");
        user.add("Hkt");
        pass.add("123456");
        String username= lb_username.getText();
        String password= lb_password.getText();
        boolean isContinue=true;
        int i=0;
        while (isContinue && i<user.size()){
            if (username.equals(user.get(i)) && password.equals(pass.get(i))) {
                label_result.setText("Đăng nhập thành công!");
                isContinue=false;
            } else {
                label_result.setText("Đăng nhập thất bại- Vui lòng thử lại!");
            }
            i=i+1;
        }

    }
}