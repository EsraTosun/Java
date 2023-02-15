package BagliListeIleKuyruk;

public class QueueYapisi 
{
	Node front;  //ilk düğümü tutar(head)
	Node rear; //son düğümü tutar(tail) 
	int cnt;  //counter(sayac)
	int size;  //kuyruğun boyutu
	
	public QueueYapisi(int size) 
	{
		this.size = size;
		cnt=0;
		front=null;
		rear=null;
	}
	
	void EnQueue(int data)
	{
		if(isFull())  //kuyruk dolu mu
			System.out.println("kuyruk dolu,ekleme yapilamadi");
		
		else
		{
			Node eleman=new Node(data);
			
			if(isEmpty())  //kuytuk bos mu
			{
				front=eleman;
				rear=eleman;
				System.out.println(data+" ilk eleman olarak kuyruga eklendi");
			}
			else
			{
				rear.next=eleman;
				rear=eleman;
				System.out.println(data+" kuyruga eklendi");
			}
			cnt++;
		}
	}
	
	void deQueue()
	{
		if(isEmpty())
			System.out.println("kuyruk bos,silinecek eleman yok");
		
		else
		{
			System.out.println(front.data+" silindi");
			front=front.next;
			cnt--;
		}
	}

	private boolean isEmpty()  // KUYRUĞUMUZ BOŞ MU
	{
		return cnt==0;
	}

	private boolean isFull()  // KUYRUĞUMUZ DOLU MU
	{
		return cnt==size;
	}
	
	void Yazdir()
	{
		if(isEmpty())
			System.out.println("kuruk bos,yazdiralacak eleman yok");
		else
		{
			Node temp=front;
			System.out.print("bas <- ");
			while(temp!=null)
			{
				System.out.print(temp.data+" <-");
				temp=temp.next;
			}	
			System.out.print(" son");
		}
	}
	
	
	
	

}
