import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.util.Random;

/**
 * Panel for the player that holds the tile grid with the ocean and ships on it
 * 
 * @author David Fei
 * @version 4/13/16
 */
public class PlayerGridPanel extends JPanel
{
    //Width of the panel
    private static final int WIDTH = 320;
    //Height of the panel
    private static final int HEIGHT = 320;
    //Offsets for tile placement
    private int offsetx, offsety;
    //2D array for all the tiles in the grid
    private Tile[][] tiles;
    //Array containing references to battleship, destroyer and patrol boat tiles
    private Tile[] battleship, destroyer, pboat;
    //Lengths of the battleship, destroyer, and patrol boat arrays
    private int bshipL, destL, pboatL;
    //Variable controlling what ship is currently being set (based on table of ship ID values)
    private int currentShip;
    //Indexing for the ship arrays (prevent out of bounds exceptions)
    private int bshipI, destI, pboatI = 0;
    //Boolean indicating whether the player has started or not
    private boolean isStarted;

    /**
     * Constructor for objects of class GridPanel
     * 
     * @param   player  Checks if the panel belongs to the player or not to decide which listener to assign
     */
    public PlayerGridPanel(boolean player)
    {
        setSize(WIDTH, HEIGHT);
        tiles = new Tile[10][10];
        offsetx = 0;
        offsety = 0;
        for(int x = 0; x<tiles.length; x++)
        {
            for(int y = 0; y<tiles[x].length; y++)
            {
                tiles[x][y] = new OceanTile(0+offsetx,0+offsety,Color.BLUE);
                offsetx += 32;
            }
            offsetx = 0;
            offsety += 32;
        }        
        battleship = new ShipTile[4];
        destroyer = new ShipTile[3];
        pboat = new ShipTile[2];
        currentShip = 0;
        if(player)
        {
            addMouseListener(new ShipSetListener());
        }
        isStarted = false;
    }

    /**
     * Resets all of the tiles on the grid
     */
    public void resetTiles()
    {
        for(int x = 0; x<tiles.length; x++)
        {
            for(int y = 0; y<tiles[x].length; y++)
            {
                if(tiles[x][y].getID()>0)
                {
                    Tile tile = tiles[x][y];
                    tiles[x][y] = new OceanTile(tile.getX(),tile.getY(),Color.BLUE);
                }
            }
        }
        bshipI = 0; 
        destI = 0; 
        pboatI = 0;
        repaint();
    }

    /**
     * Sets the ship that is currently being placed, controlled by buttons on MenuBar
     * 
     * @param   current   ID value of the ship being set
     */
    public void setCurrentShip(int current)
    {
        currentShip = current;
    }

    /**
     * Sets a specified ship's tiles randomly
     * 
     * @param   color   Color of the tiles for the ships
     * @param   id  The ID value of the ship
     */
    public void setShip(Color color, int id)
    {   
        int length;
        if(id == 1)
        {
            length = 4;
        }
        else if(id == 2)
        {
            length = 3;
        }
        else
        {
            length = 2;
        }
        Random dice1 = new Random();
        int randomRow = dice1.nextInt(tiles.length);
        int randomCol = dice1.nextInt(tiles[0].length);
        while(tiles[randomRow][randomCol].getID() != 0)
        {
            randomRow = dice1.nextInt(tiles.length);
            randomCol = dice1.nextInt(tiles[0].length);
        }
        int startRow = randomRow;
        int startCol = randomCol;
        //0 = north, 1 = south, 2 = west, 3 = east
        int direction = dice1.nextInt(4);
        //Track how many tiles of the ship have been set
        int currentI = 0;
        if(direction == 0)
        {
            boolean readyToSet = false;
            int nonOceanTiles = 0;
            //Checks all the tiles for the length of the ship to see if there are enough empty ocean tiles
            //If not, picks a new location and checks again
            while(readyToSet == false)
            {
                if(randomRow-length>=length)
                {
                    for(int i = 0; i<length-1; i++)
                    {
                        randomRow--;
                        if(tiles[randomRow][randomCol].getID() != 0)
                        {
                            nonOceanTiles++;
                        }                    
                    }

                    if(nonOceanTiles > 0)
                    {
                        randomRow = dice1.nextInt(tiles.length);
                    }
                    else
                    {
                        readyToSet = true;
                    }
                }
                else
                {
                    randomRow = dice1.nextInt(tiles.length);
                }

            }
            //Sets the tiles only after the above loop has been exited.
            for(int i = 0; i<length; i++)
            {
                tiles[randomRow][randomCol] =  new ShipTile(tiles[randomRow][randomCol].getX(), tiles[randomRow][randomCol].getY(), color, id);
                if(id == 1)
                {
                    battleship[currentI] = tiles[randomRow][randomCol];
                }
                else if(id == 2)
                {
                    destroyer[currentI] = tiles[randomRow][randomCol];
                }
                else
                {
                    pboat[currentI] = tiles[randomRow][randomCol];
                }
                randomRow--;
                currentI++;
            }
        }
        else if(direction == 1)
        {
            boolean readyToSet = false;
            int nonOceanTiles = 0;
            //Checks all the tiles for the length of the ship to see if there are enough empty ocean tiles
            //If not, picks a new location and checks again
            while(readyToSet == false)
            {
                if(randomRow+length < tiles.length-length)
                {
                    for(int i = 0; i<length-1; i++)
                    {
                        randomRow++;
                        if(tiles[randomRow][randomCol].getID() != 0)
                        {
                            nonOceanTiles++;
                        }                    
                    }

                    if(nonOceanTiles > 0)
                    {
                        randomRow = dice1.nextInt(tiles.length);
                    }
                    else
                    {
                        readyToSet = true;
                    }
                }
                else
                {
                    randomRow = dice1.nextInt(tiles.length);
                }

            }

            for(int i = 0; i<length; i++)
            {
                tiles[randomRow][randomCol] =  new ShipTile(tiles[randomRow][randomCol].getX(), tiles[randomRow][randomCol].getY(), color, id);
                if(id == 1)
                {
                    battleship[currentI] = tiles[randomRow][randomCol];
                }
                else if(id == 2)
                {
                    destroyer[currentI] = tiles[randomRow][randomCol];
                }
                else
                {
                    pboat[currentI] = tiles[randomRow][randomCol];
                }
                randomRow++;
                currentI++;
            }
        }
        else if(direction == 2)
        {
            boolean readyToSet = false;
            int nonOceanTiles = 0;
            //Checks all the tiles for the length of the ship to see if there are enough empty ocean tiles
            //If not, picks a new location and checks again
            while(readyToSet == false)
            {
                if(randomCol-length>=length)
                {
                    for(int i = 0; i<length-1; i++)
                    {
                        randomCol--;
                        if(tiles[randomRow][randomCol].getID() != 0)
                        {
                            nonOceanTiles++;
                        }                    
                    }

                    if(nonOceanTiles > 0)
                    {
                        randomCol = dice1.nextInt(tiles[0].length);
                    }
                    else
                    {
                        readyToSet = true;
                    }
                }
                else
                {
                    randomCol = dice1.nextInt(tiles[0].length);
                }

            }

            for(int i = 0; i<length; i++)
            {
                tiles[randomRow][randomCol] =  new ShipTile(tiles[randomRow][randomCol].getX(), tiles[randomRow][randomCol].getY(), color, id);
                if(id == 1)
                {
                    battleship[currentI] = tiles[randomRow][randomCol];
                }
                else if(id == 2)
                {
                    destroyer[currentI] = tiles[randomRow][randomCol];
                }
                else
                {
                    pboat[currentI] = tiles[randomRow][randomCol];
                }
                randomCol--;
                currentI++;
            }
        }
        else if(direction == 3)
        {
            boolean readyToSet = false;
            int nonOceanTiles = 0;
            //Checks all the tiles for the length of the ship to see if there are enough empty ocean tiles
            //If not, picks a new location and checks again
            while(readyToSet == false)
            {
                if(randomCol+length < tiles[0].length-length)
                {
                    for(int i = 0; i<length-1; i++)
                    {
                        randomCol++;
                        if(tiles[randomRow][randomCol].getID() != 0)
                        {
                            nonOceanTiles++;
                        }                    
                    }

                    if(nonOceanTiles > 0)
                    {
                        randomCol = dice1.nextInt(tiles[0].length);
                    }
                    else
                    {
                        readyToSet = true;
                    }
                }
                else
                {
                    randomCol = dice1.nextInt(tiles[0].length);
                }

            }

            for(int i = 0; i<length; i++)
            {
                tiles[randomRow][randomCol] =  new ShipTile(tiles[randomRow][randomCol].getX(), tiles[randomRow][randomCol].getY(), color, id);
                if(id == 1)
                {
                    battleship[currentI] = tiles[randomRow][randomCol];
                }
                else if(id == 2)
                {
                    destroyer[currentI] = tiles[randomRow][randomCol];
                }
                else
                {
                    pboat[currentI] = tiles[randomRow][randomCol];
                }
                randomCol++;
                currentI++;
            }
        }
        repaint();
    }

    /**
     * Checks to see if all the ships are set and the player is ready to start
     * 
     * @return  True if ready and false if not
     */
    public boolean isReady()
    {
        if(bshipI>3 && destI>2 && pboatI>1)
        {
            return true;
        }
        return false;
    }

    /**
     * Modifies the player's state in the game
     */
    public void setGameState(boolean state)
    {
        isStarted = state;
    }

    /**
     * Checks to see if the human player has started the game
     * 
     * @return  True if started and false if not
     */
    public boolean inGame()
    {
        return isStarted;
    }   
    
    /**
     * Has a player's grid randomly select a tile to be hit as a random move by the other player
     * Updates the grid based on whether it was a ship or ocean tile hit
     */
    public void randomMove()
    {
        Random dice1 = new Random();
        int randomRow = dice1.nextInt(tiles.length);
        int randomCol = dice1.nextInt(tiles[0].length);
        while(tiles[randomRow][randomCol].isHit())
        {
            randomRow = dice1.nextInt(tiles.length);
            randomCol = dice1.nextInt(tiles[0].length);
        }         
        tiles[randomRow][randomCol].setState(true);
        if(tiles[randomRow][randomCol].getID() != 0)
        {
            tiles[randomRow][randomCol].setColor(Color.ORANGE);
        }
        else
        {
            tiles[randomRow][randomCol].setColor(Color.BLACK);
        }
        repaint();
    }

    /**
     * Makes a move for the player based on a tile clicked
     * 
     * @param   x   x coordinate of click
     * @param   y   y coordinate of click
     * @return   True if a correct move was made, false if otherwise
     */
    public boolean playerMove(int x, int y)
    {
        for(int a = 0; a<tiles.length; a++)
        {
            for(int b = 0; b<tiles[a].length; b++)
            {
                if(tiles[a][b].isInside(x,y)==true)
                {
                    tiles[a][b].setState(true);
                    if(tiles[a][b].getID() != 0)
                    {
                        tiles[a][b].setColor(Color.ORANGE);
                    }
                    else
                    {
                        tiles[a][b].setColor(Color.BLACK);
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if the player has lost all of their ships
     */
    public void hasLost()
    {

    }

    /**
     * Draws all of GridPanel's components in
     * 
     * @param   g   Graphics module
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(int x = 0; x<tiles.length; x++)
        {
            for(int y = 0; y<tiles[x].length; y++)
            {
                tiles[x][y].draw(g2);
            }
        }
    }

    public class ShipSetListener implements MouseListener
    {        
        public void mouseClicked(MouseEvent e)
        {
            int x = e.getX();
            int y = e.getY();            
            for(int a = 0; a<tiles.length; a++)
            {
                for(int b = 0; b<tiles[a].length; b++)
                {
                    Tile tile = tiles[a][b];
                    if(tile.isInside(x,y))
                    {
                        if(currentShip == 1 && bshipI < 4 )
                        {
                            tiles[a][b] = new ShipTile(tile.getX(),tile.getY(),Color.GRAY,1);
                            battleship[bshipI] = tiles[a][b];
                            bshipI++;
                        }
                        else if(currentShip == 2 && destI < 3)
                        {
                            tiles[a][b] = new ShipTile(tile.getX(),tile.getY(),Color.BLACK,2);
                            destroyer[destI] = tiles[a][b];
                            destI++;
                        }
                        else if(currentShip == 3 && pboatI < 2)
                        {
                            tiles[a][b] = new ShipTile(tile.getX(),tile.getY(),Color.RED,3);
                            pboat[pboatI] = tiles[a][b];
                            pboatI++;
                        }
                    }

                }
            }
            repaint();
        }

        public void mouseEntered(MouseEvent e){}

        public void mouseExited(MouseEvent e){}

        public void mousePressed(MouseEvent e){}

        public void mouseReleased(MouseEvent e){}
    }
  
}
