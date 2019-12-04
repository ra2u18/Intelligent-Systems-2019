public abstract class Search {
	
	protected int[][] initState;
	
	
	private int[][] goalState;

	public static int N;
	public static Position goalPositionA;
    public static Position goalPositionB;
    public static Position goalPositionC;
    public static int RUNNING_TIME;
	
	// constructor
	public Search(int[][] initState, int[][] goalState, int N) {
		this.initState = initState;
		this.goalState = goalState;
		this.N = N;
	}
	
	// print current state
	public void printState(int[][] state) {
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < N; j ++) {
				System.out.print(state[i][j] + " ");
			}
			System.out.println();
		}
	}

}
