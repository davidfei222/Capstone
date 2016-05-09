import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    private static final int WIDTH = 500;
    //Height of the bar
    private static final int HEIGHT = 130;
    //Player grid that is being controlled
    PlayerGridPanel playerGrid;
    //Computer grid that is being controlled
    ComputerGridPanel computerGrid;
    //JLabels for start of game messages
    private JLabel startMsg;
    //Buttons for setting up the player grid
    private JButton startButton, setBship, setDest, setPboat, reset;

    /**
     * Constructor for the menu before the game starts
     * 
     * @param   player  The player's grid
     * @param   computer    The computer player's grid
     * @param   game    The game window
     */
    public MenuBar(PlayerGridPanel player, ComputerGridPanel computer)
    {
        playerGrid = player;
        computerGrid = computer;
        setSize(WIDTH, HEIGHT);
        setBackground(null);
        ActionListener buttonListener = new ButtonListener();
        //Layout manager
        GridLayout layout = new GridLayout(4,2);
        layout.setHgap(20);
        layout.setVgap(10);
        setLayout(layout);
        //Label for start message
        startMsg = new JLabel("Place ships on grid by clicking on tiles", SwingConstants.CENTER);
        add(startMsg);
        //Filler box
        //Panel filler = new JPanel();
        //filler.setBackground(Color.RED);
        //add(filler);
        //Buttons to be added        
        setBship = new JButton("Set battleship");
        setBship.addActionListener(buttonListener);
        add(setBship);
        startButton = new JButton("Start game");
        startButton.addActionListener(buttonListener);
        add(startButton);
        setDest = new JButton("Set destroyer");
        setDest.addActionListener(buttonListener);
        add(setDest);                       
        reset = new JButton("Reset all tiles");
        reset.addActionListener(buttonListener);
        add(reset);
        setPboat = new JButton("Set patrol boat");
        setPboat.addActionListener(buttonListener);
        add(setPboat); 
        //More filler boxes
        JPanel filler2 = new JPanel();
        filler2.setBackground(null);
        add(filler2);
        JPanel filler3 = new JPanel();
        filler3.setBackground(null);
        add(filler3);
    }

    /**
     * Constructor for the menu after the game starts
     */
    public MenuBar()
    {
    }

    public class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equals("Set battleship"))
            {
                playerGrid.setCurrentShip(1);
            }
            else if(e.getActionCommand().equals("Set destroyer"))
            {
                playerGrid.setCurrentShip(2);
            }
            else if(e.getActionCommand().equals("Set patrol boat"))
            {
                playerGrid.setCurrentShip(3);
            }
            else if(e.getActionCommand().equals("Reset all tiles"))
            {
                playerGrid.resetTiles();
            }
            else if(e.getActionCommand().equals("Start game"))
            {
                if(playerGrid.isReady())
                {
                    computerGrid.setShip(Color.BLACK, 1);
                    computerGrid.setShip(Color.BLACK, 2);
                    computerGrid.setShip(Color.BLACK, 3);
                }
            }

        }
    }
}
