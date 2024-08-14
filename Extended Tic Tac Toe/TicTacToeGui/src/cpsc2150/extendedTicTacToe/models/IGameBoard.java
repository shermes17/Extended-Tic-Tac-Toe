package cpsc2150.extendedTicTacToe.models;

/**
 * interface includes methods to interact with the grid for the tic tac toe game
 *
 * Initialization ensures:
 * Board is initialized empty
 * boards dimensions will be within MAX_ROWS by MAX_COLUMNS or smaller
 * but larger than MIN_DIMENSIONS by MIN_DIMENSIONS and
 *
 * defines:
 * num_rows : Z
 * num_columns : Z
 * num_to_win : Z
 *
 * Constraints:
 * MIN_DIMENSIONS <= num_rows < MAX_ROWS
 * MIN_DIMENSIONS <= num_columns < MAX_COLUMNS
 * MIN_DIMENSIONS <= num_to_win < MAX_WINNING_NUMBER
 */
public interface IGameBoard {

    public final int MAX_ROWS = 100;
    public final int MAX_COLUMNS = 100;
    public final int MIN_DIMENSIONS = 3;
    public final int MAX_WINNING_NUMBER = 25;

    /**
     * places the character in marker on the position specified by marker
     * and should not be called if the space is unavailable
     * @param marker is a boardPosition object containing the coordinates for the placement
     * @param player is a char representing which player is playing
     * @pre
     * checkSpace(marker) == true
     * player == 'X' OR player == 'O'
     * @post [current instance of board at pos = player]
     */
    public void placeMarker(BoardPosition marker, char player);

    /**
     * this function returns what is in the GameBoard at position pos
     * @param pos is a BoardPosition object containing a row, column coordinate
     * @return the char value at the given coordinate
     * @pre
     * checkSpace(pos, 'X') == true OR checkSpace(pos, 'O') == true
     * @post
     * whatsAtPos = 'X' if [current instance of board]  == 'X' AND board = #board
     * whatsAtPos = 'O' if [current instance of board] == 'O' AND board = #board
     * whatsAtPos = ' ' if [current instance of board] == ' ' AND board = #board
     */
    public char whatsAtPos(BoardPosition pos);

    /**
     * returns the number of rows in the GameBoard
     *
     * @return the integer number of rows in the board
     * @pre NONE
     * @post getNumRows = RMAX
     */
    public int getNumRows();

    /**
     * returns the number of columns in the GameBoard
     *
     * @return the integer number of columns in the board
     * @pre NONE
     * @post getNumColumns = CMAX
     */
    public int getNumColumns();

    /**
     * returns the number of tokens in a row needed to win the game
     * @return the int number of tokens required to win
     * @pre NONE
     * @post getNumToWin = WINNING_NUMBER
     */
    public int getNumToWin();

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
    default boolean isPlayerAtPos(BoardPosition pos, char player){
        if(pos.getRow() < 0 || pos.getRow() >= getNumRows() || pos.getColumn() < 0 || pos.getColumn() >= getNumColumns())
            return false;
        if(whatsAtPos(pos) == player)
            return true;
        return false;
    }

    /**
     * This function will check to see if the board position given is available
     * @param  pos is a BoardPosition object containing a row, column coordinate
     * @return true if board position is available, false if it is taken or out of bounds
     * @pre board is initialized
     * @post
     *  checkSpace = true if (board[pos.getRowC()][pos.getColumn()] == ' ' AND (pos.getRow >= 0 AND pos.getRow < RMAX)
     *  AND (pos.getColumn() >= 0 AND pos.getColumn() < CMAX) AND pos = #pos AND board = #board)
     *  else checkSpace = false
     */
    default boolean checkSpace(BoardPosition pos) {
        int RMAX = getNumRows();
        int CMAX = getNumColumns();
        int r = pos.getRow();
        int c = pos.getColumn();
        if(r >= 0 && r < RMAX && c >= 0 && c < CMAX && whatsAtPos(pos) == ' ')
            return true;
        return false;
    }

    /**
     * this function checks for a draw by checking if the board does not have any free spaces
     * @return true if board has no free spaces otherwise returns false
     * @pre neither play has won yet
     * @post
     * checkforDraw = true if [temporary BoardPositions created in a nested loop will call whatsAtPos()
     * and if whatAtPos != ' ' for all positions on the board]
     * else checkForDraw = false
     */
    default boolean checkForDraw(){
        int RMAX = getNumRows();
        int CMAX = getNumColumns();
        for(int r = 0; r < RMAX;r++) {
            for (int c = 0; c < CMAX; c++) {
                BoardPosition temp = new BoardPosition(r,c);
                if(whatsAtPos(temp) == ' ')
                    return false;
            }
        }
        return true;
    }

    /**
     * this function will check to see if the lastPos placed resulted in a winner.
     * If so it will return true, otherwise false
     * @param lastPos is a BoardPosition object representing the last placed position
     * @return true if a winner is found around the lastPos, false otherwise
     * @pre
     *  Winner has not been found prior
     *  lastPos.getRow() >= 0 AND lastPos.getRow() < RMAX
     *  lastPos.getColumn() >= 0 AND lastPos.getColumn() < CMAX
     *  [lasPos is the last position placed on the gameboard]
     * @post
     * checkForWinner = true if ((checkHorizontalWin(lastPos, 'X') == true OR checkHorizontalWin(lastPos, 'O') == true OR
     * checkVerticalWin(LastPos, 'X') == true OR checkVerticalWin(LastPos, 'O') == true OR
     * checkDiagonalWin(LastPos, 'X') == true OR checkDiagonalWin(LastPos, 'O') == true)
     * AND (lastPos = #lasPos AND board = #board))
     * else checkForWinner = false
     */
    default boolean checkForWinner(BoardPosition lastPos){
       char player = whatsAtPos(lastPos);
       if(checkVerticalWin(lastPos,player)||checkHorizontalWin(lastPos,player)||checkDiagonalWin(lastPos,player))
           return true;
        return false;
    }

    /**
     * checks if the current player has won horizontally
     *
     * @param lastPos is a BoardPosition object representing the last placed position
     * @param player  is a char representing which player is playing
     * @return true if player has won at lastPos in the horizontal direction
     * @pre
     * checkSpace(lasPos) == true
     * player == 'X' OR player == 'O'
     * @post
     * checkHorizontalWin = true if [whatsAtPos(lastPos) is
     * with in 5 consecutive spaces of player in the same column AND board = #board]
     *  else checkVerticalWin = false
     */
    default boolean checkVerticalWin(BoardPosition lastPos, char player){
        int row = lastPos.getRow();
        int col = lastPos.getColumn();
        int RMAX = getNumRows();
        int CMAX = getNumColumns();
        int WINNING_NUMBER = getNumToWin();
        int count = 0;

        for(int down = row; down < RMAX; down++)
        {
            BoardPosition temp = new BoardPosition(down, col);
            if(!isPlayerAtPos(temp,player))
                break;
            else
                count++;
        }
        if(count >= WINNING_NUMBER)
            return true;

        if(row != 0)
        {
            for(int up = (row-1); up >= 0; up--)
            {
                BoardPosition temp = new BoardPosition(up, col);
                if(!isPlayerAtPos(temp,player))
                    break;
                else
                    count++;
            }
        }
        if(count >= WINNING_NUMBER)
            return true;
        return false;
    }

    /**
     * checks if the current player has won vertically
     * @param lastPos is a BoardPosition object representing the last placed position
     * @param player  is a char representing which player is playing
     * @return true if player won at lastPos in the vertical direction
     * @pre
     * checkSpace(lasPos) == true
     * player == 'X' OR player == 'O'
     * @post
     * checkVerticalWin = true if [whatsAtPos(lastPos) is
     * in 5 consecutive spaces of player in the same row AND board = #board]
     * else checkVerticalWin = false
     */
    default boolean checkHorizontalWin(BoardPosition lastPos, char player){
        int row = lastPos.getRow();
        int col = lastPos.getColumn();
        int RMAX = getNumRows();
        int CMAX = getNumColumns();
        int WINNING_NUMBER = getNumToWin();
        int count = 0;

        //checks right of pos
        for(int right = col; right < CMAX; right++)
        {
            BoardPosition temp = new BoardPosition(row, right);
            if(!isPlayerAtPos(temp,player))
                break;
            else
                count++;
        }
        if(count >= WINNING_NUMBER)
            return true;

        //checks left of pos
        if(col != 0)
        {
            for(int left = (col-1); left >= 0; left--)
            {
                BoardPosition temp = new BoardPosition(row, left);
                if(!isPlayerAtPos(temp,player))
                    break;
                else
                    count++;
            }
        }
        if(count >= WINNING_NUMBER)
            return true;
        return false;
    }

    /**
     * checks if the current player has won diagonally
     *
     * @param lastPos is a BoardPosition object representing the last placed position
     * @param player  is a char representing which player is playing
     * @return true if player won at lastPos diagonally
     * @Pre
     * checkSpace(lasPos) == true
     * player == 'X' OR player == 'O'
     * @post
     *  checkDiagonalWin = true if board[whatsAtPos(lastPos) is
     *  in 5 consecutive spaces of player in the same diagonal AND board = #board]
     *  else checkVerticalWin = false
     */
    default boolean checkDiagonalWin(BoardPosition lastPos, char player){
        int row = lastPos.getRow();
        int col = lastPos.getColumn();
        int RMAX = getNumRows();
        int CMAX = getNumColumns();
        int WINNING_NUMBER = getNumToWin();
        int count = 0;

        //up left
        for(int r = row, c = col; r >= 0 && c >= 0; r--,c--)
        {
            BoardPosition temp = new BoardPosition(r, c);
            if(!isPlayerAtPos(temp,player))
                break;
            count++;
        }
        if(count >= WINNING_NUMBER)
            return true;
        //down right
        if(row != RMAX && col != CMAX ) {
            for (int r = row + 1, c = col + 1; r < RMAX && c < CMAX; r++, c++) {
                BoardPosition temp = new BoardPosition(r, c);
                if (!isPlayerAtPos(temp,player))
                    break;
                count++;
            }
        }
        if(count >= WINNING_NUMBER)
            return true;
        count = 0;

        //up right
        for(int r = row, c = col; r >= 0 && c < CMAX; --r,++c){
            BoardPosition temp = new BoardPosition(r, c);
            if(!isPlayerAtPos(temp,player))
                break;
            count++;
        }
        if (count >= WINNING_NUMBER)
            return true;
        // down left
        if(row != RMAX && col != 0 ) {
            for (int r = row + 1, c = col - 1; r < RMAX && c >= 0; r++, c--) {
                BoardPosition temp = new BoardPosition(r, c);
                if (!isPlayerAtPos(temp,player))
                    break;
                count++;
            }
        }
        if(count >= WINNING_NUMBER)
            return true;
        return false;
    }

}
