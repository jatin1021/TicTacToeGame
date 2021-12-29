import java.util.Scanner;

class TicTacToeGame {
	  
	public static void main(String[] args) {
		
		char[][] board = new char[3][3];
		
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				board[x][y] = '-';
			}
		}

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Tic Tac Toe Game");
		System.out.print("Player 1 name: ");
		String p1 = keyboard.nextLine();
		System.out.print("Player 2 name: ");
		String p2 = keyboard.nextLine();

		boolean player1turn = true;

		boolean gameEnded = false;
		while(!gameEnded) {

			drawBoard(board);

			if(player1turn) {
				System.out.println(p1 + " Turn (x):");
			} else {
				System.out.println(p2 + " Turn (o):");
			}

			char c = '-';
			if(player1turn) {
				c = 'x';
			} else {
				c = 'o';
			}

			int row = 0;
			int col = 0;

			while(true) {
				
				System.out.print("Enter a row (0, 1, or 2): ");
				row = keyboard.nextInt();
				System.out.print("Enter a column (0, 1, or 2): ");
				col = keyboard.nextInt();

				if(row < 0 || col < 0 || row > 2 || col > 2) {
					System.out.println("Error");
				
				} else if(board[row][col] != '-') {
					System.out.println("Error");
				
				} else {
					break;
				}
			
			}

			board[row][col] = c;

			if(playerHasWon(board) == 'x') {
				System.out.println(p1 + " won!");
				gameEnded = true;
			} else if(playerHasWon(board) == 'o') {
				System.out.println(p2 + " won!");
				gameEnded = true;
			} else {

				if(boardIsFull(board)) {
					System.out.println("Tie!");
					gameEnded = true;
				} else {
					player1turn = !player1turn;
				}

			}

		}
		
		drawBoard(board);

  }

	public static void drawBoard(char[][] board) {
		System.out.println("Board:");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static char playerHasWon(char[][] board) {
		
		for(int i = 0; i < 3; i++) {
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
				return board[i][0];
			}
		}

		for(int j = 0; j < 3; j++) {
			if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
				return board[0][j];
			}
		}

		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
			return board[0][0];
		}
		if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') {
			return board[2][0];
		}

		return ' ';

	}

	public static boolean boardIsFull(char[][] board) {
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				if(board[x][y] == '-') {
					return false;
				}
			}
		}
		return true;
	}
}
