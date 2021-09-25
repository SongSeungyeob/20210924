package person;
import java.util.Scanner;

public class Scanutil 
{
	static Scanner Sc = new Scanner(System.in);
	public static int readInt(String msg) {
		System.out.print(msg);
		int Num = Sc.nextInt();
		Sc.nextLine();
		return Num;
	}
	
	public static String readStr(String msg) {
		System.out.print(msg);
		return Sc.nextLine();
	}
}