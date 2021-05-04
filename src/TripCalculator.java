import java.util.Scanner;

public class TripCalculator {
	public static void main(String[] args) {

		TollCalculator calc;
		// Using Scanner for Getting Input from User
		Scanner in = new Scanner(System.in);
		try {
			 calc = new TollCalculator();
		} catch (Exception e) {
			System.out.println("Exception while reading the Json file:" + e);
			return;
		}

		boolean run = true;
		while(run) {
			System.out.println("Enter the from location name:");
			String fromLocation = in.nextLine();

			System.out.println("Enter the to location name:");
			String toLocation = in.nextLine();

			try {
				Trip t = calc.costOfTrip(fromLocation, toLocation);

				if (t.distance == 0) {
					System.out.println("Could not find the route or distance is zero");
				} else {
					System.out.println("Distance: " + t.distance);
					System.out.println("Cost: $" + t.cost);
				}
			} catch (LocationNotFoundException e) {
				System.out.println(e.getMessage());
			}

			System.out.println("Do you want to calculate the cost for another route: (Y/N)");
			run = in.nextLine().equalsIgnoreCase("Y");

		}
	}
}
