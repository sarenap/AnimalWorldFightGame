
import java.awt.Color;
import java.util.Random;

/**
 * class elephant extends critter
 * 3 instance vars. xy coord of goal,
 * name
 */
public class Elephant extends Critter {

    protected static int goalX;
    protected static int goalY;
    private static final String SPECIES_NAME = "El";

    /**
     * default no arg ctor
     */
    public Elephant() {
        super(SPECIES_NAME);
        goalX = 0;
        goalY = 0;
    }

    /**
     * @return Color
     */
    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    /**
     * move in the x or y direction
     * randomize goal when reached
     * 
     * @return direction
     */
    @Override
    public Direction getMove() {
        Direction dir = Direction.CENTER;
        if (info.getX() == goalX && info.getY() == goalY) 
        {
            goalX = random.nextInt(info.getWidth());
            goalY = random.nextInt(info.getHeight());
            // bounds
        }

        if (info.getX() != goalX) {
            if (info.getX() - goalX < 0)
                dir = Direction.EAST;
            else
                dir = Direction.WEST;
        }

        if (info.getY() != goalY) {
            if (info.getY() - goalY < 0)
                dir = Direction.SOUTH;
            else
                dir = Direction.NORTH;
        }
        return dir;
    }

    /**
     * @return true
     */
    @Override
    public boolean eat() {
        return true;
    }

    /**
     * increment level by 2
     */
    @Override
    public void mate() {
        incrementLevel(2);
    }

    /**
     * reset goal x & y to 0
     */
    @Override
    public void reset() {
        goalX = 0;
        goalY = 0;
    }
}