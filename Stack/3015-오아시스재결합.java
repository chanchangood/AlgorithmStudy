import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			int n = Integer.parseInt(br.readLine());
			int[] heights = new int[n];
			for (int i = 0; i < n; i++) {
				heights[i] = Integer.parseInt(br.readLine());
			}
			Deque<Integer> stack = new ArrayDeque<>(); //TODO 결국 객체를 넣어서 중복 상황에 대해 누적합 처리를 해줘야한다.
			long ans = 0;

			for (int i = 0; i < n; i++) {
				while (!stack.isEmpty() && stack.peek() < heights[i]) { //heights[i] 왼쪽에 있는 쌍들 계산
					System.out.println(heights[i] + "왼: " + stack.peek() + "-" + heights[i]);
					stack.pop();
					ans++;
				}
				if (!stack.isEmpty() && stack.peek() >= heights[i]) { //stack.peek() 오른쪽에 있는 쌍들 계산
					ans++;
					System.out.println(stack.peek() + "오: " + stack.peek() + "-" + heights[i]);
				}

				stack.push(heights[i]);
			}

			bw.write(ans + "");

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//7
	// 2
	// 4
	// 1
	// 2
	// 2
	// 5
	// 1

	// 2-4, 4-1, 4-2, 4-2, 4-5, 1-2, 2-2, 2-5, 2-5, 5-1

	// 같은 수가 연달아 나올때 문제가 발생.. 이 방법이 아닌가보다

	public static void solution2() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			int n = Integer.parseInt(br.readLine());
			int[] heights = new int[n];
			for (int i = 0; i < n; i++) {
				heights[i] = Integer.parseInt(br.readLine());
			}
			Deque<Integer> stack = new ArrayDeque<>();
			long ans = 0;

			for (int i = 0; i < n; i++) {
				while (!stack.isEmpty() && stack.peek() < heights[i]) { //heights[i] 왼쪽에 있는 쌍들 계산
					System.out.println(heights[i] + "왼: " + stack.peek() + "-" + heights[i]);
					stack.pop();
					ans++;
				}
				if (!stack.isEmpty() && stack.peek() >= heights[i]) { //stack.peek() 오른쪽에 있는 쌍들 계산
					ans++;
					System.out.println(stack.peek() + "오: " + stack.peek() + "-" + heights[i]);
				}

				stack.push(heights[i]);
			}

			bw.write(ans + "");

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}