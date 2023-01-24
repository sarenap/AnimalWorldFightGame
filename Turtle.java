
import java.awt.Color;

/**
 * class turtle extends critter.
 */
public class Turtle extends Critter {

    private static final String SPECIES_NAME = "Tu";

    /**
     * default no arg ctor
     */
    public Turtle() {
        super(SPECIES_NAME);
    }

    /**
     * @return COlor
     */
    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    /**
     * @return Direction
     */
    @Override
    public Direction getMove() {
        return Direction.WEST;
    }

    /**
     * only eat when there are no hostile animals adjacent to the Turtle
     * (hostile animals are anything that is not an empty space, food, or Turtle).
     * 
     * @return boolean
     */
    @Override
    public boolean eat() {
        String arrayDir[] = new String[4];
        arrayDir[0] = info.getNeighbor(Direction.NORTH);
        arrayDir[1] = info.getNeighbor(Direction.SOUTH);
        arrayDir[2] = info.getNeighbor(Direction.EAST);
        arrayDir[3] = info.getNeighbor(Direction.WEST);
        for (String dir : arrayDir) {//hostile
            if (!dir.equals(" ") && !dir.equals(".") &&
             !dir.equals(SPECIES_NAME)) return false; 
        }
        return true;
    }

    /**
     * 50% chance attack/forfeit
     * 
     * @return attack
     */
    @Override
    public Attack getAttack(String opponent) {
        int chance = random.nextInt(2);
        if (chance == 0)
            return Attack.ROAR;
        else
            return Attack.FORFEIT;
    }
}