

import java.util.*;
import java.io.*;


    public class day3_1_2023 {
        String content;
        Character [][] arr;
        public day3_1_2023() throws IOException
        {
            BufferedReader br = new BufferedReader(new FileReader("day3.txt"));
            arr = new Character[140][140];
            content = br.readLine();
            content=br.readLine();
            int j=0;

            while(content!=null)
            {



                for(int i=0; i<content.length(); i++)
                {
                /*if(i==0 && j==0)
                    i++;*/

                    arr[j][i]=content.charAt(i);



                }
                j++;
                content=br.readLine();
            }
            int total=0;
            StringBuilder currentNum = new StringBuilder();
            for(int i=0; i<140; i++)
            {
                for(int k=0; k<140; k++)
                {
                    currentNum=new StringBuilder();
                    try
                    {
                        if(Character.isDigit(arr[i][k]))
                        {
                            int currentK=k;
                            try
                            {
                                while(currentK<140 && Character.isDigit(arr[i][currentK]))
                                {
                                    currentNum.append(arr[i][currentK]);
                                    currentK++;
                                }
                            }catch(Exception e)
                            {
                                //lololol
                            }

                            total+=checkSurroundings(i,k,currentK-1,currentNum.toString());
                            k=currentK;
                        }
                    }
                    catch(Exception e)
                    {
                        //lololooll
                    }

                }
            }
            System.out.println(total);

        }
        public int checkSurroundings(int row, int startCol, int endCol, String num)
        {
            int result=0;
            boolean con=true;
            for(int i=startCol; i<=endCol; i++)
            {

                //check everything within one radius
                for(int j=row-1; j<=row+1; j++)
                {
                    for(int k=i-1; k<=i+1; k++)
                    {
                        try
                        {
                            if(j>=0 && j<140 && k>=0 && k<140 && arr[j][k]!='.' && !Character.isDigit(arr[j][k]))
                            {
                                con=false;
                                break;
                            }

                        }catch(Exception e)
                        {
                            //lololool
                        }

                    }
                }
                if(!con)
                {
                    result+=Integer.parseInt(num);
                    System.out.println(result);
                    break;
                }
            }
            return result;
        }

    }


