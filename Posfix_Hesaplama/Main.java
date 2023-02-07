package PosfixHesaplama;


public class Main {

	public static void main(String[] args) {
		
        StackYapisi yigin=new StackYapisi();
		
		String[] postfix={"a","b","/","c","-","d","e","*","+","a","c","*","-"};//"ab/c-de*+ac*-";
		//String[] postfix=x.ch;  //string ifadeyi chara cevirir
		String[] hesaplanan=new String[postfix.length];
		
        int k=0;
		
		System.out.println("OKUNAN \t YIGIN \t HESAPLANAN");
		
		for(int i=0;i<postfix.length;i++)
		{
			System.out.print(postfix[i]+"\t");
			yigin.Yazdir();
			System.out.print("\t");
			if(postfix[i]== "*" || postfix[i]== "-" || postfix[i]== "/" || postfix[i]== "+")
			{
				String BirinciDeger=yigin.sonDegerGoster();
				yigin.pop();
				String IkıncıDeger=yigin.sonDegerGoster();
				yigin.pop();
				
				if(k==0)
				{
					System.out.print("  T1="+BirinciDeger+postfix[i]+IkıncıDeger+"\t");
					yigin.push("T1");
				}
				else if(k==1)
				{
					System.out.print("  T2="+BirinciDeger+postfix[i]+IkıncıDeger+"\t");
					yigin.push("T2");
				}
				else if(k==2)
				{
					System.out.print("  T3="+BirinciDeger+postfix[i]+IkıncıDeger+"\t");
					yigin.push("T3");
				}
				else if(k==3)
				{
					System.out.print("  T4="+BirinciDeger+postfix[i]+IkıncıDeger+"\t");
					yigin.push("T4");
				}
				else if(k==4)
				{
					System.out.print("  T5="+BirinciDeger+postfix[i]+IkıncıDeger+"\t");
					yigin.push("T5");
				}
				else if(k==5)
				{
					System.out.print("  T6="+BirinciDeger+postfix[i]+IkıncıDeger+"\t");
					yigin.push("T6");
				}
				k++;
			
			}
			else
			{
				yigin.push(postfix[i]);
				//System.out.println();
				//yigin.Yazdir();
			}
			System.out.println();
		}
		System.out.print("SONUC: ");
		yigin.Yazdir();
		

   }
}
