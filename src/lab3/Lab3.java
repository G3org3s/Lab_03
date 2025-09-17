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
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
        root.setCenter(grid);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
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
        grid.add(btn2, 1,4);
        
        Label message = new Label("");
        
        btn1.setDisable(true);

        firstNameTextField.setOnKeyPressed(e -> {
            int r = emailTextField.getText().length();
        });
        
        btn1.setOnAction(e -> {
            boolean f = true;
            int c = 0;
            if(!emailTextField.getText().contains("@")){
                f = false;
            }
            
        });

        btn2.setOnAction(e -> {
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            emailTextField.setText("");
            passwordTextField.setText("");
        });
        
        
        
        
        Scene s = new Scene(root, 500, 500);
        stage.setScene(s);
        stage.show();
    }
    
}

//        messageLabel = new Label("Click the button to see the message");
//        Button myButton = new Button("Click me");
//        Button thyButton = new Button("Click me");
//        VBox vb = new VBox(10, messageLabel, myButton, thyButton);
//        vb.setAlignment(Pos.CENTER);
//        
//        
//        
//        Scene s = new Scene(vb, 300, 300);
//        stage.setScene(s);
//        stage.show();
//        
//        myButton.setOnAction(e -> {
//            messageLabel.setText("Top Button was Clicked!");
//        });
//        thyButton.setOnAction(e -> {
//            messageLabel.setText("Bottom Button was Clicked!");
//        });
//        s.setOnKeyPressed(e -> {
//            KeyCode keycode = e.getCode();
//            messageLabel.setText("You Cliked on " + keycode + "!");
//        });
        //myButton.setOnAction(new ButtonClickHandler());
        
//        GridPane grid = new GridPane();
//        grid.setAlignment(Pos.CENTER);
//        grid.setHgap(10);
//        grid.setVgap(10);
//        grid.setPadding(new Insets(25, 25, 25, 25));
//        Scene scene = new Scene(grid, 300, 275);
//        stage.setScene(scene);
//        
//        Text scenetitle = new Text("Welcome"); 
//        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//        grid.add(scenetitle, 0, 0, 2, 1);
//        Label userName = new Label("User Name:");
//        grid.add(userName, 0, 1);
//        TextField userTextField = new TextField();
//        grid.add(userTextField, 1, 1);
//        Label pw = new Label("Password:");
//        grid.add(pw, 0, 2);
//        PasswordField pwBox = new PasswordField();
//        grid.add(pwBox, 1, 2);
//        
//        Button btn = new Button("Sign in");
//        HBox hbBtn = new HBox(10);
//        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//        hbBtn.getChildren().add(btn);
//        grid.add(hbBtn, 1, 4);
//        Text actiontarget = new Text();
//        grid.add(actiontarget, 1, 6); 
//
//        btn.setOnAction(e -> {
//            actiontarget.setFill(Color.FIREBRICK);
//            actiontarget.setText("Sign in button pressed");
//        });
//        
