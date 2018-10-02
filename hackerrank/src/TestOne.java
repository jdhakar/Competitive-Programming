import java.util.Scanner;

public class TestOne {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int t = 0; t < T; t++) {
			int x = scanner.nextInt();
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			for (int i = l; i <= r; i++) {
				System.out.println(i^x);
			}
		}
	}
}
