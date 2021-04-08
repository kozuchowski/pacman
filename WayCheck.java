import java.util.Arrays;
public class WayCheck {
	static int check;
	public static boolean way (char[][] field, char[][] arr, int tempX, int tempY, boolean r, boolean l, boolean u, boolean d, int ox, int oy) {
		

	
			r = false;
			l = false;
			d = false;
			u = false;
		
			//sprawdzanie czy mo¿e w prawo
			if(tempY + 1 < arr.length && field[tempX][tempY + 1] != 'H'  && arr[tempX][tempY + 1] != 'X') {
				if(field[tempX][tempY + 1] == 'O') {
					System.out.println("znalaz³em");
					check = 1;
				}
				
				arr[tempX][tempY + 1] = 'X';
				r = true;	
			}
			//sprawdzanie czy mo¿e w lewo
			if(tempY > 0 && field[tempX][tempY - 1] != 'H'  && arr[tempX][tempY - 1] != 'X') {
				if(field[tempX][tempY - 1] == 'O'){				 
					System.out.println("znalaz³em");
					check = 1;
				}
				
				arr[tempX][tempY - 1] = 'X';
				l = true;
			}
			
			//sprawdzanie czy mo¿e w dó³
			if(tempX + 1 < arr.length && field[tempX + 1][tempY] != 'H'  && arr[tempX + 1][tempY] != 'X') {
				if(field[tempX + 1][tempY] == 'O') {
					System.out.println("znalaz³em");
					check = 1;
				}
				
				arr[tempX + 1][tempY] = 'X';
				d = true;
			}
			
			////sprawdzanie czy mo¿e do góry
			if(tempX > 0 &&  field[tempX - 1][tempY] != 'H'  && arr[tempX - 1][tempY] != 'X') {
				if(field[tempX - 1][tempY] == 'O') {
					System.out.println("znalaz³em");
					check = 1;
				}	
				arr[tempX - 1][tempY] = 'X';
				u = true;
			}
			if(check == 1)
				return true;
			System.out.println(tempX + " " + tempY);
			if(r) way(field, arr, tempX, tempY + 1, r ,l, u, d, ox, oy);
			if(l) way(field, arr, tempX, tempY - 1, r, l, u, d, ox, oy);
			if(d) way(field, arr, tempX + 1, tempY, r, l, u, d, ox, oy);
			if(u) way(field, arr, tempX - 1, tempY, r, l ,u, d, ox, oy);
			
			if(check == 1)
				return true;
			 return false;
	
	}
}

