/**
 * Name: Sarena Pham

import java.awt.Color;

/**
 * class Lion extends feline, has 3
 * instance variables and overrides methods
 */
public class Lion extends Feline {
    private int fights;
    private static final String SPECIES_NAME = "Lion";
    private static final String SPECIES_NAME2 = "noiL";

    /**
     * default no arg ctor
     */
    public Lion() {
        fights = 0;
        currDir = Direction.CENTER;
        displayName = SPECIES_NAME;
    }

    /**
     * @return Color
     */
    @Override
    public Color getColor() {
        return Color.YELLOW;
    }

    /**
     * @return direciton
     */
    @Override
    public Direction getMove() {
        if (moveCount >= 0 && moveCount <= 4)
            currDir = Direction.EAST;
        if (moveCount >= 5 && moveCount <= 9)
            currDir = Direction.SOUTH;
        if (moveCount >= 10 && moveCount <= 14)
            currDir = Direction.WEST;
        if (moveCount >= 15 && moveCount <= 19) {
            currDir = Direction.NORTH;
            if (moveCount == 19)
                moveCount = 0; // rset
        }
        moveCount++;
        return currDir;
    }

    /**
     * Return true if the Lion has won at least
     * one fight since it last ate or slept.
     * 
     * @return boolean
     */
    @Override
    public boolean eat() {
        // lion hungry from fight
        if (fights >= 1) {
            fights = 0;
            return true;
        }
        return false;
    }

    /**
     * increment fights if called
     */
    @Override
    public void win() {
        fights++;
    }

    /**
     * reset fights and change name
     */
    @Override
    public void sleep() {
        fights = 0;
        displayName = SPECIES_NAME2;
    }

    /**
     * change name
     */
    @Override
    public void wakeup() {
        displayName = SPECIES_NAME;
    }
}