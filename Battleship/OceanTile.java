import java.awt.*;

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
     */
    public OceanTile()
    {
        super(Color.BLUE);
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
