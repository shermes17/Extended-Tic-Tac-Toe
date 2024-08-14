package cpsc2150.extendedTicTacToe.models;

/**
 * @invariant (int row >= 0 AND int row < 100) AND
 * (int column >= 0 AND int column < 100)
 *
 */
public class BoardPosition {
    private int row;
    private int column;

    /**
     * constructor of the boardPosition class
     *
     * @param r number that represents the row
     * @param c number that represents the column
     *
     * @pre
     * r >= 0 AND r < 5
     * c >= 0 AND c < 8
     *
     * @post (this.row = r)
     * @post (this.column = c)
     *
     */
    public BoardPosition(int r, int c) {
    row = r;
    column = c;
    }

    /**
     * this function returns the instance variable private int row
     *
     * @return the integer value of the row
     *
     * @pre
     * row >= 0 AND row < 5
     * @post
     * getRow >= 0 AND getRow < 8 AND [row value does not change] AND
     * [getRow is equal to row]
     */
   public int getRow() {
       return row;
   }

    /**
     * This function returns the instance variable private int column
     *
     * @return the integer value of the column
     *
     * @pre
     * column >= 0 AND column < 8
     *
     * @post
     * getColumn >= 0 AND getColumn < 8 AND [column value does not change] AND
     * [getColumn is equal to column]
     *
     */
    public int getColumn(){
    return column;
    }

    /**
     * This function checks to see if two BoardPosition objects are equivalent
     *
     * @param obj object to compare with current instance of the class
     * @return true if this.row == pos.row && this.column == pos.column
     * @return false otherwise
     * @pre
     * r >= 0 AND r < 5
     * c >= 0 AND c < 8
     *
     * @post (this.row == pos.row) && (this.column == pos.column)
     */
    @Override
    public boolean equals(Object obj) {
        if(this.getClass() == obj.getClass()) {
            BoardPosition pos = (BoardPosition)obj;
            if (this.row == pos.getRow() && this.column == pos.getColumn())
                return true;
        }
        return false;
    }

    /**
     * prints out a string of the row and column variables as coordinates
     *
     * @return string containing both row and column variables
     * @pre
     * r >= 0 AND r < 5
     * c >= 0 AND c < 8
     * @post string (row + "," + column)
     *
     */
    @Override
    public String toString(){
        String str = this.row + "," + this.column;
        return str;
    }

}
