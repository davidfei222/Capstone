import java.awt.*;
import java.awt.geom.*;

/**
 * Write a description of class ShipTile here.
 * 
 * @author David Fei
 * @version 4/13/16
 */
public class ShipTile extends Tile
{
    //ID number indicating what kind of ship it is 
    private int id;

    /**
     * Default constructor for objects of class ShipTile
     * 
     * @param   x   X coordinate of placement
     * @param   y   Y coordinate of placement
     * @param   bkgrnd  Background color of ti
     * @param   idIn    The ID number of the ship tile (table of values can be found in the README)
     */
    public ShipTile(int x, int y, Color bkgrnd, int idIn)
    {
        super(x,y,bkgrnd);
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
