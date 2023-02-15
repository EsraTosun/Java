package KuyrukOrnek;

import java.util.Scanner;

public class QueuePideYapisi 
{
	Scanner scanner=new Scanner(System.in);
	NodePide front;  //head(ilk eleman)
	NodePide rear;  //tail(son eleman)
	int size;
	int cnt;
	
	public QueuePideYapisi(int size) {
		this.size = size;
		cnt=0;
		front=null;
		rear=null;
		
	}
	
	int toplamGelir=0;
	String isim;
	int adet;
	
	void enQueue()
	{
		if(isFull())
			System.out.println("kuyurk sirasi dolu");
		
		else
		{
			System.out.println("mustri ismi: "); isim=scanner.nextLine();
			System.out.println("pide sayisi: "); adet=scanner.nextInt();
			scanner.nextLine();

			NodePide eleman=new NodePide(isim, adet);
			if(isEmpty())
			{
				front=rear=eleman;
				System.out.println("kuruk yapisi olusturuldu ve ilk musteri siraya girdi");
			}
			else
			{
				rear.next=eleman;
				rear=eleman;
				System.out.println(rear.isim+" musteri siraya girdi");
				cnt++;
			}
		}
		
	}
	
	void deQueue()
	{
		if(isEmpty())
			System.out.println("pide sirasinde bekleyen musteri yok");
		else
		{
			toplamGelir+=front.ucret;
			System.out.println(front.isim+" "+front.adet+" pidesini aldi, toplam borcu: "+front.ucret);
			front=front.next;
			cnt--;
		}
	}
	
	void Yazdir()
	{
		if(isEmpty())
			System.out.println("bekleyen musteri yok");
		
		else
		{
			NodePide temp=front;
			System.out.print("bas <-");
			while(temp!=null)
			{
				System.out.print(temp.isim+" <-");
				temp=temp.next;
			}
			System.out.println(" son");
		}
	}
	
	boolean isEmpty()
	{
		return cnt==0;
	}
	
	boolean isFull()  //kuyruk dolu u
	{
		return cnt==size;
	}
	
	

}
