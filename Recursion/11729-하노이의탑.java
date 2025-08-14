import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int a = 1, b = 2, c = 3;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			// 1 <= n <= 20
			n = Integer.parseInt(br.readLine());

			long ans = (1L << n) - 1; // 2의 n승 - 1;
			bw.write(ans + "\n");

			recursion(n, a, b, c);
			bw.write(sb.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void recursion (int n, int from, int via, int to) {
		if (n == 0) return;
		recursion(n - 1, from, to, via); // 1번 재귀
		sb.append(from).append(' ').append(to).append('\n'); // 가장 큰 원판 이동
		recursion(n - 1, via, from, to); // 2번 재귀
	}

	// 재귀 진짜 존나 어렵다!

	// n = 3
	// |  # | 깊이| 호출 (n, from, via, to)| 출력(from to)| 디스크(원판번호)|
	// |  1 |  3 | (1, 1, 2, 3)          | 1 3         |   1 | s - 1 - 1
	// |  2 |  2 | (2, 1, 3, 2)          | 1 2         |   2 | s - 1
	// |  3 |  3 | (1, 3, 1, 2)          | 3 2         |   1 | s - 1 - 2
	// |  4 |  1 | (3, 1, 2, 3)          | 1 3         |   3 | s
	// |  5 |  3 | (1, 2, 3, 1)          | 2 1         |   1 | s - 2 - 1
	// |  6 |  2 | (2, 2, 1, 3)          | 2 3         |   2 | s - 2
	// |  7 |  3 | (1, 1, 2, 3)          | 1 3         |   1 | s - 2 - 2

	// n = 5
	// |  # | 깊이| 호출 (n, from, via, to)| 출력(from to)| 디스크|
	// |  1 |  5 | (1, 1, 2, 3)          | 1 3         |   1 | s - 1 - 1 - 1 - 1
	// |  2 |  4 | (2, 1, 3, 2)          | 1 2         |   2 | s - 1 - 1 - 1
	// |  3 |  5 | (1, 3, 1, 2)          | 3 2         |   1 | s - 1 - 1 - 1 - 2
	// |  4 |  3 | (3, 1, 2, 3)          | 1 3         |   3 | s - 1 - 1
	// |  5 |  5 | (1, 2, 3, 1)          | 2 1         |   1 | s - 1 - 1 - 2 - 1
	// |  6 |  4 | (2, 2, 1, 3)          | 2 3         |   2 | s - 1 - 1 - 2
	// |  7 |  5 | (1, 1, 2, 3)          | 1 3         |   1 | s - 1 - 1 - 2 - 2
	// |  8 |  2 | (4, 1, 3, 2)          | 1 2         |   4 | s - 1
	// |  9 |  5 | (1, 3, 1, 2)          | 3 2         |   1 | s - 1 - 2 - 1 - 1
	// | 10 |  4 | (2, 3, 2, 1)          | 3 1         |   2 | s - 1 - 2 - 1
	// | 11 |  5 | (1, 2, 3, 1)          | 2 1         |   1 | s - 1 - 2 - 1 - 2
	// | 12 |  3 | (3, 3, 1, 2)          | 3 2         |   3 | s - 1 - 2
	// | 13 |  5 | (1, 1, 2, 3)          | 1 3         |   1 | s - 1 - 2 - 2 - 1
	// | 14 |  4 | (2, 1, 3, 2)          | 1 2         |   2 | s - 1 - 2 - 2
	// | 15 |  5 | (1, 3, 1, 2)          | 3 2         |   1 | s - 1 - 2 - 2 - 2
	// | 16 |  1 | (5, 1, 2, 3)          | 1 3         |   5 | s
	// | 17 |  5 | (1, 2, 3, 1)          | 2 1         |   1 | s - 2 - 1 - 1 - 1
	// | 18 |  4 | (2, 2, 1, 3)          | 2 3         |   2 | s - 2 - 1 - 1
	// | 19 |  5 | (1, 1, 2, 3)          | 1 3         |   1 | s - 2 - 1 - 1 - 2
	// | 20 |  3 | (3, 2, 3, 1)          | 2 1         |   3 | s - 2 - 1
	// | 21 |  5 | (1, 3, 1, 2)          | 3 2         |   1 | s - 2 - 1 - 2 - 1
	// | 22 |  4 | (2, 3, 2, 1)          | 3 1         |   2 | s - 2 - 1 - 2
	// | 23 |  5 | (1, 2, 3, 1)          | 2 1         |   1 | s - 2 - 1 - 2 - 2
	// | 24 |  2 | (4, 2, 1, 3)          | 2 3         |   4 | s - 2
	// | 25 |  5 | (1, 1, 2, 3)          | 1 3         |   1 | s - 2 - 2 - 1 - 1
	// | 26 |  4 | (2, 1, 3, 2)          | 1 2         |   2 | s - 2 - 2 - 1
	// | 27 |  5 | (1, 3, 1, 2)          | 3 2         |   1 | s - 2 - 2 - 1 - 2
	// | 28 |  3 | (3, 1, 2, 3)          | 1 3         |   3 | s - 2 - 2
	// | 29 |  5 | (1, 2, 3, 1)          | 2 1         |   1 | s - 2 - 2 - 2 - 1
	// | 30 |  4 | (2, 2, 1, 3)          | 2 3         |   2 | s - 2 - 2 - 2
	// | 31 |  5 | (1, 1, 2, 3)          | 1 3         |   1 | s - 2 - 2 - 2 - 2
}
