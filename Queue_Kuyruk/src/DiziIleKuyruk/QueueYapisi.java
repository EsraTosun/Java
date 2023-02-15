package DiziIleKuyruk;

public class QueueYapisi
{
	int[] dizi;
	int size;
	int front;  //dizinin baştaki elemanını tutar
	int rear;  //dizinin son elemanını tutar
	
	public QueueYapisi(int size) 
	{
		this.size = size;
		dizi=new int[size]; //dizimize boyutunu atarız (kuyruk yapımız)
		front=0; //her zaman ilk elemanı(indexi) tutacak
		rear=-1;  //kuyrukta eleman olmadığı için -1, eleman eklendikçe tututan index değişecek	
	}
	
	void enQueue(int data)  // KUYRUĞA EKLEME
	{
		if(isFull())  //kuyruk dolu mu
		{
			System.out.println("kuyruk dolu ekleme yapamzsiniz");
		}
		else
		{
			rear++;
			dizi[rear]= data;
			System.out.println(dizi[rear]+" kuyruga eklendi");
		}
	}

	void deQueue()  //KUYRUKTAN SİLME
	{
		if(isEmpty())
		{
			System.out.println("kuyruk bos,silme islemi yapilamaz");
		}
		else
		{
			int sayi=dizi[front];	
			for(int i=1;i<=rear;i++)  //ilk elemanı silmek için 1. indisten başlarız
			{
				dizi[i-1]=dizi[i];
			}
			rear--; //elemanlar 1 indis düştüğü için rear azaltılır	
			System.out.println(sayi+" kuyruktan cikarildi");
		}	
	}
	

	private boolean isEmpty() {
		return rear==-1;
	}

	private boolean isFull() {
		return rear==size-1;  //indis 0 dan başladığı için boyut -1 alınır
	}
	
	void elemanSayisi()
	{
		System.out.println("eleman sayisi: "+(rear+1));  //rear insi tuttuğu için 0. indisi ekleriz
	}
	
	void Yazdir()
	{
		int i=rear;
		System.out.print("son->");
		
		while(i>=0)
		{
			System.out.print(dizi[i]+" ->");
			i--;
		}
		System.out.println(" bos");
	}
	
	

}
