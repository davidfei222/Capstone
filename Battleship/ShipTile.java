import java.awt.*;

/**
 * Write a description of class ShipTile here.
 * 
 * @author David Fei
 * @version 4/13/16
 */
public class ShipTile extends Tile
{
    /** ID number indicating what kind of ship it is */
    private int id;

    /**
     * Default constructor for objects of class ShipTile
     * 
     * @param   idIn    The ID number of the ship tile (table of values can be found in the README)
     */
    public ShipTile(int idIn)
    {
        super(Color.GRAY);
        this.id = idIn;
    }
            
    /**
     * Returns the ID number of the tile
     * 
     * @return  The ID number of the ship tile
     */
    public int getID()
    {
        return id;
    }
}
