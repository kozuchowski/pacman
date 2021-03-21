import java.util.Arrays;
import java.util.Scanner;

public class Pacman {
	
	static char[][] field =  new char [10][10];
	static char[][] wayToO = new char[field.length][field[0].length];
	static int count = 0;
	//X possition
	static int x = (int) Math.floor(Math.random() * field.length);
	static int y = (int) Math.floor(Math.random() * field[0].length);
	//O posiition
	static int i = (int) Math.floor(Math.random() * field.length);
	static int j = (int) Math.floor(Math.random() * field[0].length);
	// tempX possition
	static int tempX = x;
	static int tempY = y;
	//H possitions
	static int k = 0;
	static int l = 0;
	//H counter
	static int hLimit = 0;
	//function chooser
	static int direction = (int)Math.floor(Math.random() * 4);
	//iteration limit
	static int counter = 0;
	
	
	public static void right() {
		tempY += 1;
		direction = (int)Math.floor(Math.random() * 4);
	}
	public static void left() {
		tempY -= 1;
		direction = (int)Math.floor(Math.random() * 4);
	}
	public static void up() {
		tempX -= 1;	
		direction = (int)Math.floor(Math.random() * 4);
	}
	public static void down() {
		tempX += 1;
		direction = (int)Math.floor(Math.random() * 4);
	}
	public static boolean way () {
//		System.out.println(tempX + " " + tempY + " " + "direction:" + direction);
		while(counter < 3500) { //very poorly limited
			if(field[tempX][tempY] == 'O') {
				return true;
			}else {
				if(direction == 0) {
					if(tempY +1 < field[0].length && field[tempX][tempY +1] != 'H') {
						right();
						
					}
				}else if(direction == 1) {
					if(tempY -1 >= 0 && field[tempX][tempY -1] != 'H') {
						left();
						
					}
				}else if(direction == 2) {
					if(tempX -1 >= 0 && field[tempX -1][tempY] != 'H') {
						up();
						
					}
				}else if(direction == 3) {
					if(tempX +1 < field.length && field[tempX +1][tempY] != 'H') {
						down();
						
					}
				}
			}
			direction = (int)Math.floor(Math.random() * 4);
			counter++;
			way();
		}

		return false;
	
	}
	public static void pacman () {
		
		while(x == i && y == j) {
			i = (int) Math.floor(Math.random() * field.length);
			j = (int) Math.floor(Math.random() * field[0].length);
		}
		
		
		
		//field creating
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				field[i][j] = '_';
			}
		}
		//start possitions
		field[x][y] = 'X';
		field[i][j] = 'O';
		
		
		//H posisions
		while (hLimit < 30) {
				k = (int) Math.floor(Math.random() * field.length);
				l = (int) Math.floor(Math.random() * field[0].length);
				
				if(field[k][l] == '_') {
					field[k][l] = 'H';
				hLimit++;
				}
		
		}
		
		//way possibility checking
		if(way() == true) {
			System.out.println("There is a way");
		}else 
			System.out.println("No possible way. Game Over!");
		
	
		
		//field printing
		for(int i = 0; i < field.length; i++) {
			System.out.println(Arrays.toString(field[i]));
			
		};
		System.out.println("score: " + count);
		Scanner scanner = new Scanner(System.in);
		
	
		
		//moving
	while (y != field.length + 1) {
		String move = scanner.nextLine();
		if(move.equals("w" )&& x >= 1 && field[x-1][y] != 'H') {	
			x -= 1;
			field[x][y] = 'X';
			field[x+1][y] = '_';		
		}
		else if(move.equals("z") && x <=8 && field[x + 1][y] != 'H') {
			x += 1;
			field[x][y] = 'X';
			field[x-1][y] = '_';
		}
		
		else if(move.equals("a") && y >=1 && field[x][y - 1] != 'H') {
			y -= 1;
			field[x][y] = 'X';
			field[x][y+1] = '_';
		}
			
		else if(move.equals("d") && y <= 8 && field[x][y + 1] != 'H') {
			y += 1;
			field[x][y] = 'X';
			field[x][y-1] = '_';
		}
		if(x == i && y == j) {
			count ++;
			counter = 0;
			i = (int) Math.floor(Math.random() * field.length);
			j = (int) Math.floor(Math.random() * field[0].length);
			
			while(field[i][j] == 'H' || field[i][j] == 'X') { 
				i = (int) Math.floor(Math.random() * field.length);
				j = (int) Math.floor(Math.random() * field[0].length);
			}
				field[i][j] = 'O';
				
				//way possibility checking
				if(way() == true) {
					System.out.println("There is a way");
				}else 
					System.out.println("No possible way. Game over!");
				
					
				

		}
			
		else if(move.equals("q"))
			y = field.length + 1;
		
		
		for(int i = 0; i < field.length; i++) {
			System.out.println(Arrays.toString(field[i]));
			
		};
		System.out.println("score: " + count);
		
		
	}
	}

	public static void main(String[] args) {
		
		pacman();
		
	}
	
}	