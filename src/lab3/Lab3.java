/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab3;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author 6302743
 */

/*
Git username: G3orG3s
Git Repo link: https://github.com/G3org3s/Lab_03
*/
public class Lab3 extends Application {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    boolean firstNameFilled = false;
    boolean lastNameFilled = false;
    boolean emailFilled = false;
    boolean passwordFilled = false;
    @Override
    public void start(Stage stage) throws Exception {
        //Creating layout
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
        root.setCenter(grid);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
        //Making all the Labels, text and buttons
        Label firstName = new Label("First name: ");
        TextField firstNameTextField = new TextField();
        grid.add(firstName, 0,0);
        grid.add(firstNameTextField, 1, 0);
        
        Label lastName = new Label("Last name: ");
        TextField lastNameTextField = new TextField();
        grid.add(lastName, 0, 1);
        grid.add(lastNameTextField, 1, 1);
        
        Label email = new Label("Email: ");
        TextField emailTextField = new TextField();
        grid.add(email, 0, 2);
        grid.add(emailTextField, 1, 2);
        
        
        Label password = new Label("PassWord: ");
        PasswordField passwordTextField = new PasswordField();
        grid.add(password, 0, 3);
        grid.add(passwordTextField, 1, 3);
        
        Button btn1 = new Button("Register");
        grid.add(btn1, 0,4);
        
        Button btn2 = new Button("Clear");
        grid.add(btn2, 1, 4);
        
        Label message = new Label("");
        grid.add(message, 1, 5);
        btn1.setDisable(true);
        
        /*Checks if a field is empty on every key press in order to update
        the register buttons status (disabled or not)
        */
        firstNameTextField.setOnKeyPressed(e -> {
            firstNameFilled= firstNameTextField.getText().length() > 0 ;
            setRegister(btn1);
        });
        lastNameTextField.setOnKeyPressed(e -> {
            lastNameFilled= lastNameTextField.getText().length() > 0 ;
            setRegister(btn1);
        });
        emailTextField.setOnKeyPressed(e -> {
            emailFilled= emailTextField.getText().length() > 0 ;
            setRegister(btn1);
        });
        passwordTextField.setOnKeyPressed(e -> {
            passwordFilled= passwordTextField.getText().length() > 0 ;
            setRegister(btn1);
        });
        
        //Action once we click register
        btn1.setOnAction(e -> {
            boolean hasNum = false;
            boolean hasLet = false;
            boolean hasAt = false;
            boolean validDom = false;
            
            //Checks if the email is valid
            String domain = "";
            if(emailTextField.getText().split("@").length == 2) {
                hasAt = true;
                domain = emailTextField.getText().split("@")[1];
            }
            if(domain.split("\\.").length == 2 && hasAt) {
                 validDom = true; 
            }
            //Check if password has both letters and numbers
            for(Character c : passwordTextField.getText().toCharArray()) {
                if (c > 47 && c <58) {
                    hasNum = true;
                }
                if ((c > 64 && c < 91) || (c > 96 && c < 123)) {
                    hasLet = true;
                }
            }
            
            //set the error message depending on if everything ok
            if(hasLet && hasNum && hasAt && validDom) {
                message.setText("Valid Registration");
            } else {
                message.setText("Error");
            }
        });
        
        //Clear button action
        btn2.setOnAction(e -> {
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            emailTextField.setText("");
            passwordTextField.setText("");
        });
        
        //Create scene and set the stage
        Scene s = new Scene(root, 500, 500);
        stage.setScene(s);
        stage.show();
    }
    
    //Method to check if all fields have entries
    public void setRegister(Button btn1) {
        if (firstNameFilled && lastNameFilled && emailFilled && passwordFilled) {
            btn1.setDisable(false);
        } else {
            btn1.setDisable(true);
        }
    }
}

