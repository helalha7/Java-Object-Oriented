package graph;

import java.util.*;

public class Graph<V> {
	//to save the vertices of the graph
	private Set<V> vertices;
	//to save the neighbours of the vertices
	private Map<V, Set<V>> edges;
	//used in connected to know which vertices already checked
	private Set<V> checked = new HashSet<>();

	//to init the graph
	public Graph() {
		vertices = new HashSet<>();
		edges = new HashMap<>();
	}

	//to add a vertex to the graph
	public void addVertex(V v) throws GraphException {
		if (vertices.contains(v))
			throw new GraphException("this vertex is already in the graph");
		vertices.add(v);
		edges.put(v, new HashSet<>());
	}

	//to add edge between two vertices in the graph
	public void addEdge(V v1, V v2) throws GraphException {
		if (!(vertices.contains(v1)) || !(vertices.contains(v2)))
			throw new GraphException("one or two of the vertices is not in the graph");
		if (hasEdge(v1, v2))
			throw new GraphException("the edge is already in the graph");
		edges.get(v1).add(v2);
		edges.get(v2).add(v1);

	}

	//checks if there is an edge between v1 and v2
	public boolean hasEdge(V v1, V v2) {
		if (vertices.contains(v1) && vertices.contains(v2)) {
			if (edges.get(v1).contains(v2))
				return true;
			return false;
		}
		return false;
	}

	//checks if there is a way from v1 to v2 in the graph
	public boolean connected(V v1, V v2) throws GraphException {
		if (!(vertices.contains(v1)) || !(vertices.contains(v2)))
			throw new GraphException("one or two of the vertices is not in the graph");
		if (v1.equals(v2))
			return true;
		checked.add(v1);
		for (V v : edges.get(v1)) {
			if (!(checked.contains(v))) {
				if (connected(v, v2)) {
					checked = new HashSet<>();
					return true;
				}
			}
		}
		return false;
	}
}
