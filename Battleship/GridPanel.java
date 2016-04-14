import javax.swing.*;

/**
 * Panel that holds the tile grid with the ocean and ships on it
 * 
 * @author David Fei
 * @version 4/13/16
 */
public class GridPanel extends JPanel
{
    /**2D array for all the tiles in the grid*/
    private Tile[] tiles;
    /**Array for a battleship's tiles*/
    private ShipTile[] battleship;
    /**Array for a destroyer's tiles*/
    private ShipTile[] destroyer;
    /**Array for a patrol boat's tiles*/
    private ShipTile[] PTboat;

    /**
     * Constructor for objects of class GridPanel
     */
    public GridPanel()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void sampleMethod(int y)
    {
        
    }
}
