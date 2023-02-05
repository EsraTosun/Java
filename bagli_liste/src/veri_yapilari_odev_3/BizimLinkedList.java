package veri_yapilari_odev_3;


public class BizimLinkedList 
{
	Eleman bas;
	Eleman son;
	
	
	public BizimLinkedList()
	{
		bas=null;
		son=null;
	}
	
	public void Arama(int eleman)
	{
		Eleman isaretci=bas;
		int sayac=0;
		
		while(isaretci!=null)
		{
			if(eleman==isaretci.katSayi*UsAlma(isaretci.taban,isaretci.us))
			{
				System.out.println(isaretci.katSayi+"*"+isaretci.taban+"^"+isaretci.us);
				sayac=1;
			}
			
			isaretci=isaretci.sonraki;
		}
		if(sayac==0)
			System.out.println("girdiginzi deger bulunmamaktadir.");
		System.out.println();
	}
	
	public void Toplama()
	{
		Eleman isaretci=bas;
		int toplam=0;
		
		while(isaretci!=null)
		{
			if(isaretci.sonraki==null)
			System.out.print(isaretci.katSayi+"x"+isaretci.taban+"^"+isaretci.us+"+");
			else
			System.out.print(isaretci.katSayi+"x"+isaretci.taban+"^"+isaretci.us+"+");
			isaretci=isaretci.sonraki;
		}
		System.out.print("=");
		isaretci=bas;
		while(isaretci!=null)
		{
			int deger=isaretci.katSayi*UsAlma(isaretci.taban, isaretci.us);
			if(isaretci.sonraki==null)
			System.out.print(deger);
			else
			System.out.print(deger+"+");
		
			toplam+=deger;
			isaretci=isaretci.sonraki;
		}
		System.out.println("="+toplam);
	}
	
	public int UsAlma(int taban,int us)
	{
		int carpim=1;
		for(int i=0;i<us;i++)
		{
			carpim*=taban;
		}
		return carpim;
	}
   
	public void Birlestirme(BizimLinkedList List)
	{
		Eleman isaretci1=bas;
		Eleman isaretci2=bas;
		Eleman isaretci3=bas;
		
		int index1=0;
		while(isaretci1!=null)
		{
			isaretci2=isaretci1;
			int taban=isaretci1.taban;
			int us=isaretci1.us;
			int toplam=0,i=0,sayac=0,index=0;
			while(isaretci2!=null)
			{
				if(isaretci1.taban==isaretci2.taban && isaretci1.us==isaretci2.us )
				{
					toplam+=isaretci2.katSayi;
					isaretci2=isaretci2.sonraki;
					sayac++;
				}
				else
			        break;
			}
			if(sayac>=2)
			{
				index=index1;
				for(int k=0;k<sayac;k++)
				{
					List.indexiSil(index);
				}
				List.indexeEkleme(toplam,taban ,us , index1);
				index1--; //1 den fazla eleman silindiği için listede sıra kayma yapıyor bunu önlemek için sayactan silme yapılır 
				isaretci1=isaretci3;  //ve isaretci bir öncekine alınır fazla atlama olmaması için
			}
			
			index1++;
			isaretci3=isaretci1;
			isaretci1=isaretci1.sonraki;
		}
	}
	
	public void SiraliEkleme(int katSayi,int taban,int us)
	{
		Eleman yeniEleman=new Eleman(katSayi, taban, us);
		yeniEleman.katSayi=katSayi;
		yeniEleman.taban=taban;
		yeniEleman.us=us;
		
		if(doluMu()!=true)
			basaEkle(katSayi, taban, us);
		
		else
		{
			Eleman isaretci=bas;
			int index=0;
			while(isaretci!=null)
			{
				if(isaretci.taban>taban)
				{
					indexeEkleme(katSayi, taban, us, index);
					break;
				}
				else if(isaretci.taban==taban)
				{
					if(isaretci.us>us)
					{
						indexeEkleme(katSayi, taban, us, index);
						break;
					}
					
					else if(isaretci.us==us)
					{
						if(isaretci.katSayi>katSayi)
							indexeEkleme(katSayi, taban, us, index);
						
						else
							indexeEkleme(katSayi, taban, us, index+1);
						
						break;
					}				
				}
				index++;
				isaretci=isaretci.sonraki;
			 }
			if(index==boyut())
				sonaEkle(katSayi, taban, us);
		}			
	}
	
	public void basaEkle(int katSayi,int taban,int us) 
	{
		Eleman yeniEleman=new Eleman(katSayi, taban, us);
		yeniEleman.katSayi=katSayi;
		yeniEleman.taban=taban;
		yeniEleman.us=us;

		if(doluMu())
		{
			//liste dolu
			yeniEleman.sonraki=bas;
			bas=yeniEleman;
		}
		
		else
		{
			//liste boş
			bas=yeniEleman;
			son=yeniEleman;
		}
	}
	public void sonaEkle(int katSayi,int taban,int us)
	{
		Eleman yeniEleman=new Eleman(katSayi, taban, us);
		yeniEleman.katSayi=katSayi;
		yeniEleman.taban=taban;
		yeniEleman.us=us;

		if(doluMu())
		{
			//liste dolu
			son.sonraki=yeniEleman;
			son=yeniEleman;
		}
		
		else
		{
			//liste boş
			bas=yeniEleman;
			son=yeniEleman;
		}
	}
	
	public void indexeEkleme(int katSayi,int taban,int us,int index)
	{
		Eleman yeniEleman=new Eleman(katSayi, taban, us);
		yeniEleman.katSayi=katSayi;
		yeniEleman.taban=taban;
		yeniEleman.us=us;
		
		if(doluMu())
		{
			//liste dolu
			if(index==0)
			{
				//basa eklemekle aynı 
				yeniEleman.sonraki=bas;
				bas=yeniEleman;
			}
			else
			{
				//ortada bir yere ekliyoruz(sona ekleme bunun içine dahil)
				Eleman isaretci1=null;
				Eleman isaretci2=bas;

				int Mevcutindex=0;
				while(isaretci2 !=null && Mevcutindex<index)
				{
					isaretci1=isaretci2;
					isaretci2=isaretci2.sonraki;
					Mevcutindex++;
				}
				if(isaretci2==null)
				{
					//listenin sonuna ekle
					son.sonraki=yeniEleman;
					son=yeniEleman;
				}
				else
				{
					//ortada bir yere ekliyoruz
					yeniEleman.sonraki=isaretci2;
					isaretci1.sonraki=yeniEleman;
				}
			}
		}
		
		else
		{
			//liste boş
			bas=yeniEleman;
			son=yeniEleman;
		}
	}
	public void indexiSil(int index)
	{
		if(doluMu() && index>=0)
		{
			if(bas ==son)
			{
				//tek eleman var
				bas=null;
				son=null;
			}
			else
			{
				//en az iki eleman var
                if(index==0)
                {
                	Eleman yeniBas=bas.sonraki;
    				bas.sonraki=null; //bağı kopartıyoruz
    				bas=yeniBas;
                }
                else
                {
                	//en az iki eleman var ve sildiğimiz başta değil
                	Eleman isaretci1=null;
                	Eleman isaretci2=bas;
                	int mevcutIndex=0;
                	while(isaretci2!=null &&mevcutIndex<index)
                	{
                		isaretci1=isaretci2; //silinicek elemanın öncekini tutar
                		isaretci2=isaretci2.sonraki; //silinecek indexteki elemanı tutar
                		mevcutIndex++;
                	}
                	if(isaretci2!=null) //işaretci2 nulla eşitse silme yapılamaz
                	{
                		if(isaretci2==son)
                		{
                			//sondan silme
                			son=isaretci1;
                			isaretci1.sonraki=null;
                		}
                		else
                		{
                			//ortadan silme
                			isaretci1.sonraki=isaretci2.sonraki;
                			isaretci2=isaretci1;
                		}
                	}
                }
			}
		}
	}

	
	public void listeyiYazdir()
	{
		Eleman isaretci=bas;
		int elemanSayisi=0;
		
		while(isaretci !=null)
		{
			System.out.print(isaretci.katSayi+"*("+isaretci.taban+"^"+isaretci.us+")");
			System.out.print("\t ");
			isaretci=isaretci.sonraki;
			elemanSayisi++;
		}
		System.out.println();
		System.out.println("Eleman sayisi: "+elemanSayisi);
		System.out.println();
		System.out.println();


	}
	
	public int boyut()
	{
		Eleman isaretci=bas;
		int elemanSayisi=0;
		while(isaretci !=null)
		{
		    isaretci=isaretci.sonraki;
			elemanSayisi++;
		}
		return elemanSayisi;
	}
	
	
	public boolean doluMu() 
	{
		if(bas!=null)
			return true;
		
		else
			return false;
		
	}

}
