import java.io.*; 
import java.util.*; 
import java.lang.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {
	public String serializeInteger(int x) {
		String result ="";
		result = (char)(x&255) + result;
		x >>>=8;
		result = (char)(x&255) + result;
		x >>>=8;
		result = (char)(x&255) + result;
		x >>>=8;
		result = (char)(x&255) + result;
		x >>>=8;
		return result;
		
	}
	public int deserializeInteger(String s) {
		int x = 0;
		for (int i=0; i<s.length(); i++) {
			x <<= 8;
			x += (int)s.charAt(i);
		}
		return x;
	}
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = "";
        if (root ==null){return result;}
        /*
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
        	TreeNode x = stack.pop();
        	result = result + serializeInteger(x.val);
        	if (x.right!=null) {stack.push(x.right);}
        	if (x.left!=null) {stack.push(x.left);}
        }
        */
        result = inOrder(root, result);
        return result;
    }
    public String inOrder(TreeNode root, String result) {
    	if (root == null) {return result;}
    	result = result + serializeInteger(root.val);
    	if (root.left!=null) {result = inOrder(root.left, result);}
    	if (root.right!=null) {result = inOrder(root.right, result);}
    	//System.out.println(result);
    	return result;
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {return null;}
    	//TreeNode root = new TreeNode (deserializeInteger(data.substring(0,4)));
    	
    	int [] arr = new int[data.length() / 4];
    	int [] arr2 = new int[data.length() / 4];
    	LinkedList<Integer> list= new LinkedList<>();
    	for (int i = 0; i<data.length(); i+=4) {
    		arr[i / 4] = deserializeInteger(data.substring(i, i+4));
    		list.add(arr[i/4]);
    	}
    	
    	Stack <Integer> stack = new Stack<>();
    	//stack.push(0);
    	int i = 0;
    	while (i < arr.length  ) {
    		if(stack.isEmpty()) {
    			stack.push(i);
    			i++;
    		}
    		else if (arr[i] < arr[stack.peek()]) {
    			stack.push(i);
    			i++;
    		} 
    		else {
    			arr2[stack.pop()] = i;
    		}
    	}
    	while (!stack.isEmpty() ) {
    		arr2[stack.pop()] = arr.length;
    	}
    	
    	
    	//return buildTree(arr, 0, arr.length - 1,  arr2);
    	return buildTree_v2(list, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode buildTree_v2(LinkedList<Integer> list , int lower, int upper) {
    	if (list.isEmpty()) {return null;}
    	int x = list.get(0);
    	if (x < lower || x > upper) {
    		return null;
    	}
    	TreeNode root = new TreeNode (x);
    	list.poll();
    	root.left = buildTree_v2(list, lower, x);
    	root.right= buildTree_v2(list, x, upper);
    	return root;
    	
    }
    
    
    
    public TreeNode buildTree(int[]arr, int start, int end, int[]arr2) {
    	if (start == end) {
    		return new TreeNode(arr[start]);
    	}
    	if (start > end) {return null;}
    	TreeNode root = new TreeNode(arr[start]);
    	int i = arr2[start];
    	
    	if (i > end) { i = end + 1;}
    	
    	root.left = buildTree(arr, start + 1, i - 1, arr2);
    	root.right= buildTree(arr, i , end, arr2);
    	return root;
    }
}

public class Solution {
	public static String function(String s) {
		s = s+"ttt";
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "uuuuuuuuuuuuuuuuuuuuuuuuuuuu";
		System.out.println(function(str));
		System.out.println(str);
		Codec c = new Codec();
		
		TreeNode root = new TreeNode (103);
		TreeNode l2 = new TreeNode (102);
		TreeNode l1 = new TreeNode (101);
		TreeNode l4 = new TreeNode (104);
		root.right = l4;
		root.left = l2;
		l2.left = l1;
		

		System.out.println(c.serialize(root));
		c.deserialize(c.serialize(root));
	}

}
