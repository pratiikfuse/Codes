import java.util.*;

public class Program
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter elenents");

        int i = 0;

        for(i = 0;i<size;i++)
        {
            arr[i] = sc.nextInt();
        }

        int[] resultArray = UserProgramCode.oddEvenSort(arr);

        System.out.println("Array after sorting even elements and odd elements : ");
        for(int n : resultArray)
        {
            System.out.println(n);4
        }
    }

}
