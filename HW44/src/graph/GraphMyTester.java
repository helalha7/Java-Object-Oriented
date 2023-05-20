package graph;

public class GraphMyTester {

	public static void main(String[] args) throws GraphException {
		Maze m = new Maze(4, 0, 0, 3, 3);
		m.addWall(1, 1);
		m.addWall(3, 1);
		m.addWall(0, 1);
		m.addWall(2, 3);
		m.addWall(2, 3);
		m.addWall(1, 3);
		System.out.println(m);
		Graph<Integer> g = new Graph<>();
		for (int i = 0; i < 100; i++)
			g.addVertex(i);
		for (int i = 0; i < 50; i++)
			g.addEdge(i, i+1);
		System.out.println(g.connected(1, 3));
		System.out.println(g.connected(3, 60));


	}

}
