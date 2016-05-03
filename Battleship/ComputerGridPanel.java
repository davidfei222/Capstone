
/**
 * The grid panel for the computer player.  Almost exactly the same as the player grid except it 
 * does not show the ships like it does for the player.
 * 
 * @author David Fei
 * @version 4/15/16
 */
public class ComputerGridPanel extends PlayerGridPanel
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class ComputerGridPanel
     */
    public ComputerGridPanel()
    {
        // initialise instance variables
        x = 0;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
