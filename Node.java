/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Node {
	
	String val;
	Node left;
	Node right;

	Node(String val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static String serialize(Node root) {
		if (root == null) {
			return "null";
		}
		String left = serialize(root.left);
		String right = serialize(root.right);
		return root.val + "," + left + "," + right;
	}

	public static Node deserialize(String s) {
		Queue<String> queue = new LinkedList<>();
		queue.addAll(Arrays.asList(s.split(",")));
		return buildTree(queue);
	}

	private static Node buildTree(Queue<String> queue) {
		String val = queue.poll();
		if (val.equals("null")) {
			return null;
		}
		Node node = new Node(val, null, null);
		node.left = buildTree(queue);
		node.right = buildTree(queue);
		return node;
	}
	
	public static void main(String[] args) {
		Node node = new Node("root", new Node("left", new Node("left.left", null, null), null), new Node("right", null, null));
		String serialized = serialize(node);
		System.out.println(serialized); // prints "root,left,left.left,null,null,null,right,null,null"
		Node deserialized = deserialize(serialized);
		System.out.println(deserialized.left.left.val); // prints "left.left"
	}
}
