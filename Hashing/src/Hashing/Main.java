package Hashing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("hashing tablosunun boyutunu giriniz");
		int boyut=scanner.nextInt();
		
		Hashing hashing=new Hashing(boyut);
		ListeOlustur(hashing);
		
		Hashing.H_Listele();
		
		System.out.println("\nListede aramak istediginiz personel numarasini giriniz");
		int no=scanner.nextInt();
		
		Hashing.H_Arama(no);
		
		System.out.println("\n\nListede silmek istediginiz personel numarasini giriniz");
		no=scanner.nextInt();
		
		Hashing.H_Silme(no);
		
		System.out.println("\n\nListede silmek istediginiz personel numarasini giriniz");
		no=scanner.nextInt();
		
		Hashing.H_Silme(no);

		
	}
	
	public static void ListeOlustur(Hashing hashing) 
	{
	
		try (BufferedReader okuyucu=new BufferedReader(new FileReader("Personel.txt"))) {
			
			String satir=okuyucu.readLine();
			
			while(satir!=null)
			{
				String[] dizi=satir.split(" ");
				Personel personel=new Personel(Integer.valueOf(dizi[0]), dizi[1], dizi[2]);
				
				
				hashing.H_Yaz(personel);
					
				satir=okuyucu.readLine();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
