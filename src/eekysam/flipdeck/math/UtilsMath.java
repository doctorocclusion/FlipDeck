package eekysam.flipdeck.math;

public class UtilsMath
{
	public static long gcdl(long a, long b)
	{
		while (b > 0)
		{
			long i = b;
			b = a % b;
			a = i;
		}
		return a;
	}

	public static long gcdl(long[] nums)
	{
		long out = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			out = gcdl(out, nums[i]);
		}
		return out;
	}

	public static long lcml(long a, long b)
	{
		return a * (b / gcdl(a, b));
	}

	public static long lcml(long[] nums)
	{
		long mult = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			mult = lcml(mult, nums[i]);
		}
		return mult;
	}
	
	public static int gcd(int a, int b)
	{
		while (b > 0)
		{
			int i = b;
			b = a % b;
			a = i;
		}
		return a;
	}

	public static int gcd(int[] nums)
	{
		int out = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			out = gcd(out, nums[i]);
		}
		return out;
	}

	public static int lcm(int a, int b)
	{
		return a * (b / gcd(a, b));
	}

	public static int lcm(int[] nums)
	{
		int mult = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			mult = lcm(mult, nums[i]);
		}
		return mult;
	}
}
