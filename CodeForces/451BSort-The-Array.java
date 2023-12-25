//B. Sort the Array
//time limit per test:1 second
//memory limit per test:256 megabytes
//input:standard input
//output:standard output
//java solution

import java.util.*;
import java.io.*;


public class CodeForces {
    public static void main(String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sortedList = new int[n];
        int[] regList = new int[n];
        for(int i=0; i<n; i++)
        {
            int a = Integer.parseInt(st.nextToken());
            sortedList[i]=a;
            regList[i]=a;
        }
        Arrays.sort(sortedList);
        int stIndex=0;
        int endIndex=0;
        for(int i=0; i<n; i++)
        {
            if(regList[i]!=sortedList[i])
            {
                stIndex=i;
                break;
            }
        }
        for(int i=n-1; i>=stIndex; i--)
        {
            if(regList[i]!=sortedList[i])
            {
                endIndex=i;
                break;
            }

        }
        int [] reversedArr = reverseSeg(regList, stIndex, endIndex);
        if(Arrays.equals(reversedArr, sortedList))
        {
            System.out.println("yes");
            System.out.println((stIndex+1) + " " + (endIndex+1));
        }
        else
        {
            System.out.println("no");

        }
    }
    public static int[] reverseSeg(int [] arr, int a, int b)
    {
        List <Integer> reverse = new ArrayList<>();
        for(int i=a; i<=b; i++)
        {
            reverse.add(arr[i]);

        }
        Collections.reverse(reverse);
        for(int i=a; i<=b; i++)
        {
            arr[i]=reverse.get(i-a);
        }
        return arr;

    }
}
