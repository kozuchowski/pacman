import java.util.Arrays;

public class WayCheck {

	public static boolean way (char[][] field, char[][] arr, int tempX, int tempY, boolean r, boolean l, boolean u, boolean d) {
		
//		for(int i = 0; i < field.length; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			
//		}
		System.out.println( " ");
			r = false;
			l = false;
			d = false;
			u = false;
		
			//way right
			if(tempY + 1 < arr.length && field[tempX][tempY + 1] != 'H'  && arr[tempX][tempY + 1] != 'X') {
				if(field[tempX][tempY + 1] == 'O') {
					return true;
				}
				
				arr[tempX][tempY + 1] = 'X';
				r = true;	
			}
			//way left
			if(tempY > 0 && field[tempX][tempY - 1] != 'H'  && arr[tempX][tempY - 1] != 'X') {
				if(field[tempX][tempY - 1] == 'O'){				 
					return true;
				}
				
				arr[tempX][tempY - 1] = 'X';
				l = true;
			}
			
			//way down
			if(tempX + 1 < arr.length && field[tempX + 1][tempY] != 'H'  && arr[tempX + 1][tempY] != 'X') {
				if(field[tempX + 1][tempY] == 'O') {
					return true;
				}
				
				arr[tempX + 1][tempY] = 'X';
				d = true;
			}
			
			//way up
			if(tempX > 0 &&  field[tempX - 1][tempY] != 'H'  && arr[tempX - 1][tempY] != 'X') {
				if(field[tempX - 1][tempY] == 'O') {
					return true;
				}	
				arr[tempX - 1][tempY] = 'X';
				u = true;
			}
			
			if(r) {
				if(way(field, arr, tempX, tempY + 1, r ,l, u, d))
					return true;
			}
			if(l) {
				if(way(field, arr, tempX, tempY - 1, r, l, u, d)) 
					return true;
				
			}
			if(d) {
				if(way(field, arr, tempX + 1, tempY, r, l, u, d))
					return true;
			}
			if(u) {
				if(way(field, arr, tempX - 1, tempY, r, l ,u, d))
					return true;
			}
			
			
			 return false;
	
	}
}

