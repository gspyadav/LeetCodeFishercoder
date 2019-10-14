package leetcode.solutions;

import leetcode.common.classes.TreeNode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class _1214_Two_Sum_BSTs {
    public static class Solution1{
        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            HashSet<Integer> set = new HashSet<>();
            traverse(root1,set);

            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root2);

            while(!queue.isEmpty()){
                TreeNode temp = queue.poll();
                if(set.contains(target-temp.val)){
                    return true;
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }if(temp.left!=null){
                    queue.offer(temp.left);
                }
            }
            return false;

        }
        public void traverse(TreeNode root, HashSet<Integer> set){
            if(root == null){
                return;
            }
            traverse(root.left,set);
            set.add(root.val);
            traverse(root.right,set);
        }
    }
}
