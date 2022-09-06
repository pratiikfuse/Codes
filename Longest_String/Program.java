import java.util.*;

class Program
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Strings");
        int size  = sc.nextInt();
        sc.nextLine();

        List<String> ls  = new ArrayList<String>();

        int i = 0;

        for(i= 0;i<size;i++)
        {
            ls.add(i,sc.nextLine());
        }

        System.out.println("Enter character you want your string to start with");
        char ch =sc.nextLine().charAt(0);

        String result = UserProgramCode.getLongestString(ls,ch);

        System.out.println(result);



    }
}

class UserProgramCode
{
    public static String getLongestString(List<String>ls,char ch)
    {
        List<String> S  = new ArrayList<String>();

        char[] Arr ;
        int i = 0;
        boolean flag = true;
        char small = '\0';
        char big = '\0';
        if(ch >= 'a' && ch<='z')
        {
            big = (char)(ch-32);
            small = ch;
            
        }
        else if(ch >= 'A' && ch<= 'Z')
        {
            small = (char)(ch+32);
            big = ch;
        }
        
        for(String str : ls )
        {
            
            Arr = str.toCharArray();
            for(i=0;i<Arr.length;i++)
            {
                if(Arr[i]>='a' &&Arr[i]<= 'z' || Arr[i]>= 'A' && Arr[i]<= 'Z')
                {
                    continue;
                }
                else
                {
                    flag = false;
                    break;
                }                
            }
            if(flag == false)
            {
                break;
            }
            if(Arr[0] == small || Arr[0] == big)
            {
                S.add(str);
            }
        }

        if(flag == false)
        {
            return "String should contins only alphabet";
        }

        if(S.size() == 0)
        {
            return "No string found with starting letter "+"'"+ch+"'";
        }

        String longestString = "\0";
        int max = 0;

        for(String s : S)
        {
            if(s.length()>max)
            {
                max  = s.length();
                longestString = s;
            }
        }

        return longestString;
    }
}