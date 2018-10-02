package org.jeet.kattis.challenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class C_CAT_AND_DOGS {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int c=scanner.nextInt();
			int d=scanner.nextInt();
			int v=scanner.nextInt();
			Node[] nodes = new Node[v+1];
			Set<Integer> catLover=new HashSet<Integer>();
			Set<Integer> dogLover=new HashSet<Integer>();
//			int[][] graph = new int[v+2][v+2];
			Map<Integer, HashMap<Integer, Integer>> graph = new HashMap<Integer, HashMap<Integer, Integer>>();
			for (int k = 1; k <= v; k++) {
				String l=scanner.next();
				String h=scanner.next();
				int li=Integer.valueOf(l.substring(1, l.length()));
				int hi=Integer.valueOf(h.substring(1, h.length()));
				nodes[k]=new Node(li, hi);
				if(l.charAt(0)=='C') {
					for (int di : dogLover) {
						if(nodes[di].l==hi || nodes[di].h==li) {
							if(!graph.containsKey(k)) graph.put(k,new HashMap<Integer, Integer>());
							graph.get(k).put(di,Integer.MAX_VALUE);
							if(!graph.containsKey(di)) graph.put(di,new HashMap<Integer, Integer>());
							graph.get(di).put(k,0);
//							graph[k][di]=Integer.MAX_VALUE;
						}
					}
					catLover.add(k);
				}
				else {
					for (int ci : catLover) {
						if(nodes[ci].h==li || nodes[ci].l==hi) {
							if(!graph.containsKey(ci)) graph.put(ci,new HashMap<Integer, Integer>());
							graph.get(ci).put(k,Integer.MAX_VALUE);
							if(!graph.containsKey(k)) graph.put(k,new HashMap<Integer, Integer>());
							graph.get(k).put(ci,0);
//							graph[ci][k]=Integer.MAX_VALUE;
						}
					}
					dogLover.add(k);
				}
			}
			for (int k : catLover) {
				if(!graph.containsKey(0)) graph.put(0,new HashMap<Integer, Integer>());
				graph.get(0).put(k,1);
				if(!graph.containsKey(k)) graph.put(k,new HashMap<Integer, Integer>());
				graph.get(k).put(0,0);
//				graph[0][k]=1;
			}
			for (int k : dogLover) {
				if(!graph.containsKey(k)) graph.put(k,new HashMap<Integer, Integer>());
				graph.get(k).put(v+1,1);
				if(!graph.containsKey(v+1)) graph.put(v+1,new HashMap<Integer, Integer>());
				graph.get(v+1).put(k,0);
//				graph[k][v+1]=1;
			}
			System.out.println(v-fordFulkerson(graph, 0, v+1, v+2));
		}
		scanner.close();
	}

	static class Node {
		public int l;
		public int h;
		Node(int l_, int h_){
			this.l=l_;
			this.h=h_;
		}
		@Override
		public String toString() {
			return "Node [l=" + l + ", h=" + h + "]";
		}
	}


	static boolean bfs(Map<Integer, HashMap<Integer, Integer>> rGraph, int s, int t, int parent[])
	{
		// Create a visited array and mark all vertices as not
		// visited
		Set<Integer> visited = new HashSet<Integer>();
//		for(int i=0; i<V; ++i)
//			visited[i]=false;

		// Create a queue, enqueue source vertex and mark
		// source vertex as visited
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited.add(s);
		parent[s]=-1;

		// Standard BFS Loop
		while (queue.size()!=0)
		{
			int u = queue.poll();
			if(!rGraph.containsKey(u)) continue;
			for (int v :rGraph.get(u).keySet())
			{
				if (!visited.contains(v) && rGraph.get(u).get(v) > 0)
				{
					queue.add(v);
					parent[v] = u;
					visited.add(v);
				}
			}
		}

		// If we reached sink in BFS starting from source, then
		// return true, else false
		return visited.contains(t);
	}

	// Returns tne maximum flow from s to t in the given graph
	static int fordFulkerson(Map<Integer, HashMap<Integer, Integer>> rGraph, int s, int t, int V)
	{
		int u, v;

		// Create a residual graph and fill the residual graph
		// with given capacities in the original graph as
		// residual capacities in residual graph

		// Residual graph where rGraph[i][j] indicates
		// residual capacity of edge from i to j (if there
		// is an edge. If rGraph[i][j] is 0, then there is
		// not)
//		int rGraph[][] = new int[V][V];
//
//		for (u = 0; u < V; u++)
//			for (v = 0; v < V; v++)
//				rGraph[u][v] = graph[u][v];

		// This array is filled by BFS and to store path
		int parent[] = new int[V];

		int max_flow = 0;  // There is no flow initially

		// Augment the flow while tere is path from source
		// to sink
		while (bfs(rGraph, s, t, parent))
		{
			// Find minimum residual capacity of the edhes
			// along the path filled by BFS. Or we can say
			// find the maximum flow through the path found.
			int path_flow = Integer.MAX_VALUE;
			for (v=t; v!=s; v=parent[v])
			{
				u = parent[v];
				path_flow = Math.min(path_flow, rGraph.get(u).get(v));
			}

			// update residual capacities of the edges and
			// reverse edges along the path
			for (v=t; v != s; v=parent[v])
			{
				u = parent[v];
				rGraph.get(u).put(v, rGraph.get(u).get(v)-path_flow);
				rGraph.get(v).put(u, rGraph.get(v).get(u)+path_flow);
//				rGraph[u][v] -= path_flow;
//				rGraph[v][u] += path_flow;
			}

			// Add path flow to overall flow
			max_flow += path_flow;
		}

		// Return the overall flow
		return max_flow;
	}

}