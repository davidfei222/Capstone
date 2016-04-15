import javax.swing.*;
import java.awt.*;

/**
 * The window that displays the game
 * 
 * @author David Fei
 * @version 4/13/16
 */
public class GameWindow extends JFrame
{
    // Height of the window
    private static final int HEIGHT = 700;
    // Width of the window
    private static final int WIDTH = 1100;
    // The player's grid
    PlayerGridPanel playerGrid;
    // The menu bar along the top
    MenuBar menu;

    /**
     * Default constructor for objects of class GameWindow, 
     * contains tile grid and player interface
     */
    public GameWindow()
    {
        setSize(WIDTH, HEIGHT);
        setTitle("Battleship");
        this.playerGrid = new PlayerGridPanel();
        add(this.playerGrid, BorderLayout.CENTER);
        this.menu = new MenuBar();
        add(this.menu, BorderLayout.SOUTH);
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
