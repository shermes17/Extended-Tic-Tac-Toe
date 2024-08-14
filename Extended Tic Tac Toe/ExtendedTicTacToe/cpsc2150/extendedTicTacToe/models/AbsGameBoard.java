package cpsc2150.extendedTicTacToe.models;

public abstract class AbsGameBoard implements IGameBoard {

    /**
     * this overridden toString method will make and return a string that contains the char[][] board
     * @return string variable containing the board with
     * @pre NONE
     * @post [In a nested loop, each position will create a temporary BoardPosition and use the whatsAtPos() in the interface
     * to get the char at the position. for each iteration the cell will be added to a string variable spaced by "|",
     * at the beginning of each row and column there will be a number in the string to represent which row/column it is]
     *
     */
    @Override
    public String toString() {
        int RMAX = getNumRows();
        int CMAX = getNumColumns();
        String str = "    0";
        for (int i = 1; i < CMAX; i++){
            if (i < 10)
                str += "| "+i;
            else
                str += "|"+i;
        }
        str += "|\n";
        for (int r = 0; r < RMAX; r++) {
            if (r < 10)
                str += " " + r + "|";
            else
                str += r + "|";
            for(int c = 0; c < CMAX; c++) {
                BoardPosition temp = new BoardPosition(r,c);
                str += whatsAtPos(temp) + " |";
            }
            str += "\n";
        }
        return str;
    }

}
