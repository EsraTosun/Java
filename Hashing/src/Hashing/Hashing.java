package Hashing;

public class Hashing 
{
	static BagliListe[] dizi;
	static int size;
	
	public Hashing(int size) 
	{
		this.size = size;
		dizi=new BagliListe[size]; //dizimize boyutunu atarız (kuyruk yapımız)
		for(int i=0;i<size;i++)
		{
			dizi[i]=new BagliListe();
		}
	}
	
	public void H_Yaz(Personel personel)
	{
		int index=indexUret(personel.no);
		BagliListe eleman=new BagliListe(personel);
		BagliListe gecici=dizi[index];  //eklenecek konumu bulur
		BagliListe gecici2=gecici.siradaki;
		
		while(gecici.siradaki!=null) //ilgili bağlı listenin sonuna ekleme yapar
		{
			if(personel.no>gecici.siradaki.personel.no)
				break;
			gecici=gecici.siradaki;
			gecici2=gecici2.siradaki;
		}
		
		gecici.siradaki=eleman;
		eleman.siradaki=gecici2;
		System.out.println(+personel.no+" "+personel.isim+" "+personel.soyadi+" eleman eklendi");
		
	}
	
	public static int indexUret(int data)
	{
		return data%size;
	}
	
	
	public static void H_Arama(int eleman)
	{
		int index=indexUret(eleman);
		BagliListe gecici=dizi[index];
		while(gecici.siradaki!=null)
		{
			if(gecici.siradaki.personel.no==eleman)
			{
				System.out.print(eleman+" Hash tablosunda yer almaktadir =>");
				System.out.print(gecici.siradaki.personel.no+" "+
						gecici.siradaki.personel.isim+" "+
						gecici.siradaki.personel.soyadi+" ");
				break;
			}
			gecici=gecici.siradaki;
		}
		if(gecici.siradaki==null)
		{
			System.out.println(eleman+" Hash listesinde bulunmamaktadir");
		}		
	}
	
	public static void H_Silme(int eleman)
	{
		int index=indexUret(eleman);
		BagliListe gecici=dizi[index];
		BagliListe gecici2=gecici.siradaki;
		while(gecici.siradaki!=null)
		{
			if(gecici.siradaki.personel.no==eleman)
			{
				gecici.siradaki=gecici2.siradaki;
				break;
			}
			gecici=gecici.siradaki;
			gecici2=gecici2.siradaki;
		}
		if(gecici.siradaki==null)
		{
			System.out.println(eleman+" Mevcut personel bulunamadi! \n\n");
		}
		H_Listele();
	}
	
	public static void H_Listele()
	{
		int index=0;
		while(index<size)
		{
			BagliListe gecici=dizi[index];
			System.out.print("["+index+"] |_|->");
			System.out.print(" ");
			while(gecici.siradaki!=null)
			{
				System.out.print(gecici.siradaki.personel.no+" "+
						gecici.siradaki.personel.isim+" "+
						gecici.siradaki.personel.soyadi+" ");
				gecici=gecici.siradaki;
				if(gecici.siradaki!=null)
				System.out.print("->");
			}
			System.out.println();
			index++;
		}
	}
	
	
	
	
	
	
	
	

}
