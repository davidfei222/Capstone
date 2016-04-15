import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Panel for the player that holds the tile grid with the ocean and ships on it
 * 
 * @author David Fei
 * @version 4/13/16
 */
public class PlayerGridPanel extends JPanel
{
    //Width of the panel
    private static final int WIDTH = 320;
    //Height of the panel
    private static final int HEIGHT = 320;
    //2D array for all the tiles in the grid
    private Tile[][] tiles;
    //Array for a battleship, destroyer and patrol boat tiles
    private ShipTile[] battleship, destroyer, pboat;
    //Counts for the length of the battleship, destroyer, and patrol boat arrays
    private int bshipL, destL, pboatL;

    /**
     * Constructor for objects of class GridPanel
     */
    public PlayerGridPanel()
    {
        setSize(WIDTH, HEIGHT);
        tiles = new Tile[10][10];
        int offsetx = 0;
        int offsety = 0;
        for(int x = 0; x<tiles.length; x++)
        {
            for(int y = 0; y<tiles[x].length; y++)
            {
                tiles[x][y] = new OceanTile(0+offsetx,0+offsety,Color.BLUE);
                offsetx += 32;
            }
            offsetx = 0;
            offsety += 32;
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
     * Method to set the battleship tiles for the player
     */
    public void setBattleship()
    {
        
    }
    
    /**
     * Method to set the destroyer tiles for the player
     */
    public void setDestroyer()
    {
        
    }
    
    /**
     * Method to set the patrol boat tiles for the player
     */
    public void setPboat()
    {
        
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
    
    public class ShipSetListener implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
        }
        
        public void mouseEntered(MouseEvent e){}
        
        public void mouseExited(MouseEvent e){}
        
        public void mousePressed(MouseEvent e){}
        
        public void mouseReleased(MouseEvent e){}
    }
}
