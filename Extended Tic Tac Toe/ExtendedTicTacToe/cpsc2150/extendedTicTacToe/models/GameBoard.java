package cpsc2150.extendedTicTacToe.models;

/**
 * @invariant MAX_ROWS = 100
 * @invariant MAX_COLUMNS = 100
 * @invariant MAX_WINNING_NUMBER = 25
 *
 * @correspondents
 * 0 <= BoardPosition.getRow() < MAX_ROWS AND  0 <= BoardPosition.getRow() < MAX_COLUMNS
 * self = char[][]
 *
 */
public class GameBoard extends AbsGameBoard implements IGameBoard{
    public char[][] board;
    public int RMAX;
    public int CMAX;
    public int WINNING_NUMBER;

    /**
     *  Constructor of the class, will initialize the board variable, char[][] board
     * @pre none
     * @post [each position in board will be blank]
     */
    public GameBoard(int num_of_Rows, int num_of_Columns, int num_to_win) {
        RMAX = num_of_Rows;
        CMAX = num_of_Columns;
        WINNING_NUMBER = num_to_win;

        board = new char[RMAX][CMAX];
        for(int r = 0; r < RMAX; r++)
            for(int c = 0; c < CMAX; c++)
                board[r][c] = ' ';
    }

    /**
     * this function returns what is in the GameBoard at position pos
     * @param pos is a BoardPosition object containing a row, column coordinate
     * @return the char value at the given coordinate
     * @pre
     * pos.getRow() >= 0 AND pos.getRow() < RMAX
     * pos.getColumn() >= 0 AND pos.getRow() < CMAX
     * @post
     * whatsAtPos = board[pos.getRow()][pos.getColumn()] AND board = #board
     */
    @Override
    public char whatsAtPos(BoardPosition pos){
        return board[pos.getRow()][pos.getColumn()];
    }

    /**
     * places the character in marker on the position specified by marker
     * and should not be called if the space is unavailable
     * @param marker is a boardPosition object containing the coordinates for the placement
     * @param player is a char representing which player is playing
     * @pre
     * checkSpace(marker) == true
     * @post board[marker.getRow()][marker.getColumn()] = player
     */
    @Override
    public void placeMarker(BoardPosition marker, char player) {
        int r = marker.getRow();
        int c = marker.getColumn();
        if(checkSpace(marker) == true)
            board[r][c] = player;
    }

    /**
     * returns the number of rows in the GameBoard
     *
     * @return the integer number of rows in the board
     * @pre
     * @post getNumRows = RMAX
     */
    @Override
    public int getNumRows(){return RMAX;}

    /**
     * returns the number of columns in the GameBoard
     *
     * @return the integer number of columns in the board
     * @pre
     * @post getNumColumns = CMAX
     */
    @Override
    public int getNumColumns(){return CMAX;}

    /**
     * returns the number of tokens in a row needed to win the game
     * @return the int number of tokens required to win
     * @pre
     * @post getNumToWin = WINNING_NUMBER
     */
    @Override
    public int getNumToWin(){return WINNING_NUMBER;}

}


