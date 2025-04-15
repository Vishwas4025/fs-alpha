import java.util.*;
public class day24program5 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();             
        String s2 = sc.nextLine();             
        String[] words = s2.split(" ");        
        if (s1.length() != words.length) 
        {
            System.out.println(false);
            return;
        }
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> usedWords = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) 
        {
            char ch = s1.charAt(i);
            String word = words[i];
            if (map.containsKey(ch)) 
            {
                if (!map.get(ch).equals(word)) 
                {
                    System.out.println(false);
                    return;
                }
            } 
            else 
            {

                if (usedWords.contains(word))
                {
                    System.out.println(false);
                    return;
                }

                map.put(ch, word);
                usedWords.add(word);
            

}
        

}

        System.out.println(true);
    

}

}