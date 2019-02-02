import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap2 {

	// <key, <time, value>>
	private HashMap<String, TreeMap<Integer, String>> keyToSortedTimeValue = new HashMap<>();

	public TimeMap2() {
	}

	public void set(String key, String value, int timestamp) {
		TreeMap<Integer, String> tm = keyToSortedTimeValue.get(key);
		if (tm == null) {
			keyToSortedTimeValue.put(key, tm = new TreeMap<>());
		}
		tm.put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		TreeMap<Integer, String> tm = keyToSortedTimeValue.get(key);
		if (tm == null) {
			return "";
		}

		Map.Entry<Integer, String> e = tm.floorEntry(timestamp);
		if (e == null) {
			return "";
		}

		return e.getValue();
	}
}
