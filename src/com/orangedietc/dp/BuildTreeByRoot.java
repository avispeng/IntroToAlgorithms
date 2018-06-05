package com.orangedietc.dp;

public class BuildTreeByRoot {
	/*
	 * 15.5-1 Given the table root, outputs the structure of an optimal binary search tree.
	 */
	public Node buildTree(int[][] roots) {
		return helper(roots, 1, roots.length);
	}
	public Node helper(int[][] roots, int i, int j) {
		if(j < i - 1) return null;
		if(j == i - 1) return new Node(j, 'd');
		int rootVal = roots[i-1][j-1];
		Node root = new Node(rootVal, 'k');
		root.left = helper(roots, i, rootVal - 1);
		root.right = helper(roots, rootVal + 1, j);
		return root;
	}
}
