package graph;

import java.util.*;

public class ConnectionChecker<V> {
	// to save the graph
	private GraphInterface<V> g;
	// to save the checked vertices while running the function check
	private List<V> checked = new ArrayList<>();

	// normal constructor to init graph
	public ConnectionChecker(GraphInterface<V> g) {
		this.g = g;
	}

	// this function is to check if there is a way between v1 and v2 in a graph
	public boolean check(V v1, V v2) {
		if (v1.equals(v2))
			return true;
		checked.add(v1);
		for (V v : g.neighbours(v1)) {
			if (!(checked.contains(v))) {
				if (check(v, v2)) {
					checked = new ArrayList<>();
					return true;
				}
			}
		}
		return false;
	}

}
