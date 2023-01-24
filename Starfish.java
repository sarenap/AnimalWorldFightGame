
import java.awt.Color;

/**
 * class starfish extends critter
 * instance var name
 */
public class Starfish extends Critter {
    private static final String SPECIES_NAME = "Patrick";

    /**
     * Default constructor - creates critter 
     * with name Patrick
     */
    public Starfish() {
        super(SPECIES_NAME);
    }

    /**
     * @return Direction center
     */
    @Override
    public Direction getMove() {
        // TODO
        return Direction.CENTER;
    }

    /**
     * Returns the color of the Starfish
     * @return Color pink
     */
    @Override 
    public Color getColor() {
        return Color.PINK;
    }
}