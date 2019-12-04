
public class Main {

	public static void main(String[] args) {
		testGrid6x6(TypeSearch.ASTAR);
	}
	
	static void testGrid3x3(TypeSearch t) {
		
		int[][] init_state = {
				{0,-1,0},
				{0,0,0},
				{1,2,3}
		};
		int[][] goal_state = {
				{-1,1,0},
				{0,2,0},
				{0,3,0}
		};
		int N = 3;
		
		Position A = new Position(2, 0);
		Position B = new Position(2, 1);
		Position C = new Position(2, 2);
		Position agent = new Position(0, 1);
		
		Search.goalPositionA = new Position(0, 1);
		Search.goalPositionB = new Position(1, 1);
		Search.goalPositionC = new Position(2, 1);
		
		switch(t) {
			
			case ASTAR:
				Astar astar = new Astar(init_state, goal_state, N, A, B, C, agent);
				astar.astar();
				break;
			case BFS:
				Bfs bfs = new Bfs(init_state, goal_state, N, A, B, C, agent);
				bfs.bfs();
				break;
			case DFS:
				Dfs dfs = new Dfs(init_state, goal_state, N, A, B, C, agent);
				dfs.dfs();
				break;
			case IDDFS:
				IterativeDeepening iddfs = new IterativeDeepening(init_state, goal_state, N, A, B, C, agent);
				iddfs.IDS();
				break;
		}
		
		
		
	}
	
	static void testGrid4x4(TypeSearch t) {
		
		int[][] init_state = {
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{1,2,3,-1}
		};
		int[][] goal_state = {
				{0,0,0,0}, 
				{0,1,0,0}, 
				{0,2,0,0}, 
				{0,3,0,-1}
		};
		int N = 4;
		
		Position A = new Position(3, 0);
		Position B = new Position(3, 1);
		Position C = new Position(3, 2);
		Position agent = new Position(3, 3);
		
		Search.goalPositionA = new Position(1, 1);
		Search.goalPositionB = new Position(2, 1);
		Search.goalPositionC = new Position(3, 1);
		
		switch(t) {
		
			case ASTAR:
				Astar astar = new Astar(init_state, goal_state, N, A, B, C, agent);
				astar.astar();
				break;
			case BFS:
				Bfs bfs = new Bfs(init_state, goal_state, N, A, B, C, agent);
				bfs.bfs();
				break;
			case DFS:
				Dfs dfs = new Dfs(init_state, goal_state, N, A, B, C, agent);
				dfs.dfs();
				break;
			case IDDFS:
				IterativeDeepening iddfs = new IterativeDeepening(init_state, goal_state, N, A, B, C, agent);
				iddfs.IDS();
				break;
		}
		
	}
	
	static void karthik(TypeSearch t) {
		
		int[][] init_state = {
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{1,2,3,-1}
		};
		int[][] goal_state = {
				{0,0,0,0}, 
				{0,0,1,0}, 
				{0,0,2,0}, 
				{0,0,3,-1}
		};
		int N = 4;
		
		Position A = new Position(3, 0);
		Position B = new Position(3, 1);
		Position C = new Position(3, 2);
		Position agent = new Position(3, 3);
		
		Search.goalPositionA = new Position(1, 2);
		Search.goalPositionB = new Position(2, 2);
		Search.goalPositionC = new Position(3, 2);
		
		switch(t) {
		
			case ASTAR:
				Astar astar = new Astar(init_state, goal_state, N, A, B, C, agent);
				astar.astar();
				break;
			case BFS:
				Bfs bfs = new Bfs(init_state, goal_state, N, A, B, C, agent);
				bfs.bfs();
				break;
			case DFS:
				Dfs dfs = new Dfs(init_state, goal_state, N, A, B, C, agent);
				dfs.dfs();
				break;
			case IDDFS:
				IterativeDeepening iddfs = new IterativeDeepening(init_state, goal_state, N, A, B, C, agent);
				iddfs.IDS();
				break;
		}
		
	}
	
	static void testGrid5x5(TypeSearch t) {
		int[][] init_state = {
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{1,2,3,-1,0}
		};
		int[][] goal_state = {
				{0,0,0,0,0}, 
				{0,1,0,0,0}, 
				{0,2,0,0,0}, 
				{0,3,0,-1,0}
		};
		int N = 5;
		
		Position A = new Position(4, 0);
		Position B = new Position(4, 1);
		Position C = new Position(4, 2);
		Position agent = new Position(4, 3);
		
		Search.goalPositionA = new Position(2, 1);
		Search.goalPositionB = new Position(3, 1);
		Search.goalPositionC = new Position(4, 1);
		
		switch(t) {
		
			case ASTAR:
				Astar astar = new Astar(init_state, goal_state, N, A, B, C, agent);
				astar.astar();
				break;
			case BFS:
				Bfs bfs = new Bfs(init_state, goal_state, N, A, B, C, agent);
				bfs.bfs();
				break;
			case IDDFS:
				IterativeDeepening iddfs = new IterativeDeepening(init_state, goal_state, N, A, B, C, agent);
				iddfs.IDS();
				break;
			case DFS:
				Dfs dfs = new Dfs(init_state, goal_state, N, A, B, C, agent);
				dfs.dfs();
				break;
		}
	}
	
	static void testGrid6x6(TypeSearch t) {
		int[][] init_state = {
				{0,0,0,0,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0},
				{1,2,3,-1,0,0}
		};
		int[][] goal_state = {
				{0,0,0,0,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0},
				{0,1,0,0,0,0},
				{0,2,0,0,0,0},
				{0,3,0,-1,0,0}
		};
		int N = 6;
		
		Position A = new Position(5, 0);
		Position B = new Position(5, 1);
		Position C = new Position(5, 2);
		Position agent = new Position(5, 3);
		
		Search.goalPositionA = new Position(3, 1);
		Search.goalPositionB = new Position(4, 1);
		Search.goalPositionC = new Position(5, 1);
		
		switch(t) {
		
			case ASTAR:
				Astar astar = new Astar(init_state, goal_state, N, A, B, C, agent);
				astar.astar();
				break;
			case BFS:
				Bfs bfs = new Bfs(init_state, goal_state, N, A, B, C, agent);
				bfs.bfs();
				break;
			case IDDFS:
				IterativeDeepening iddfs = new IterativeDeepening(init_state, goal_state, N, A, B, C, agent);
				iddfs.IDS();
				break;
			case DFS:
				Dfs dfs = new Dfs(init_state, goal_state, N, A, B, C, agent);
				dfs.dfs();
				break;
		}
	}

}
