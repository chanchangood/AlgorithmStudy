import java.io.*;
import java.util.*;

public class Main {
	static int n, w, l;
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 1 <= n <= 1000 트럭 수
			w = Integer.parseInt(st.nextToken()); // 1 <= w <= 100 다리 길이
			l = Integer.parseInt(st.nextToken()); // 10 <= l <= 1000 최대 하중

			st = new StringTokenizer(br.readLine());
			int[] trucks = new int[n];
			for (int i = 0; i < n; i++) {
				trucks[i] = Integer.parseInt(st.nextToken()); // 트럭 무게 저장
			}

			Deque<Integer> bridge = new ArrayDeque<>();

			int sum = 0;   // 다리 위 총 무게
			int index = 0; // 다음에 올릴 트럭 인덱스
			int count = 0;

			while (index < n) {
				// 다리 위가 가득 차면 한 칸 전진(맨 앞 빠짐)
				if (bridge.size() == w) {
					sum -= bridge.removeFirst();
				}

				int next = trucks[index];

				if (sum + next <= l) { // 다음 트럭 올릴 수 있으면 올림
					bridge.addLast(next);
					sum += next;
					index++;
				} else { // 못 올리면 0으로 채움
					bridge.addLast(0);
				}
				count++;
			}

			// 마지막 트럭 빠지는 시간 더함
			count += w;
			ans = count;

			bw.write(ans+"");
			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}


// 처음에 truck 클래스를 만들어서 했는데 필요없어서 다시 바꿈