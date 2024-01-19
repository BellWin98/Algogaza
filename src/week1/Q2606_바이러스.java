package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2606_바이러스 {
    static boolean[] visited;
    static int count;
    static List<List<Integer>> adjList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int computers = sc.nextInt();
        int edges = sc.nextInt();
        count = 0;
        visited = new boolean[computers + 1];
        adjList = new ArrayList<>();
        for (int i = 0; i <= computers; i++){
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++){
            addEdge(sc.nextInt(), sc.nextInt());
        }
        for (int i = 1; i <= computers; i++){
            dfs(1);
        }

        System.out.println(count);
    }

    static void dfs(int start){
        visited[start] = true;
        for (int target : adjList.get(start)){
            if (!visited[target]){
                count++;
                dfs(target);
            }
        }
    }

    static void addEdge(int start, int end){
        adjList.get(start).add(end);
        adjList.get(end).add(start);
    }
}
