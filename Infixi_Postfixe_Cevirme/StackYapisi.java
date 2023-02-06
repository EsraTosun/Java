package InfixiPostfixeCevirme;

public class StackYapisi 
{
	//int size;
	int cnt;  //sayac
	
	Node top;  //en üst düğümü tutan gösterici(head gibi)
	
	public StackYapisi() {
		//this.size = size;
		cnt=0;
		top=null;
	}
	
	int push(char data)  //EKLEME
	{
		Node eleman=new Node(data);  //düğüme eklemek için mesme oluşturmak zorundayız
		
		     
			if(isEmpty())
			{
				top=eleman;
				//top.next=null; Sınıfda next nulla eşit dediğimiz için sonrakini takrar nulla eşitlemeye gerek yok
			//	System.out.println(top.data+" stace ilk eleman olarak eklendi");
				cnt++;
				return 1;
			}
			else
			{
				if(Deger(data)>Deger(top.data))
				{
					eleman.next=top;
					top=eleman;
				//	System.out.println(top.data+ " stace eklendi");
					cnt++;
					return 1;
				}
				else
					return 0;	
			}
	}
	
	int Deger(char x)
	{
		int deger=0;
		
		if(x==')')
		deger=0;
		
		else if(x=='*' || x=='/')
		deger=2;
		
		else if(x=='+' || x=='-')
		deger=1;
		
		else if(x=='(')
		deger=4;	
		
		return deger;
	}
	
	void pop()  //SİLME
	{
		if(isEmpty())
		{
			System.out.print("\t");
		}
		
		else
		{
		//	System.out.println(top.data+" cikarildi ");
			top=top.next;
			cnt--;
		}
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
			Node temp=top;
			
			//System.out.println("stacktaki veriler:");
			
			while(temp!=null)
			{
				System.out.print(temp.data);
				temp=temp.next;
			}
			System.out.print("\t");
		}
	}
	
	/*boolean isFull()  //DOLU MU
	{
		return (cnt==size);
	}   */
	
	boolean isEmpty()  //BOŞ MU
	{
		return (cnt==0);
	}
	
	
	

}
