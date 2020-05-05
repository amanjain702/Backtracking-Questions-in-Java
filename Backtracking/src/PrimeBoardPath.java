import java.util.Scanner;

public class PrimeBoardPath {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		boolean[] primes = new boolean[n + 1];
		for (int i = 2; i < primes.length; i++) {
			if (prime(i)) {
				primes[i] = true;
			}
		}
		int[] ladder = makeladder(primes);
		bp(ladder, n, 0, "");

	}

	public static void bp(int[] ladders, int end, int curr, String res) {
		if (end == curr) {
			System.out.println(res + "END");
			return;
		}

		if (curr > end) {
			return;
		}

		if (ladders[curr] != 0 && curr < ladders[curr]) {
			bp(ladders, end, ladders[curr], res + ladders[curr]);
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				bp(ladders, end, curr + dice, res + dice);
			}
		}

	}

	public static int[] makeladder(boolean[] primes) {
		int[] ladder = new int[primes.length+1];
		int i = 0;
		int j = primes.length - 1;
		while (i < j) {
			while (primes[i] != true) {
				i++;

			}
			while (primes[j] != true) {
				j--;
			}
			ladder[i] = j;
			ladder[j] = i;
			i++;
			j--;
		}
		return ladder;
	}

	public static boolean prime(int n) {
		int i = 2;
		while (i < n) {
			if (n % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}

}
