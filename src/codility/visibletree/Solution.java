package codility.visibletree;

import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.Stack;

class Solution {

    class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }

    public int solution(Tree T){
        if (T == null)
        {
            return -1;
        }

        int count = 0;

        Stack<Entry<Integer, Tree>> stack = new Stack<Entry<Integer, Tree>>();
        stack.push(new AbstractMap.SimpleEntry<>(T.x, T));
         
        while (!stack.empty())
        {
            Entry<Integer, Tree> n = stack.pop();
            if (n.getKey() <= n.getValue().x)
            {
                count++;
            }
            
            int max = Math.max(n.getKey(), n.getValue().x);
            
            if (n.getValue().l != null)
            {
                stack.push(new AbstractMap.SimpleEntry<Integer, Tree>(max, n.getValue().l));
            }
            
            if (n.getValue().r != null)
            {
                stack.push(new AbstractMap.SimpleEntry<Integer, Tree>(max, n.getValue().r));
            }
        }

        return count;
    }
}