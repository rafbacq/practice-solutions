import java.util.*;
import java.io.*;

public class day4_1_2023 {
    String content;
    int total=0;
    public day4_1_2023() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("day4.txt"));
        content = br.readLine();
        content=br.readLine();
        int length1=6;
        int length2=8;
        int [] winning = new int [length1];
        int [] elfPick = new int[length2];

        while(content!=null)
        {
            int starting1 = content.indexOf(":")+1;
            int starting2=content.indexOf("|")+1;
            String current="";
            for(int i=starting1; i<starting2; i++)
            {
                while(Character.isDigit(content.charAt(i)))
                {
                    current+=content.charAt(i);
                    starting1++;
                }
                winning[i]= Integer.parseInt(current);
                current="";
            }

            for(int i=starting2; i<content.length(); i++)
            {
                while(Character.isDigit(content.charAt(i)))
                {
                    current+=content.charAt(i);
                    starting1++;
                }
                starting1++;
                elfPick[i] = Integer.parseInt(current);
                current="";
            }
            int numCorrectValue=0;

            for(int i:winning)
            {
                for(int j=0; j<length2; j++)
                {
                    if(elfPick[j]==i)
                    {
                        if(numCorrectValue==0)
                            numCorrectValue++;
                        else
                            numCorrectValue*=2;
                        break;
                    }
                }

            }
            total+=numCorrectValue;
            content = br.readLine();

        }
        System.out.println(total);




    }
}
