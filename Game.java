package pacman;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class Game {
    private Pacman pacman;
    private Board gameBoard;
    private Pane myPane;
    private int score;
    private Timeline timeline;
    private sideBar sideBar;
    private Ghost redGhost;
    private Ghost greenGhost;
    private Ghost pinkGhost;
    private Ghost goldGhost;
    public Game(Pane pane, sideBar sideBar){
        this.myPane = pane;
        this.score = 0;
        this.sideBar = sideBar;
        this.setGameBoard();
        this.update();


    }

    private void setGameBoard() {
        this.gameBoard = new Board(this.myPane);

        for (int row=0; row<this.gameBoard.getBoard().length; row++) {
            for (int col = 0; col < this.gameBoard.getBoard()[0].length; col++) {
                if (this.gameBoard.getBoard()[row][col].getType()== CS15SquareType.PACMAN_START_LOCATION) {
                    this.pacman = new Pacman(this.myPane, this.gameBoard);
                    this.pacman.setLocation(col*30 + 15, row*30 + 15);
                    //System.out.println(this.gameBoard.getBoard()[row][col].getSquareElements());
                } else if(this.gameBoard.getBoard()[row][col].getType() == CS15SquareType.DOT){
                    Dot dot = new Dot(this.myPane);
                    dot.setLocation(col*30 + 15, row*30 + 15);
                    this.gameBoard.getBoard()[row][col].addElement(dot);
                    //System.out.println(this.gameBoard.getBoard()[row][col].getSquareElements());

                } else if (this.gameBoard.getBoard()[row][col].getType() == CS15SquareType.ENERGIZER){
                    Energizer energizer = new Energizer(this.myPane);
                    energizer.setLocation(col*30 + 15, row*30 + 15);
                    this.gameBoard.getBoard()[row][col].addElement(energizer);
                    //System.out.println(this.gameBoard.getBoard()[row][col].getSquareElements());

                } else if (this.gameBoard.getBoard()[row][col].getType() == CS15SquareType.GHOST_START_LOCATION){
                    //int [] redTarget = this.pacman.getCoordinates();
                    this.pinkGhost = new Ghost(this.myPane, Color.FUCHSIA, this.gameBoard );
                    this.pinkGhost.setLocation(col * 30, row * 30);
                    this.gameBoard.getBoard()[row][col].addElement(this.pinkGhost);
                    System.out.println(this.gameBoard.getBoard()[row][col].getSquareElements());
                    //System.out.println(this.gameBoard.getBoard()[row][col].getSquareElements());

                    //int [] pinkTarget = {this.pacman.getCoordinates()[0], this.pacman.getCoordinates()[1] + (2*30)}; //2 spaces to the right of Pacman’s location
                    this.redGhost = new Ghost(this.myPane, Color.RED, this.gameBoard);
                    this.redGhost.setLocation(col * 30, (row * 30) - 60 );
                    this.gameBoard.getBoard()[row][col].addElement(this.redGhost);
                    //this.gameBoard.getBoard()[row][col].addElement(this.pinkGhost);
                    //System.out.println(this.gameBoard.getBoard()[row][col].getSquareElements());

                    //int [] greenTarget = {this.pacman.getCoordinates()[0] - (4*30), this.pacman.getCoordinates()[1]}; //4 spaces above Pacman’s location
                    this.greenGhost = new Ghost(this.myPane, Color.CHARTREUSE, this.gameBoard);
                    this.greenGhost.setLocation((col * 30) + 30, row * 30);
                    this.gameBoard.getBoard()[row][col].addElement(this.greenGhost);
                    //System.out.println(this.gameBoard.getBoard()[row][col].getSquareElements());

                    //int [] goldTarget = {this.pacman.getCoordinates()[0] +(30), this.pacman.getCoordinates()[1] - (3*30)}; //3 spaces to the left and 1 space down from Pacman’s location
                    this.goldGhost = new Ghost(this.myPane, Color.GOLD, this.gameBoard);
                    this.goldGhost.setLocation((col * 30) - 30, row * 30);
                    this.gameBoard.getBoard()[row][col].addElement(this.goldGhost);
                    //System.out.println(this.gameBoard.getBoard()[row][col].getSquareElements());

                }
            }
        }
    }

    private void checkCollision(){
        int row = this.pacman.getCoordinates()[1]/30;
        int col = this.pacman.getCoordinates()[0]/30;
        Square currentSquare = this.gameBoard.getBoard()[row][col];
        if (currentSquare.getSquareElements().size() != 0) {
            for (int i =0; i< currentSquare.getSquareElements().size(); i++) {
                this.score += currentSquare.getSquareElements().get(i).getScore();
                currentSquare.getSquareElements().get(i).executeCollision();
                currentSquare.removeElement(currentSquare.getSquareElements().get(i));
                this.sideBar.changeLabel("Score: "+this.getScore());

            }
        }
    }

    private void update(){
        KeyFrame keyFrame = new KeyFrame(Duration.millis(400), (ActionEvent e) -> {
            this.pacman.move();
            this.checkCollision();
            //this.pinkGhost.moveGhost();
        }
        );
        this.timeline = new Timeline(keyFrame);
        this.myPane.setOnKeyPressed((KeyEvent e) -> this.onKeyPressed(e));
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();

    }

    private void onKeyPressed(KeyEvent e){
        KeyCode keyPressed = e.getCode();
        switch(keyPressed){
            case UP:
                this.pacman.changeDirection(Direction.UP);
                //System.out.println(this.pacman.getCurrentDir());
                break;
            case DOWN:
                this.pacman.changeDirection(Direction.DOWN);
                //System.out.println(this.pacman.getCurrentDir());
                break;
            case LEFT:
                this.pacman.changeDirection(Direction.LEFT);
                //System.out.println(this.pacman.getCurrentDir());
                break;
            case RIGHT:
                this.pacman.changeDirection(Direction.RIGHT);
                //System.out.println(this.pacman.getCurrentDir());
                break;
            default:
                break;
        }
        e.consume();
    }
    public int getScore(){
        return this.score;
    }

    public Pane getMyPane(){
        return this.myPane;
    }

}
