package PosfixHesaplama;

public class StackYapisi 
{
	//int size;
	int cnt;  //sayac
	
	Node ilk;  //en üst düğümü tutan gösterici(head gibi)
	Node son;
	
	public StackYapisi() {
		cnt=0;
		ilk=null;
		son=null;
	}
	
	void push(String data)  //EKLEME
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
			if(ilk==son)
			{
				son=null;
				ilk=null;
			}
			else
			{
				son=son.onceki;
				son.sonraki=null;
			}
			cnt--;
		}
	}
	
	String sonDegerGoster()
	{
		return son.data;
	}
	
	void topGoster()
	{
		if(isEmpty())
			System.out.print("\t");
		
		else
		{
		//	System.out.println("en üstteki dugumun datasi:"+top.data);
		}
	}
	
	void Yazdir()
	{
		if(isEmpty())
			System.out.print("\t");
		
		else
		{
			Node temp=ilk;
			
			//System.out.println("stacktaki veriler:");
			
			while(temp!=null)
			{
				System.out.print(temp.data);
				temp=temp.sonraki;
			}
		}
	}
	
	
	boolean isEmpty()  //BOŞ MU
	{
		return (cnt==0);
	}	

}
