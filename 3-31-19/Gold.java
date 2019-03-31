import java.util.Scanner;

public class Sticks {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt();
		int ans = (power(2, n, m) % m) - ((n + 1) % m) - (nCr(n, 2, m) % m);
		if (ans < 0)
			ans = (ans + m) % m;
		System.out.println(ans + " " + nCr(4, 2, m));
	}

	static int nCrModpDP(int n, int r, int p) {
		int[] C = new int[r + 1];

		C[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, r); j > 0; j--)
				C[j] = (C[j] + C[j - 1]) % p;
		}
		return C[r];
	}

	static int nCr(int n, int r, int p) {
		if (r == 0)
			return 1;
		int ni = n % p;
		int ri = r % p;
		return (nCr(n / p, r / p, p) *
				nCrModpDP(ni, ri, p)) % p; 
	}

	static int power(int x, int y, int p) {
		int res = 1;
		x = x % p;
		while (y > 0) {
			if ((y & 1) == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}

}
