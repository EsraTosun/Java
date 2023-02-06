package InfixiPostfixeCevirme;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		StackYapisi yigin=new StackYapisi();
		
		String x="a/b-c+d*e-a*c";
		char[] infix= x.toCharArray();  //string ifadeyi chara cevirir
		char[] hesaplanan=new char[infix.length];
		
		
		int k=0;
		
		System.out.println("OKUNAN \t YIGIN \t HESAPLANAN");
		for(int i=0;i<infix.length;i++)
		{
			System.out.print(infix[i]+" \t ");
			
			if(infix[i]=='+' || infix[i]=='-' || infix[i]=='(' || infix[i]==')' || infix[i]=='*' || infix[i]=='/')
			{
				int deger=yigin.push(infix[i]);
				
				if(deger==0)
				{
					for(int m=0;m<=yigin.cnt;m++)
					{
						if(yigin.top.data=='(' || yigin.top.data==')')
						{
							yigin.pop();
							continue;
						}
						hesaplanan[k]=yigin.top.data;
						k++;
						yigin.pop();
					}
					yigin.push(infix[i]);
				}	
			}
			
			else if(infix[i]>='a' && infix[i]<='z')
			{
				hesaplanan[k]=infix[i];
				k++;
			}
			yigin.Yazdir();
			Yazdir(hesaplanan,k);
			System.out.println();
			
		}
		for(int i=0;i<=yigin.cnt;i++)
		{
			hesaplanan[k]=yigin.top.data;
			k++;
			yigin.pop();
			System.out.print(" \t ");
			yigin.Yazdir();
			Yazdir(hesaplanan,k);
			System.out.println();
		}
		
	}
	
	public static void Yazdir(char[] hesaplanan,int k)
	{
		
		for(int i=0;i<k;i++)
		{
			System.out.print(hesaplanan[i]);
		}
	}

}
