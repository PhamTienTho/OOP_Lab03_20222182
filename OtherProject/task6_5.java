import java.util.Scanner;
public class task6_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++)
		{
			a[i] = scanner.nextInt();
		}
		for(int i=n-1; i>0; i--)
		{
			for(int j=0; j<i; j++)
			{
				if(a[j] > a[j+1])
				{
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp; 
				}
			}
		}
		for(int i=0; i<n; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.exit(0);
	}
}
