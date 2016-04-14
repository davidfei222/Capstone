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

    /**
     * Default constructor for objects of class Tile
     */
    public Tile(Color bkgrnd)
    {
        setSize(WIDTH, HEIGHT);
        this.background = bkgrnd;
        setBackground(background);
    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public void sampleMethod(int y)
    {
        // put your code here
        
    }
    
    abstract public int getID();
    

}
