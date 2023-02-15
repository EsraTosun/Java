package DiziIleDaireselKuyruk;

public class Uygulama {

	public static void main(String[] args) 
	{
		QueueYapisi kuyruk=new QueueYapisi(5);
		
		kuyruk.enQueue(10);
		kuyruk.enQueue(20);
		kuyruk.enQueue(30);
		kuyruk.enQueue(40);
		kuyruk.elemanSayisi();
		kuyruk.enQueue(50);
		kuyruk.elemanSayisi();

		
		kuyruk.enQueue(60);
		kuyruk.elemanSayisi();
		kuyruk.Yazdir();
		
		System.out.println("kuyrugun basindaki eleman: "+kuyruk.dizi[kuyruk.front]);
		System.out.println("kuyrugun sonundaki eleman: "+kuyruk.dizi[kuyruk.rear]);
		
		kuyruk.deQueue();
		kuyruk.Yazdir();
		kuyruk.deQueue();
		kuyruk.Yazdir();
		kuyruk.deQueue();
		kuyruk.Yazdir();
		kuyruk.deQueue();
		kuyruk.deQueue();
		
		kuyruk.deQueue();


		
	}

}
