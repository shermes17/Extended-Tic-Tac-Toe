default: cpsc2150/extendedTicTacToe/GameScreen.java cpsc2150/extendedTicTacToe/models/AbsGameBoard.java cpsc2150/extendedTicTacToe/models/BoardPosition.java cpsc2150/extendedTicTacToe/models/GameBoard.java cpsc2150/extendedTicTacToe/models/GameBoardMem.java cpsc2150/extendedTicTacToe/models/IGameBoard.java
	javac cpsc2150/extendedTicTacToe/GameScreen.java cpsc2150/extendedTicTacToe/models/AbsGameBoard.java cpsc2150/extendedTicTacToe/models/BoardPosition.java cpsc2150/extendedTicTacToe/models/GameBoard.java cpsc2150/extendedTicTacToe/models/GameBoardMem.java cpsc2150/extendedTicTacToe/models/IGameBoard.java

run: cpsc2150/extendedTicTacToe/GameScreen.class cpsc2150/extendedTicTacToe/models/AbsGameBoard.class cpsc2150/extendedTicTacToe/models/BoardPosition.class cpsc2150/extendedTicTacToe/models/GameBoard.class cpsc2150/extendedTicTacToe/models/GameBoardMem.class cpsc2150/extendedTicTacToe/models/IGameBoard.class
	java cpsc2150.extendedTicTacToe.GameScreen

test: cpsc2150/extendedTicTacToe/models/TestGameBoard.java cpsc2150/extendedTicTacToe/models/TestGameBoardMem.java cpsc2150/extendedTicTacToe/models/AbsGameBoard.java cpsc2150/extendedTicTacToe/models/BoardPosition.java cpsc2150/extendedTicTacToe/models/GameBoard.java cpsc2150/extendedTicTacToe/models/GameBoardMem.java cpsc2150/extendedTicTacToe/models/IGameBoard.java cpsc2150/extendedTicTacToe/GameScreen.java
	javac -cp .:/usr/share/java/junit4.jar cpsc2150/extendedTicTacToe/models/TestGameBoard.java cpsc2150/extendedTicTacToe/models/TestGameBoardMem.java cpsc2150/extendedTicTacToe/models/AbsGameBoard.java cpsc2150/extendedTicTacToe/models/BoardPosition.java cpsc2150/extendedTicTacToe/models/GameBoard.java cpsc2150/extendedTicTacToe/models/GameBoardMem.java cpsc2150/extendedTicTacToe/models/IGameBoard.java cpsc2150/extendedTicTacToe/GameScreen.java
	
testGB: cpsc2150/extendedTicTacToe/models/TestGameBoard.class cpsc2150/extendedTicTacToe/models/AbsGameBoard.class cpsc2150/extendedTicTacToe/models/BoardPosition.class cpsc2150/extendedTicTacToe/models/GameBoard.class cpsc2150/extendedTicTacToe/models/GameBoardMem.class cpsc2150/extendedTicTacToe/models/IGameBoard.class cpsc2150/extendedTicTacToe/GameScreen.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.extendedTicTacToe.models.TestGameBoard
	
testGBmem: cpsc2150/extendedTicTacToe/models/TestGameBoardMem.class cpsc2150/extendedTicTacToe/models/AbsGameBoard.class cpsc2150/extendedTicTacToe/models/BoardPosition.class cpsc2150/extendedTicTacToe/models/GameBoard.class cpsc2150/extendedTicTacToe/models/GameBoardMem.class cpsc2150/extendedTicTacToe/models/IGameBoard.class cpsc2150/extendedTicTacToe/GameScreen.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.extendedTicTacToe.models.TestGameBoardMem
	

clean:
	rm -f cpsc2150/extendedTicTacToe/*.class
	rm -f cpsc2150/extendedTicTacToe/models/*.class
	rm -f *.zip
zip:
	zip -r project4.zip cpsc2150 makefile Report.pdf -x ".*" -x "__MACOSX" -x "*/.*"
