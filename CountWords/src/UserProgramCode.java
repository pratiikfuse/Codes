import java.util.*;
public class UserProgramCode
{
    public static String getWordsCount(String str)
    {
        String s = str.trim();

        String[] stringArray =    s.split("\\s");

        HashMap<String,Byte> hMap = new HashMap<String,Byte>();
         byte i = 0;
         byte count  = 0;

         String word;

         for(i = 0;i<stringArray.length;i++)
         {
             word = stringArray[i].toLowerCase();

             if(hMap.containsKey(word))
             {
                count = hMap.get(word);
                count++;
                hMap.put(word,count);
             }
             else
             {
                 hMap.put(word,(byte)1);
             }
         }

         StringJoiner sj = new StringJoiner(",","[","]");

         Set<String> keys = hMap.keySet();

         for(String key : keys)
         {
             sj.add(key+"="+hMap.get(key));
         }

         return sj.toString();
    }
}
