
import java.util.Scanner;

public class Programs {

	public static void main(String[] args) 
	{
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("Enter Number");
		int num = sc.nextInt();
		
		int Result = UserProgramCode.sumSquare(num);
		
		if(Result == -1)
		{
			System.out.println("Negative number not allowed");
		}
		else
		{
			System.out.println("Sum of Squares upto given number is : "+Result);
		}
		
	}

}
