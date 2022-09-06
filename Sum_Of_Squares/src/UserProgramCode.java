
public class UserProgramCode 
{
	public static int sumSquare(int num)
	{
		if(num<0)
		{
			return -1;
		}
		int SquareSum = 0;
		int i = 0;
		
		for(i = 1;i<=num;i++)
		{
			SquareSum += (i*i);
		}
		
		return SquareSum;
	}
}
