import java.io.*;

public class day25_2015 {
    String content;
    public day25_2015() throws IOException
    {
        //BufferedReader br = new BufferedReader(new FileReader("day3.txt"));
        //content =br.readLine();
        int row=6;
        int col=6;
        int num=1;
        for(int i=1; i<row; i++)
        {
            num+=i;

        }
        int j=row+1;
        for(int i=0; i<col-1; i++)
        {
            num+=j;
            j++;

        }
        long total=20151125;
        for(int i=1; i<num; i++)
        {
            total*=252533;
            total=total%33554393;
        }
        System.out.println(total);



    }

}
