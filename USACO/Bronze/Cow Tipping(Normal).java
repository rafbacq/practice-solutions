//USACO 2017 January Contest, Bronze
//Problem 3. Cow Tipping (Normal)
//Java Solution

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("cowtip.in"));
        PrintWriter pw = new PrintWriter (new BufferedWriter(new FileWriter("cowtip.out")));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer("");
        int [][] cows = new int[N][N];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(reader.readLine().replaceAll("", " ").trim());
            for(int j=0; j<N; j++)
            {
                cows[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        int steps=0;
        for(int i=cows.length-1; i>=0; i--)
        {
            for(int j=cows.length-1; j>=0; j--)
            {
                if(cows[i][j]==1)
                {
                    steps++;
                    fillIn(cows, i, j);
                }
            }
        }
        pw.println(steps);
        pw.close();
    }
    public static int [][] fillIn (int [][] arr, int x, int y)
    {
        for(int i=0; i<=x; i++)
        {
            for(int j=0; j<=y; j++)
            {
                if(arr[i][j]==0)
                {
                    arr[i][j]=1;

                }
                else
                {
                    arr[i][j]=0;
                }


            }
        }
        return arr;

    }
}
