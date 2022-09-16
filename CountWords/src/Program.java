import java.util.Scanner;
import java.util.StringJoiner;

public class Program
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String");
        String str  = sc.nextLine();

        String result  = UserProgramCode.getWordsCount(str);

        System.out.println(result);


    }

}
