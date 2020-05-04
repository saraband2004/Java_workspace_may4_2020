import java.util.Arrays;

public class Board {
	int M;
	int N;
	int K;
	char[][] brd;
	public Board(int M, int N, int K) {
		this.M = M;
		this.N = N;
		this.K = K;
		brd = new char[M][N];
		for (int i = 0; i < M; i ++ ) {
			for (int j = 0; j < N; j ++ ) {
				brd[i][j] = 's';
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < M ; i ++ ) {
			System.out.println(Arrays.toString(brd[i]));
		}		
	}
}
