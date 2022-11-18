
	import java.util.*;

	public class LRU{

		static int pageFaults(int arr[],int arrlen,int len){
			int count=0;
			int page_faults=0;
			ArrayList<Integer> s=new ArrayList<>(len);
			for(int i:arr){
				if(!s.contains(i))
				{
					
					if(s.size()==len)
					{
						
						s.remove(0);
						s.add(len-1,i);
					}
					else 
						s.add(count,i);
						page_faults++;
						++count;
				}
				else
				{
					s.remove((Object)i);
					s.add(s.size(),i);		
				}
			}
			return page_faults;
		}
			
			public static void main(String[] args) {
				Scanner sc=new Scanner(System.in);
				int noofpages,capacity;
				double pageFaults,pageHits,hitRatio,mixRatio;
				System.out.print("Enter the number of pages you want to enter: ");
				noofpages=sc.nextInt();
				int pages[]=new int[noofpages];
		        for (int i=0;i<noofpages;i++) {
					pages[i]=sc.nextInt();
				}
		        System.out.print("Enter the capacity of frame: ");
		        capacity=sc.nextInt();
				pageFaults=pageFaults(pages,noofpages ,capacity);
				pageHits=noofpages-pageFaults;
				hitRatio=(pageHits/noofpages)*100;
				mixRatio=(pageFaults/noofpages)*100;
				System.out.println("Page Fault: "+pageFaults+"\nPage Hit: "+pageHits);
				System.out.printf("Hit Ratio:%.2f \nMix Ratio:%.2f ",hitRatio,mixRatio);
				
			}
		

}
