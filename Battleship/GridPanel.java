import javax.swing.*;
import java.awt.*;

/**
 * Panel that holds the tile grid with the ocean and ships on it
 * 
 * @author David Fei
 * @version 4/13/16
 */
public class GridPanel extends JPanel
{
    /**2D array for all the tiles in the grid*/
    private Tile[][] tiles;
    /**Array for a battleship's tiles*/
    private ShipTile[] battleship;
    /**Array for a destroyer's tiles*/
    private ShipTile[] destroyer;
    /**Array for a patrol boat's tiles*/
    private ShipTile[] pboat;

    /**
     * Constructor for objects of class GridPanel
     */
    public GridPanel()
    {
        tiles = new Tile[10][10];
        for(int x = 0; x<tiles.length; x++)
        {
            for(int y = 0; y<tiles[x].length; y++)
            {
                tiles[x][y] = new OceanTile();
                add(tiles[x][y]);
                tiles[x][y].setVisible(true);
            }
        }        
        battleship = new ShipTile[4];
        destroyer = new ShipTile[3];
        pboat = new ShipTile[2];
        for(int i = 0; i<battleship.length; i++)
        {
            battleship[i] = new ShipTile(1);
            if(i<3)
            {
                destroyer[i] = new ShipTile(2);
            }
            if(i<2)
            {
                pboat[i] = new ShipTile(3);
            }
        }        
    }

    /**
     * Draws all of GridPanel's components in
     * 
     * @param   g   Graphics module
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
    }
}
