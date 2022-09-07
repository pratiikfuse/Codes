import java.util.*;
import java.util.stream.*;
class Program
{
    public static void main(String args[])
    {
        Scanner sc   = new Scanner(System.in);

        System.out.println("Enter size of list");
        int size = sc.nextInt();

        List<Integer> ls  = new ArrayList<Integer>();

        System.out.println("Enter elements");
        int  i = 0;

        for(i=0;i<size;i++)
        {
            ls.add(i,sc.nextInt());
        }

        System.out.println("Enter number ");
        int num = sc.nextInt();

        List<Integer> resultList = UserProgramCode.GetElements(ls,num);

        if(resultList.get(0) == -1 && resultList.size() == 1)
        {
            System.out.println("No Such Elements Found");
        }
        else
        {
            System.out.println("Numbers greater than given number are : ");
            for(Integer n : resultList)
            {
                System.out.print(n+" ");
            }
        }
        System.out.println();
    }
}

class UserProgramCode
{
    public static List<Integer>  GetElements(List<Integer>ls,int num)
    {
        List<Integer> result  = new ArrayList<Integer>();

        for(Integer n : ls)
        {
            if(n>num)
            {
                result.add(n);
            }
        }

        if(result.size() == 0)
        {
            result.add(-1);
        }

        List<Integer> sortedResult = result.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        return sortedResult;


    }
}