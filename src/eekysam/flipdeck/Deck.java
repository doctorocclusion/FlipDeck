package eekysam.flipdeck;

public class Deck
{
	private final int[] deck;
	
	private Deck(int[] order) throws Exception
	{
		this.deck = order;
		if (!this.checkValid())
		{
			throw new Exception("Order is not a valid order!");
		}
	}
	
	@Deprecated
	public boolean isValid()
	{
		return true;
	}
	
	public boolean checkValid()
	{
		return isValidDeck(this.deck);
	}
	
	public static boolean isValidDeck(int[] order)
	{
		boolean[] pres = new boolean[order.length];
		
		for (int i = 0; i < order.length; i++)
		{
			int o = order[i];
			if (o < 0 || o >= order.length)
			{
				return false;
			}
			if (pres[o])
			{
				return false;
			}
			else
			{
				pres[o] = true;
			}
		}
		
		for (int i = 0; i < order.length; i++)
		{
			if (!pres[i])
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static Deck newInstance(int[] order)
	{
		try
		{
			return new Deck(order);
		}
		catch (Exception e)
		{
			return null;
		}
	}
}
