package solutions;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author MChurakkat
 *
 */
public class MaxSub {

	/**
	 * Gets the subsequence of numbers, of length k, that has the largest sum of
	 * elements.
	 * 
	 * @param numbers
	 * @param k
	 * @return
	 */
	public static int[] getMaxSub(int[] numbers, int k) {
		int[] result = new int[k];
		int[] numsCopy = numbers.clone();
		Arrays.sort(numsCopy);
		final int threshold = numsCopy[numsCopy.length - k];
		final int larger = (int) Arrays.stream(numbers)
				.filter(num -> num > threshold).count();
		int equal = k - larger;

		int i = 0;
		for (final int num : numbers)
			if (num > threshold) {
				result[i++] = num;
			} else if (num == threshold && equal > 0) {
				result[i++] = num;
				--equal;
			}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int n = 0;
		int numbers[] = null;
		int k = 0;
		try {

			System.out.println("Enter number of array elements: ");
			n = s.nextInt();
			numbers = new int[n];

			System.out.println("Enter array elements");
			for (int i = 0; i < n; i++) {
				numbers[i] = s.nextInt();
			}

			System.out.println("Enter subsequence length: ");
			k = s.nextInt();

			int[] result = getMaxSub(numbers, k);

			System.out.println("\nInput Array:\n" + Arrays.toString(numbers));
			System.out.println("Subsequence of length " + k
					+ " with largest sum of elements:\n"
					+ Arrays.toString(result));

		} catch (NegativeArraySizeException exception) {
			System.out
					.println("Please enter a positive integer for array size");
		} catch (InputMismatchException exception) {
			System.out.println("Please enter an integer");
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

	}
}
