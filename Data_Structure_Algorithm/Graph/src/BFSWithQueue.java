import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSWithQueue {
    public static void main(String[] args) {
        int[][] graph = {
                {0,1,0,0,0,0},
                {1,0,1,1,1,0},
                {0,1,0,1,0,1},
                {0,1,1,0,0,0},
                {0,1,0,0,0,1},
                {0,0,1,0,1,0}
        };

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        queue.add(0);
        set.add(0);

        while (!queue.isEmpty()){
            int i = queue.poll();
            System.out.print(i+"\t");

            for(int j = 0; j < graph.length; j++){
                if(graph[i][j] == 1 && !set.contains(j)){
                    queue.add(j);
                    set.add(j);
                }
            }
        }
    }
}
