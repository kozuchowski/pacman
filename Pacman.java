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
	static int recuX = x;
	static int recuY = y;
	
	public static boolean way (char[][] field, char[][] arr, int x, int y) {
//		for(int i = 0; i < field.length; i++) {
//			System.out.println(Arrays.toString(field[i]));
//		}
//		System.out.println(" ");
//		for(int i = 0; i < field.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println(" ");
		
		if(field[x][y] == 'O') {
			System.out.println("znalaz³em");
			return true;
			
		}else {
			
			if(y + 1 < arr.length && (field[x][y + 1] == '_' || field[x][y + 1] == 'O') && arr[x][y + 1] != 'X') {
				System.out.println(counter + " right ");
				arr[x][y + 1] = 'X';
				
				way(field, arr, x, y + 1);
				
			}else if(y - 1 >= 0 && (field[x][y - 1] == '_' || field[x][y - 1] == 'O') && arr[x][y - 1] != 'X') {
				System.out.println(counter + " left ");
				arr[x][y - 1] = 'X';
				
				way(field, arr, x, y - 1);
				
			}else if(x + 1 < arr.length && (field[x + 1][y] == '_' || field[x + 1][y] == 'O') && arr[x + 1][y] != 'X') {
				System.out.println(counter + " down ");
				arr[x + 1][y] = 'X';
				
				way(field, arr, x + 1, y);
			}else if(x - 1 >= 0 && (field[x - 1][y] == '_' || field[x - 1][y] == 'O') && arr[x - 1][y] != 'X') {
				System.out.println(counter + " up ");
				arr[x - 1][y] = 'X';
				
				way(field, arr, x - 1, y);
			}
		}
		counter++;
		System.out.println(x+ " " + y);
		
		
		
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
		
//		//way possibility checking
		if(way(field, wayToO, tempX, tempY) == false)
			System.out.println("game over");
		
			
		
		
	
		
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
				if(way(field, wayToO, tempX, tempY) == false)
					System.out.println("game over");
				
				
					
				

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