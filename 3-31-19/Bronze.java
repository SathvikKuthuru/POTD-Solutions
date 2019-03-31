import java.util.Scanner;

public class Arnold {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		outer:
		while(n-->0) {
			String a = scan.next();
			String b = scan.next();
			int[] aa = new int[26];
			int[] bb = new int[26];
			for(int i = 0; i < a.length(); i++) aa[a.charAt(i)-'a']++;
			for(int i = 0; i < b.length(); i++) bb[b.charAt(i)-'a']++;
			for(int i = 0; i < b.length(); i++) {
				int c = b.charAt(i) - 'a';
				if(aa[c] < bb[c]) {
					System.out.println("no");
					continue outer;
				}
			}
			System.out.println("yes");
		}
	}

}
