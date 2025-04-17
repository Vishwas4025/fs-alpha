// Naresh is working on expression of words.
// If you give him an expression like, [p,q,r]s[t,u],
// Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
// Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

// Naresh will be given an expression as a string EXP, like the above format.
// He needs to return all words that can be formed in like mentioned above, 
// Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

// NOTE: 
// Expression consist of lowercase alphabets, comma, and square brackets only.

// Input Format:
// -------------
// A string EXP, expression.

// Output Format:
// --------------
// Print list of words, formed from the expression.


// Sample Input-1:
// ---------------
// [b]c[e,g]k

// Sample Output-1:
// ----------------
// [bcek, bcgk]


// Sample Input-2:
// ---------------
// [a,b][c,d]

// Sample Output-2:
// ----------------
// [ac, ad, bc, bd]


// Sample Input-3:
// ---------------
// [xyz]a[b,c]

// Sample Output-3:
// ----------------
// [xyzab, xyzac]



import java.util.*;

public class day27program2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<List<String>> al = split(s);
        // System.out.println(al);
        
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        btrack(al, 0,sb, result);
        System.out.println(result);
    }
    
    public static void btrack(List<List<String>> al, int ind, StringBuilder sb, List<String> result){
        if(ind >= al.size()){
            result.add(sb.toString());
            return;
        }
        for(int i=0; i<al.get(ind).size(); i++ ){
            int len = sb.length();
            sb.append(al.get(ind).get(i));
            btrack(al, ind+1,sb, result);
            // sb.deleteCharAt(sb.length()-1); // fails when it appends string instead of single character. so use setLength()
            sb.setLength(len);
        }
    }
    
    public static List<List<String>> split(String s){
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        int j=0;
        if(s.charAt(0)=='['){
            j=1;
        }
        for(int i=j; i<s.length(); i++){
            char c = s.charAt(i);
            if(c!='[' && c!=']'){
                sb.append(c);
            }
            else if(c=='[' || c==']'){
                if(sb.length()!=0){
                    list.add(sb.toString());
                }
                
                sb.setLength(0);
            }
        }
        if(sb.length()!=0){
            list.add(sb.toString());
        }
        
        List<List<String>> al = new ArrayList<>();
        for(String seq : list){
            String[] sub = seq.split(",");
            al.add(Arrays.asList(sub));
        }

        al.removeIf(List::isEmpty);
        return al;
    }
}