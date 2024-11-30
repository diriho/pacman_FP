package pacman;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Dot implements Collidable{
    private Circle dot;
    private Pane myPane;

    private int dotScore;
    public Dot(Pane pane){
        this.myPane = pane;
        this.dot = new Circle(5);
        this.dot.setFill(Color.WHITE);
        this.myPane.getChildren().add(this.dot);

        this.dotScore = 10;
    }
    public void setLocation (int x, int y){
        this.dot.setCenterX(x);
        this.dot.setCenterY(y);
    }

    public void removeObj(){
        this.myPane.getChildren().remove(this.dot);
    }

    public void setColor(Paint color){
        this.dot.setFill(color);
    }

    /*this is a helper method which returns */
    @Override
    public int[] getCoordinates(){
        int[] coordinate = new int [2];
        coordinate[0] = (int) this.dot.getCenterX();
        coordinate[1] = (int) this.dot.getCenterY();
        return coordinate;

    }

    @Override
    public void executeCollision(){
        this.removeObj();
    }


    public void setSize(int radius){
        this.dot.setRadius(radius);
    }

    public Circle getCircle(){
        return this.dot;
    }

    @Override
    public int getScore() {
        return this.dotScore;
    }
}
