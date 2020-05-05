import java.util.Scanner;

public class TowerOfHanoi {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		TowerOfHanoi(n, "src", "dest", "helper");

	}

	private static void TowerOfHanoi(int n, String src, String dest, String helper) {
		if (n == 0) {
			return;
		}
		TowerOfHanoi(n - 1, src, helper, dest);
		System.out.println("Move " + n + "th disk from " + src + " to " + dest);
		TowerOfHanoi(n - 1, helper, dest, src);

	}

}
