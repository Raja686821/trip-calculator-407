import java.util.ArrayList;
import java.util.List;

public class Location {
	private final int id;
	private final String name;
	private final Double lat;
	private final Double lng;

	private final List<Route> to_routes;

	public Location(String id, String name, Double lat, Double lng) {
		this.id = Integer.parseInt(id);
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.to_routes = new ArrayList<>();
	}

	public void addRoute(Route route) {
		to_routes.add(route);
	}

	public List<Route> getRoutes() {
		return to_routes;
	}

	public String getName() {
		return name;
	}
}
