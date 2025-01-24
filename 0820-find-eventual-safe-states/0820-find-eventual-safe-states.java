class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
     int n = graph.length;
        // State array: 0 = unvisited, 1 = visiting, 2 = safe
        int[] state = new int[n];
        List<Integer> safeNodes = new ArrayList<>();

        // DFS helper function
        for (int i = 0; i < n; i++) {
            if (state[i] == 0) {
                dfs(graph, i, state);
            }
        }

        // Collect all safe nodes
        for (int i = 0; i < n; i++) {
            if (state[i] == 2) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

        // DFS function to mark the node as safe or unsafe
    private int dfs(int[][] graph, int node, int[] state) {
        if (state[node] != 0) {
            return state[node];  // Return the state of the node
        }

        // Mark the node as visiting (1)
        state[node] = 1;

        // Explore all neighbors of the current node
        for (int neighbor : graph[node]) {
            if (state[neighbor] == 1 || dfs(graph, neighbor, state) == 1) {
                // If neighbor is visiting or leads to an unsafe node, mark the current node as unsafe
                state[node] = 1;
                return 1;
            }
        }

        // Mark the node as safe (2)
        state[node] = 2;
        return 2;
    }
}