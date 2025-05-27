/*
public Indus Infra Ltd purchased a land of size L * W acres, for their upcoming venture.
The land is divided into rectangular plots, using fences. They have kept some 
H horizontal fences as hfences[] and V vertical fences as vfences[] on the land,
where hfence[i] is the distance from the top of the land to the i-th horizontal
fence and, vfence[j] is the distance from the top of the land to the j-th 
vertical fence. Each 1*1 cell is one acre plot.

Mr.RGV wants to purchase the biggest plot available to build a Guest-house.
Your task is to help Mr.RGV to find the biggest plot vailable after the fences 
are setup in the venture.
NOTE: The answer can be a large number, return the modulo of 10^9 + 7.

Input Format:
-------------
Line-1: 4 space separated integers, L,W,H and V
Line-2: H space separated integers, hfence[] in the range [0, L]
Line-3: V space sepaarted integers, vfence[] in the range [0, W]

Output Format:
--------------
Print an integer result, the area of biggest plot.


Sample Input-1:
---------------
5 6 2 2
2 3
2 5

Sample Output-1:
----------------
6


Sample Input-2:
---------------
5 6 1 1
3
4

Sample Output-2:
----------------
12
*/


import java.util.*;

public class day47program2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int l=sc.nextInt();
        int w=sc.nextInt();
        int h=sc.nextInt();
        int v=sc.nextInt();
        int[] hfence = new int[h];
        int[] vfence = new int[v];
        
        for(int i=0; i<h; i++){
            hfence[i]=sc.nextInt();
        }
        for(int i=0; i<v; i++){
            vfence[i]=sc.nextInt();
        }
        Arrays.sort(hfence);
        Arrays.sort(vfence);
        
        int currLen=0;
        int maxLen=0;
        for(int i=0; i<h; i++){
            maxLen=Math.max(maxLen, hfence[i]-currLen);
            currLen=hfence[i];
        }
        maxLen=Math.max(maxLen, l-currLen);
        
        int currWid=0;
        int maxWid=0;
        for(int i=0; i<v; i++){
            maxWid=Math.max(maxWid, vfence[i]-currWid);
            currWid=vfence[i];
        }
        maxWid=Math.max(maxWid, w-currWid);
        
        long maxArea=maxLen*maxWid;
        int mod=1_000_000_007;
        System.out.print(maxArea%mod);
    }
}




// import java.util.*;

// public class program{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         long l=sc.nextInt();
//         long w=sc.nextInt();
//         int h=sc.nextInt();
//         int v=sc.nextInt();
//         int[] hfence = new int[h];
//         int[] vfence = new int[v];
        
//         for(int i=0; i<h; i++){
//             hfence[i]=sc.nextInt();
//         }
//         for(int i=0; i<v; i++){
//             vfence[i]=sc.nextInt();
//         }
//         Arrays.sort(hfence);
//         Arrays.sort(vfence);
        
//         List<Long> len = new ArrayList<>();
//         long currLen=0;
//         for(int i=0; i<h; i++){
//             len.add(hfence[i]-currLen);
//             currLen=hfence[i];
//         }
//         len.add(l-hfence[h-1]);
        
//         List<Long> wid = new ArrayList<>();
//         long currWid=0;
//         for(int i=0; i<v; i++){
//             wid.add(vfence[i]-currWid);
//             currWid=vfence[i];
//         }
//         wid.add(w-vfence[v-1]);
        
//         long maxArea=0;
//         int mod=1_000_000_007;
//         for(long p:len){
//             for(long q:wid){
//                 maxArea= Math.max(maxArea, (p*q)%mod);
//             }
//         }
        
//         System.out.print(maxArea);
//     }
// }






        

