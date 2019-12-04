import java.util.*;

public class Dfs extends Search{

	Position A;
	Position B;
	Position C;
	Position agent;
	
	public Dfs(int[][] initState, int[][] goalState, int N, Position A, Position B, Position C, Position agent) {
		super(initState, goalState, N);
		this.A = A;
		this.B = B;
		this.C = C;
		
		this.agent = agent;
	}
	
	public void dfs() {
		Grid startNode = new Grid(initState, A, B, C, agent);
		
		if(startNode.checkGoalState()) {
			System.out.println("Found goal state");
			startNode.printState();
			return;
		}
		
		Stack<Grid> frontier = new Stack<Grid>();
		frontier.push(startNode);
		
		while(!frontier.isEmpty()) {
			
			Grid currentNode = frontier.pop();
			RUNNING_TIME ++;
			currentNode.nodesGeneratedBefore = RUNNING_TIME;
			List<Grid> randomiseActions = new ArrayList<>();
			
			for(Grid g : currentNode.getNeighbors(currentNode)) {
				randomiseActions.add(g);
			}
			
			Collections.shuffle(randomiseActions);
			
			for(Grid neighbor : randomiseActions) {
				if(neighbor.checkGoalState()) {
					System.out.println("Found goal state");
					retracePath(neighbor);
					return;
				}
				frontier.add(neighbor);
			}
		}
		
	}
	
	private void retracePath(Grid node) {
		Grid currentNode = node;
		List<Grid> path = new ArrayList<>();
		while(currentNode != null) {
			path.add(currentNode);
			currentNode = currentNode.parent;
		}
		
		Collections.reverse(path);
		
		for(Grid g : path) {
			g.printState();
			System.out.println("Nodes generated before " + g.nodesGeneratedBefore);
		}
		
	}
	
}
