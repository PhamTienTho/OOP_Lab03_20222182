import java.util.Scanner;
public class task226 {
	public static void main(String[] args) {
		double a1, b1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap a va b cho phuong trinh bac nhat: ");
		a1 = scanner.nextDouble();
		b1 = scanner.nextDouble();
		if(a1 == 0) 
		{
			System.out.println("Phuong trinh vo nghiem!");
		}
		else
		{
			double x1 = -b1/a1;
			System.out.println("Nghiem cua phuong trinh la: " + x1);
		}
		double a2, b2, c2;
		System.out.println("Nhap a, b va c cho phuong trinh bac nhat: ");
		a2 = scanner.nextDouble();
		b2 = scanner.nextDouble();
		c2 = scanner.nextDouble();
		if(a2 == 0 && b2 == 0 && c2!=0)
		{
			System.out.println("Phuong trinh vo nghiem");
		}
		else if(a2 == 0 && b2 == 0 && c2 == 0)
		{
			System.out.println("Phuong trinh vo so nghiem");
		}
		else if(a2 == 0 && b2 != 0)
		{
			System.out.println("phuong trinh co nghiem duy nhat: " + -c2/b2);
		}
		else if(a2 != 0)
		{
			double delta = b2*b2 - 4*a2*c2;
			if(delta < 0 )
			{
				System.out.println("phuong trinh vo nghiem");
			}
			else if(delta == 0)
			{
				double x2 = -b2/(2*a2);
				System.out.println("phuong trinh co nghiem duy nhat: " + x2);
			}
			else if(delta > 0)
			{
				double x3 = (-b2 + Math.sqrt(delta)) / (2 * a2);
				double x4 = (-b2 - Math.sqrt(delta)) / (2 * a2);
				System.out.println("2 nghiem cua phuong trinh la " + x3 + " " + x4);
			}
		}
		System.exit(0);
	}
}
