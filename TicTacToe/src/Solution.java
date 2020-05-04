import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
	
	public int cpuStrategy(int [] m) {
		for (int i = 0; i<9; i++) {
			if (m[i] == 0) {
				if (cpuPlayNext(m, i) == 1) {
					return i;
				}
			}
		}
		for (int i = 0; i<9; i++) {
			if (m[i] == 0) {
				if (cpuPlayNext(m, i) == 0) {
					return i;
				}
			}
		}
		for (int i = 0; i<9; i++) {
			if (m[i] == 0) {
				return i;
			}
		}
		return 99;
	}
	
	
	public int cpuPlayNext(int[]m, int x) {
		m[x] = 1;
		int result = 1;
		boolean test = false;
		if (whowin(m) == 1) {
			m[x] = 0;
			return 1;}
		else if (whowin(m) == 0) {
			for (int i = 0; i<9 ; i++) {
				if (m[i] == 0) {
					test = true;
					int temp = humanPlayNext(m, i);
					result *= temp;
					if (temp == -1) {
						m[x] = 0;
						return -1;
					}
				}
			}
		}
		m[x] = 0;
		if (!test) return 0;
		return result;
		// 1 for cpu win always
		// -1 for human win always
		// 0 for cpu will never loose
	}
	public int humanPlayNext(int[]m, int x) {
		m[x] = -1;
		int result = -1;
		boolean test = false;
		if (whowin(m) == -1) {
			m[x] = 0;
			return -1;}
		else if (whowin(m) == 0) {
			for (int i = 0; i<9 ; i++) {
				if (m[i] == 0) {
					test = true;
					int temp = cpuPlayNext(m, i);
					if (temp == 0) {result = 0;}
					else if (temp == -1 && result == -1) {}
					else if (temp == 1) {
						m[x] = 0;
						return 1;
					}
				}
			}
		}
		m[x] = 0;
		if (!test) return 0;
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
		System.out.println("Hello JAVA");
		Solution s = new Solution();
		int[]m = {0,0,0,
				  0,-1,0,
				  0,0,0};
		System.out.println(s.cpuPlayNext(m, 7));
		
		
	}

	public int whowin( int[]matrix) {
        int x = 1;
        if (matrix[0] == x && matrix[1] == x && matrix[2] == x ) {
            return x;
        }
        if (matrix[3] == x && matrix[4] == x && matrix[5] == x ) {
            return x;
        }
        if (matrix[6] == x && matrix[7] == x && matrix[8] == x ) {
            return x;
        }
        if (matrix[0] == x && matrix[4] == x && matrix[8] == x ) {
            return x;
        }
        if (matrix[2] == x && matrix[4] == x && matrix[6] == x ) {
            return x;
        }
        if (matrix[0] == x && matrix[3] == x && matrix[6] == x ) {
            return x;
        }
        if (matrix[1] == x && matrix[4] == x && matrix[7] == x ) {
            return x;
        }
        if (matrix[2] == x && matrix[5] == x && matrix[8] == x ) {
            return x;
        }
        
        x = -1;
        
        if (matrix[0] == x && matrix[1] == x && matrix[2] == x ) {
            return x;
        }
        if (matrix[3] == x && matrix[4] == x && matrix[5] == x ) {
            return x;
        }
        if (matrix[6] == x && matrix[7] == x && matrix[8] == x ) {
            return x;
        }
        if (matrix[0] == x && matrix[4] == x && matrix[8] == x ) {
            return x;
        }
        if (matrix[2] == x && matrix[4] == x && matrix[6] == x ) {
            return x;
        }
        if (matrix[0] == x && matrix[3] == x && matrix[6] == x ) {
            return x;
        }
        if (matrix[1] == x && matrix[4] == x && matrix[7] == x ) {
            return x;
        }
        if (matrix[2] == x && matrix[5] == x && matrix[8] == x ) {
            return x;
        }
        
        
        return 0;
    }

	
	
}
