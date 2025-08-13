import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 0 <= n,k <= 100,000
			n = Integer.parseInt(st.nextToken()); // 시작 위치
			k = Integer.parseInt(st.nextToken()); // 목적지



			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	static int bfs(){

	}
}