import java.util.Arrays;
import java.util.Scanner;
//koniec!!
public class Pacman {

	static char[][] field = new char[10][10];
	static char[][] wayToArr = new char[field.length][field[0].length];
	static int count = 0;
	// X possition
	static int x = (int) Math.floor(Math.random() * field.length);
	static int y = (int) Math.floor(Math.random() * field[0].length);
	// O posiition
	static int i = (int) Math.floor(Math.random() * field.length);
	static int j = (int) Math.floor(Math.random() * field[0].length);
	//ghost possition
	static int ghostX = (int) Math.floor(Math.random() * field.length);
	static int ghostY = (int) Math.floor(Math.random() * field[0].length);
	
	// H possitions
	static int k = 0;
	static int l = 0;
	
	// H counter
	static int hLimit;
	
	// direction  chooser
	static int direction = (int) Math.floor(Math.random() * 4);
	static boolean right;
	static boolean left;
	static boolean up;
	static boolean down;
	
	static int moveCount;
	static char[] directionsArr;
	
	static WayCheck wayCheck = new WayCheck(wayToArr, x, y, ghostX, ghostY);

	public static boolean fieldCreate() {
		while(x == i && y == j) {
			i = (int) Math.floor(Math.random() * field.length);
			j = (int) Math.floor(Math.random() * field[0].length);
		}
		while(ghostX == x && ghostY == y) {
			ghostX = (int) Math.floor(Math.random() * field.length);
			ghostY = (int) Math.floor(Math.random() * field[0].length);	
			}
		hLimit = 0;
		// field creating
				for (int i = 0; i < field.length; i++) {
					for (int j = 0; j < field[i].length; j++) {
						field[i][j] = '_';
					}
				}
				// start possitions
				field[x][y] = 'X';
				field[i][j] = 'O';
				field[ghostX][ghostY] = 'G';

				// H posisions
				while (hLimit < 30) {
					k = (int) Math.floor(Math.random() * field.length);
					l = (int) Math.floor(Math.random() * field[0].length);

					if (field[k][l] == '_') {
						field[k][l] = 'H';
						hLimit++;
					}

				}

//				//way possibility checking
				if (wayCheck.wayCheckExecutor(field, x, y,  right, left, up, down, 'O', 0, directionsArr) == false) {
					for(int i = 0; i < field.length; i++) {
						System.out.println(Arrays.toString(field[i]));
					}
					System.out.println("game over");
					return false;
				} else
					System.out.println("dzia³a");
			
				wayCheck = new WayCheck(wayToArr, x, y, ghostX, ghostY);
				
				//ghost way checking
				if (wayCheck.wayCheckExecutor(field, ghostX, ghostY, right, left, up, down, 'X', moveCount, directionsArr)) {	
					System.out.println("Duch ma drogê");
					moveCount = wayCheck.counter();
				}else System.out.println("Duch nie ma drogi");
				wayCheck = new WayCheck(wayToArr, x, y, ghostX, ghostY);
				directionsArr = new char[moveCount];
				wayCheck.wayCheckExecutor(field, ghostX, ghostY, right, left, up, down, 'X', moveCount, directionsArr);
				moveCount = 0;
				// field printing
				for (int i = 0; i < field.length; i++) {
					System.out.println(Arrays.toString(field[i]));

				}
				
				
//				System.out.println(Arrays.toString(directionsArr));
				System.out.println();
				System.out.println("score: " + count);
				
				return true;

	}
	
	public static boolean pacman() {
		if(fieldCreate() == false) {
			return false;
		};
	
		
		Scanner scanner = new Scanner(System.in);

		// moving
		while (y != field.length + 1) {
			String move = scanner.nextLine();
			if (move.equals("w") && x >= 1 && field[x - 1][y] != 'H') {
				x -= 1;
				field[x][y] = 'X';
				field[x + 1][y] = '_';
			} else if (move.equals("z") && x <= 8 && field[x + 1][y] != 'H') {
				x += 1;
				field[x][y] = 'X';
				field[x - 1][y] = '_';
			}

			else if (move.equals("a") && y >= 1 && field[x][y - 1] != 'H') {
				y -= 1;
				field[x][y] = 'X';
				field[x][y + 1] = '_';
			}

			else if (move.equals("d") && y <= 8 && field[x][y + 1] != 'H') {
				y += 1;
				field[x][y] = 'X';
				field[x][y - 1] = '_';
			}
			
			//ghost way checking
			if (wayCheck.wayCheckExecutor(field, ghostX, ghostY, right, left, up, down, 'X', moveCount, directionsArr)) {	
				moveCount = wayCheck.counter();
				System.out.println(moveCount);
				System.out.println("Duch ma drogê");
			}else System.out.println("Duch nie ma drogi");
			directionsArr = new char[moveCount];
			wayCheck = new WayCheck(wayToArr, x, y, ghostX, ghostY);
			wayCheck.wayCheckExecutor(field, ghostX, ghostY, right, left, up, down, 'X', moveCount, directionsArr);
			moveCount = 0;
			
			
			if (x == i && y == j) {
				count++;
				i = (int) Math.floor(Math.random() * field.length);
				j = (int) Math.floor(Math.random() * field[0].length);

				while (field[i][j] == 'H' || field[i][j] == 'X' || field[i][j] == 'G') {
					i = (int) Math.floor(Math.random() * field.length);
					j = (int) Math.floor(Math.random() * field[0].length);
				}
				field[i][j] = 'O';

//				way possibility checking
				if (wayCheck.wayCheckExecutor(field, x, y, right, left, up, down, 'O', 0, directionsArr) == false) {
					for(int i = 0; i < field.length; i++) {
						System.out.println(Arrays.toString(field[i]));
					}
					System.out.println("game over");
					return false;
				} else
					System.out.println("dzia³a");
				
				
				wayCheck = new WayCheck(wayToArr, x, y, ghostX, ghostY);
				
			
				if(count % 3 == 0) {
					if(fieldCreate() == false) {
						return false;
					};
				}

			} else if (move.equals("q"))
				y = field.length + 1;
			
			
			for (int i = 0; i < field.length; i++) {
				System.out.println(Arrays.toString(field[i]));

			}

			System.out.println(moveCount);
			
			System.out.println(Arrays.toString(directionsArr));
			System.out.println();
			System.out.println("score: " + count);

		}
		return true;
	}

	public static void main(String[] args) {

		pacman();

	}

}