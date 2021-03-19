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
	static int choose = (int)Math.floor(Math.random() * 4);
	
	
	public static void right(char[][] tempArr) {
		if(tempY < field[0].length - 1) {
			if(field[tempX][tempY + 1] == '_') {
				tempY = tempY + 1;
				tempArr[tempX][tempY] = 'X';
				tempArr[tempX][tempY - 1] = '_';
			}else {
				choose = (int)Math.floor(Math.random() * 4);
		}
		}
		
	}
	public static void left(char[][] tempArr) {
		if(tempY - 1 > 0) {
			if(field[tempX][tempY - 1] == '_') {
				tempY = tempY - 1;
				tempArr[tempX][tempY] = 'X';
				tempArr[tempX][tempY + 1] = '_';
			}else {
				choose = (int)Math.floor(Math.random() * 4);
			}
		}
		
	}
	public static void up(char[][] tempArr) {
		if(tempX - 1 > 0) {
			if(field[tempX - 1][tempY] == '_') {
				tempX = tempX - 1;
				tempArr[tempX][tempY] = 'X';
				tempArr[tempX + 1][tempY] = '_';
			}else {
				choose = (int)Math.floor(Math.random() * 4);
			}
		}
		
	}
	public static void down(char[][] tempArr) {
		if(tempX < field.length - 1) {
			if(field[tempX + 1][tempY] == '_') {
				tempX = tempX + 1;
				tempArr[tempX][tempY] = 'X';
				tempArr[tempX - 1][tempY] = '_';
			}else {
				choose = (int)Math.floor(Math.random() * 4);
			}
		}
		
	}
	
	public static boolean way (char[][] tempArr) {
		if(tempX == i && tempY == j)
			return true;
		
		if(choose == 0) {
			right(tempArr);
			way(tempArr);
		}else if(choose == 1) {
			up(tempArr);
			way(tempArr);
		}else if (choose  == 2) {
			down(tempArr);
			way(tempArr);
		}else if(choose == 3) {
			left(tempArr);
			way(tempArr);
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
//		if(way(wayToO) == true)
//			System.out.println("dzia³a");
	
		
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
			i = (int) Math.floor(Math.random() * field.length);
			j = (int) Math.floor(Math.random() * field[0].length);
			
			while(field[i][j] == 'H' || field[i][j] == 'X') { 
				i = (int) Math.floor(Math.random() * field.length);
				j = (int) Math.floor(Math.random() * field[0].length);
			}
				field[i][j] = 'O';
//				if(way(wayToO) == true)
//					System.out.println("dzia³a");

		}
			
		else if(move.equals("q"))
			y = field.length + 1;
		
		System.out.println(x + " " + y);
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