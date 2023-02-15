package KuyrukOrnek;

import java.util.Scanner;

public class Uygulama {

	public static void main(String[] args)
    {
		Scanner scanner=new Scanner(System.in);

		int secim=-1,n;
		System.out.println("kuyuk yapisinin eleman sayisi: "); n=scanner.nextInt();
		
		QueuePideYapisi kuyruk=new QueuePideYapisi(n);
		
		while(secim!=0)
		{
			System.out.println("1- yeni musteri ekle");
			System.out.println("2- satis yap");
			System.out.println("3- bekleyen musteriler");
			System.out.println("4- toplam gelir");
			System.out.println("0- cikis");
			System.out.println("seciminiz: ");
			//scanner.nextLine();
			secim=scanner.nextInt();
			
			
			switch (secim) 
			{
			case 1:
				kuyruk.enQueue();
				break;
				
            case 2:
				kuyruk.deQueue();
				break;
				
            case 3:
				kuyruk.Yazdir();
				break;
				
            case 4:
	            System.out.println("Toplam gelir: "+kuyruk.toplamGelir);
	            break;
	 
            case 0:
	            System.out.println("cikis yapildi");
	            break;

			default:
				System.out.println("hatali islem");
				break;
			}

		}
		
	}

}
