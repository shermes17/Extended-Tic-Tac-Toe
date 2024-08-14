package cpsc2150.extendedTicTacToe.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * @invariant MAX_ROWS = 100
 * @invariant MAX_COLUMNS = 100
 * @invariant MAX_WINNING_NUMBER = 25
 *
 * @correspondents
 * 0 <= BoardPosition.getRow() < MAX_ROWS AND  0 <= BoardPosition.getRow() < MAX_COLUMNS
 * self = Map<Character,List<BoardPosition>>
 */
public class GameBoardMem extends AbsGameBoard implements IGameBoard{

    private Map<Character, List<BoardPosition>> map = new HashMap<>();
    private int RMAX;
    private int CMAX;
    private int WINNING_NUMBER;

    /**
     *  Constructor of the class will set the bounds for the board
     * @param num_of_Columns is the amount of columns in the board
     * @param num_of_Rows  is the amount of rows in the board
     * @param num_to_win is the amount of spaces it takes to win
     * @pre NONE
     * @post
     * RMAX = num_of_Rows;
     * CMAX = num_of_Columns;
     * WINNING_NUMBER = num_to_win;
     */
    public GameBoardMem(int num_of_Rows, int num_of_Columns, int num_to_win) {
        RMAX = num_of_Rows;
        CMAX = num_of_Columns;
        WINNING_NUMBER = num_to_win;
    }

    /**
     * this function returns what is in the GameBoard at position pos
     * @param pos is a BoardPosition object of the position
     * @return the key which contains pos
     * @pre
     * pos.getRow() >= 0 AND pos.getRow() < RMAX
     * pos.getColumn() >= 0 AND pos.getRow() < CMAX
     * @post
     * whatsAtPos = key if [the key's list contains pos] else
     * whatsAtPos = ' '
     */
    @Override
    public char whatsAtPos(BoardPosition pos){
        List<BoardPosition> list = new ArrayList<>();
        for(char key : map.keySet()){
            list = map.get(key);
            if (list.contains(pos))
                return key;
        }
    return ' ';
    }

    /**
     * places the character in marker on the position specified by marker
     * and should not be called if the space is unavailable
     * @param marker is a boardPosition object containing the coordinates for the placement
     * @param player is a char representing which player is playing
     * @pre
     * checkSpace(marker) == true
     * @post map.put(player,list.add(marker))
     */
    @Override
    public void placeMarker(BoardPosition marker, char player) {
       List<BoardPosition> list = new ArrayList<>();
       if(whatsAtPos(marker) == ' ') {
           if (!map.containsKey(player)) {
               list.add(marker);
               map.put(player, list);
           } else {
               list = map.get(player);
               list.add(marker);
               map.put(player, list);
           }
       }
    }

    /**
     * returns the number of rows in the GameBoard
     *
     * @return the integer number of rows in the board
     * @pre
     * @post getNumRows = RMAX
     */
    @Override
    public int getNumRows(){
        return RMAX;}

    /**
     * returns the number of columns in the GameBoard
     *
     * @return the integer number of columns in the board
     * @pre
     * @post getNumColumns = CMAX
     */
    @Override
    public int getNumColumns(){
        return CMAX;}

    /**
     * returns the number of tokens in a row needed to win the game
     * @return the int number of tokens required to win
     * @pre
     * @post getNumToWin = WINNING_NUMBER
     */
    @Override
    public int getNumToWin(){
        return WINNING_NUMBER;}

    /**
     *  this function checks if the given player is at the given pos
     * @param pos is a BoardPosition object containing a row, column coordinate
     * @param player is a char representing which player is playing (X or O)
     * @return returns true if the player is at pos; otherwise, it returns false
     * @pre NONE
     * @post
     * isPlayerAtPos = true if (whatsAtPos(pos) == player AND pos = #pos)
     * else isPlayerAtPos = false
     */
    @Override
    public boolean isPlayerAtPos(BoardPosition pos, char player){
       List<BoardPosition> list = new ArrayList<>();
       if(map.get(player) == null)
           return false;
       list = map.get(player);
       if(list.contains(pos))
           return true;
        return false;
    }

}


