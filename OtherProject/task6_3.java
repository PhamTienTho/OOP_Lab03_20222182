import java.util.Scanner;
public class task6_3 {
	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap n:");
		n = scanner.nextInt();
		int m;
		if(n%2 == 1)
		{
			m = (n+1)/2;
		}
		else m = n/2  ;
		while(m >= 0)
		{
			for(int i=1; i<=m; i++)
			{
				System.out.print(" ");
			}
			for(int i=1; i<=n-2*m; i++)
			{
				System.out.print("*");
			}
			System.out.println();
			m--;
		}
	}
}
