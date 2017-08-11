public class Solution {
	int m;
	int n;
	boolean[][] used;
	int[] ii = {0, 0, 1, -1};
	int[] jj = {1, -1, 0, 0};

    public boolean exist(char[][] board, String word) {
    	if(word.length() == 0)
    		return true;
    	m = board.length;
    	n = board[0].length;
    	char c = word.charAt(0);
    	used = new boolean[m][n];

        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(board[i][j] == c){
                    used[i][j] = true;
        			if(search(i, j, board, 1, word))
        				return true;
                    used[i][j] = false;
        		}
        	}
        }
        return false;


    }

    public boolean search(int i, int j, char[][] board, int next, String word){
    	if(next == word.length())
    		return true;
    	char c = word.charAt(next);
    	for(int k = 0; k < 4; k++){
    		int next_i = i + ii[k];
    		int next_j = j + jj[k];
    		if(next_i < 0 || next_i >= m || next_j < 0 || next_j >= n || used[next_i][next_j])
    			continue;
    		if(board[next_i][next_j] == c){
    			used[next_i][next_j] = true;
    			if(search(next_i, next_j, board, next + 1, word))
    				return true;
    			used[next_i][next_j] = false;
    		}
    	}
    	return false;
    }
}