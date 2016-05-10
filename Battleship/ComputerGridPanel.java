import java.awt.*;
import java.awt.event.*;

/**
 * The grid panel for the computer player.  Almost exactly the same as the player grid except it 
 * does not show the ships like it does for the player.
 * 
 * @author David Fei
 * @version 4/15/16
 */
public class ComputerGridPanel extends PlayerGridPanel
{
    /**
     * Constructor for objects of class ComputerGridPanel
     */
    public ComputerGridPanel()
    {
        super(false);
        addMouseListener(new PlayerMoveMaker());
    }
    
    public class PlayerMoveMaker implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
            int x = e.getX();
            int y = e.getY();
        }

        public void mouseEntered(MouseEvent e){}

        public void mouseExited(MouseEvent e){}

        public void mousePressed(MouseEvent e){}

        public void mouseReleased(MouseEvent e){}
    }   
    
}
