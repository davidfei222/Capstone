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
    private static final int HEIGHT = 650;
    // Width of the window
    private static final int WIDTH = 1200;
    // Offset from the edges of the screen for grids
    private static final int OFFSET = 150;
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
        setLayout(null);
        playerGrid = new PlayerGridPanel();
        add(playerGrid);
        playerGrid.setBounds(OFFSET, OFFSET-50, playerGrid.getSize().width, playerGrid.getSize().height);
        menu = new MenuBar(playerGrid);
        add(menu);
        menu.setBounds(WIDTH/2-menu.getSize().width/2, HEIGHT-150, menu.getSize().width, menu.getSize().height);
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
