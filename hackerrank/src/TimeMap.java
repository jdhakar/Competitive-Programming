import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class TimeMap {

	class Node {
		public String k;
		public int i;
		public int getI(){
			return i;
		}
		Node(String k_, int i_){
			k=k_;
			i=i_;
		}
	}

	Map<String, ArrayList<Node>> map;
	/** Initialize your data structure here. */
	public TimeMap() {
		map=new HashMap<String, ArrayList<Node>>();
	}

	public void set(String key, String value, int timestamp) {
		if(!map.containsKey(key)){
			ArrayList<Node> list = new ArrayList<Node>();
			map.put(key, list);
		}
		ArrayList<Node> l1=map.get(key);
		int k = Collections.binarySearch(l1, new Node("", timestamp), Comparator.comparing(Node::getI));
		if(k>=0) {
			l1.get(k).k=value;
		} else {
			k=-1-k;
			l1.add(k, new Node(value, timestamp));
		}

	}

	public String get(String key, int timestamp) {
		if(!map.containsKey(key)){
			return "";
		} else {
			ArrayList<Node> l1=map.get(key);
			int k = Collections.binarySearch(l1, new Node("", timestamp), Comparator.comparing(Node::getI));
			if(k>=0) {
				return l1.get(k).k;
			} else {
				k=-1-k;
				if(k==0) {
					return "";
				} else {
					return l1.get(k-1).k;
				}
			}
		}
	}
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */