package sjsu.ma.cs146.project4;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testGraph() {
		fail("Not yet implemented");
	}

	@Test
	public void testPopulateGraph() {
		fail("Not yet implemented");
	}

	@Test
	public void testMyRandom() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerateMaze() {
		fail("Not yet implemented");
	}
	
	/*
	 * test vertex constructor
	 */
	@Test
	public void testVertex(){
		Graph g = new Graph(4);
		int label = 3;
		Graph.Vertex v = g.new Vertex(label);
		assertEquals(label, v.label);		
	}
	
	/*
	 * test vertex's allWallsIntact() method
	 */
	@Test
	public void testAllWallsIntact(){
		Graph g = new Graph(4);
		int label = 3;
		Graph.Vertex v = g.new Vertex(label);
		assertEquals(true, v.allWallsIntact());
		
		Graph gr = new Graph(4);
		int labelr = 3;
		Graph.Vertex vr = gr.new Vertex(labelr);
		vr.breakDownWall();
		assertEquals(false, vr.allWallsIntact());
	}
	
	/*
	 * test vertex's setAllWallsIntact() method
	 */
	@Test
	public void testSetAllWallsIntact(){
		Graph g = new Graph(4);
		int label = 3;
		Graph.Vertex v = g.new Vertex(label);
		assertEquals(true, v.allWallsIntact());
		v.breakDownWall();
		v.breakRightWall();
		assertEquals(false, v.allWallsIntact());
		v.setAllWallsIntact();
		assertEquals(true, v.allWallsIntact());
	}
	
	/*
	 * test vertex's set() methods
	 */
	@Test
	public void testSetMethods(){
		Graph g = new Graph(4);
		int label = 5;
		int labelr = 6;
		Graph.Vertex v = g.new Vertex(label);
		Graph.Vertex vr = g.new Vertex(labelr);
		Graph.Vertex vra = g.new Vertex(3);
		Graph.Vertex vrab = g.new Vertex(8);
		Graph.Vertex vrac = g.new Vertex(9);
		
		assertEquals(null,v.getRight());
		v.setRight(vr);
		assertEquals(vr, v.getRight());
		
		assertEquals(null,v.getLeft());
		v.setLeft(vra);
		assertEquals(vra, v.getLeft());
		
		assertEquals(null,v.getUp());
		v.setUp(vrab);
		assertEquals(vrab, v.getUp());
		
		assertEquals(null,v.getDown());
		v.setDown(vrac);
		assertEquals(vrac, v.getDown());
	}
	
	@Test
	public void testVertexRelationship(){
		Graph g = new Graph(4);
		int label = 5;
		int labelr = 6;
		Graph.Vertex v = g.new Vertex(label);
		Graph.Vertex vr = g.new Vertex(labelr);
		v.setRight(vr);
		int r = v.vertexRelationship(vr);
		assertEquals(1, r);
		
		int l = 7;
		Graph.Vertex vl = g.new Vertex(l);
		v.setLeft(vl);
		int rl = v.vertexRelationship(vl);
		assertEquals(3, rl);
		
		int u = 8;
		Graph.Vertex vu = g.new Vertex(u);
		v.setUp(vu);
		int r2 = v.vertexRelationship(vu);
		assertEquals(0, r2);
		
		int d = 9;
		Graph.Vertex vd = g.new Vertex(d);
		v.setDown(vd);
		int r3 = v.vertexRelationship(vd);
		assertEquals(2, r3);
	}
	
	@Test 
	public void testNeighbors() 
	{
		Graph g = new Graph(4); 
		g.populateGraph();
		Graph.Vertex v = g.vertexList[0][0]; 
		String neighbor = "";
		
		for(Graph.Vertex v1 : v.neighbors)
		{
			if(v1 != null)
				neighbor += v1.label;
		}
		
		assertEquals("25", neighbor);
	}

@Test 
	public void testPrintGraph()
	{
		Graph g = new Graph(6); 
		g.populateGraph();
		
		String before = g.printGrid();
		g.generateMaze();
		String after = g.printGrid();
		
		System.out.println(before);
		System.out.println(after);
		assertNotEquals(before, after);
		
		/*
		 * PROBLEM
		 * when we do something to the wall of each vertex, the other side of the wall doesn't know about it
		 * when we manipulate walls, we should have some extra steps
		 */
	}

}


