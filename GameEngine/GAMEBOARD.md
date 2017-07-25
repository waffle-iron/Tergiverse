# GameBoard Class Overview

Date Created: July 25,2017
Date Last Modified: July 25,2017

## Class Purpose
* The major function of the GameBoard class is to represent the structure of a standard chess board and allow for interactions between the players, the pieces, and teh game runner itself. This class contains the methods and data structures necessary to ensure basic rules involving piece placement and creation, check and checkmate algorithms, and the handling of destroyed pieces.

### Piece Placement Scope
* The scope of this class involves the encompassing rules for moving a piece from one location to another. NOTE: THIS DOES NOT INVOLVE SPECIFIC PIECE MOVEMENT ALGORITHMS STORED IN THEIR RESPECTIVE CLASSES. This class involves verifying that a piece of a certain color is available to move into a spot withuot being blocked by another piece. A piece attempting to move to a position cannot be placed if any piece of any color is blocking the path to move to the wanted position. A piece may be placed on top of an existing piece if that piece is the color of the other player (Taking or Killing the Piece).

### Piece Creation Scope
* The need for piece creation is a large part of implementing a Chess Engine. NOTE: THE PIECE CREATION ALGORITHM IS NOT WRITTEN HERE>  It is important to discuss piece creation here however as this is the onl class that requires piece creation. This creation is used when first initializing the board with pieces as well as for pawn promotion. Piece creation is performed through method calls to the PieceGenerator object.

### Check and Checkmate Algorithms
* The Check and Checkmate class are very important to the game of chess as they enforce restrictive rules on how the game must continue as well as inform the players that the game has ended. The efficiency of the Chess Engine is largely dependent on the quality that the Check and Checkmate algorithms performance making it a crucial part of the implementation.

### Destroyed Pieces
* The last major portion of the GameBoard class involves teh undertaking of performing and storage of kiled pieces of the opponents. In order to add personality to the game, a graveyard has been added to the specs as a way for users to see what piece have been eliminated from the game































