package algo;

import java.util.*;

public class GraphAlgo {
	
	static void bfs(List<List<Integer>> adj, int s,boolean[] visited) {
		//FIFO
		Queue<Integer> q=new LinkedList<>();
		
		visited[s]=true;
		q.add(s);
		
		while(!q.isEmpty()) {
			int current=q.poll();
			System.out.print(current + " ");
			for(int x:adj.get(current)) {
				if(!visited[x]) {
					visited[x]=true;
					q.add(x);
				}
			}
		}
		
	}
	static void bfsDisconnected(List<List<Integer>> adj) {
		boolean[] visited=new boolean[adj.size()];
		for(int i=0;i<adj.size();i++) {
			if(!visited[i]) {
				bfs(adj,i,visited);
			}
		}
	}
	static void add(List<List<Integer>> adj,int u , int v) {
		//Undirected
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
    
    public static void main(String[] args) {
        int vetNumber=6;
        List<List<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < vetNumber; i++) {
            adj.add(new ArrayList<>());
        }
	    add(adj, 0, 1);
	    add(adj, 0, 2);
	    add(adj, 3, 4);
	    add(adj, 4, 5); 
       
        
       bfsDisconnected(adj);
        
        
    }
}

