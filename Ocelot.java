
import java.awt.Color;

/**
 * class ocelot extends leopard
 * instancevar name
 */
public class Ocelot extends Leopard {

    private static final String SPECIES_NAME = "Oce";

    /**
     * no arg ctor default
     */
    public Ocelot() {
        displayName = SPECIES_NAME;
    }

    /**
     * @return COlor
     */
    @Override
    public Color getColor() {
        return Color.LIGHT_GRAY;
    }

    /**
     * @return Attack
     * This method is called from getAttack(String opponent)
     */
    @Override
    protected Attack generateAttack(String opponent) {
        Attack a = Attack.FORFEIT;
        if (opponent.equals("Lion") || opponent.equals("Fe") ||
                opponent.equals("Lpd"))
            a = Attack.SCRATCH;
        else
            a = Attack.POUNCE;
        return a;

    }

}