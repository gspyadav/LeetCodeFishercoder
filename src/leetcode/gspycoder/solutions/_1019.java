package leetcode.gspycoder.solutions;

import leetcode.gspycoder.common.classes.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _1019 {
    public static class Solution1 {
        public int[] nextLargerNodes(ListNode head) {

            if(head == null){
                return new int[]{};
            }

            List<Integer> list = new ArrayList<>();
            ListNode nodei = head;
            ListNode nodej = head;
            while(nodei.next!=null){
                nodej = nodei.next;
                int val = 0;
                while(nodej!=null){

                    if(nodej.val > nodei.val){
                        val = nodej.val;
                        break;
                    }
                    nodej= nodej.next;
                }
                list.add(val);
                nodei = nodei.next;
            }
            list.add(0);
            int[] res = new int[list.size()];
            for(int k=0;k<list.size();k++){
                res[k] = list.get(k);
            }

            return res;
        }
    }
}
