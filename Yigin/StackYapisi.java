package Yigin;

public class StackYapisi 
{
	int cnt;  //sayac
	
	Node ilk;  //en üst düğümü tutan gösterici(head gibi)
	Node son;
	
	Node ilk1;  //en üst düğümü tutan gösterici(head gibi)
	Node son1;
	
	public StackYapisi() {
		cnt=0;
		ilk=null;
		son=null;
		ilk1=null;
		son1=null;
	}
	
	void EnUzunSayiDizilimi() 
	{
		StackYapisi enUzunSayiYigin=new StackYapisi();

		Node temp=ilk;
		 int onceki=0;
		 int index=0,ilkIndex=0,sonIndex=0,sayac=0;
						
			while(temp!=null)
			{
				int ascii=temp.data;
			   
				if(ascii>=48 & ascii<=57)
				{
					if(sayac==0)
					{
						ilkIndex=index;
						sonIndex=index;
						onceki=ascii;
						sayac++;
					}
					else
					{
						if(onceki+1==ascii)
						{
							sonIndex=index;
							onceki=ascii;
							sayac++;
						}
					}
				}
				else
				{
					if(sayac>1)
					enUzunSayiYigin.ekleme(ilkIndex, sonIndex, sayac);
					
					ilkIndex=0;
					sayac=0;
				}
				index++;
				temp=temp.sonraki;
			}
			if(sayac>1)
				enUzunSayiYigin.ekleme(ilkIndex, sonIndex, sayac);
			
			Node Dugum=enUzunSayiYigin.EnUzunDiziminiGoster();
			
			temp=ilk;
			index=0;
			while(temp!=null)
			{
				if(index>=Dugum.ilkIndex & index<=Dugum.sonIndex)
				System.out.print(temp.data+" ");
				
				index++;
				temp=temp.sonraki;
			}
	}


	void EnUzunHarfDizilimi() 
	{
		StackYapisi enUzunHarfYigin=new StackYapisi();

		 Node temp=ilk;
		 int onceki=0;
		 int index=0,ilkIndex=0,sonIndex=0,sayac=0;
			
			while(temp!=null)
			{
				int ascii=temp.data;
				if(ascii>=97 & ascii<=122)
				{
					if(sayac==0)
					{
						ilkIndex=index;
						sonIndex=index;
						onceki=ascii;
						sayac++;
					}
					else
					{
						if(onceki+1==ascii)
						{
							sonIndex=index;
							onceki=ascii;
							sayac++;
						}
					}
				}
				else
				{
					if(sayac>1)
					enUzunHarfYigin.ekleme(ilkIndex, sonIndex, sayac);
					
					ilkIndex=0;
					sayac=0;
				}
				index++;
				temp=temp.sonraki;
			}
			if(sayac>1)
				enUzunHarfYigin.ekleme(ilkIndex, sonIndex, sayac);
			
			Node Dugum=enUzunHarfYigin.EnUzunDiziminiGoster();
			
			temp=ilk;
			index=0;
			while(temp!=null)
			{
				if(index>=Dugum.ilkIndex & index<=Dugum.sonIndex)
				System.out.print(temp.data+" ");
				
				index++;
				temp=temp.sonraki;
			}
			
	}
	
	Node EnUzunDiziminiGoster()
	{
		Node temp1=ilk1;
        int enBuyuk=0;
        Node Dugum=temp1;;
		while(temp1!=null)
		{
			if(enBuyuk<temp1.sayac)
			{
				enBuyuk=temp1.sayac;
				Dugum=temp1;
			}
			
			temp1=temp1.sonraki;
		}
		
		return Dugum;
	}
	
	public void Arama(StackYapisi arananyigin,int boyut) 
	{
	    Node temp=ilk;
	    System.out.println();
	    int index=0,sayac=0;
	    while(temp!=null)
	    {
	    	if(arananyigin.indexElemanGoster(index)==temp.data)
	    	{
	    		index++;
	    		sayac++;
	    		 if(sayac==boyut)
	    		 {
	    		    	System.out.println("aradiginiz dizi bulunmaktadir");
	    		    	break;
	    		 }
	    	}
	    	else
	    	{
	    		index=0;
	    		sayac=0;
	    	}
	    	temp=temp.sonraki;
	    }
	   
	    if(temp==null)
	    	System.out.println("aradaginiz karakter dizisi bulunmamaktadir");
	
	}
	
	char indexElemanGoster(int index)
	{
		Node temp=ilk;
		int sayac=0;
		while(temp!=null)
		{
			if(sayac==index)
				return temp.data;
			
			sayac++;
			temp=temp.sonraki;
		}
		return 0;
	}
	
	void ekleme(int ilkIndex,int sonIndex,int sayac)  //EKLEME
	{
		Node eleman=new Node(ilkIndex,sonIndex,sayac);  //düğüme eklemek için mesme oluşturmak zorundayız
		
		if(ilk1==null)
		{
			ilk1=eleman;
			ilk1.onceki=null;
		}
		else
		{
			son1.sonraki=eleman;
			eleman.onceki=son1;
		}
		son1=eleman;
		son1.sonraki=null;	
	}
	
	void push(char data)  //EKLEME
	{
		Node eleman=new Node(data);  //düğüme eklemek için mesme oluşturmak zorundayız
		
		if(isEmpty())
		{
			ilk=eleman;
			ilk.onceki=null;
		}
		else
		{
			son.sonraki=eleman;
			eleman.onceki=son;
		}
		son=eleman;
		son.sonraki=null;
		
			cnt++;   	
	}
	
	void pop()  //SİLME
	{
		if(isEmpty())
		{
			System.out.println("stack bos. cikartilacak bir sey yok");
		}
		
		else
		{
			//System.out.println(top.data+" cikarildi ");
			son=son.onceki;
			son.sonraki=null;
		}
	}
	
	void topGoster()
	{
		if(isEmpty())
			System.out.println("stack bos");
		
		else
		{
			//System.out.println("en üstteki dugumun datasi:"+top.data);
		}
	}
	
	void Yazdir()
	{
		if(isEmpty())
			System.out.println("yazdirilacak bir sey yok");
		
		else
		{
			Node temp=ilk;
			
			//System.out.println("stacktaki veriler:");
			
			while(temp!=null)
			{
				System.out.println(temp.data);
				temp=temp.sonraki;
			}
		}
	}

	boolean isEmpty()  //BOŞ MU
	{
		return (cnt==0);
	}

}
