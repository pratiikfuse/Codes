import java.util.Scanner;
public class Program
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = -1;
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("\uD83D\uDE4F \uD83D\uDD35 \uD83D\uDD35 \uD83D\uDD35 \uD83D\uDD35" +
                " Welcome to Number conversion Application" +
                " \uD83D\uDD35 \uD83D\uDD35 \uD83D\uDD35 \uD83D\uDD35 \uD83D\uDE4F");

        System.out.println("---------------------------------------------------------------------------");
        while(choice != 0)
        {
            System.out.println("Choose operation to perform");
            System.out.println("1 : Decimal to Binary conversion");
            System.out.println("2 : Binary to Decimal conversion");
            System.out.println("0 : Exit the application");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case(1)->{
                    System.out.println("Enter number");
                    int decimalNumber = sc.nextInt();

                    String result = NumberConversion.decimalToBinary(decimalNumber);

                    if(decimalNumber>=0)
                    {
                        System.out.println("-----------------------------------------------");
                        System.out.println("Binary representation of number "+decimalNumber+" is : "+result);
                        System.out.println("-----------------------------------------------");
                    }
                    else
                    {
                        System.out.println("-----------------------------------------------");
                        System.out.println("Binary representation of number "+ decimalNumber+" using 2's complement is : "+result);
                        System.out.println("-----------------------------------------------");
                    }
                }

                case(2)->{
                    System.out.println("Enter binary representation");
                    String binaryString = sc.nextLine();

                    int decimalNumber = NumberConversion.binaryToDecimal(binaryString);

                    if(decimalNumber == -1)
                    {
                        System.out.println("-----------------------------------------------");
                        System.out.println("binary number should only contains 1's and 0's");
                        System.out.println("-----------------------------------------------");
                    }
                    else
                    {
                        System.out.println("-----------------------------------------------");
                        System.out.println("decimal number of "+binaryString+" is "+decimalNumber);
                        System.out.println("-----------------------------------------------");
                    }
                }

                case(0)->{
                    System.out.println("-----------------------------------------------");
                    System.out.println("Thank you for using the application \uD83D\uDE07");
                    System.out.println("-----------------------------------------------");
                }

                default -> {
                    System.out.println("-----------------------------------------------");
                    System.out.println(" ⛔ wrong option");
                    System.out.println("-----------------------------------------------");
                }
            }
        }
    }
}


class NumberConversion
{
    /////////////////////////////////////////////////////////////////////////////////
    // Method Name : binaryToDecimal
    // declaration : public static int binaryToDecimal(String)
    // Input : String
    // Return : int
    // Description : returns decimal number of given binary string
    //               returns -1 if binaryString is not in valid form
    /////////////////////////////////////////////////////////////////////////////////
    public static int binaryToDecimal(String binaryString)
    {
        String stringNoSpaces = binaryString.replaceAll("\\s","");

        if(stringNoSpaces.length() == 0)
        {
            System.exit(0);
        }

        char[] binaryArray =stringNoSpaces.toCharArray();

        boolean flag = true;

        for(char ch : binaryArray )
        {
            if(ch != '1' && ch!= '0')
            {
                flag = false;
                break;
            }
        }


        if(flag)
        {
            int i = stringNoSpaces.length()-1;
            int j = 0;
            int decimalNumber = 0;

            while(i>=0)
            {
                decimalNumber += Math.pow(2,j)*(Integer.parseInt(binaryArray[i]+""));

                j++;
                i--;

            }
            return decimalNumber;
        }
        else
        {
            return -1;
        }
    }
    /////////////////////////////////////// End of Method /////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////////////
    // Method Name : decimalToBinary
    // declaration : public static String decimalToBinary(int)
    // Input : int
    // Return : String
    // Description : returns binary representation of given decimal number
    /////////////////////////////////////////////////////////////////////////////////
    public static String decimalToBinary(int decimalNumber)
    {
        boolean negativeFlag = false;
        String result ;
        if(decimalNumber<0)
        {
            negativeFlag = true;
            decimalNumber = -decimalNumber;
        }
        int temp = decimalNumber;
        StringBuilder binaryStringBuilder = new StringBuilder();
        int count  = 0;
        while(temp!=0)
        {
            binaryStringBuilder.append(temp%2);
            count++;
            temp = temp/2;
        }

        if(negativeFlag)
        {
            while(count%16 != 0)
            {
                binaryStringBuilder.append(0);
                count++;
            }
            binaryStringBuilder.reverse();
            String binaryString = binaryStringBuilder.toString();
            char[] binaryArray = binaryString.toCharArray();

            int i;

            StringBuilder complimentString = new StringBuilder();

            for(i = 0;i<binaryArray.length;i++)
            {
                complimentString.append(1 ^ (Integer.parseInt(binaryArray[i] + "")));
            }

            char[] complimentArray = complimentString.toString().toCharArray();

            for(i= complimentArray.length -1;i>=0;i--)
            {
                if(((Integer.parseInt(complimentArray[i]+""))^1) == 1)
                {
                    complimentArray[i] = '1';
                    break;
                }
                else
                {
                    complimentArray[i] = '0';
                }

            }



            StringBuilder finalStringBuilder  = new StringBuilder();
            count  = 0;
            for(i=0;i<complimentArray.length;i++,count++)
            {

                if(count%4 == 0)
                {
                    finalStringBuilder.append(" ");
                    finalStringBuilder.append(complimentArray[i]);
                }
                else
                {
                    finalStringBuilder.append(complimentArray[i]);
                }
            }
             result = new String(finalStringBuilder);
        }
        else
        {
            while(count%8 != 0)
            {
                binaryStringBuilder.append(0);
                count++;
            }

            binaryStringBuilder.reverse();

            String binaryString = binaryStringBuilder.toString();
            char[] positiveBinaryArray= binaryString.toCharArray();
            count = 0;
            StringBuilder finalStringBuilder  = new StringBuilder();
            for(int i=0;i<positiveBinaryArray.length;i++,count++)
            {
                if(count%4 == 0)
                {
                    finalStringBuilder.append(" ");
                    finalStringBuilder.append(positiveBinaryArray[i]);
                }
                else
                {
                    finalStringBuilder.append(positiveBinaryArray[i]);
                }
            }

             result   = new String(finalStringBuilder);
        }

        return result;
    }
    /////////////////////////////////////// End Of method ///////////////////////////////////////////
}