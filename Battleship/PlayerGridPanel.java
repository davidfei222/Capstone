import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

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
    //Counts for the length of the battleship, destroyer, and patrol boat arrays
    private int bshipL, destL, pboatL;
    //Variable controlling what ship is currently being set (based on table of ship ID values)
    private int currentShip;
    //Indexing for the ship arrays (prevent out of bounds exceptions)
    private int bshipI, destI, pboatI = 0;

    /**
     * Constructor for objects of class GridPanel
     */
    public PlayerGridPanel()
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
        addMouseListener(new ShipSetListener());
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
     * Method to set the battleship's tiles randomly
     * 
     * @param   color   Color of the tiles for the ship
     */
    public void setBattleship(Color color)
    {   
        int randomRow = (int) Math.random()*tiles.length;
        int randomCol = (int) Math.random()*tiles[0].length;
        while(tiles[randomRow][randomCol].getID() != 0)
        {
            randomRow = (int) Math.random()*tiles.length;
            randomCol = (int) Math.random()*tiles[0].length;
        }
        int startRow = randomRow;
        int startCol = randomCol;
        //0 = north, 1 = south, 2 = west, 3 = east
        int direction = (int) Math.random()*4;
        //Track how many tiles of the ship have been set
        int currentI = 0;
        if(direction == 0)
        {
            while(randomRow >= 0 && tiles[randomRow-1][randomCol].getID()>0 && currentI < battleship.length)
            {
                tiles[randomRow][randomCol] =  new ShipTile(tiles[randomRow][randomCol].getX(), tiles[randomRow][randomCol].getY(), color, 1);
                battleship[currentI] = tiles[randomRow][randomCol];
                randomRow--;
                currentI++;
            }
            int offsetRow = startRow+1;
            if(currentI < battleship.length-1)
            {
                for(int i = currentI; i < battleship.length; i++)
                {
                    tiles[offsetRow][randomCol] = new ShipTile(tiles[randomRow][randomCol].getX(), tiles[randomRow][randomCol].getY(), color, 1);
                    battleship[i] = tiles[offsetRow][randomCol];
                    offsetRow++;
                }
            }
        }
        else if(direction == 1)
        {
            while(randomRow <= tiles.length-1 && tiles[randomRow+1][randomCol].getID()>0 && currentI < battleship.length)
            {
                tiles[randomRow][randomCol] =  new ShipTile(tiles[randomRow][randomCol].getX(), tiles[randomRow][randomCol].getY(), color, 1);
                battleship[currentI] = tiles[randomRow][randomCol];
                randomRow++;
                currentI++;
            }
            int offsetRow = startRow-1;
            if(currentI < battleship.length-1)
            {
                for(int i = currentI; i < battleship.length; i++)
                {
                    tiles[offsetRow][randomCol] = new ShipTile(tiles[randomRow][randomCol].getX(), tiles[randomRow][randomCol].getY(), color, 1);
                    battleship[i] = tiles[offsetRow][randomCol];
                    offsetRow--;
                }
            }
        }
        else if(direction == 2)
        {
            while(randomCol >= 0 && tiles[randomRow][randomCol-1].getID()>0 && currentI < battleship.length)
            {
                tiles[randomRow][randomCol] =  new ShipTile(tiles[randomRow][randomCol].getX(), tiles[randomRow][randomCol].getY(), color, 1);
                battleship[currentI] = tiles[randomRow][randomCol];
                randomCol--;
                currentI++;
            }
            int offsetCol = startCol+1;
            if(currentI < battleship.length-1)
            {
                for(int i = currentI; i < battleship.length; i++)
                {
                    tiles[randomRow][offsetCol] = new ShipTile(tiles[randomRow][randomCol].getX(), tiles[randomRow][randomCol].getY(), color, 1);
                    battleship[i] = tiles[randomRow][offsetCol];
                    offsetCol++;
                }
            }
        }
        else if(direction == 3)
        {
            while(randomCol <= tiles[0].length-1 && tiles[randomRow][randomCol+1].getID()>0 && currentI < battleship.length)
            {
                tiles[randomRow][randomCol] =  new ShipTile(tiles[randomRow][randomCol].getX(), tiles[randomRow][randomCol].getY(), color, 1);
                battleship[currentI] = tiles[randomRow][randomCol];
                randomCol++;
                currentI++;
            }
            int offsetCol = startCol-1;
            if(currentI < battleship.length-1)
            {
                for(int i = currentI; i < battleship.length; i++)
                {
                    tiles[randomRow][offsetCol] = new ShipTile(tiles[randomRow][randomCol].getX(), tiles[randomRow][randomCol].getY(), color, 1);
                    battleship[i] = tiles[randomRow][offsetCol];
                    offsetCol--;
                }
            }
        }

    }
    
    /**
     * Method to set the destroyer tiles randomly
     */
    public void setDestroyer()
    {
    }
    
    /**
     * Method to set the patrol boat tiles randomly
     */
    public void setPboat()
    {
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
