import java.util.*;
class Program
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String");
        String s  = sc.nextLine();

        

        int Result = UserProgramCode.getCount(s);

        

        if(Result != -1)
        {
            System.out.println("Special Character Count : "+Result);

            String sResult  = UserProgramCode.getString(s);

            System.out.println("String without special Characters : "+sResult);
        }
        else
        {
            System.out.println("String has no special character");
        }

    }
}


class UserProgramCode
{
    
    public static int getCount(String s)
    {
        int i = 0;
        int Count  = 0;

        for(i = 0;i<s.length();i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i) <= 'z' || s.charAt(i)>='A' && s.charAt(i)<='Z' || s.charAt(i)>='0' && s.charAt(i)<='9' || s.charAt(i) == ' ')
            {
                continue;
            }
            else
            {
                Count++;
            }
        }

        if(Count == 0)
        {
            return -1;
        }

        return Count;
    }

    public static String getString(String s)
    {
        int i = 0;
        int Count  = 0;
        String onlyCharacter =  "\0";
        for(i = 0;i<s.length();i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i) <= 'z' || s.charAt(i)>='A' && s.charAt(i)<='Z' || s.charAt(i)>='0' && s.charAt(i)<='9' || s.charAt(i) == ' ')
            {
                onlyCharacter += s.charAt(i);
                continue;
            }
        }

        return onlyCharacter;
        
    }
}
