/**
 * Date 01/08/2017
 * @author Tashnim Chowdhury
 *
 * References -
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 * https://www.youtube.com/watch?v=xouin83ebxE
 * 
 */




import java.util.Arrays;

public class NQueen {

		class Position {
			int row, col;

			Position(int row, int col) {
				this.row = row;
				this.col = col;
			}
		}
		
		public static void main(String[] args) {
			NQueen s = new NQueen();
			Position[] positions = s.NQueenSol(4);
	        Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.col));
		}


		public Position[] NQueenSol(int N) {
			Position[] positions = new Position[N];
			boolean solution = getPosition(N, 0, positions);

			if (solution) {
				return positions;
			} else {
				return new Position[0];
			}

		}

		private boolean getPosition(int N, int row, Position[] position) {
			if (N == row) {
				return true;
			}

			for (int col = 0; col < N; col++) {
				boolean safe = true;

				for (int queen = 0; queen < row; queen++) {
					if (position[queen].col == col || position[queen].row + position[queen].col == row + col
							|| position[queen].row - position[queen].col == row - col) {
						safe = false;
					}
				}

				if (safe) {
					position[row] = new Position(row, col);
					if (getPosition(N, row + 1, position)) {
						return true;
					}
				}

			}
			return false;

		}

		
	}

