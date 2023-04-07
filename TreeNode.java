/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1 
*/

public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	private static boolean isUnival(TreeNode node) {

		if (node == null) {
			return true;
		}

		if (node.left != null && node.left.val != node.val) {
			return false;
		}

		if (node.right != null && node.right.val != node.val) {
			return false;
		}

		return isUnival(node.left) && isUnival(node.right);
	}

	private static int countUnivalSubtrees(TreeNode node) {

		if (node == null) {
			return 0;
		}

		int count = countUnivalSubtrees(node.left) + countUnivalSubtrees(node.right);

		if (isUnival(node)) {
			count++;
		}

		return count;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(0);
		root.right.left.left = new TreeNode(1);
		root.right.left.right = new TreeNode(1);

		int count = countUnivalSubtrees(root);
		System.out.println(count); // debería imprimir 5
	}
}
