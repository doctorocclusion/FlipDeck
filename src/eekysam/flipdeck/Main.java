package eekysam.flipdeck;

public class Main
{
	public static void main(String[] args)
	{
		for (int i = 1; i <= 1000; i++)
		{
			Deck d = Deck.newInstance(i);
			System.out.println(d.size + "\t" + d.rotateNumber());
		}
	}
}
