//USACO 2022 US Open Contest, Bronze
//Problem 2. Counting Liars
//Java Solution

    import java.util.*;
    import java.io.*;
    
    public class USACO {

        public static void main(String[] args) throws IOException {
            //BufferedReader reader = new BufferedReader(new FileReader("whereami.in"));
            //PrintWriter pw = new PrintWriter (new BufferedWriter(new FileWriter("whereami.out")));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            List<Integer> greater = new ArrayList<>();
            List<Integer> lesser = new ArrayList<>();
            for(int i=0; i<n; i++)
            {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                if(st.nextToken().equals("G"))
                {
                    greater.add(Integer.valueOf(st.nextToken()));
                }
                else
                {
                    lesser.add(Integer.valueOf(st.nextToken()));

                }
            }
            int count=Integer.MAX_VALUE;
            if(lesser.size()==0)
                System.out.println(0);
            else
            {
                for(int i=0; i<lesser.size(); i++)
                {
                    int current=lesser.get(i);
                    int currentCount=0;
                    for(int j=0; j<greater.size(); j++)
                    {
                        if(current<greater.get(j))
                        {
                            currentCount++;
                        }
                    }
                    for(int j=0; j<lesser.size(); j++)
                    {
                        if(current>lesser.get(j))
                        {
                            currentCount++;
                        }
                    }
                    count=Math.min(currentCount,count);

                }
                for(int i=0; i<greater.size(); i++)
                {
                    int current=greater.get(i);
                    int currentCount=0;
                    for(int j=0; j<lesser.size(); j++)
                    {
                        if(current>lesser.get(j))
                        {
                            currentCount++;
                        }
                    }
                    for(int j=0; j<greater.size(); j++)
                    {
                        if(current<greater.get(j))
                        {
                            currentCount++;
                        }
                    }
                    count=Math.min(currentCount,count);

                }

            }
            System.out.println(count);
        }
    }
