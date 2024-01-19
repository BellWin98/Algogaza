import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> adjList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        visited = new boolean[N + 1];
        adjList = new ArrayList<>();

        for (int i = 0; i <= N; i++){
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            addEdge(sc.nextInt(), sc.nextInt());
        }

        for (int i = 1; i <= N; i++){
            Collections.sort(adjList.get(i));
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(V);

    }

    static void addEdge(int start, int end){
        adjList.get(start).add(end);
        adjList.get(end).add(start);
    }

    static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");
        for (int node : adjList.get(start)){
            if (!visited[node]){
                dfs(node);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> Q = new LinkedList<>();
        visited[start] = true;
        Q.offer(start);
        while (!Q.isEmpty()){
            int node = Q.poll();
            System.out.print(node + " ");
            for (int target : adjList.get(node)){
                if (!visited[target]){
                    visited[target] = true;
                    Q.offer(target);
                }
            }
        }
    }
}