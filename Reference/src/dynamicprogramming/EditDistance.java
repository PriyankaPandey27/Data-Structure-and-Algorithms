
package dynamicprogramming;

import java.util.Arrays;

public class EditDistance {
     public static void main(String[] args) {
    
      char[] s1= "hellooo".toCharArray();
      char[] s2="hello".toCharArray();
      
           System.out.println("\ns1 = "+Arrays.toString(s1));
     System.out.println("s2 = "+Arrays.toString(s2));
      
      solution(s1,s2);

  
    }
     public static void solution(char[] s1,char[] s2)
     {
System.out.println("Minimum number of edits (by using Recusrion)= "+naiveUtil(s1,s2,s1.length-1,s2.length-1));
         
System.out.println("Minimum number of edits (by using DP)= "+DP_Util(s1,s2));         
     }
     
     public static int naiveUtil(char[] s1,char[] s2,int l1,int l2)
     {
         
         if(l1==0 &&  l2==0)
         {
            if(s1[l1]==s2[l2])
                return 0;
            else
                return 1;
         }
         
         if(l1==0 || l2==0)
         {
             if(l1==0)
             {
                 if(s1[l1]==s2[l2])
                     return l2-1;
                 else
                     return l2;

             }
             else
             {
                  if(s1[l1]==s2[l2])
                     return l1-1;
                 else
                     return l1;
 
             }
         }
         
         if(s1[l1]==s2[l2])
         {
             int p1=naiveUtil(s1, s2, l1-1, l2-1);
             int p2=1+Math.min(naiveUtil(s1, s2, l1-1, l2), naiveUtil(s1, s2, l1, l2-1));

             return Math.min(p1, p2);
         }
         else 
         {
            int p1=naiveUtil(s1, s2, l1-1, l2-1)+1;
             int p2=1+Math.min(naiveUtil(s1, s2, l1-1, l2), naiveUtil(s1, s2, l1, l2-1));

             return Math.min(p1, p2);
         }
         
         
     }

     public static int DP_Util(char[] s1,char[] s2)
     {
         int m=s1.length,n=s2.length;
         
         int mt[][]=new int[n][m];
         
         int i,j,diagonal;
         
         for(i=0;i<m;i++)
             mt[0][i]=i;
         
         for(j=0;j<n;j++)
             mt[j][0]=j;
         
         for(i=1;i<n;i++)
         {
             for(j=1;j<m;j++)
             {
                 
                // if(mt[i][j]==mt[i-1][j-1])
                 if(s1[j]==s2[i])
                 {
                     
//                     int left=mt[i-1][j];
//                     int up=mt[i][j-1];
//                      diagonal=mt[i-1][j-1];
                      mt[i][j]=mt[i-1][j-1];
                     //mt[i][j]=Math.min(left, Math.min(up, diagonal));
                 }
                 else
                 {
                     int left=mt[i-1][j];
                     int up=mt[i][j-1];                 
                     diagonal=mt[i-1][j-1];
                     
                     mt[i][j]=Math.min(left, Math.min(up, diagonal))+1;
                 }
                 
                
             }
         }
         
      
         
          
         return mt[i-1][j-1];
     }
     
    
}
