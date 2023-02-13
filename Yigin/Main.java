package Yigin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) 
	{

		StackYapisi yigin=new StackYapisi();
		StackYapisi harfYigin=new StackYapisi();
		StackYapisi sayiYigin=new StackYapisi();
		ListeOlustur(yigin,harfYigin,sayiYigin);
		System.out.println("yigindeki veriler");
		yigin.Yazdir();
		System.out.println("\nharf yigindeki veriler");
		harfYigin.Yazdir();
		System.out.println("\nsayi yigindeki veriler");
		sayiYigin.Yazdir();
		System.out.println();
		yigin.EnUzunSayiDizilimi();
		System.out.println();
		yigin.EnUzunHarfDizilimi();
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("\n Aramak istediginiz karakter dizisini giriniz(2,3,a seklinde bosluk birakmadan virgullu sekilde yaziniz)");
		String string=scanner.next();
		string=string.replace(",","");
		
		int i;
		
		StackYapisi arananyigin=new StackYapisi();

		for(i=0;i<string.length();i++)
		{
			arananyigin.push(string.charAt(i));
		}
	     
		yigin.Arama(arananyigin,i);
		
	}


	public static void ListeOlustur(StackYapisi yigin,StackYapisi harfYigin,StackYapisi sayiYigin) 
		{
			
			try (BufferedReader okuyucu=new BufferedReader(new FileReader("dosya.txt"))) {
				
				char data;
				String satir=okuyucu .readLine();
				
				while(satir!=null)
				{
				
					String[] dizi= satir.split(" ");
					
					data=dizi[0].charAt(0);
					yigin.push(data);
										
					if(dizi[0].compareTo("a")>=0 & dizi[0].compareTo("z")<=25)
					{
						harfYigin.push(data);
					}
					
					if(dizi[0].compareTo("1")>=0 & dizi[0].compareTo("9")<=9)
					{
						sayiYigin.push(data);
					}
				
					satir=okuyucu.readLine();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

}
