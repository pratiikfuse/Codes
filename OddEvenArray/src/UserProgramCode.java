public class UserProgramCode
{
    public static int[] oddEvenSort(int[] arr)
    {
        int i = 0;
        int countOdd = 0;
        int countEven = 0;

        for(i = 0;i<arr.length;i++)
        {
            if(arr[i]%2 == 0)
            {
                countEven++;
            }
            else
            {
                countOdd++;
            }
        }

        int Brr[] = new int[arr.length];

        int oddIndex = arr.length -  countOdd;

        int j = 0;
        int k = 0;

        for(k = 0,i=0,j=oddIndex;k<arr.length||j<arr.length||i<countEven;k++)
        {
            if(arr[k]%2 == 0)
            {
                Brr[i] = arr[k];
                i++;
            }
            else
            {
                Brr[j] = arr[k];
                j++;
            }
        }
        return Brr;
    }
}
