------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Battleship
PURPOSE OF PROJECT: AP Computer Science Capstone
VERSION or DATE: 5/11/16
DEPENDENCIES: None
HOW TO START THIS PROJECT:
AUTHORS: David Fei
USER INSTRUCTIONS:
To play the game, run the main method of the GameWindow class.
The player's grid is the one on the right; the computer player is the one on the left.
To set a ship, click its button in the menu on the bottom and click the desired tile to set it on.  The grid won't respond until one of the buttons has been clicked.
The battleship should be set as a row of 4 tiles, the destroyer a row of 3, and the patrol boat a row of 2.
When making moves during the game, if the tile turns black it's a miss and if it turns orange it's a hit.
When first running the game, it may freeze upon pressing the start button or not let you set all the tiles for a ship.  The reason for this is currently unknown. 
If this happens, simply reset the Java Virtual Machine and restart the program. 


TILE ID VALUES (all values are int primitives)
Ocean = 0
Battleship = 1
Destroyer = 2
Patrol boat = 3

Design Overview:
This application is a PC version of the classic board game Battleship, made using the Java standard library.
The current version only supports singleplayer human vs computer games.
The user interface consists of two JPanels, one for the human player and one for the computer, that contain a 10x10 grid of Tile objects which are just colored Rectangle2D objects.
It also contains the menu that handles starting the game and setting the tiles for the player.
The player grid contains a listener that allows the user to set their ships on their grid.
The computer grid contains a listener that handles moves made by the player and makes a random move on the player's grid.
The Tile class has two subclasses, ship and ocean tiles, to represent the two possible tiles in the grid.

Concepts used:
This program synthesizes both object-oriented design and GUI design. It also makes use of data structures such as arrays
to keep track of all the tiles for each player's game board as well as the ships on the board, and utilizes class design
concepts such as encapsulation.  It also incorporates the most basic concepts such as loops, boolean logic, and object references.
I had to do additional research on Java layout managers in order to position objects within my GUI properly, and made use of new
concepts such as the GridLayout manager and absolute positioning based on coordinates within the window to make the GUI 
look more organized and visually appeasing.

