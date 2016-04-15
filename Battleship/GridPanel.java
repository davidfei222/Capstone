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
        setSize(700,1000);
        tiles = new Tile[10][10];
        int offsetx = 0;
        int offsety = 0;
        for(int x = 0; x<tiles.length; x++)
        {
            for(int y = 0; y<tiles[x].length; y++)
            {
                tiles[x][y] = new OceanTile(0+offsetx,0+offsety,Color.BLUE);
                offsetx += 22;
            }
            offsetx = 0;
            offsety += 22;
        }        
        battleship = new ShipTile[4];
        destroyer = new ShipTile[3];
        pboat = new ShipTile[2];
        for(int i = 0; i<battleship.length; i++)
        {
            //battleship[i] = new ShipTile(1);
            if(i<3)
            {
                //destroyer[i] = new ShipTile(2);
            }
            if(i<2)
            {
                //pboat[i] = new ShipTile(3);
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
        Graphics2D g2 = (Graphics2D) g;
        for(int x = 0; x<tiles.length; x++)
        {
            for(int y = 0; y<tiles[x].length; y++)
            {
                tiles[x][y].draw(g2);
            }
        } 
    }
}
