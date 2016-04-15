import java.awt.*;
import java.awt.geom.*;

/**
 * Tile for the ocean
 * 
 * @author David Fei 
 * @version 4/13/16
 */
public class OceanTile extends Tile
{    
    /**
     * Default constructor for objects of class OceanTile
     * 
     * @param   x   X coordinate of placement
     * @param   y   Y coordinate of placement
     * @param   bkgrnd  Background color of tile
     */
    public OceanTile(int x, int y, Color bkgrnd)
    {
        super(x,y,bkgrnd);
    }
    
    /**
     * Returns the ID number of the tile
     * 
     * @return  The ID number for ocean tiles(0)
     */
    public int getID()
    {
        return 0;
    }
}
