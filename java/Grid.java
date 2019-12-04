import java.util.ArrayList;
import java.util.List;

public class Grid {
	
    // Parent of the current node.
	Grid parent;

    // Position of the agent in the current state.
    Position agentPosition = new Position(0, 0);

    // Current state.
    int[][] state;

    // Move applied on parent state.
    String move;
   
    public Position A = new Position(0, 0);
    public Position B = new Position(0, 0);
    public Position C = new Position(0, 0);
    
    // Applicable for A star only.
    public int fCost;
    public int gCost;
    public int hCost;
    
    public int nodesGeneratedBefore;
    
    public Grid(int[][] initState, Position A, Position B, Position C, Position agent) {
    	
    	this.parent = null;
    	this.state = initState;
    	
    	this.A = A;
    	this.B = B;
    	this.C = C;
    	this.agentPosition = agent;
    }
    
    public Grid(Grid parent, int x, int y) {
    	setParent(parent);
    	
    	this.state = new int[parent.getState().length][parent.getState()[0].length];
    	for(int i = 0; i < parent.getState().length; i ++)
            state[i] = parent.getState()[i].clone();
    	
    	this.agentPosition.x = parent.getAgentPosition().x;
    	this.agentPosition.y = parent.getAgentPosition().y;
    	
    	this.A.x = parent.A.x;
    	this.A.y = parent.A.y;
    	this.B.x = parent.B.x;
    	this.B.y = parent.B.y;
    	this.C.x = parent.C.x;
    	this.C.y = parent.C.y;
    	

        move(x, y);
    }
    
    public List<Grid> getNeighbors(Grid parent){
		List<Grid> neighbors = new ArrayList<Grid>();
		
		for(int x = -1; x <= 1; x ++) {
			for(int y = -1; y <= 1; y ++) {
				// Check for correctness of the move, i.e: can't go on diagonals.
				if( isCorrectMove(x, y) ) {
					int checkX = agentPosition.x + x;
					int checkY = agentPosition.y + y;
					// Check if the move is within the grid.
					if( isWithinGrid(checkX, checkY) ) {
						Grid candidate = new Grid(parent, checkX, checkY);
						neighbors.add(candidate);
					}
				}
			}
		}
		
		return neighbors;
	}
	
    protected boolean checkGoalState() {
		if( A.x == Search.goalPositionA.x && 
				A.y == Search.goalPositionA.y &&
				B.x == Search.goalPositionB.x && 
				B.y == Search.goalPositionB.y &&
				C.x == Search.goalPositionC.x && 
				C.y == Search.goalPositionC.y) {
			return true;
		}
		return false;
	}
    
	private boolean isCorrectMove(int x, int y) {
		if(x == -1 && y == 1 || x == -1 && y == -1 || x == 1 && y == -1 || y == 1 && x == 1 || x == 0 && y == 0)
			return false;
		return true;
	}
	
	private boolean isWithinGrid(int x, int y) {
		if( x < Search.N && x >= 0 && y < Search.N && y >= 0 )
			return true;
		return false;
	}
	
	private void move(int checkX, int checkY) {
		
		if(checkX == A.x && checkY == A.y) {
			A.x = agentPosition.x;
			A.y = agentPosition.y;
		}
		else if(checkX == B.x && checkY == B.y) {
			B.x = agentPosition.x;
			B.y = agentPosition.y;
		}
		else if(checkX == C.x && checkY == C.y) {
			C.x = agentPosition.x;
			C.y = agentPosition.y;
		}
		
		int temp = state[agentPosition.x][agentPosition.y];
		
		state[agentPosition.x][agentPosition.y] = state[checkX][checkY];
		state[checkX][checkY] = temp;
		
		agentPosition.x = checkX;
		agentPosition.y = checkY;
	}
	
    public int[][] getState(){
    	return state;
    }
    
	public void printState() {
		for(int i = 0; i < state.length; i ++) {
			for(int j = 0; j < state.length; j ++) {
				System.out.print(state[i][j] + " ");
			}
			System.out.println();
		}
	}
    
    public Position getAgentPosition(){
        return this.agentPosition;
    }
    
    public void setParent(Grid parent){
        this.parent = parent;
    }
    
    public Grid getParent() {
    	return this.parent;
    }

    
}
