package pacman;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class sideBar {
    private HBox barPane;
    private Label scoreLabel;
    private Button btn;
    public sideBar(HBox bar){
        this.barPane = bar;
        this.setUpSideBar();
    }


    private void setUpSideBar(){
        this.btn = new Button("Quit");
        this.scoreLabel = new Label("Score: 0");
        this.scoreLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));

        this.btn.setFocusTraversable(false);
        this.barPane.setFocusTraversable(false);
        this.btn.setOnAction((ActionEvent e) -> System.exit(0));
        this.barPane.getChildren().addAll(btn, this.scoreLabel);
        this.barPane.setAlignment(Pos.CENTER);
        this.barPane.setSpacing(20);
        this.barPane.setStyle("-fx-background-color:#900C3F");
    }

    public void changeLabel(String s){
        this.barPane.getChildren().clear();
        Label label = new Label(s);
        this.btn = new Button("Quit");
        this.btn.setFocusTraversable(false);
        this.btn.setOnAction((ActionEvent e) -> System.exit(0));
        label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
        this.barPane.getChildren().addAll(this.btn, label);
    }

}
