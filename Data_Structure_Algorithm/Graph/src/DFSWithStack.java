import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class DFSWithStack {
    public static void main(String[] args) {
        int[][] graph = {
                {0,1,0,0,0,0},
                {1,0,1,1,1,0},
                {0,1,0,1,0,1},
                {0,1,1,0,0,0},
                {0,1,0,0,0,1},
                {0,0,1,0,1,0}
        };

        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        //Chọn đỉnh đầu là 0
        stack.add(0);
        //Đánh dấu đã duyệt đỉnh đầu
        set.add(0);

        while (!stack.isEmpty()){
            int i = stack.pop();

            System.out.print(i + "\t");

            //Add tất cả đỉnh kề với i mà chưa được duyệt vào stack
            for(int j = 0; j < graph.length; j++){
                if(graph[i][j] == 1 && !set.contains(j)){
                    stack.add(j);
                    set.add(j);
                }
            }
        }
    }
}