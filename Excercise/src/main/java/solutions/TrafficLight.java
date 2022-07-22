package solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author MChurakkat
 *
 */
public class TrafficLight {

	/**
	 * Determines the color of the traffic light at time enteredTimeInMinutes
	 * 
	 * @param enteredTime
	 * @return
	 */
	public static String getTrafficLightAtTime(int enteredTimeInMinutes) {

		int colorTime = enteredTimeInMinutes % 5;

		if (colorTime >= 0 && colorTime < 3) {
			return "Green";
		} else if (colorTime >= 3 && colorTime < 5) {
			return "Red";
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		try {

			System.out.println("Enter time (in mins):");
			int enteredTimeInMinutes = s.nextInt();

			String color = getTrafficLightAtTime(enteredTimeInMinutes);
			System.out.println("\n The traffic light color at " + enteredTimeInMinutes
					+ " minutes is " + color);
		} catch (InputMismatchException exception) {
			System.out.println("Please enter a number ");
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}
