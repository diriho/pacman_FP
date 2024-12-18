package pacman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
  * This is the Apps class where your Pacman game will start.
  * The main method of this application calls the start method. You
  * will need to fill in the start method to instantiate your game.
  *
  * Class comments here...
  *
  */

public class Apps extends Application {

    @Override
    public void start(Stage stage) {
        // Create top-level object, set up the scene, and show the stage here.
        PaneOrganizer paneOrganizer = new PaneOrganizer();
        Scene myScene = new Scene(paneOrganizer.getRoot(), 690, 720);
        stage.setScene(myScene);
        stage.setTitle("Pacman!");
        stage.show();

    }

    /*
    * Here is the mainline! No need to change this.
    */
    public static void main(String[] argv) {
        // launch is a method inherited from Application
        launch(argv);
    }
}
