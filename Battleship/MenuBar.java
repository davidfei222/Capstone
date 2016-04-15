import javax.swing.*;
import java.awt.*;

/**
 * Panel that holds the scores, number of turns, and ships left for each player.
 * Before the game starts, it holds buttons for setting ships on the player's grid.
 * 
 * @author David Fei 
 * @version 4/15/16
 */
public class MenuBar extends JPanel
{
    //Width of the bar
    private static final int WIDTH = 700;
    //Height of the bar
    private static final int HEIGHT = 50;
    //JLabel for start of game message
    private JLabel startMsg;

    /**
     * Constructor for the menu before the game starts
     */
    public MenuBar()
    {
        setSize(WIDTH, HEIGHT);
        setBackground(Color.RED);
        startMsg = new JLabel("Set your ships to start the game");
        add(startMsg);
    }
    
    /**
     * Constructor for the menu after the game starts
     */
    public MenuBar(PlayerGridPanel panel)
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
