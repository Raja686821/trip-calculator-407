import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class TollCalculator {
	Map<Long, Location> location_by_id = new HashMap<>();
	Map<String, Long> location_id_by_name = new HashMap<>();
	public TollCalculator() throws Exception {
		Object obj = new JSONParser().parse(new FileReader("resources/interchanges.json"));

		JSONObject jo = (JSONObject) obj;

		Map locations = (Map) jo.get("locations");
		Iterator<Map.Entry> itr = locations.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry pair = itr.next();
			Map temp = (Map) pair.getValue();
			Location l = new Location((String) pair.getKey(), (String) temp.get("name"), (Double)temp.get("lat"), (Double) temp.get("lng"));

			JSONArray routes = (JSONArray) temp.get("routes");

			for(Object r : routes) {
				Map route = (Map) r;
				l.addRoute(new Route((Long)route.get("toId"), ((Number)route.get("distance")).doubleValue()));
			}
			location_by_id.put(Long.parseLong((String) pair.getKey()), l);
			location_id_by_name.put(l.getName(), Long.parseLong((String) pair.getKey()));
		}
	}

	public Trip costOfTrip(String fromName, String toName) throws LocationNotFoundException{
		if (!location_id_by_name.containsKey(fromName)) {
			throw new LocationNotFoundException("Incorrect Location: " + fromName);
		}

		if (!location_id_by_name.containsKey(toName)) {
			throw new LocationNotFoundException("Incorrect Location: " + toName);
		}

		if (fromName.equals(toName)) return new Trip((double) 0);

		return new Trip(findRecursive(location_id_by_name.get(fromName), location_id_by_name.get(toName), 0, new HashSet<>()));

	}

	private double findRecursive(long fromId, long toId, double distance, Set<Long> visited) {
		for (Route r : location_by_id.get(fromId).getRoutes()) {
			if (r.toId == toId) return distance + r.distance;
			if (visited.contains(r.toId) || !location_by_id.containsKey(r.toId)) return 0;
			visited.add(r.toId);
			return findRecursive(r.toId, toId, distance + r.distance, visited);
		}
		return 0;
	}
}
