import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    // The players' grids
    PlayerGridPanel playerGrid, computerGrid;
    // The menu bar along the top
    MenuBar menu;
    // Labels for the grids
    JLabel playerLabel, computerLabel;

    /**
     * Default constructor for objects of class GameWindow, 
     * contains tile grid and player interface
     */
    public GameWindow()
    {
        setSize(WIDTH, HEIGHT);
        setTitle("Battleship");
        setLayout(null);
        computerGrid = new PlayerGridPanel(false, null);
        add(computerGrid);        
        computerGrid.setBounds(OFFSET, OFFSET-50, computerGrid.getSize().width, computerGrid.getSize().height);
        playerGrid = new PlayerGridPanel(true, computerGrid);
        add(playerGrid);
        playerGrid.setBounds(WIDTH-OFFSET-playerGrid.getSize().width, OFFSET-50, playerGrid.getSize().width, computerGrid.getSize().height);
        computerGrid.setOpponent(playerGrid);
        menu = new MenuBar(playerGrid, computerGrid);
        add(menu);
        menu.setBounds(WIDTH/2-menu.getSize().width/2, HEIGHT-150, menu.getSize().width, menu.getSize().height);
        playerLabel = new JLabel("Player 1");
        add(playerLabel);
        playerLabel.setBounds(868, 60, 100, 20);
        computerLabel = new JLabel("Computer");
        add(computerLabel);
        computerLabel.setBounds(282, 60, 100, 20);
    }

    /**
     * Main method to run everything
     */
    public static void main(String[]args)
    {
        GameWindow game = new GameWindow();
        game.setDefaultCloseOperation(EXIT_ON_CLOSE);
        game.setVisible(true);
    }

}
