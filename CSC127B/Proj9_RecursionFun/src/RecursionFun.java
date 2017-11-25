/**
 * RecursionFun.java
 * 
 * CSc 127B Spring 16
 * 
 * This class contains 17 (out of 21 total) examples/problems of methods that
 * use recursion.
 * 
 * @author Brian Loi
 */

public class RecursionFun {

	// #1 Combinations - finds the number of possible combinations if choosing k
	// from n
	public int combinations(int n, int k) {
		if (k == 1)
			return n;
		if (n == k)
			return 1;

		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// #2 Factorial - multiplies a number by every number preceding it
	public int factorial(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		return n * factorial(n - 1);
	}

	// #3 addReciprocals - takes an integer as a parameter and returns the sum
	// of the first n reciprocals. addReciprocals(n) returns
	// (1.0 + 1.0/2.0 + 1.0/3.0 + ... + 1.0/n).
	public double addReciprocals(int n) {
		double r = n;
		if (n == 1)
			return 1.0;

		return 1 / r + addReciprocals(n - 1);
	}

	// #4 GCD - Finds the greatest common denominator between two integers
	public int GCD(int m, int n) {
		if (n == 0)
			return m;

		return GCD(n, m % n);
	}

	// #5 fibonacci - the sum of the preceding two integers
	public int fibonacci(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;

		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	// #6 Underscore - places an underscore between repeating letters in a
	// string
	public String underScore(String str) {
		if (str.length() == 0)
			return "";

		if (str.length() == 1)
			return str;

		if (str.charAt(0) == str.charAt(1))
			return str.charAt(0) + "_" + underScore(str.substring(1));

		return str.charAt(0) + underScore(str.substring(1));
	}

	// #7 NestParen - Given a string, return true if it is a nesting of zero or
	// more pairs of parenthesis
	public boolean nestParen(String str) {
		if (str.length() == 0)
			return true;

		if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')')
			return nestParen(str.substring(1, str.length() - 1));
		else
			return false;
	}

	// #8 noAdjacents - when given a string, recursively returns a string where
	// adjacent chars that are the same have been reduced to a single char
	public String noAdjacents(String str) {

		if (str.length() == 0)
			return "";

		if (str.length() == 1)
			return str;

		if (str.charAt(0) == str.charAt(1))
			return noAdjacents(str.substring(1));

		return str.charAt(0) + noAdjacents(str.substring(1));
	}

	// #9 convert - returns a string that is the base equivalent num
	public String convert(int num, int base) {

		if (num == 0)
			return "";

		return convert(num / base, base) + num % base;
	}

	// #10 intWithCommas - returns the argument as a String with commas in the
	// correct places
	public String intWithCommas(int n) {
		if (n < 1000)
			return "" + n;

		if (n % 1000 < 10)
			return "" + intWithCommas(n / 1000) + ",00" + n % 1000;

		if (n % 1000 < 100)
			return "" + intWithCommas(n / 1000) + ",0" + n % 1000;

		return "" + intWithCommas(n / 1000) + "," + n % 1000;
	}

	// #11 sumArray - returns the sum of all the int elements in the given range
	// of indexes
	public int sumArray(int[] nums, int beginIndex, int endIndex) {
		if (endIndex < beginIndex)
			return 0;

		if (beginIndex == endIndex)
			return nums[endIndex];

		return nums[beginIndex] + sumArray(nums, beginIndex + 1, endIndex);
	}

	// #12 sumArray - returns the sum of all integers in the given array x
	public int sumArray(int[] nums) {
		return sumArray(nums, 0);
	}

	private int sumArray(int[] nums, int index) {
		if (index == nums.length)
			return 0;

		return nums[index] + sumArray(nums, index + 1);
	}

	// #13 reverseArray - reverses the array elements in a filled array of ints.
	// Use recursion
	public void reverseArray(int[] nums) {
		reverseArray(nums, 0, nums.length - 1);
		return;
	}

	private void reverseArray(int[] nums, int index, int endIdx) {

		if (endIdx < index)
			return;
		else {
			int temp = nums[index];
			nums[index] = nums[endIdx];
			nums[endIdx] = temp;
			reverseArray(nums, index + 1, endIdx - 1);
		}
	}

	// #14 arrayRange - returns the maximum integer minus the minimum integer in
	// the filled array of ints
	public int arrayRange(int[] nums) {
		return arrayRange(nums, 0, nums[0], nums[0]);
	}

	private int arrayRange(int[] nums, int index, int max, int min) {
		if (index == nums.length)
			return max - min;

		if (max < nums[index])
			max = nums[index];
		if (min > nums[index])
			min = nums[index];

		return arrayRange(nums, index + 1, max, min);
	}

	// #15 isSorted - return true if the given array of ints is sorted in
	// ascending order. Return false if not completely sorted
	public boolean isSorted(int[] nums) {
		return isSorted(nums, 0);
	}

	private boolean isSorted(int[] nums, int index) {
		if (nums.length == 0)
			return true;
		if (index == nums.length - 1)
			return true;
		if (nums[index] > nums[index + 1])
			return false;

		return isSorted(nums, index + 1);
	}

	// #16 found - return true if search is found in the array strs. If
	// searchValue is not found, return false.
	public boolean found(String search, String[] strs) {
		return found(search, strs, 0);
	}

	private boolean found(String search, String[] strs, int index) {
		if (index == strs.length)
			return false;
		if (search.equals(strs[index]))
			return true;

		return found(search, strs, index + 1);
	}

	// #17 binarySearch - return the index of the first String that equals
	// searchValue
	public int binarySearch(String searchValue, String[] strings) {
		return binarySearch(searchValue, strings, 0);
	}

	private int binarySearch(String searchValue, String[] strings, int index) {
		if (index == strings.length)
			return -1;

		if (searchValue.equals(strings[index]))
			return index;

		return binarySearch(searchValue, strings, index + 1);
	}
}
