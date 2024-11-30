package pacman;

import javafx.scene.layout.Pane;

public class Energizer extends Dot implements Collidable{
    private int energizerScore;
    public Energizer(Pane pane) {
        super(pane);
        this.setSize(8);
        this.energizerScore = 100;
    }

    @Override
    public int getScore(){
        return this.energizerScore;
    }

}
