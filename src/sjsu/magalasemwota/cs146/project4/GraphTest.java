package sjsu.magalasemwota.cs146.project4;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {

	
	@Test
	public void testCompare4By4(){
		Graph g = new Graph(4);
		g.generateMaze();
		String grid = g.printGrid(); //print empty maze
		System.out.println("Graph Size: 4");
		System.out.println("MAZE : "+ "\n" + grid);
		
		g.DFS(g.vertexList[0][0]);
		String aGrid = g.printGrid1();
		System.out.println("DFS: " + "\n" + aGrid);
		
		g.setPath();
		String dGrid = g.printGrid2(); //DFS with hashes 
		System.out.println(dGrid);
		
		Graph g1 = new Graph(4);
		g1.generateMaze();
		g1.BFS(g1.vertexList[0][0]);
		String bGrid = g1.printGrid1();
		System.out.println("BFS: " + "\n" + bGrid);
		
		g1.setPath();
		String cGrid = g1.printGrid2(); //BFS with hashes
		System.out.println(cGrid);
		
		assertEquals(dGrid, cGrid); //compare hash solution of BFS and DFS
		
		System.out.println("====================== " + "\n" + "  Program Completed! " + "\n" + "======================");
	}
	
	@Test
	public void testCompare5By5(){
		Graph g = new Graph(5);
		g.generateMaze();
		String grid = g.printGrid(); //print empty maze
		System.out.println("Graph Size: 5");
		System.out.println("MAZE : "+ "\n" + grid);
		
		g.DFS(g.vertexList[0][0]);
		String aGrid = g.printGrid1();
		System.out.println("DFS: " + "\n" + aGrid);
		
		g.setPath();
		String dGrid = g.printGrid2(); //DFS with hashes 
		System.out.println(dGrid);
		
		Graph g1 = new Graph(5);
		g1.generateMaze();
		g1.BFS(g1.vertexList[0][0]);
		String bGrid = g1.printGrid1();
		System.out.println("BFS: " + "\n" + bGrid);
		
		g1.setPath();
		String cGrid = g1.printGrid2(); //BFS with hashes
		System.out.println(cGrid);
		
		assertEquals(dGrid, cGrid); //compare hash solution of BFS and DFS
		
		System.out.println("====================== " + "\n" + "  Program Completed! " + "\n" + "======================");
	}
	
	
	@Test
	public void testCompare6By6(){
		Graph g = new Graph(6);
		g.generateMaze();
		String grid = g.printGrid(); //print empty maze
		System.out.println("Graph Size: 6");
		System.out.println("MAZE : "+ "\n" + grid);
		
		g.DFS(g.vertexList[0][0]);
		String aGrid = g.printGrid1();
		System.out.println("DFS: " + "\n" + aGrid);
		
		g.setPath();
		String dGrid = g.printGrid2(); //DFS with hashes 
		System.out.println(dGrid);
		
		Graph g1 = new Graph(6);
		g1.generateMaze();
		g1.BFS(g1.vertexList[0][0]);
		String bGrid = g1.printGrid1();
		System.out.println("BFS: " + "\n" + bGrid);
		
		g1.setPath();
		String cGrid = g1.printGrid2(); //BFS with hashes
		System.out.println(cGrid);
		
		assertEquals(dGrid, cGrid); //compare hash solution of BFS and DFS
		
		System.out.println("====================== " + "\n" + "  Program Completed! " + "\n" + "======================");
	}
	
	@Test
	public void testCompare7By7(){
		Graph g = new Graph(7);
		g.generateMaze();
		String grid = g.printGrid(); //print empty maze
		System.out.println("Graph Size: 7");
		System.out.println("MAZE : "+ "\n" + grid);
		
		g.DFS(g.vertexList[0][0]);
		String aGrid = g.printGrid1();
		System.out.println("DFS: " + "\n" + aGrid);
		
		g.setPath();
		String dGrid = g.printGrid2(); //DFS with hashes 
		System.out.println(dGrid);
		
		Graph g1 = new Graph(7);
		g1.generateMaze();
		g1.BFS(g1.vertexList[0][0]);
		String bGrid = g1.printGrid1();
		System.out.println("BFS: " + "\n" + bGrid);
		
		g1.setPath();
		String cGrid = g1.printGrid2(); //BFS with hashes
		System.out.println(cGrid);
		
		assertEquals(dGrid, cGrid); //compare hash solution of BFS and DFS
		
		System.out.println("====================== " + "\n" + "  Program Completed! " + "\n" + "======================");
	}
	
	@Test
	public void testCompare8By8(){
		Graph g = new Graph(8);
		g.generateMaze();
		String grid = g.printGrid(); //print empty maze
		System.out.println("Graph Size: 8");
		System.out.println("MAZE : "+ "\n" + grid);
		
		g.DFS(g.vertexList[0][0]);
		String aGrid = g.printGrid1();
		System.out.println("DFS: " + "\n" + aGrid);
		
		g.setPath();
		String dGrid = g.printGrid2(); //DFS with hashes 
		System.out.println(dGrid);
		
		Graph g1 = new Graph(8);
		g1.generateMaze();
		g1.BFS(g1.vertexList[0][0]);
		String bGrid = g1.printGrid1();
		System.out.println("BFS: " + "\n" + bGrid);
		
		g1.setPath();
		String cGrid = g1.printGrid2(); //BFS with hashes
		System.out.println(cGrid);
		
		assertEquals(dGrid, cGrid); //compare hash solution of BFS and DFS
		
		System.out.println("====================== " + "\n" + "  Program Completed! " + "\n" + "======================");
	}	
	
	@Test
	public void testCompare10By10(){
		Graph g = new Graph(10);
		g.generateMaze();
		String grid = g.printGrid(); //print empty maze
		System.out.println("Graph Size: 10");
		System.out.println("MAZE : "+ "\n" + grid);
		
		g.DFS(g.vertexList[0][0]);
		String aGrid = g.printGrid1();
		System.out.println("DFS: " + "\n" + aGrid);
		
		g.setPath();
		String dGrid = g.printGrid2(); //DFS with hashes 
		System.out.println(dGrid);
		
		Graph g1 = new Graph(10);
		g1.generateMaze();
		g1.BFS(g1.vertexList[0][0]);
		String bGrid = g1.printGrid1();
		System.out.println("BFS: " + "\n" + bGrid);
		
		g1.setPath();
		String cGrid = g1.printGrid2(); //BFS with hashes
		System.out.println(cGrid);
		
		assertEquals(dGrid, cGrid); //compare hash solution of BFS and DFS
		
		System.out.println("====================== " + "\n" + "  Program Completed! " + "\n" + "======================");
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
	
	/*
	 * test Vertex's vertexRelationship method 
	 */
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
	public void testPrintGraph()
	{
		Graph g = new Graph(4); 
		g.populateGraph();
		
		String before = g.printGrid();
		g.generateMaze();
		Graph.Vertex v = g.vertexList[1][1]; 
		v.breakDownWall();
		String after = g.printGrid();
		
		assertNotEquals(before, after);
		
	}

	@Test
	public void testNeighbors(){
		Graph g = new Graph(4); 
		g.populateGraph();
		Graph.Vertex v = g.vertexList[0][0];
		String neighbor = "";
		for (Graph.Vertex v1 : v.neighbors){
			if (v1 != null)
				neighbor += v1.label;
		}
		assertEquals("25", neighbor);
	}
	
}
