import java.io.*;

public class day2_2023 {
    String content="";
    public day2_2023() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("day2.txt"));
        content = br.readLine();
        //int gameID = 0;
        int total=0;
        //final int red=12;
        //final int blue = 14;
        //final int green= 13;
        int red,blue,green;
        boolean con;


        while(content!=null)
        {
            //int indexCol=content.indexOf(":");
            //gameID=findNum(indexCol-1);
            red=0;
            blue=0;
            green=0;

            //con=true;
            for(int i=0; i<content.length(); i++)
            {
                if(i+4<=content.length() && content.substring(i,i+4).equals("blue"))
                {

                    /*if(findNum(i-2)>blue)
                    {
                        con=false;
                        break;
                    }*/
                    blue=Math.max(findNum(i-2),blue);
                }
                if(i+5<=content.length()  && content.substring(i,i+5).equals("green"))
                {


                    /*if(findNum(i-2)>green)
                    {
                        con=false;
                        break;
                    }*/
                    green=Math.max(findNum(i-2),green);
                }
                if(i+3<=content.length() && content.substring(i,i+3).equals("red"))
                {

                    /*if(findNum(i-2)>red)
                    {
                        con=false;
                        break;
                    }*/
                    red=Math.max(findNum(i-2),red);
                }
            }
            total+=red*green*blue;

            content =br.readLine();

        }
        System.out.println(total);

        br.close();


    }
    public int findNum(int index)
    {
        StringBuilder reverseThis =new StringBuilder();
        while(!Character.isWhitespace(content.charAt(index)))
        {
            reverseThis.append(content.charAt(index));
            index--;
        }
        return Integer.parseInt(reverseThis.reverse().toString());
    }
}
