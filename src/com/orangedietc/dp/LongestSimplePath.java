package com.orangedietc.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSimplePath {
	/*
	 * 15-1 find the longest simple path in a DAG
	 */
	public int longestSimplePathTopDownMemo(int[][] edges, int s, int t, int n) {
		/*
		 * edges: [u, v, w] an edge starts from vertex u to vertex v with weight w
		 * s: source, t: destination, n: number of vertices
		 * both s and t are between [0, n-1]
		 * solved with dynamic programming with top-down memoization
		 * adding a negative integer to Integer.MIN_VALUE will be equal to positive max
		 * so this method only works when there is no negative weight.
		 */
		int[] dist = new int[n]; // distance to t from each vertex
		Arrays.fill(dist, Integer.MIN_VALUE);
		dist[t] = 0;
		Map<Integer, List<int[]>> edgeList = new HashMap<>();
		for(int[] edge: edges) {
			List<int[]> curSource = edgeList.get(edge[0]);
			if(curSource == null) {
				curSource = new ArrayList<>();
				edgeList.put(edge[0], curSource);
			}
			curSource.add(edge);
		}
		return dp(edgeList, s, dist);
	}
	private int dp(Map<Integer, List<int[]>> edgeList, int s, int[] dist) {
		if(dist[s] > Integer.MIN_VALUE) return dist[s];
		int max = dist[s];
		List<int[]> curSource = edgeList.get(s);
		if(curSource != null) {
			for(int[] edge: curSource) {
				max = Math.max(max, dp(edgeList, edge[1], dist) + edge[2]);
			}
		}
		dist[s] = max;
		return dist[s];
	}
}
