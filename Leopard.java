
import java.awt.Color;

/**
 * class leopard extends feline
 * 2 instance var confidence and name
 */
public class Leopard extends Feline {
    
    protected static int confidence = 1;
    private static final String SPECIES_NAME = "Lpd";

    /**
     * default no arg ctor
     */
    public Leopard() {
        super();
        displayName = SPECIES_NAME;
    }

    /**
     * @return color
     */
    @Override
    public Color getColor() {
        return Color.RED;
    }

    /**
     * @return direction
     *         check for food/patrick in 4 directions
     */
    @Override
    public Direction getMove() {
        String arrayDir[] = new String[4];
        // array stores strings on the world
        arrayDir[0] = info.getNeighbor(Direction.NORTH);
        arrayDir[1] = info.getNeighbor(Direction.SOUTH);
        arrayDir[2] = info.getNeighbor(Direction.EAST);
        arrayDir[3] = info.getNeighbor(Direction.WEST);
        for (int i = 0; i < arrayDir.length; i++) {
            if (arrayDir[i].equals(".") || arrayDir[i].equals("Patrick")) {
                if (i == 0)
                    currDir = Direction.NORTH;
                else if (i == 1)
                    currDir = Direction.SOUTH;
                else if (i == 2)
                    currDir = Direction.EAST;
                else if (i == 3)
                    currDir = Direction.WEST;
                break; // stop once found direction!
            } else
                currDir = currDir(); // inherit from feline
            // move random if no foods around leopard
        }
        return currDir;
    }

    /**
     * set chance based on confidence
     * 
     * @return boolean
     */
    @Override
    public boolean eat() {
        int percent = 10 * confidence;
        int chance = random.nextInt(100);
        if (chance >= 0 && chance < percent)
            return true;
        return false;
    }

    /**
     * increase confidence
     */
    @Override
    public void win() {
        if (confidence < 10)
            confidence++;
    }

    /**
     * decrease confidence
     */
    @Override
    public void lose() {
        if (confidence > 0)
            confidence--;
    }

    /**
     * calls helper method
     * 
     * @return Attack
     */
    @Override
    public Attack getAttack(String opponent) {
        if (opponent.equals("Tu") || confidence > 5) {
            return Attack.POUNCE;
        } else
            return generateAttack(opponent);
    }

    /**
     * helper method to randomize attack
     * 
     * @return Attack
     */
    protected Attack generateAttack(String opponent) {
        Attack a = Attack.FORFEIT;
        if (opponent.equals("Patrick"))
            return Attack.FORFEIT;

        int ranAttack = random.nextInt(3);
        if (ranAttack == 0) {
            a = Attack.POUNCE;
        }
        if (ranAttack == 1) {
            a = Attack.SCRATCH;
        }
        if (ranAttack == 2) {
            a = Attack.ROAR;
        }
        return a;
    }

    /**
     * set confidence = 0
     */
    @Override
    public void reset() {
        confidence = 0;
    }
}