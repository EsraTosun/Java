package Yigin;

public class Node 
{
	char data;
	Node sonraki;
	Node onceki;
	int ilkIndex;
	int sonIndex;
	int sayac;
	
	public Node(char data) 
	{
		this.data = data;
		sonraki=null;
		onceki=null;
	}
	
	public Node(int ilkIndex,int sonIndex,int sayac) 
	{
		this.data = data;
		this.ilkIndex = ilkIndex;
		this.sonIndex = sonIndex;
		this.sayac = sayac;
		sonraki=null;
		onceki=null;
	}
	
	

	
}
