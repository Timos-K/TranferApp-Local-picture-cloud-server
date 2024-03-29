package application;
	
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import controllers.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
    @Override
    public void start(Stage primaryStage) {
        try {
        	Controller controller = new Controller(primaryStage);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxmls/file_manager.fxml"));
            fxmlLoader.setController(controller);
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("../fxmls/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle( "Super Transfer" );
            //primaryStage.setResizable(false);
            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent t) {
                    Platform.exit();
                    System.exit(0);
                }
            });

            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
