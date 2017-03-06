https://www.hackerrank.com/challenges/countingsort3

import java.util.Scanner;


public class CountingSort3 {

       public static void main(String[] args) {
              
              Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         int numberCount[] = new int[100];
        
        for(int i=0;i<=n;i++)
        {
              String[] words =sc.nextLine().split(" ");
              if(!words[0].equals(""))
              {
            int number = Integer.parseInt(words[0]);
            numberCount[number]+=1;
              }
        }
        int sum=0;
        for(int i=0;i<numberCount.length;i++)
        {
            sum=0;
            for(int j=0;j<=i;j++)
               sum+=numberCount[j];
           
            System.out.print(sum+" ");
        }
        sc.close();

       }

}
