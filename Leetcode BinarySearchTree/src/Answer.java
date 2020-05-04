import java.io.*; 
import java.util.*; 
import java.lang.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



public class Answer {
	
	public static TreeNode buildNode(String str) {
		if (str.compareTo("null") == 0) return null;
		return new TreeNode(Integer.valueOf(str));
	}
	
	public static TreeNode buildTree(String str) {
		str = str.substring(1, str.length() - 1);
		System.out.println(str);
		String[] datum = str.split(",");
		Queue<TreeNode> queue = new LinkedList<>();
		
		TreeNode root = buildNode(datum[0]);
		queue.offer(root);
		
		int index = 1;
		
		while(index < datum.length) {
			TreeNode p = queue.poll();
			if (p == null) continue;
			p.left = buildNode (datum[index ++]);
			queue.offer(p.left);
			if (index < datum.length) {
				p.right = buildNode(datum[index ++]);
				queue.offer(p.right);
			}
		}
		return root;
	} 
	
	public static void preorder(TreeNode root) {
		if (root == null) return;
		System.out.print(root.val + ",");
		preorder(root.left);
		preorder(root.right);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("HELLO, java Answer");
		String str = "[1,2,3,null,null,4,5,6,7,null,9]";
		TreeNode root = buildTree(str);
		preorder(root);
	}

}
