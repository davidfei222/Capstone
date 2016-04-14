import javax.swing.*;
import java.awt.*;

/**
 * An individual tile on the map that contains either ocean or a ship section.
 * 
 * @author David Fei
 * @version 4/13/16
 */
abstract public class Tile extends JPanel
{
    /** The height of the tile*/
    private static final int HEIGHT = 20;
    /** The width of the tile*/
    private static final int WIDTH = 20;
    /** The background of the tile */
    private Color background;
    /** The state of the tile*/
    private boolean state;

    /**
     * Default constructor for objects of class Tile
     */
    public Tile(Color bkgrnd)
    {
        setSize(WIDTH, HEIGHT);
        this.background = bkgrnd;
        setBackground(background);
        this.state = false;
    }

    /**
     * Sets the state of the tile
     *
     * @param    status   The new state of the tile
     */
    public void setState(boolean status)
    {
        this.state = status;        
    }
    
    /**
     * Returns the state of the tile
     * 
     * @return   True if the tile is hit, false if not
     */
    public boolean getState()
    {
        return this.state;
    }
    
    /**
     * Returns the ID of the tile
     * 
     * @return  The ID of the tile
     */
    abstract public int getID();
    

}
