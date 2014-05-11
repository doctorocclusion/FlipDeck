package eekysam.flipdeck;

import eekysam.flipdeck.math.UtilsMath;

public class Deck
{
	private final int[] deck;
	public final int size;
	
	private Deck(int[] order) throws Exception
	{
		this.deck = order;
		size = order.length;
		if (!this.checkValid())
		{
			throw new Exception("Order is not a valid order!");
		}
	}
	
	public int rotate(int number)
	{
		if (number >= this.size || number < 0)
		{
			return -1;
		}
		return this.rotateUnchecked(number);
	}
	
	private int rotateUnchecked(int number)
	{
		int i = 1;
		int j = this.deck[number];
		while (j != number)
		{
			j = this.deck[j];
			i++;
		}
		return i;
	}
	
	public int[] rotateAll()
	{
		int[] r = new int[this.size];
		for (int i = 0; i < this.size; i++)
		{
			r[i] = this.rotateUnchecked(i);
		}
		return r;
	}
	
	public int rotateNumber()
	{
		return UtilsMath.lcm(this.rotateAll());
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
	
	public static Deck newInstance(int size)
	{
		int[] order = new int[size];
		if (size % 2 == 1)
		{
			order[size - 1] = size / 2;
		}
		for (int i = 0; i < size / 2; i++)
		{
			order[i * 2] = i;
			order[i * 2 + 1] = size - (i + 1);
		}
		return newInstance(order);
	}
}
