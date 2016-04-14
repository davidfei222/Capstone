import javax.swing.*;

/**
 * The window that displays the game
 * 
 * @author David Fei
 * @version 4/13/16
 */
public class GameWindow extends JFrame
{
    /** Height of the window*/
    private static final int HEIGHT = 700;
    /** Width of the window*/
    private static final int WIDTH = 1100;

    /**
     * Default constructor for objects of class GameWindow, 
     * contains tile grid and player interface
     */
    public GameWindow()
    {
        setSize(WIDTH, HEIGHT);
        setTitle("Battleship");
        GridPanel playerGrid = new GridPanel();
        add(playerGrid);
        add(new MenuPanel());
    }
    
    /**
     * Main method to run everything
     */
    public static void main(String[]args)
    {
        GameWindow game = new GameWindow();
        game.setVisible(true);
    }
}
