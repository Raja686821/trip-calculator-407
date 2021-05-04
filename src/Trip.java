public class Trip {
	Double cost;
	Double distance;

	public Trip(Double distance) {
		this.cost = 0.25 * distance;
		this.distance = distance;
	}
}
