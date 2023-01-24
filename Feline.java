
import java.util.Random;
/**
 * class feline extends critter
 * 3 instance vars
 */
public class Feline extends Critter {
    protected int moveCount; 
    protected int eatCount; 
    protected Direction currDir; 
    private static final String SPECIES_NAME = "Fe";

    /**
     * default no arg ctor
     */
    public Feline() {
        // TODO
        super(SPECIES_NAME);
        currDir = Direction.CENTER;
        moveCount = 0;
        eatCount = 1;
    }

    /**
     * helper method
     * put it inside of getmove so leopard and
     * ocelot can use it. 
     * @return direction
     */
    protected Direction currDir()
    {
        int ranDir = random.nextInt(4);
        if( ranDir == 0 ) {
            currDir = Direction.NORTH;
        }
        if( ranDir == 1 ) {
            currDir = Direction.SOUTH;
        }
        if( ranDir == 2 )
        {
            currDir = Direction.EAST;
        }
        if( ranDir == 3 )
        {
            currDir = Direction.WEST;
        }
        return currDir;
    }
    /**
     * change direction after 5 moves
     * @return Direction
     */
    @Override
    public Direction getMove() {
        // TODO    
        //increment each time its called
        //currDir stay same until 5th move
        if( moveCount == 5 )
        {
            moveCount = 0;
            currDir = currDir(); 
            //update randomdirection
        }
        moveCount++;
        return currDir;
    }    

    /**
     * animal eats or not
     * @return boolean
     */
    @Override
    public boolean eat() {
        // TODO
        //fix if eatcount and no food yet
        if( eatCount == 3)
        {
            eatCount = 1;
            return true;
        }
        eatCount++;
        return false;
    }

    /**
     * param opponent
     * @return attack
     */
    @Override
    public Attack getAttack( String opponent ){
       // TODO
       return Attack.POUNCE;
    }
}