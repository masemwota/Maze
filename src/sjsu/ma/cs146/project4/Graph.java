package sjsu.ma.cs146.project4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * Maze Generator and Solver
 *
 * This program generates and solves mazes. It will generate a new random maze
 * and solve it. It solves it using depth-first search and breadth-first search
 *
 * @author Marietta Asemwota
 * @author Monsi Magal
 *
 */

public class Graph {

    /**
     * A class to hold a single cell or room Each vertex will know its immediate
     * neghbors
     *
     * @author Marietta
     *
     */
    class Vertex {
        public int label; // to hold the name / number of the vertex
        Vertex[] neighbors; //array of neighbors
        int[] walls;
        int color; //white (0) , grey(1) , black(2)
        Vertex pi; //parent
        int startTime;  //when vertex is first found = when it turns grey
        int endTime; //when it turns black 
        int distance;
        
		/*
		 * array of walls. -1 representing edge of maze, 0 broken wall (no wall), and 1 intact wall , and 4 representing entry and exit
		 */


        public Vertex(int lab) {
            label = lab;
			/* 
			 * index correspondance for neighbors 
			 * 0 = up 
			 * 1 = right
			 * 2 = down
			 * 3 = left
			 */
            neighbors = new Vertex[4];
            walls = new int[4];
			/*
			 * index correspondance for walls
			 * 0 = up wall
			 * 1 = right wall
			 * 2 = down wall
			 * 3 = left wall 
			 */
            setAllWallsIntact();
            
           // color = 0; 
            pi = null;
            startTime = Integer.MAX_VALUE;
            endTime = Integer.MAX_VALUE;
            distance = 0;
            }

        public boolean allWallsIntact(){
            for (int i = 0; i < walls.length; i++){
                if (walls[i] == 0) {
                    return false;
                }
            }
            return true;
        }

        public void setAllWallsIntact(){
            for (int i = 0; i < walls.length; i++){
                walls[i] = 1;
            }
        }

        public void breakUpWall(){
            if (walls[0] != -1) walls[0] = 0;
        }

        public void breakRightWall(){
            if (walls[1] != -1) walls[1] = 0;
        }

        public void breakDownWall(){
            if (walls[2] != -1) walls[2] = 0;
        }

        public void breakLeftWall(){
            if (walls[3] != -1) walls[3] = 0;
        }
        public void setLeft(Vertex v){
            neighbors[3] = v;
        }
        public void setRight(Vertex v){
            neighbors[1] = v;
        }
        public void setUp(Vertex v){
            neighbors[0] = v;
        }
        public void setDown(Vertex v){
            neighbors[2] = v;
        }
        public Vertex getLeft(){
            return this.neighbors[3];
        }
        public Vertex getRight(){
            return this.neighbors[1];
        }
        public Vertex getUp(){
            return this.neighbors[0];
        }
        public Vertex getDown(){
            return this.neighbors[2];
        }

        public int vertexRelationship(Vertex v){
            if(getUp() != null && getUp().equals(v)){
                return 0;
            } else if (getRight() != null && getRight().equals(v)){
                return 1;
            } else if (getDown() != null && getDown().equals(v)){
                return 2;
            } else { //if (getLeft().equals(v)){
                return 3;
            }
        }

       
        public void printWalls(){
            for (int i = 0; i < walls.length; i++){
                System.out.println(walls[i]);
            }
        }

    }

    Vertex vertexList[][];
    int amountVertices;
    int dimension; //dimensions
    private Random myRandGen; // random number generator
    private Vertex startVertex;
    private Vertex endVertex;
    int time;

    /**
     * Constructor for this program takes in the dimensions of the maze It also
     * makes the seed of the random generator 0 for easier testing
     *
     * *** calls method to fill the graph with n*n rooms
     *
     * @param dimension_in as number of rows and columns
     */

    public Graph(int dimension_in) {
        vertexList = new Vertex[dimension_in][dimension_in];
        //for simplicity of naming vertices, r keeps track of what "row" the vertex is being created in
        int r = 1;
        for (int i=0; i < dimension_in; i++) {
            for (int j=0; j < dimension_in; j++) {
                vertexList[i][j] = new Vertex(i + r + j);
            }
            //r increases by a function of the length of the column
            r += dimension_in - 1;
        }

        dimension = dimension_in;
        amountVertices = dimension * dimension;
        myRandGen = new java.util.Random(0);	//seed	is	0
        startVertex = vertexList[0][0];	//set startVertex to top left
        
        endVertex = vertexList[dimension-1][dimension-1];	//set endVertex to bottom right
        
        populateGraph();
    }
    
    public void DFS_Visit(Vertex u)
    {
    	u.color = 1; //color = grey 
    	time++; 
    	u.startTime = time; 
    	
    	for(int i = 0; i < u.neighbors.length; i++)
    	{
    		Vertex v = u.neighbors[i]; 
    		int direction = u.vertexRelationship(v); //rel between u and v
    		if((v != null) && v.color == 0 && (u.walls[direction] == 0))
    		{
    			v.pi = u; 
    			DFS_Visit(v); 
    		}
    	}
    	
    	u.color = 2; 
    	time++; 
    	u.endTime = time;
    }
    
    public void DFS () 
    {
//    	for(int i = 0; i < dimension; i++) 
//    	{
//    		for(int j = 0; j < dimension; j++)
//    		{
//    			vertexList[i][j].color = 0; //color = white
//    		}
//    	}
    	graphReset(); 
    	time = 0; 
    	
    	for(int i = 0; i < dimension; i++) 
    	{
    		for(int j = 0; j < dimension; j++)
    		{
    			if(vertexList[i][j].color == 0) //color = white
    			{
    				DFS_Visit(vertexList[i][j]);
    			}
    		}
    	}

    }
    
   
    public void graphReset() 
    {
    	populateGraph();
    	for(int i = 0; i < dimension; i++) 
    	{
    		for(int j = 0; j < dimension; j++)
    		{
    			//makes all the vertices in the vertexList = white 
    			vertexList[i][j].color = 0;
    			//make all the parents to null
    			vertexList[i][j].pi = null;
    			vertexList[i][j].startTime = Integer.MAX_VALUE; 
    			vertexList[i][j].endTime = Integer.MAX_VALUE;
    		}
    	}
    	
    	startVertex.walls[0] = 4; 
        endVertex.walls[2] = 4;
    }
    
    public void BFS(Vertex s) 
    {
    	//graphReset(); 
    	//generateMaze(); 
    	
    	Queue<Vertex> q = new LinkedList<>(); 
    	q.add(s);
    	while(!q.isEmpty())
    	{
    		System.out.println("Inside while");
    		Vertex u = q.remove(); //vertex A 
    		for(int i = 0; i < u.neighbors.length; i++) 
    		{
    			Vertex v = u.neighbors[i]; //vertex B
				int direction = u.vertexRelationship(v);
				System.out.println("direction: " + direction);
				System.out.println("label: " + u.label);

				if ((v != null) && (v.color == 0) && (u.walls[direction] == 0)) //if color is white
				{
					System.out.println("Inside the if statement");
					v.color = 1;
					v.distance = u.distance + 1; // check added
					v.pi = u;
					q.add(v);
				}
    		
    		}
    		u.color = 2; 
    	}
    }
    
    
    /*
     * populates graph to the dimension provided in the constructor of graph
     */
    public void populateGraph() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                Vertex mine = vertexList[i][j];

                if (i == 0){
                    mine.setUp(null);
                    mine.walls[0] = -1; //edge wall
                }

                else {
                    mine.setUp(vertexList[i - 1][j]);
                    mine.neighbors[0] = vertexList[i-1][j];
                }

                if (j == 0) {
                    mine.setLeft(null);
                    mine.walls[3] = -1;
                }

                else {
                    mine.setLeft(vertexList[i][j - 1]);
                    mine.neighbors[3] = vertexList[i][j - 1];
                }

                if (i == dimension-1) {
                    mine.setDown(null);
                    mine.walls[2] = -1;
                }

                else {
                    mine.setDown(vertexList[i + 1][j]);
                    mine.neighbors[2] = vertexList[i + 1][j];
                }

                if (j == dimension-1) {
                    mine.setRight(null);
                    mine.walls[1] = -1;
                }

                else {
                    mine.setRight(vertexList[i][j + 1]);
                    mine.neighbors[1] = vertexList[i][j + 1];
                }
            }
        }
        
        //startVertex.walls[0] = 0; 
       // endVertex.walls[2] = 0;
    }

    /**
     * Get a random number
     *
     * @return random double between 0 and 1
     */
    double myRandom() {
        return myRandGen.nextDouble();
    }

    void generateMaze(){
		/*
		 * 
		create a CellStack (LIFO) to hold a list of cell locations
		set TotalCells= number of cells in grid
		choose the starting cell and call it CurrentCell
		set VisitedCells = 1
		while VisitedCells < TotalCells
			find all neighbors of CurrentCell with all walls intact
			if one or more found choose one at random
				knock down the wall between it and CurrentCell
				push CurrentCell location on the CellStack
				make the new cell CurrentCell
				add 1 to VisitedCells
			else
				pop the most recent cell entry off the CellStack
				make it CurrentCell
		 */

    	//startVertex.walls[0] = -1; 
        //endVertex.walls[2] = -1;
    	//make the up wall of start vertex = 4
    	startVertex.walls[0] = 4; 
    	//make the down wall of end vertex = 4
    	endVertex.walls[2] = 4;
        
        Stack<Vertex> cellStack = new Stack<>();
        int totalCells = amountVertices;
        Vertex currentCell = vertexList[0][0];
        int visitedCells = 1;
        while(visitedCells < totalCells){
            //Vertex neighborsIntact[] = new Vertex[4];
            ArrayList<Vertex> neighborsIntact = new ArrayList<Vertex>();
            //	int index = 0;	//index of neighborsIntact[]
            //for loop goes through all the neighbors
            //System.out.println("size of currentCell.neighbors " +  currentCell.neighbors.length);
            for (int i = 0; i < currentCell.neighbors.length; i++){
                Vertex neighbor = currentCell.neighbors[i];
//				System.out.println("printing neighbors");
//				for (int j = 0; j < currentCell.neighbors.length; j++){
//					if (currentCell.neighbors[j] != null)
//						System.out.println(currentCell.neighbors[j].label);
//				}
                if(neighbor != null) {
                    if(neighbor.allWallsIntact()) {
                       // System.out.println("NEIGHBOR ADDING PRINT WALLS " + neighbor.label);
                        //neighbor.printWalls();
                       // System.out.println("adding wall");
                        neighborsIntact.add(neighbor);
                    }
                }
            }
            //if one or more walls
            if (neighborsIntact.size() != 0){
               // System.out.println("current cell: " + currentCell.label);
               // System.out.println("size " + neighborsIntact.size());
               // System.out.print("Neighbors: ");
//                for (Vertex v : neighborsIntact) {
//                    System.out.print(v.label + ",");
//                }
//                System.out.println();
                //rand tells you which vertex you are knocking down a wall between
                int rand = (int)(myRandom()*neighborsIntact.size());
                Vertex knockDown = neighborsIntact.get(rand);
               // System.out.println("knockDown " + knockDown.label);
                int relationship = currentCell.vertexRelationship(knockDown); //finds relationship between current and knockDown
                if (relationship == 0) {//knockDown is above currentCell
                  //  System.out.println("relationship 0");
                    currentCell.breakUpWall();
                    knockDown.breakDownWall();
                } else if (relationship == 1) { //knockDown is to the right of currentCell
                  //  System.out.println("relationship 1");
                    currentCell.breakRightWall();
                    knockDown.breakLeftWall();
                } else if (relationship == 2) { //knockDown is below currentCell
                 //   System.out.println("relationship 2");
                    currentCell.breakDownWall();
                  //  System.out.println("CC walls");
                  //  currentCell.printWalls();
                  //  System.out.println("knock walls");
                    knockDown.breakUpWall();
                  //  knockDown.printWalls();
                } else {	//knockDown is to the left of currentCell
                  //  System.out.println("relationship 3");
                    currentCell.breakLeftWall();
                    knockDown.breakRightWall();
                }
                //push CurrentCell location on the CellStack
                cellStack.push(currentCell);
//                System.out.println(cellStack.peek().label);
//                String location = findLocation(knockDown);
//                String row = location.substring(0, 1);
//                String col = location.substring(1, 2);
//                int r = Integer.parseInt(row);
//                int c = Integer.parseInt(col);
//                vertexList[r][c] = knockDown;
//
//                String location1 = findLocation(currentCell);
//                String row1 = location1.substring(0, 1);
//                String col1 = location1.substring(1, 2);
//                int r1 = Integer.parseInt(row1);
//                int c1 = Integer.parseInt(col);
//                vertexList[r1][c1] = currentCell;

                //make the new cell CurrentCell
                currentCell = knockDown;
               // System.out.println(currentCell.label);
                //add 1 to VisitedCells
                visitedCells++;
               // System.out.println("knock down walls that are left after");
               // knockDown.printWalls();
               // System.out.println("printing vertexList walls SHOULD BE SAME");	//is not the same, knockDown has it properly knocked down but [1][0] is not knocked down. pointers??
                //vertexList[1][0].printWalls();
               // System.out.println("***");
               // currentCell.printWalls();
            } else {
                currentCell = cellStack.pop();
            }
        }
    }

    public String findLocation(Vertex v){
        String toReturn = "";
        for (int i = 0; i < vertexList.length; i++){
            for (int j = 0; j < vertexList.length; j++){
                if (v.label == vertexList[i][j].label){
                    toReturn += Integer.toString(i) + Integer.toString(j);
                }
            }
        }
        return toReturn;
    }

    /*
     * Slightly more complicated in order to print the grid in a way that makes it easy to read
     * Prints all the top walls, the left and right, and the bottom row
     */
    public String printGrid()
    {
        String grid = "";
        //first print the top layer

        int n = 2;
        for(int i = 0; i < dimension; i++)
        {
            if(i == dimension-1)
                n = 3;
            for(int layer = 1; layer <= n; layer++) {
                //layer represents the layers of a cell: up, left/right, and down
                //top layer already printed; for the rest, print sides and bottom
                //1 = top
                //2 = left and right
                //3 = bottom

                if(layer == 1) {
                    grid += "+";
                }

                if(layer == 2) {
                    grid += "|";
                }

                if((layer == 3)&&(i == dimension-1)) {
                    grid += "+";
                }

                for(int j = 0; j < dimension; j++) {
                    Vertex v = vertexList[i][j];

                    //prints according to the layer
                    //layer one --> print up
                    if (layer == 1) {
                        if((v.walls[0] != 0) && (v.walls[0] != 4)) //if -1, edge wall; if 1, inner wall, 0 is broken wall
                            grid += "-";
                        else
                            grid += " ";

                        grid += "+";
                    }

                    //layer two --> print left/right and label
                    else if(layer == 2){
//						if(v.walls[3] != 0) //if there is a left wall - 3
//							grid += "|";
//						else
//							grid += " ";

                        //print label
                        //grid += v.label;

                        //don't print label
                    	//grid += (v.label);
                        //grid += " ";
                    	
                    	//printing start times 
                    	if(v.startTime >= 1000)
                    		grid += " ";
                    	else 
                    		grid += (v.startTime % 10);

                    	
                    	//walls
                        if(v.walls[1] != 0) //right wall is 1
                            grid += "|";
                        else
                            grid += " ";
                    }

                    //layer three --> print bottom layer
                    else if((layer == 3) && (i == dimension-1)) {
                        //down wall
                        //if there is an down wall, include symbol
                        //grid += "+";

                        if((v.walls[2] != 0) && (v.walls[2] != 4)) //if -1, edge wall; if 1, inner wall, 0 is broken wall
                            grid += "-";
                        else
                            grid += " ";

                        grid += "+";

                    }

                    //grid += "\n";
                }
                grid += "\n";
            }
        }

        return grid;
    }


    public String printBGrid()
    {
        String grid = "";
        //first print the top layer

        int n = 2;
        for(int i = 0; i < dimension; i++)
        {
            if(i == dimension-1)
                n = 3;
            for(int layer = 1; layer <= n; layer++) {
                //layer represents the layers of a cell: up, left/right, and down
                //top layer already printed; for the rest, print sides and bottom
                //1 = top
                //2 = left and right
                //3 = bottom

                if(layer == 1) {
                    grid += "+";
                }

                if(layer == 2) {
                    grid += "|";
                }

                if((layer == 3)&&(i == dimension-1)) {
                    grid += "+";
                }

                for(int j = 0; j < dimension; j++) {
                    Vertex v = vertexList[i][j];

                    //prints according to the layer
                    //layer one --> print up
                    if (layer == 1) {
                        if((v.walls[0] != 0) && (v.walls[0] != 4)) //if -1, edge wall; if 1, inner wall, 0 is broken wall
                            grid += "-";
                        else
                            grid += " ";

                        grid += "+";
                    }

                    //layer two --> print left/right and label
                    else if(layer == 2){
//						if(v.walls[3] != 0) //if there is a left wall - 3
//							grid += "|";
//						else
//							grid += " ";

                        //print label
                        //grid += v.label;

                        //don't print label
                    	//grid += (v.label);
                        //grid += " ";
                    	
                    	//printing start times 
//                    	if(v.startTime >= 1000)
//                    		grid += " ";
//                    	else 
//                    		grid += (v.startTime % 10);
                    	
                    	
                    	if(v.pi == null)
                    	{
                    		grid += " ";
                    	}
                    	
                    	else
                    	{
                    		grid += (v.pi.label); 
                    	}

                    	
                    	//walls
                        if(v.walls[1] != 0) //right wall is 1
                            grid += "|";
                        else
                            grid += " ";
                    }

                    //layer three --> print bottom layer
                    else if((layer == 3) && (i == dimension-1)) {
                        //down wall
                        //if there is an down wall, include symbol
                        //grid += "+";

                        if((v.walls[2] != 0) && (v.walls[2] != 4)) //if -1, edge wall; if 1, inner wall, 0 is broken wall
                            grid += "-";
                        else
                            grid += " ";

                        grid += "+";

                    }

                    //grid += "\n";
                }
                grid += "\n";
            }
        }

        return grid;
    }
    

    public static void main(String[] args) {
        Graph g = new Graph(4);
        //g.populateGraph();

//        for (int i = 0; i < g.dimension; i++) {
//            for (int j = 0; j < g.dimension; j++) {
//                System.out.print(g.vertexList[i][j].label + " ");
//            }
//            System.out.println();
//        }

       // System.out.println(g.vertexList[0][0].getRight().label);
       // System.out.println(g.startVertex.label);
       // System.out.println(g.endVertex.label);

        g.generateMaze();
        System.out.println("Generated Grid: ");
        String aGrid = g.printGrid();
        System.out.println(aGrid);
        
        g.DFS();
        System.out.println("DFS");
        String bGrid = g.printGrid();
        System.out.println(bGrid);
        
//        g.generateMaze(); 
//        g.BFS(g.vertexList[0][0]);
//        System.out.println("BFS");
//        String cGrid = g.printBGrid();
//        System.out.println(cGrid);
        
        
//        for(int i = 0; i < g.dimension; i++) 
//    	{
//    		for(int j = 0; j < g.dimension; j++)
//    		{
//    			Vertex v = g.vertexList[i][j];
//    			System.out.println("start: " + v.startTime); 
//    			System.out.println("end: " + v.endTime); 
//    			
//    			if(v.pi != null)
//    			{
//    				System.out.println("current: " + v.label);
//    				System.out.println("parent: " + v.pi.label + "\n"); 
//    			}
//    		
//    		}
//    	}

    }
}

