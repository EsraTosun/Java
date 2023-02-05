package veri_yapilari_odev_3;

public class Eleman 
{
	int katSayi;
	int taban;
	int us;
	Eleman sonraki;
	
	public  Eleman(int katSayi,int taban,int us ) 
	{
	     this.katSayi=katSayi;
	     this.taban=taban;
	     this.us=us;
	     this.sonraki=null;
	}
	
}
