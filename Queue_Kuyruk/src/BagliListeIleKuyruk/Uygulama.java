package BagliListeIleKuyruk;

public class Uygulama {

	public static void main(String[] args)
	{

		QueueYapisi kuyruk=new QueueYapisi(5);
		
		kuyruk.EnQueue(10);
		kuyruk.EnQueue(20);		
		kuyruk.EnQueue(30);
		kuyruk.EnQueue(40);	
		System.out.println("kuyruktaki mevcut eleman sayisi: "+kuyruk.cnt);
		System.out.println("kurugun basindaki eleman : "+kuyruk.front.data);
		System.out.println("kurugun sonundaki eleman : "+kuyruk.rear.data);

		kuyruk.EnQueue(50);
		
		kuyruk.EnQueue(60);
		
		kuyruk.deQueue();
		kuyruk.deQueue();
		kuyruk.deQueue();
		kuyruk.deQueue();
		kuyruk.deQueue();
		kuyruk.deQueue();

		System.out.println("kuyruktaki mevcut eleman sayisi: "+kuyruk.cnt);
		
		kuyruk.Yazdir();

		
	}

}
