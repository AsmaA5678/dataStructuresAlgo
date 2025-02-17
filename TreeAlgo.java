package algo;

import java.util.*;

public class TreeAlgo {
	//Breadth first search BFS (level order traversal)
	//using stack 
	static void levelOrderRec(TreeNode root, int level, ArrayList<ArrayList<Integer>> res) {
		if(root==null) return;
		if(res.size() <= level) res.add(new ArrayList<>());
		res.get(level).add(root.val);
		levelOrderRec(root.left,level+1,res);
		levelOrderRec(root.right,level+1,res);
	    
	}
	static ArrayList<ArrayList<Integer>> bfs(TreeNode root){
			ArrayList<ArrayList<Integer>> res = new ArrayList<>();
			levelOrderRec(root,0,res);
			return res;
	}
		

	
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(5);
	   
        ArrayList<ArrayList<Integer>> res = bfs(root);

        // result
        for (ArrayList<Integer> level : res) {
            for (int data : level) {
                System.out.print(data + " ");
            
        
            }
        }
    }
}

