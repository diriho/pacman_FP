package pacman;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Board {
    private CS15SquareType[][] myMaze;

    private Pane pane;

    private Square[][] myBoard;

    public Board(Pane pane){
        this.pane = pane;
        this.myMaze = SupportMap.getSupportMap();
        this.setMyBoard();

    }

    private void setMyBoard(){
        //setting the smartSquares of the board
        this.myBoard = new Square[23][23];
        for (int i = 0; i<this.myBoard.length; i++) {
            for (int j = 0; j < this.myBoard[0].length; j++) {
                this.myBoard[j][i] = new Square(this.pane, this.myMaze[j][i]);
                this.myBoard[j][i].setLocation(i*30, j*30);
                if (this.myBoard[j][i].getType() == CS15SquareType.WALL){
                    this.myBoard[j][i].setColor(Color.BLUE);
                    //System.out.println(this.myBoard[j][i]);
                    //System.out.println(this.myMaze[j][i]);
                } else {
                    this.myBoard[j][i].setColor(Color.BLACK);
                    //System.out.println(this.myBoard[j][i]);
                    //System.out.println(this.myMaze[j][i]);
                }
            }
        }

    }
    public boolean isWall(int rw, int col){
        if (this.myBoard[rw][col].getType() == CS15SquareType.WALL){
            return true;
        }
        return false;
    }

    public Square[][] getBoard(){
        return this.myBoard;
    }

}

