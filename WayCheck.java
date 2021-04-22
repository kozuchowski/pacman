import java.util.Arrays;

public class WayCheck {
	static char[][] arr;

	static int counter;
	
	WayCheck(char[][] field, int tempX, int tempY, int gX, int gY){
		arr = new char[field.length][field.length];

	}
	public static boolean wayCheckExecutor(char[][] field,int x, int y, boolean r, boolean l, boolean u, boolean d, char target, int count, char[] directionsArr ) {
		counter = 0;
		arr = new char[field.length][field.length];
		if(way(field, x, y, r, l, u, d, target, count, directionsArr) == false)
			return false;
		return true;
	}
	public static boolean way (char[][] field,  int tempX, int tempY, boolean r, boolean l, boolean u, boolean d, char target, int count, char[] directionsArr) {
		
//		for (int i = 0; i < field.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
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
				if(way(field,  tempX, tempY + 1, r ,l, u, d, target, count, directionsArr)) {
					if(target == 'G') {
						counter++;
						
						if(count > 0) {
							directionsArr[directionsArr.length - counter] = 'r';
						}
					}
					return true;
				}
				
			}
			if(l) {
				if(way(field, tempX, tempY - 1, r, l, u, d, target, count, directionsArr)) {
					if(target == 'G') {
						counter++;
						if(count > 0) {
							directionsArr[directionsArr.length - counter] = 'l';
						}
					}
					return true;
				}
				
			}
			if(d) {
				if(way(field, tempX + 1, tempY, r, l, u, d, target, count, directionsArr)) {
					if(target == 'G') {
						counter++;
						if(count > 0) {
							directionsArr[directionsArr.length - counter] = 'd';
						}
					}
					return true;
				}
			}
			if(u) {
				if(way(field,  tempX - 1, tempY, r, l ,u, d, target, count, directionsArr)) {
					if(target == 'G') {
						counter++;
						
						if(count > 0) {
							directionsArr[directionsArr.length - counter] = 'u';
							
						}
					}
					return true;
				}
			}
			
			
			 return false;
	
	}
	int counter() {
		return counter;
	}
	int [] ghostMove (char[][] field,char[] directionsArr, int x, int y){
		int arr[] = {x, y};
		if(directionsArr[0] == 'r') {
			arr[1] = y + 1;
		}
		if(directionsArr[0] == 'l') {
			arr[1] = y - 1;
		}
		if(directionsArr[0] == 'd') {
			arr[0] = x + 1;
		}
		if(directionsArr[0] == 'u') {
			arr[0] = x - 1;
		}
		
		return arr;
	}
	
}

