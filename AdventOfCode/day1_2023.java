import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class day1_2023 {
    public day1_2023() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("day1.txt"));
        String content = br.readLine();
        int total=0;
        String currentNumer="";
        Map<String, Integer> hm = new HashMap<>();
        hm.put("one",1);
        hm.put("two",2);
        hm.put("three",3);
        hm.put("four",4);
        hm.put("five",5);
        hm.put("six",6);
        hm.put("seven",7);
        hm.put("eight",8);
        hm.put("nine",9);
        hm.put("ten",10);
        boolean con, con2;
        while(content!=null)
        {
            con=true;
            con2=true;

            for(int i=0; i<content.length(); i++)
            {
                if(Character.isDigit(content.charAt(i))) {
                    currentNumer += Integer.parseInt(content.substring(i, i + 1));
                    break;
                }
                else
                {
                    for(String s:hm.keySet())
                    {
                        if(i+s.length()<=content.length() && content.substring(i,i+s.length()).equals(s))
                        {
                            currentNumer+=hm.get(s);
                            con=false;
                            break;
                        }
                    }
                }
                if(!con)
                {
                    break;
                }
            }
            for(int i=content.length()-1; i>=0; i--)
            {
                if(Character.isDigit(content.charAt(i))) {
                    currentNumer += Integer.parseInt(content.substring(i, i + 1));
                    break;
                }
                else
                {
                    for(String s:hm.keySet())
                    {
                        if(i+s.length()<=content.length() && content.substring(i,i+s.length()).equals(s))
                        {
                            currentNumer+=hm.get(s);
                            con2=false;
                            break;
                        }
                    }
                }
                if(!con2)
                {
                    break;
                }
            }
            total+=Integer.parseInt(currentNumer);
            content=br.readLine();
            currentNumer="";

        }
        System.out.println(total);
        br.close();
    }
}
