package cpsc2150.extendedTicTacToe;

import cpsc2150.extendedTicTacToe.models.*;

import java.util.*;

public class GameScreen {

        private static char player;
        private static final int MAX_PLAYERS = 10, MAX_DIMENSION = 100,MAX_WINNING_NUMBER = 25;
        private static final int MIN_DIMENSION = 3, MIN_PLAYERS = 2;
        private static List<Character> players = new ArrayList<>();
        private static final Scanner scan = new Scanner(System.in);

    /**
     * controls the flow of  the Extended Tic Tac Toe game
      */
    private static void playGame()
    {

        boolean flag = false, winner = false;
        int r = 0;
        int c = 0;
        int w = 0;
        int num_of_players = 0;
        IGameBoard game;


        //input number of players
        while(MIN_PLAYERS > num_of_players || num_of_players > MAX_PLAYERS)
        {
            System.out.println("How many players?");
            num_of_players = scan.nextInt();
            if(num_of_players > MAX_PLAYERS)
                System.out.println("Must be 10 players or fewer");
            else if(num_of_players < MIN_PLAYERS)
                System.out.println("Must be at least 2 players");
        }

        // put players into the players arrayList
        int i = 0;
        while(i < num_of_players)
        {
            System.out.println("Enter the character to represent player "+(i+1));
            player = Character.toUpperCase(scan.next().charAt(0));
            if(i == 0 || players.contains(player) == false){
                players.add(player);
                i++;
            }
            else
            {
                System.out.println(player + " is already taken as a player token!");
            }
        }

        //input number of rows
        while(MIN_DIMENSION > r || r >= MAX_DIMENSION)
        {
            System.out.println("How many rows?");
            r = scan.nextInt();
            if(MIN_DIMENSION > r || r >= MAX_DIMENSION)
            {
                System.out.println("Rows must be between 3 and 100");
            }
        }

        //input number of columns
        while(MIN_DIMENSION > c || c >= MAX_DIMENSION)
        {
            System.out.println("How many columns?");
            c = scan.nextInt();
            if(MIN_DIMENSION > c || c >= MAX_DIMENSION)
            {
                System.out.println("Columns must be between 3 and 100");
            }
        }

        //input number to win
        while(MIN_DIMENSION > w || w >= MAX_WINNING_NUMBER || w > r || w > c)
        {
            System.out.println("How many in a row to win?");
            w = scan.nextInt();
            if(MIN_DIMENSION > w || w >= MAX_WINNING_NUMBER)
            {
                System.out.println("it must be between 3 and 25");
            }
            else if(w > r)
                System.out.println("must be less than or equal to the number of rows");
            else if(w > c)
                System.out.println("must be less than or equal to the number of columns");
        }


        // fast or memory efficient
        char mem = ' ';
        while(mem != 'F' && mem != 'M'){
            System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");
            mem = Character.toUpperCase(scan.next().charAt(0));
            if(mem != 'F' && mem != 'M'){
                System.out.println("Please enter F or M");
            }
        }

        if(mem == 'F')
            game = new GameBoard(r,c,w);
        else
            game = new GameBoardMem(r,c,w);

        player = players.get(0); //sets to first player

        // start game
        int row;
        int column;
        while(!winner)
        {
            BoardPosition pos;
            System.out.println(game.toString());

            do // user input for position
            {
                System.out.println("Player "+ player + " Please enter your ROW");
                 row = scan.nextInt();
                System.out.println("Player "+ player +" Please enter your COLUMN");
                column = scan.nextInt();
                pos = new BoardPosition(row,column);
                if(!game.checkSpace(pos)) {
                    System.out.println("That space is unavailable, please pick again");
                    System.out.println(game.toString());
                }
            } while (!game.checkSpace(pos));

            game.placeMarker(pos,player);

            if(game.checkForDraw())//checks for draw
            {
                System.out.println("Draw! No player wins!");
                winner = true;
            }
            else if(game.checkForWinner(pos)) // checks for winner
            {
                System.out.println("Player " + player+" wins!");
                winner = true;
            }

            nextPlayer(player);

        }//while(!winner)

        System.out.printf(game.toString());
        char input = ' ';

        // checks if user want to play again
        while (true){
            System.out.println("Would you like to play again? Y/N");
            input = Character.toUpperCase(scan.next().charAt(0));
            if(input == 'Y') {
                flag = true;
                break;
            }
            if(input == 'N')
                break;
        }
        if(flag) {
            players.clear();
            playGame(); // recursively start a new game
        }
    }

    /**
     * player is set to the next player
     * @param p current player
     * @return next player
     * @pre players.contains(p) == true
     * @post if (players.indexOf(p) != players.size-1) player = players.get(players.indexOf(p)+1)
     * else (player = players.get(0))
     * players = #players
     */
    public static void nextPlayer(char p)
    {
        int i = players.indexOf(p);
        if(i == players.size()-1)
            i = 0;
        else
            i++;
        player = players.get(i);
    }

    public static void main(String args[]){
        playGame();

    }
}
