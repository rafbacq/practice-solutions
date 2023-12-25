
//USACO 2016 January Contest, Bronze
//Problem 2. Angry Cows
//java solution


import java.io.*;
import java.util.*;

public class angryCows {
	static List<haybale> haybaleList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("angry.in"));
		PrintWriter pw = new PrintWriter("angry.out");
		try {
			int n = Integer.parseInt(reader.readLine());
			for (int i = 0; i < n; i++) {
				haybaleList.add(new haybale(Integer.parseInt(reader.readLine())));

			}
		} catch (NumberFormatException e ) {
			System.out.println("\n Invalid number try again.\n");
		}

		int max=0;
		for(int i=0; i<haybaleList.size(); i++)
		{
			haybaleList.get(i).explode();
			int count=1;
			haybaleList.get(i).setRadius(1);
			while(Explosions())//checks if there are explosions to be made
			{
				for(int k=0; k<haybaleList.size(); k++)
				{
					if(haybaleList.get(k).checkExplode())
					{

						for(int j=0; j<haybaleList.size(); j++)
						{

							if(j!=k &&
									!haybaleList.get(j).checkExplode() &&
									!haybaleList.get(j).getalreadyExploded() &&
									haybaleList.get(k).isInRange(haybaleList.get(j)))
							{
								haybaleList.get(j).explode();
								count++;
								haybaleList.get(j).setRadius( haybaleList.get(k).getRadius()+1);
							}
						}
						haybaleList.get(k).reset();
						haybaleList.get(k).setalreadyExploded(true);
					}

				}


			}
			
			max=Math.max(max, count);

			for(int j=0; j<haybaleList.size(); j++)
			{
				haybaleList.get(j).setalreadyExploded(false);
				haybaleList.get(j).reset();
			}
			

		}
		pw.println(max);
		pw.close();
		
		
		


		
	}public static boolean Explosions()
		{
			
			for(int i=0; i<haybaleList.size(); i++)
			{
				if(haybaleList.get(i).checkExplode())
				{
					return true;
				}
			}
			return false;
		}
	static class haybale
	{
		boolean hasExploded;
		int position;
		int radius;
		boolean alreadyExploded;
		public haybale(int position)
		{
			this.position=position;
			hasExploded=false;
			radius=0;
			alreadyExploded=false;
		}
		public void reset()
		{
			hasExploded=false;
			radius = 1;
		}
		public boolean checkExplode()
		{
			return hasExploded;
		}
		public int getPosition()
		{
			return position;
		}
		public void explode()
		{
			hasExploded=true;

		}
		public void setalreadyExploded(boolean b)
		{
			alreadyExploded=b;
		}
		public boolean getalreadyExploded()
		{
			return alreadyExploded;
		}
		public boolean isInRange( haybale nextBale)
		{
			if(Math.abs(this.position - nextBale.getPosition())<= this.radius)
			{
				return true;
			}
			else{
				return false;
			}
		}
       public void setRadius( int newRadius) {
			this.radius = newRadius;
	   }
	   public  int getRadius() {
			return radius;
	   }
	}
}
