package veri_yapilari_odev_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;




public class veri_yapilari_3_odev {

	public static void main(String[] args) {
		BizimLinkedList list = new BizimLinkedList();
		ListeOlustur(list);
		System.out.println("\n\n");
		list.Birlestirme(list);
        list.listeyiYazdir();
        
        int secenek;
        do {
        Scanner veri=new Scanner(System.in);
        System.out.println("aranacak degeri giriniz");
        int eleman=veri.nextInt();
        
        list.Arama(eleman);
        System.out.println("cikmak istiyorsaniz 0\nistemiyorsaniz 0 disinde bir sayi giriniz");
        secenek=veri.nextInt();
        }while(secenek!=0);
        list.Toplama();

	}
	
	
	
    static void ListeOlustur(BizimLinkedList list) 
	{
		
		try (BufferedReader okuyucu=new BufferedReader(new FileReader("UsluSayilar.txt"))) {
			
			int katSayi;
			int taban;
			int us;
			
			String satir=okuyucu .readLine();
			
			while(satir!=null)
			{
			
				String[] dizi= satir.split(" ");
	
				katSayi=Integer.valueOf(dizi[0]);
				taban=Integer.valueOf(dizi[1]);
				us=Integer.valueOf(dizi[2]);
				
				
			    list.SiraliEkleme(katSayi, taban, us);					
				list.listeyiYazdir();
			
				satir=okuyucu.readLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
