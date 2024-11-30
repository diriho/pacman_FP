package pacman;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class PaneOrganizer {
    private BorderPane root;
    private Pane gamePane;
    private sideBar sideBar;
    private Game myGame;
    public PaneOrganizer(){
        this.root = new BorderPane();
        this.setBottomPane();
        this.setGamePane();

    }


    private void setGamePane(){
        this.gamePane = new Pane();
        this.gamePane.setStyle("-fx-background-color:#900C3F");
        this.gamePane.setPrefSize(690, 690);
        this.gamePane.setFocusTraversable(true);
        this.myGame = new Game(this.gamePane, this.sideBar);
        this.root.setCenter(this.gamePane);

    }

    private void setBottomPane(){
        HBox bottomPane = new HBox();
        this.sideBar = new sideBar(bottomPane);
        this.root.setBottom(bottomPane);

    }


    public BorderPane getRoot(){
        return this.root;
    }

}
