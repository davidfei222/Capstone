import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * An individual tile on the map that contains either ocean or a ship section.
 * 
 * @author David Fei
 * @version 4/13/16
 */
abstract public class Tile
{    
    //The height of the tile
    private static final int HEIGHT = 30;
    //The width of the tile
    private static final int WIDTH = 30;
    //The background of the tile
    private Color background;
    //The state of the tile
    private boolean state;
    //Rectangle object for the tile
    private Rectangle2D tile;

    /**
     * Default constructor for objects of class Tile
     * 
     * @param   x   X coordinate of placement
     * @param   y   Y coordinate of placement
     * @param   bkgrnd  Background color of tile
     */
    public Tile(int x, int y, Color bkgrnd)
    {
        this.state = false;
        this.background = bkgrnd;
        this.tile = new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
    }
    
    /**
     * Draws all the tiles onto the grid panel
     * 
     * @param   g2  Graphics module
     */
    public void draw(Graphics2D g2)
    {
        g2.setColor(this.background);
        g2.draw(tile);
        g2.fill(tile);
    }
    
    /**
     * Sets the tile to a new location
     * 
     * @param   x   New x coordinate
     * @param   y   New y coordinate
     */
    public void setLocation(int x, int y)
    {
        this.tile = new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
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
     * Checks to see if the given coordinates are inside the tile
     * 
     * @param   x   X coordinate of the point
     * @param   y   Y coordinate of the point
     * @return  True if inside, false if not
     */
    public boolean isInside(int x, int y)
    {
        return this.tile.contains(x,y);
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
     * Gets the x coordinate of the upper left corner of the tile
     * 
     * @return  The x coordinate of the upper left corner in int form
     */
    public int getX()
    {
        return(int)(tile.getX());
    }
    
    /**
     * Gets the y coordinate of the upper left corner of the tile
     * 
     * @return  The y coordinate of the upper left corner in int form
     */
    public int getY()
    {
        return (int)(tile.getY());
    }
    
    /**
     * Returns the ID of the tile
     * 
     * @return  The ID of the tile
     */
    abstract public int getID();
    

}
