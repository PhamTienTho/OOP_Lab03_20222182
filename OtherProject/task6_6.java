import java.util.Scanner;
public class task6_6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap n va m");
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int a[][] = new int[n][m];
		int b[][] = new int[n][m];
		int c[][] = new int[n][m];
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				a[i][j] = scanner.nextInt();
			}
		}
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				b[i][j] = scanner.nextInt();
			}
		}
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		System.out.println("Ma tran c:");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
}
