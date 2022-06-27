import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
//        int[][] arr = {{},{4,1},{4,2,5,1},{1},{1}};
        int[][] arr = {{5,7,4,3,8},{3,9,4,1},{4,8},{8},{8,7},{8,1},{4,8,3},{},{4}};
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<HashSet<Integer>> mySet= new ArrayList<>();
        for (int i=0; i< arr.length; i++){
            mySet.add(new HashSet<>());
            ArrayList<Integer> myArr = new ArrayList<>();
            for (int j: arr[i]){
                myArr.add(j);
            }
            graph.add(myArr);
        }
        System.out.println(graph);
        int count =0;
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < graph.size(); i++) {
            stackAndDelete(i,count,visited,graph,mySet);
        }
        System.out.println(graph);
        System.out.println(count);
    }

    public static HashSet<Integer> stackAndDelete(int i,int count,boolean[] visited,ArrayList<ArrayList<Integer>> graph,ArrayList<HashSet<Integer>> mySet){
        if (visited[i]) return mySet.get(i);
        else if(graph.get(i).isEmpty()){
            mySet.get(i).add(0);
            return mySet.get(i);
        } else {
            for (int j: graph.get(i)){
                HashSet<Integer> subSet= stackAndDelete(j-1,count,visited,graph,mySet);
                mySet.get(i).addAll(subSet);
            }
            count=count+ graph.get(i).size();
            System.out.println(count);
            graph.get(i).removeAll(mySet.get(i));
            mySet.get(i).addAll(graph.get(i));
            count=count - graph.get(i).size();
        }
        visited[i]= true;
        return mySet.get(i);
    }


}
