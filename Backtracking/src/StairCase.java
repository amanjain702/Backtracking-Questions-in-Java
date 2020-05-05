import java.util.Scanner;

public class StairCase {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(stair(n));
	}

	public static int stair(int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		int ans = 0;
		ans = stair(n - 1) + stair(n - 2) + stair(n - 3);

		return ans;
	}

}
