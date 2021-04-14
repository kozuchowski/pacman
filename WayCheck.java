import java.util.Arrays;
//koniec!!
public class WayCheck {
	static char[][] arr;
	static int x;
	static int y;
	WayCheck(char[][] field, int tempX, int tempY){
		arr = new char[field.length][field.length];
		x = tempX;
		y = tempY;
	}
	public static boolean wayCheckExecutor(char[][] field, boolean r, boolean l, boolean u, boolean d, char target ) {
		if(way(field, x, y, r, l, u, d, target) == false)
			return false;
		return true;
	}
	public static boolean way (char[][] field,  int tempX, int tempY, boolean r, boolean l, boolean u, boolean d, char target) {
		
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
				if(field[tempX][tempY + 1] == target) {
					return true;
				}
				
				arr[tempX][tempY + 1] = 'X';
				r = true;	
			}
			//way left
			if(tempY > 0 && field[tempX][tempY - 1] != 'H'  && arr[tempX][tempY - 1] != 'X') {
				if(field[tempX][tempY - 1] == target){				 
					return true;
				}
				
				arr[tempX][tempY - 1] = 'X';
				l = true;
			}
			
			//way down
			if(tempX + 1 < arr.length && field[tempX + 1][tempY] != 'H'  && arr[tempX + 1][tempY] != 'X') {
				if(field[tempX + 1][tempY] == target) {
					return true;
				}
				
				arr[tempX + 1][tempY] = 'X';
				d = true;
			}
			
			//way up
			if(tempX > 0 &&  field[tempX - 1][tempY] != 'H'  && arr[tempX - 1][tempY] != 'X') {
				if(field[tempX - 1][tempY] == target) {
					return true;
				}	
				arr[tempX - 1][tempY] = 'X';
				u = true;
			}
			
			if(r) {
				if(way(field,  tempX, tempY + 1, r ,l, u, d, target))
					return true;
			}
			if(l) {
				if(way(field, tempX, tempY - 1, r, l, u, d, target)) 
					return true;
				
			}
			if(d) {
				if(way(field, tempX + 1, tempY, r, l, u, d, target))
					return true;
			}
			if(u) {
				if(way(field,  tempX - 1, tempY, r, l ,u, d, target))
					return true;
			}
			
			
			 return false;
	
	}
}

