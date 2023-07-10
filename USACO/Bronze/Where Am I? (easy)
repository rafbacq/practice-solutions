//USACO 2019 December Contest, Bronze
//Problem 2. Where Am I? (easy)
//Java solution

import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter pw = new PrintWriter (new BufferedWriter(new FileWriter("whereami.out")));
        int a = Integer.parseInt(reader.readLine());
        String lol = reader.readLine();

        for(int counter=1;; counter++)
        {
            boolean con=true;
            List <String> arrList= new ArrayList<>();
            for(int i=0; i<=a-counter; i++)
            {
                String substring = lol.substring(i, i + counter);
                if(arrList.contains(substring))
                {
                    con=false;
                    break;
                }
                else
                {
                    arrList.add(substring);
                }
            }
            if(con)
            {
                pw.println(counter);
                pw.close();
                break;
                
            }
        }






    }
}
