package com.freeraven.unsorted;

/**
 * Created by zvlades on 5/19/17.
 */

/**
 * Find number of сonnected components (a. k. a. GraphConnectedComponentsCounter Cluster) in graph defined by adjacency matrix
 */
public class GraphConnectedComponentsCounter {
    static int zombieCluster(String[] zombies) {
        int n = zombies.length;
        boolean[][] matrix = getAdjacencyMatrix(zombies, n);
        boolean[] visited = new boolean[n];

        int numberOfClusters = 0;
        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited[vertex]) {
                numberOfClusters++;
                dfs(vertex, matrix, visited);
            }

        }
        return numberOfClusters;
    }

    private static boolean[][] getAdjacencyMatrix(String[] zombies, int n) {
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = zombies[i].charAt(j);
                matrix[i][j] = c == '1';
            }
        }
        return matrix;
    }

    private static void dfs(int i, boolean[][] matrix, boolean[] visited) {
        if(!visited[i]) {
            visited[i] = true;

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] && !visited[j]) {
                    dfs(j, matrix, visited);
                }
            }
        }
    }
}
