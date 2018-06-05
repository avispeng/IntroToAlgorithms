package com.orangedietc.dp;

public class Test {
	public static void main(String[] args) {
		LongestSimplePath longestSimplePath = new LongestSimplePath();
		int[][] edges = {{2,0,7},{0,3,4},{0,5,2},{1,0,3},{1,4,5},{2,3,1},{2,5,1},{3,5,2},{4,0,2},{4,2,6}};
		int s = 4, t = 0;
		System.out.println(longestSimplePath.longestSimplePathTopDownMemo(edges, s, t, 6));
	}
}
