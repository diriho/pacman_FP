package pacman;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Ghost implements Collidable{
    private Rectangle ghost;
    private int ghostScore;
    private Pane pane;
    private Direction currentDir;
    private Set visited;
    private Board myBoard;
    private Queue<Square> neighbors;
    private int[] myTarget;
    private ghostBehavior currBehaviour;

    public Ghost(Pane pane, Paint color, Board board){
        this.pane = pane;
        this.myBoard = board;
        this.ghost = new Rectangle(30, 30, color);
        this.pane.getChildren().add(this.ghost) ;
        this.currentDir = Direction.START;
        this.ghostScore = 200;
        //this.myTarget = target;

    }

    public void getShortestPath(Pacman target){
        int[][] directionVector = {{},{}};
        this.visited = new HashSet();

        int targetRow = target.getCoordinates()[1]/30;
        int targetCol = target.getCoordinates()[0]/30;

//        int row = this.getCoordinates()[1]/30;
//        int col = this.getCoordinates()[0]/30;



//        Square neighbor1 = this.myBoard.getBoard()[row+1][col];
//        Square neighbor2 = this.myBoard.getBoard()[row-1][col];
//        Square neighbor3 = this.myBoard.getBoard()[row][col+1];
//        Square neighbor4 = this.myBoard.getBoard()[row][col-1];
//
//        if (neighbor1.getType() != CS15SquareType.WALL){
//            this.neighbors.offer(neighbor1);
//        } if (neighbor2.getType() != CS15SquareType.WALL){
//            this.neighbors.offer(neighbor1);
//        } if (neighbor3.getType() != CS15SquareType.WALL){
//            this.neighbors.offer(neighbor1);
//        } if (neighbor4.getType() != CS15SquareType.WALL){
//            this.neighbors.offer(neighbor1);
//        }
//
//        while (!this.neighbors.isEmpty()){
//
//        }
    }

    private LinkedList<Square> getNeighbors(Square currSquare){
        LinkedList<Square> neighbors = new LinkedList<>();
        int row = currSquare.getLocation()[1]/30;
        int col = currSquare.getLocation()[0]/30;
        Square neighbor1 = this.myBoard.getBoard()[row+1][col];
        Square neighbor2 = this.myBoard.getBoard()[row-1][col];
        Square neighbor3 = this.myBoard.getBoard()[row][col+1];
        Square neighbor4 = this.myBoard.getBoard()[row][col-1];

        if (neighbor1.getType() != CS15SquareType.WALL && !this.visited.contains(neighbor1)){
            neighbors.offer(neighbor1);
        } if (neighbor2.getType() != CS15SquareType.WALL && !this.visited.contains(neighbor2)){
            neighbors.offer(neighbor2);
        } if (neighbor3.getType() != CS15SquareType.WALL && !this.visited.contains(neighbor3)){
            neighbors.offer(neighbor3);
        } if (neighbor4.getType() != CS15SquareType.WALL && !this.visited.contains(neighbor4)){
            neighbors.offer(neighbor4);
        }
        return neighbors;
    }


    @Override
    public int[] getCoordinates(){
        int[] coordinate = new int [2];
        coordinate[0] = (int) this.ghost.getX();
        coordinate[1] = (int) this.ghost.getY();
        return coordinate;

    }
    public void moveGhost(){
        switch (this.currentDir){
            case UP:
                if (canMove()){
                    this.moveUp();
                }
                break;
            case DOWN:
                if (canMove()){
                    this.moveDown();}
                break;
            case RIGHT:
                if (this.getCoordinates()[0] == 675) {
                    this.setLocation(15, this.getCoordinates()[1]);
                } else if (canMove()){
                    this.moveRight();}
                break;
            case LEFT:
                if (this.getCoordinates()[0] == 15) {
                    this.setLocation(675, this.getCoordinates()[1]);
                } else if (canMove()){
                    this.moveLeft(); }
                break;
            default:
                break;
        }
    }

    public void setLocation(int x, int y){
        this.ghost.setX(x);
        this.ghost.setY(y);
    }

    @Override
    public void executeCollision(){
        this.removeObj();
        this.ghost.setY(90);
    }
    private void removeObj(){
        this.pane.getChildren().remove(this.ghost);
    }

    @Override
    public int getScore() {
        return this.ghostScore;
    }

    public void moveRight(){
        int newX = (int) (this.ghost.getX()+30);
        this.ghost.setX(newX);
    }
    public void moveLeft(){
        int newX = (int) (this.ghost.getX() - 30);
        this.ghost.setX(newX);
    }

    public void moveDown(){
        int newY = (int) (this.ghost.getY() + 30);
        this.ghost.setY(newY);
    }

    public void moveUp(){
        int newY = (int) (this.ghost.getY() - 30);
        this.ghost.setY(newY);
    }

    public int[] getTarget(){
        return this.myTarget;
    }

    private void setTarget(int[] target){
        this.myTarget = target;
    }

    private boolean canMove(){
        int row = this.getCoordinates()[1]/30;
        int col = this.getCoordinates()[0]/30;
        switch(this.currentDir){
            case LEFT:
                if (this.myBoard.isWall(row, col-1)) {
                    return false;
                }
                break;
            case RIGHT:
                if (this.myBoard.isWall(row, col+1)) {
                    return false;
                }
                break;
            case UP:
                if (this.myBoard.isWall(row-1, col)) {
                    return false;
                }
                break;
            case DOWN:
                if (this.myBoard.isWall(row+1, col)) {
                    return false;
                }
                break;

        }
        return true;
    }

}
