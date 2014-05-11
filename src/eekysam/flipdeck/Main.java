package eekysam.flipdeck;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
	public static void main(String[] args)
	{
		int min = 1;
		int max = 1000;
		BufferedWriter writer = null;
		String fname = null;

		if (args.length == 1)
		{
			try
			{
				min = 1;
				max = Integer.parseInt(args[0]);
				fname = null;
			}
			catch (NumberFormatException e)
			{
				min = 1;
				max = 1000;
				fname = args[0];
			}
		}
		else if (args.length == 2)
		{
			try
			{
				max = Integer.parseInt(args[1]);
				min = Integer.parseInt(args[0]);
				fname = null;
			}
			catch (NumberFormatException e0)
			{
				min = 1;
				max = Integer.parseInt(args[0]);
				fname = args[1];
			}
		}
		else if (args.length >= 3)
		{
			max = Integer.parseInt(args[1]);
			min = Integer.parseInt(args[0]);
			fname = args[2];
		}

		if (fname != null)
		{
			try
			{
				File file = new File(fname);
				file.createNewFile();
				writer = new BufferedWriter(new FileWriter(file));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		if (writer == null)
		{
			for (int i = min; i <= max; i++)
			{
				Deck d = Deck.newInstance(i);
				System.out.println(d.size + "\t" + d.rotateNumber());
			}
		}
		else
		{
			try
			{
				int delta = 0;
				for (int i = min; i <= max; i++)
				{
					Deck d = Deck.newInstance(i);
					writer.append(d.size + "\t" + d.rotateNumber() + "\n");
					if (delta >= 500)
					{
						delta = 0;
						System.out.println((int)((((float) (i - min)) / (max - 1)) * 100) + "%");
					}
					delta++;
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			System.out.println("100% - Done!");
			try
			{
				writer.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
