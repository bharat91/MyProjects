package org.learning.algorithms;

import java.util.ArrayList;

public class NumberOfIslands_Graphs {
    boolean[][] visited;
    public int solve(ArrayList<ArrayList<Integer>> A) {

        visited = new boolean[A.size()][A.get(0).size()];

        int ans = 0;
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++){
                if(!visited[i][j] && A.get(i).get(j)==1){
                    ans++;
                    dfs(A,i,j);
                }
            }
        }
        return ans;
    }

    public void dfs(ArrayList<ArrayList<Integer>> A,int x, int y){
        visited[x][y] = true;
        for(int dx=-1;dx<=1;dx++){
            for(int dy=-1;dy<=1;dy++){
                int X = x+dx;
                int Y = y+dy;
                if(X>=0 && X<A.size() && Y>=0 && Y<A.get(0).size()){
                    if(A.get(X).get(Y)==1 && !visited[X][Y]){
                        dfs(A,X,Y);
                    }
                }
            }
        }
    }
}
