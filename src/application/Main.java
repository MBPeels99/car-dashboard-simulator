package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;


public class Main extends Application {
    public Stage primaryStage;
    Scene scene_start_menu;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        primaryStage.setTitle("Driving Simulator");
        Scene scene_start_menu = new Scene(root,root.prefWidth(0),root.prefHeight(0));
        primaryStage.setScene(scene_start_menu);
        scene_start_menu.getStylesheets().add
        (Main.class.getResource("application.css").toExternalForm());
        primaryStage.show();
    }

    
}
