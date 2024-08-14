package cpsc2150.extendedTicTacToe.controllers;

import cpsc2150.extendedTicTacToe.models.*;
import cpsc2150.extendedTicTacToe.views.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * The {@link TicTacToeController} class will handle communication between our {@link TicTacToeView}
 * and our model ({@link IGameBoard} and {@link BoardPosition})
 * </p>
 *
 * <p>
 * This is where you will write code
 * <p>
 *
 * You will need to include your {@link BoardPosition} class, the {@link IGameBoard} interface
 * and both of the {@link IGameBoard} implementations from Project 4.
 * If your code was correct you will not need to make any changes to your {@link IGameBoard} implementation class.
 *
 * @version 2.0
 */
public class TicTacToeController {

    /**
     * <p>
     * The current game that is being played
     * </p>
     */
    private IGameBoard curGame;

    /**
     * <p>
     * The screen that provides our view
     * </p>
     */
    private TicTacToeView screen;

    /**
     * <p>
     * Constant for the maximum number of players.
     * </p>
     */
    public static final int MAX_PLAYERS = 10;

    /**
     * <p>
     * The number of players for this game. Note that our player tokens are hard coded.
     * </p>
     */
    private int numPlayers;

    /**
     * List of characters that represents the current players in the game
     */
    private static List<Character> players = new ArrayList<>();

    /**
     * Array of chars that represents the possible players
     */
    private static final char [] PLAYER_LIST = {'X','O','A','Z','N','L','S','K','P','U'};

    /**
     * char variable represents the current player
     */
    private static char player;

    private boolean winner_found;


    /**
     * <p>
     * This creates a controller for running the Extended TicTacToe game
     * </p>
     *
     * @param model
     *      The board implementation
     * @param view
     *      The screen that is shown
     * @param np
     *      The number of players for this game.
     *
     * @post [ the controller will respond to actions on the view using the model. ]
     */
    public TicTacToeController(IGameBoard model, TicTacToeView view, int np) {
        this.curGame = model;
        this.screen = view;
        this.numPlayers = np;

        // Some code is needed here.
        for(int i = 0; i < numPlayers;i++){
            players.add(PLAYER_LIST[i]);
        }
        player = players.get(0);
        winner_found = false;
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
    public static void nextPlayer(char p) {
        int i = players.indexOf(p);
        if(i == players.size()-1)
            i = 0;
        else
            i++;
        player = players.get(i);
    }

    /**
     * <p>
     * This processes a button click from the view.
     * </p>
     *
     * @param row
     *      The row of the activated button
     * @param col
     *      The column of the activated button
     *
     * @post [ will allow the player to place a marker in the position if it is a valid space, otherwise it will display an error
     * and allow them to pick again. Will check for a win as well. If a player wins it will allow for them to play another
     * game hitting any button ]
     */
    public void processButtonClick(int row, int col) {
        // Your code goes here.

        //button pressed after a winner
        if(winner_found){
            players.clear();
            newGame();
        }
        else {
            // checks if current space is valid
            BoardPosition pos = new BoardPosition(row, col);
            if (!curGame.checkSpace(pos)) {
                screen.setMessage("Invalid space!");
                return;
            }
            //places marker in models and in views
            curGame.placeMarker(pos, player);
            screen.setMarker(row, col, player);


            if (curGame.checkForWinner(pos)) { //checks for winner
                screen.setMessage("Player " + player + " has won!");
                winner_found = true;
            }
            else if (curGame.checkForDraw()) { // checks for draw
                screen.setMessage("Draw!");
                winner_found = true;
            }
            else {  //goes to next player
                nextPlayer(player);
                screen.setMessage("It is " + player + "'s turn.");
            }
        }
    }

    /**
     * <p>
     * This method will start a new game by returning to the setup screen and controller
     * </p>
     *
     * @post [ a new game gets started ]
     */
    private void newGame() {
        //close the current screen
        screen.dispose();

        //start back at the set up menu
        GameSetupScreen screen = new GameSetupScreen();
        GameSetupController controller = new GameSetupController(screen);
        screen.registerObserver(controller);
    }
}