import java.util.*;


class Solution {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        q.add(0);
        q.add(9);
        System.out.println(q.peek());
        q.add(-1);
        System.out.println(q.peek());
        PriorityQueue<Integer> max = new PriorityQueue<Integer>((a,b)->(b-a));
        max.add(7);
        max.add(-1);
        System.out.println(max.peek());
        max.add(99);
        System.out.println(max.peek());
    }
}