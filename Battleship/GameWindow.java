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

    /**
     * Default constructor for objects of class GameWindow, 
     * contains tile grid and player interface
     */
    public GameWindow()
    {
        setSize(WIDTH, HEIGHT);
        setTitle("Battleship");
        setLayout(null);
        playerGrid = new PlayerGridPanel(true);
        add(playerGrid);
        playerGrid.setBounds(OFFSET, OFFSET-50, playerGrid.getSize().width, playerGrid.getSize().height);
        computerGrid = new PlayerGridPanel(false);
        add(computerGrid);
        computerGrid.setBounds(WIDTH-OFFSET-computerGrid.getSize().width, OFFSET-50, computerGrid.getSize().width, playerGrid.getSize().height);
        menu = new MenuBar(playerGrid, computerGrid);
        add(menu);
        menu.setBounds(WIDTH/2-menu.getSize().width/2, HEIGHT-150, menu.getSize().width, menu.getSize().height);
        addMouseListener(new MoveMaker());
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

    public class MoveMaker implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
            if(playerGrid.inGame() && computerGrid.inGame())
            {
                int x = e.getX();
                int y = e.getY();
                boolean madeMove = computerGrid.playerMove(x,y);                
                if(madeMove)
                {
                    playerGrid.randomMove();
                }   
                playerGrid.repaint();
                computerGrid.repaint();
                if(playerGrid.hasLost())
                {
                    System.out.println("Computer player has won");
                }
                else if(computerGrid.hasLost())
                {
                    System.out.println("Human player has won");
                }
                
            }

        }

        public void mouseEntered(MouseEvent e){}

        public void mouseExited(MouseEvent e){}

        public void mousePressed(MouseEvent e){}

        public void mouseReleased(MouseEvent e){}
    } 
}
