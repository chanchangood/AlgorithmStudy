import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 100000;
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

			int[] dist = new int[MAX + 1];
			int[] parent = new int[MAX + 1];
			boolean[] visited = new boolean[MAX + 1];
			Arrays.fill(parent, -1);

			bfs(n, k, dist, parent, visited);

			// 경로 복원
			Deque<Integer> path = new ArrayDeque<>();
			for (int cur = k; cur != -1; cur = parent[cur]) {
				path.push(cur);
				if (cur == n) break;
			}

			StringBuilder sb = new StringBuilder();
			sb.append(dist[k]).append('\n');
			while (!path.isEmpty()) sb.append(path.pop()).append(' ');
			bw.write(sb.toString().trim());
			bw.flush();

			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	static void bfs(int start, int target, int[] dist, int[] parent, boolean[] visited) {
		Deque<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == target) return;

			int[] nexts = {cur - 1, cur + 1, cur * 2};
			for (int nx : nexts) {
				if (nx < 0 || nx > MAX || visited[nx]) continue;
				visited[nx] = true;
				dist[nx] = dist[cur] + 1;
				parent[nx] = cur;
				q.add(nx);
			}
		}
	}
}