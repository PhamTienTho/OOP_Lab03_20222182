import java.util.Scanner;
public class task6_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int thang, nam;
		while(true)
		{
			System.out.println("Nhap thang:");
			thang = scanner.nextInt();
			System.out.println("Nhap nam:");
			nam = scanner.nextInt();
			if(thang <= 12 && thang >=1) break;
			System.out.println("Khong hop le!");
		}
		int date1[] = new int[13];
		date1[1] = 31;
		date1[2] = 28;
		date1[3] = 31;
		date1[4] = 30;
		date1[5] = 31;
		date1[6] = 30;
		date1[7] = 31;
		date1[8] = 31;
		date1[9] = 30;
		date1[10] = 31;
		date1[11] = 30;
		date1[12] = 31;
		
		int date2[] = new int[13];
		
		date2[1] = 31;
		date2[2] = 29;
		date2[3] = 31;
		date2[4] = 30;
		date2[5] = 31;
		date2[6] = 30;
		date2[7] = 31;
		date2[8] = 31;
		date2[9] = 30;
		date2[10] = 31;
		date2[11] = 30;
		date2[12] = 31;
		
		if(nam%4 != 0 || (nam%100 == 0 && nam%400 != 0))
		{
			System.out.println("so ngay trong thang la: " + date1[thang]);
		}
		else System.out.println("so ngay trong thang la: " + date2[thang]);
		System.exit(0);
	}
}