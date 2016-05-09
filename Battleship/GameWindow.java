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
    // The computer's grid
    ComputerGridPanel computerGrid;
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
        computerGrid = new ComputerGridPanel();
        add(computerGrid);
        computerGrid.setBounds(WIDTH-OFFSET-computerGrid.getSize().width, OFFSET-50, computerGrid.getSize().width, playerGrid.getSize().height);
        menu = new MenuBar(playerGrid, computerGrid);
        add(menu);
        menu.setBounds(WIDTH/2-menu.getSize().width/2, HEIGHT-150, menu.getSize().width, menu.getSize().height);
    }
    
    /**
     * Adds the computer player's grid to the game window
     */
    public static void addGrid(PlayerGridPanel grid)
    {
        //add(grid);
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
