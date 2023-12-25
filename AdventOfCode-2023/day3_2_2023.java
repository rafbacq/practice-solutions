import java.io.*;


public class day3_2_2023 {
    String content;
    Character [][] arr;
    int bruh=140;
    public day3_2_2023() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("day3.txt"));

        arr = new Character[bruh][bruh];
        content = br.readLine();
        content=br.readLine();
        int j=0;

        while(content!=null)
        {
            for(int i=0; i<content.length(); i++)
            {
                    arr[j][i]=content.charAt(i);
            }
            j++;
            content=br.readLine();
        }
        int total=0;

        for(int i=0; i<bruh; i++)
        {
            for(int k=0; k<bruh; k++)
            {

                    if(arr[i][k]!='.' && !Character.isDigit(arr[i][k])) {
                        System.out.println(checkSurroundings(i,k));
                        total += checkSurroundings(i,k);
                    }

            }
        }
        System.out.println(total);

    }
    public int checkSurroundings(int row, int col)
    {
        int result=0;
        boolean con=true;
        boolean isSecond=false;
        int first=0;
        int second=0;
        StringBuilder firstNum= new StringBuilder();
        StringBuilder secondNum = new StringBuilder();

        for(int j=row-1; j<=row+1; j++)
        {
            for(int k=col-1; k<=col+1; k++)
            {

                if(j>=0 && j<bruh && k>=0 && k<bruh && Character.isDigit(arr[j][k]))
                {

                    if(!isSecond)
                    {
                        first =checkSurroundings2(j,k,arr[j][k]+"");
                        isSecond=true;
                        while(k<bruh && Character.isDigit(arr[j][k]))
                        {
                            k++;
                        }
                        k--;
                    }
                    else
                    {
                        return first*checkSurroundings2(j,k,arr[j][k]+"");

                    }


                }
            }


        }

        return first*second;
    }
    public int checkSurroundings2(int row, int col,String current)
    {
        //going forward
        for(int i=col+1; i<arr.length; i++)
        {
            if(Character.isDigit(arr[row][i]))
            {
                current+=("" + arr[row][i]);
            }
            else
            {
                break;
            }

        }
        for(int i=col-1; i>=0; i--)
        {
            if(Character.isDigit(arr[row][i]))
            {
                current=""+arr[row][i]+current;

            }
            else
            {
                break;
            }
        }

        return Integer.parseInt(current);
    }


}
