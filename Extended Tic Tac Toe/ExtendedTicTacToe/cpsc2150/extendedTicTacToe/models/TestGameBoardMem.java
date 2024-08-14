package cpsc2150.extendedTicTacToe.models;
import  org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestGameBoardMem {

    private IGameBoard MakeAGame(int r,int c,int n) {
        IGameBoard game = new GameBoardMem(r, c, n);
        return game;
    }

        private String toString(char[][] gb) {
            int row = gb.length;
            int col = gb[0].length;
            String str = "    0";
            for (int i = 1; i < col; i++) {
                if (i < 10)
                    str += "| " + i;
                else
                    str += "|" + i;
            }
            str += "|\n";
            for (int r = 0; r < row; r++) {
                if (r < 10)
                    str += " " + r + "|";
                else
                    str += r + "|";
                for (int c = 0; c < col; c++) {
                    str += gb[r][c] + " |";
                }
                str += "\n";


            }
            return str;
        }
        //test minimum dimension
        @Test
        public void constructor1(){
            IGameBoard test = MakeAGame(3,3,3);
            char[][] expected = new char[3][3];
            for(int r = 0; r < 3;r++){
                for (int c = 0; c < 3; c++){
                    expected[r][c] = ' ';
                }
            }
            assertEquals(test.toString(),toString(expected));
        }
        //test within dimensions
        @Test
        public void constructor2() {
            int row = 12;
            int col = 15;
            IGameBoard test = MakeAGame(row,col,5);
            char[][] expected = new char[row][col];
            for(int r = 0; r < row;r++){
                for (int c = 0; c < col; c++){
                    expected[r][c] = ' ';
                }
            }
            assertEquals(test.toString(),toString(expected));

        }
        //test maximum dimension
        @Test
        public void constructor3(){
            int row = 100;
            int col = 100;
            IGameBoard test = MakeAGame(row,col,25);
            char[][] expected = new char[row][col];
            for(int r = 0; r < row;r++){
                for (int c = 0; c < col; c++){
                    expected[r][c] = ' ';
                }
            }
            assertEquals(test.toString(),toString(expected));
        }


        //test empty space
        @Test
        public void checkSpace1(){
            IGameBoard test =  MakeAGame(5,5,3);
            BoardPosition pos;
            //create testing board
            char player = 'X';
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,player);

            player = 'O';
            pos = new BoardPosition(1,4);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,player);

            //testing position
            pos = new BoardPosition(3,2);

            assertEquals(test.checkSpace(pos),true);

        }
        //test taken space
        @Test
        public void checkSpace2(){
            IGameBoard test =  MakeAGame(5,5,3);
            BoardPosition pos ;
            //create testing board
            char player = 'X';
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,player);

            player = 'O';
            pos = new BoardPosition(1,4);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,player);

            //testing position
            pos = new BoardPosition(1,1);
            assertEquals(test.checkSpace(pos),false);
        }
        //test invalid space
        @Test
        public void checkSpace3(){
            IGameBoard test =  MakeAGame(5,5,3);
            BoardPosition pos ;
            //create testing board
            char player = 'X';
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,player);

            player = 'O';
            pos = new BoardPosition(1,4);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,player);

            //testing position
            pos = new BoardPosition(6,2);
            assertEquals(test.checkSpace(pos),false);
        }


        //test win in the middle
        @Test
        public void checkHorizontalWin1(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;
            //create testing board
            char player = 'X';
            pos = new BoardPosition(1,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,3);
            test.placeMarker(pos,player);

            player = 'O';
            pos = new BoardPosition(1,4);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,player);

            //test
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,'X');
            assertEquals(test.checkHorizontalWin(pos,'X'),true);

        }
        //test no winner
        @Test
        public void checkHorizontalWin2(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;
            //create testing board
            char player = 'X';
            pos = new BoardPosition(1,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,player);

            player = 'O';
            pos = new BoardPosition(1,4);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,player);

            //test
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,'X');
            assertEquals(test.checkHorizontalWin(pos,'X'),false);
        }
        //test left boundary
        @Test
        public void checkHorizontalWin3(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;
            //create testing board
            char player = 'X';
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,3);
            test.placeMarker(pos,player);

            player = 'O';
            pos = new BoardPosition(1,4);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,player);

            //test
            pos = new BoardPosition(1,0);
            test.placeMarker(pos,'X');
            assertEquals(test.checkHorizontalWin(pos,'X'),true);
        }
        // test right boundary
        @Test
        public void checkHorizontalWin4(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;
            //create testing board
            char player = 'X';
            pos = new BoardPosition(1,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);

            player = 'O';
            pos = new BoardPosition(1,4);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,player);

            //test
            pos = new BoardPosition(1,3);
            test.placeMarker(pos,'X');
            assertEquals(test.checkHorizontalWin(pos,'X'),true);
        }

        //test win in the middle
        @Test
        public void checkVerticalWin1(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;
            //create testing board
            char player = 'X';
            pos = new BoardPosition(1,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(4,3);
            test.placeMarker(pos,player);

            player = 'O';
            pos = new BoardPosition(0,3);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,3);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,player);

            //test
            pos = new BoardPosition(2,3);
            test.placeMarker(pos,'O');
            assertEquals(test.checkVerticalWin(pos,'O'),true);
        }
        //test no winner
        @Test
        public void checkVerticalWin2(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;
            //create testing board
            char player = 'X';
            pos = new BoardPosition(1,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(4,3);
            test.placeMarker(pos,player);

            player = 'O';
            pos = new BoardPosition(0,3);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,player);

            //test
            pos = new BoardPosition(1,3);
            test.placeMarker(pos,'O');
            assertEquals(test.checkVerticalWin(pos,'O'),false);
        }
        //test upper boundary
        @Test
        public void checkVerticalWin3(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;
            //create testing board
            char player = 'X';
            pos = new BoardPosition(1,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(4,3);
            test.placeMarker(pos,player);

            player = 'O';
            pos = new BoardPosition(1,3);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,3);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,player);

            //test
            pos = new BoardPosition(0,3);
            test.placeMarker(pos,'O');
            assertEquals(test.checkVerticalWin(pos,'O'),true);
        }
        //test lower boundary
        @Test
        public void checkVerticalWin4(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;
            //create testing board
            char player = 'X';
            pos = new BoardPosition(1,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(4,3);
            test.placeMarker(pos,player);

            player = 'O';
            pos = new BoardPosition(0,3);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,3);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,3);
            test.placeMarker(pos,player);

            //test
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,'O');
            assertEquals(test.checkVerticalWin(pos,'O'),true);
        }

        //test no winner in "\" diagonal
        @Test
        public void checkDiagonalWin1(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,player);


            player = 'O';
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,player);


            //test
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,'X');
            assertEquals(test.checkDiagonalWin(pos,'X'),false);
        }
        // "\" diagonal in middle
        @Test
        public void checkDiagonalWin2(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,player);


            player = 'O';
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(4,1);
            test.placeMarker(pos,player);

            //test
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,'X');
            assertEquals(test.checkDiagonalWin(pos,'X'),true);
        }
        // top left of "\" diagonal
        @Test
        public void checkDiagonalWin3(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,player);


            player = 'O';
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(4,1);
            test.placeMarker(pos,player);

            //test
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,'X');
            assertEquals(test.checkDiagonalWin(pos,'X'),true);
        }
        //bottom right of "\" diagonal
        @Test
        public void checkDiagonalWin4(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,player);


            player = 'O';
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(4,1);
            test.placeMarker(pos,player);

            //test
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,'X');
            assertEquals(test.checkDiagonalWin(pos,'X'),true);
        }
        // middle of "/" diagonal
        @Test
        public void checkDiagonalWin5(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);


            player = 'O';
            pos = new BoardPosition(0,3);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,0);
            test.placeMarker(pos,player);


            //test
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,'O');
            assertEquals(test.checkDiagonalWin(pos,'O'),true);
        }
        // top right of "/" diagonal
        @Test
        public void checkDiagonalWin6(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);


            player = 'O';
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(3,0);
            test.placeMarker(pos,player);


            //test
            pos = new BoardPosition(0,3);
            test.placeMarker(pos,'O');
            assertEquals(test.checkDiagonalWin(pos,'O'),true);
        }
        // bottom left of "/" diagonal
        @Test
        public void checkDiagonalWin7(){
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos ;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);


            player = 'O';
            pos = new BoardPosition(0,3);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,player);


            //test
            pos = new BoardPosition(3,0);
            test.placeMarker(pos,'O');
            assertEquals(test.checkDiagonalWin(pos,'O'),true);
        }

        //test tie game
        @Test
        public void checkForDraw1(){
            IGameBoard test =  MakeAGame(3,3,3);
            BoardPosition pos;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(0,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,player);

            player = 'O';
            pos = new BoardPosition(0,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,0);
            test.placeMarker(pos,player);

            //test
            assertEquals(test.checkForDraw(),true);
        }
        // empty spaces
        @Test
        public void checkForDraw2(){
            IGameBoard test =  MakeAGame(3,3,3);
            BoardPosition pos ;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(0,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,player);


            player = 'O';
            pos = new BoardPosition(0,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,0);
            test.placeMarker(pos,player);

            //test
            assertEquals(test.checkForDraw(),false);
        }
        //multiple players and multiple spaces
        @Test
        public void checkForDraw3(){
            IGameBoard test =  MakeAGame(3,3,3);
            BoardPosition pos;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(0,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,player);

            player = 'O';
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,2);
            test.placeMarker(pos,player);


            //test
            assertEquals(test.checkForDraw(),false);
        }
        //board is empty
        @Test
        public void checkForDraw4(){
            IGameBoard test =  MakeAGame(3,3,3);
            //test
            assertEquals(test.checkForDraw(),false);
        }

        //currect player currenct space
        @Test
        public void whatsAtPos1(){
            IGameBoard test =  MakeAGame(3,3,3);
            BoardPosition pos;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(0,1);
            test.placeMarker(pos,player);


            player = 'O';
            pos = new BoardPosition(0,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);


            //test
            pos = new BoardPosition(0,1);
            assertEquals(test.whatsAtPos(pos) == 'X',true);
        }
        //empty space
        @Test
        public void whatsAtPos2(){
            IGameBoard test =  MakeAGame(3,3,3);
            BoardPosition pos;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(0,1);
            test.placeMarker(pos,player);


            player = 'O';
            pos = new BoardPosition(0,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);


            //test
            pos = new BoardPosition(2,1);
            assertEquals(test.whatsAtPos(pos) == ' ',true);
        }
        @Test
        public void whatsAtPos3(){
            IGameBoard test = MakeAGame(3,3,3);
            BoardPosition pos = new BoardPosition(1,1);
            assertEquals(test.whatsAtPos(pos) == ' ',true);
        }
        //left and up boundaries
        @Test
        public void whatsAtPos4(){
            IGameBoard test =  MakeAGame(3,3,3);
            BoardPosition pos;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(0,1);
            test.placeMarker(pos,player);


            player = 'O';
            pos = new BoardPosition(0,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);


            //test
            pos = new BoardPosition(0,0);
            assertEquals(test.whatsAtPos(pos) == 'X',true);
        }
        //bottom and right boundaries
        @Test
        public void whatsAtPos5(){
            IGameBoard test =  MakeAGame(3,3,3);
            BoardPosition pos;

            //create testing board
            char player = 'X';
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,player);
            pos = new BoardPosition(0,1);
            test.placeMarker(pos,player);


            player = 'O';
            pos = new BoardPosition(0,2);
            test.placeMarker(pos,player);
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,player);


            //test
            pos = new BoardPosition(2,2);
            assertEquals(test.whatsAtPos(pos) == 'X',false);
        }

        //correct space
        @Test
        public void isPlayerAtPos1(){
            IGameBoard test =  MakeAGame(3,3,3);
            BoardPosition pos;

            //set up board for test
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,'X');
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,'X');

            pos = new BoardPosition(0,1);
            test.placeMarker(pos,'O');
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,'O');

            // test
            pos = new BoardPosition(1,1);

            assertEquals(test.isPlayerAtPos(pos,'X'),true);
        }
        //empty space
        @Test
        public void isPlayerAtPos2(){
            IGameBoard test =  MakeAGame(3,3,3);
            BoardPosition pos;

            //set up board for test
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,'X');
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,'X');

            pos = new BoardPosition(0,1);
            test.placeMarker(pos,'O');
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,'O');

            // test
            pos = new BoardPosition(1,2);

            assertEquals(test.isPlayerAtPos(pos,'O'),false);
        }
        //incorrect player
        @Test
        public void isPlayerAtPos3(){
            IGameBoard test =  MakeAGame(3,3,3);
            BoardPosition pos;

            //set up board for test
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,'X');
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,'X');

            pos = new BoardPosition(0,1);
            test.placeMarker(pos,'O');
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,'O');

            // test
            pos = new BoardPosition(1,1);

            assertEquals(test.isPlayerAtPos(pos,'O'),false);
        }
        //not a current player
        @Test
        public void isPlayerAtPos4(){
            IGameBoard test =  MakeAGame(3,3,3);
            BoardPosition pos;

            //set up board for test
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,'X');
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,'X');

            pos = new BoardPosition(0,1);
            test.placeMarker(pos,'O');
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,'O');

            // test
            pos = new BoardPosition(1,1);

            assertEquals(test.isPlayerAtPos(pos,'A'),false);
        }
        //invalid space
        @Test
        public void isPlayerAtPos5(){
            IGameBoard test =  MakeAGame(3,3,3);
            BoardPosition pos;

            //set up board for test
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,'X');
            pos = new BoardPosition(1,1);
            test.placeMarker(pos,'X');

            pos = new BoardPosition(0,1);
            test.placeMarker(pos,'O');
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,'O');

            // test
            pos = new BoardPosition(3,0);

            assertEquals(test.isPlayerAtPos(pos,'X'),false);
        }

        //open space
        @Test
        public void placeMarker1(){
            char[][] expected = new char[5][5];
            for(int r = 0; r < 5;r++){
                for (int c = 0; c < 5; c++){
                    expected[r][c] = ' ';
                }
            }
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos;

            //set up board for test
            pos = new BoardPosition(3,0);
            test.placeMarker(pos,'X');
            expected[3][0] = 'X';

            pos = new BoardPosition(2,1);
            test.placeMarker(pos,'O');
            expected[2][1] = 'O';

            // test
            pos = new BoardPosition(3,3);
            test.placeMarker(pos,'A');
            expected[3][3] = 'A';

            assertEquals(test.toString(),toString(expected));
        }
        //taken space
        @Test
        public void placeMarker2(){
            char[][] expected = new char[5][5];
            for(int r = 0; r < 5;r++){
                for (int c = 0; c < 5; c++){
                    expected[r][c] = ' ';
                }
            }
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos;

            //set up board for test
            pos = new BoardPosition(3,0);
            test.placeMarker(pos,'X');
            expected[3][0] = 'X';

            pos = new BoardPosition(2,1);
            test.placeMarker(pos,'O');
            expected[2][1] = 'O';

            // test
            pos = new BoardPosition(2,1);
            test.placeMarker(pos,'A');

            assertEquals(test.toString(),toString(expected));
        }
        //invalid space
        @Test
        public void placeMarker3(){
            char[][] expected = new char[5][5];
            for(int r = 0; r < 5;r++){
                for (int c = 0; c < 5; c++){
                    expected[r][c] = ' ';
                }
            }
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos;

            //set up board for test
            pos = new BoardPosition(3,0);
            test.placeMarker(pos,'X');
            expected[3][0] = 'X';

            pos = new BoardPosition(2,1);
            test.placeMarker(pos,'O');
            expected[2][1] = 'O';

            // test
            pos = new BoardPosition(0,5);
            test.placeMarker(pos,'A');


            assertEquals(test.toString(),toString(expected));
        }
        //first on the board
        @Test
        public void placeMarker4(){
            char[][] expected = new char[5][5];
            for(int r = 0; r < 5;r++){
                for (int c = 0; c < 5; c++){
                    expected[r][c] = ' ';
                }
            }
            IGameBoard test =  MakeAGame(5,5,4);
            BoardPosition pos;

            //test
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,'X');
            expected[2][2] = 'X';


            assertEquals(test.toString(),toString(expected));
        }
        // finish the board
        @Test
        public void placeMarker5(){
            char[][] expected = new char[3][3];
            for(int r = 0; r < 3;r++){
                for (int c = 0; c < 3; c++){
                    expected[r][c] = ' ';
                }
            }
            IGameBoard test =  MakeAGame(3,3,3);
            BoardPosition pos;

            //create testing board
            //player 'X'
            pos = new BoardPosition(0,0);
            test.placeMarker(pos,'X');
            expected[0][0] = 'X';

            pos = new BoardPosition(1,0);
            test.placeMarker(pos,'X');
            expected[1][0] = 'X';

            pos = new BoardPosition(2,1);
            test.placeMarker(pos,'X');
            expected[2][1] = 'X';

            pos = new BoardPosition(0,2);
            test.placeMarker(pos,'X');
            expected[0][2] = 'X';

            //player 'O'
            pos = new BoardPosition(0,1);
            test.placeMarker(pos,'O');
            expected[0][1] = 'O';

            pos = new BoardPosition(1,1);
            test.placeMarker(pos,'O');
            expected[1][1] = 'O';

            pos = new BoardPosition(2,0);
            test.placeMarker(pos,'O');
            expected[2][0] = 'O';

            pos = new BoardPosition(1,2);
            test.placeMarker(pos,'O');
            expected[1][2] = 'O';


            // place new marker
            pos = new BoardPosition(2,2);
            test.placeMarker(pos,'X');
            expected[2][2] = 'X';

            assertEquals(test.toString(),toString(expected));
        }
    }
