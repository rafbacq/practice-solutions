/*
3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without duplicate characters.
*/
//Did in java cuz c++ hard <:(
//Complexity: 20.92| Memory: 24.18
import java.util.*;
import java.io.*;
public class ga{
    public static void main(String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int l=0;
        int r=1;
        int result=1;
        while(r < s.length())
        {
            String subs = s.substring(l,r);
            char current = s.charAt(r);
            if(!subs.contains(current + ""))
            {
                r++;

            }
            else{
                l++;
            }
            result = Math.max(result, r-l);


            System.out.println(subs + " " + result);
        }
        System.out.println(result);

    }
}
