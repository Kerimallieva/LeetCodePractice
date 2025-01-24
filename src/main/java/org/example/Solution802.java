package org.example;

import java.util.ArrayList;
import java.util.List;
/*Cуть этой задачи заключается в том что у нас есть города(узлы),
 и дороги(связи между узлами). Город называется ТЕРМИНАЛЬНЫМ, если из него
 нельзя никуда уехать(если нет узлов).
 Город считается безопасным если: из него можно доехать до терминального города(если узел ведет только к терминальному узлу)
 или это и есть безопасный город(то есть узлы без связей)

и наша задача вывести из данного массива безопасные города*/

class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();
        int[] state = new int[graph.length]; // 0: unvisited, 1: visiting, 2: safe

        for (int i = 0; i < graph.length; i++) {
            if (isSafe(i, graph, state)) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean isSafe(int node, int[][] graph, int[] state) {
        if (state[node] != 0) { // Если узел уже был проверен
            return state[node] == 2; // Если безопасен, возвращаем true
        }

        state[node] = 1; // Отмечаем как "в процессе проверки"

        for (int neighbour : graph[node]) {
            if (!isSafe(neighbour, graph, state)) {
                state[node] = 3; // Небезопасен
                return false;
            }
        }

        state[node] = 2; // Если все соседи безопасны, помечаем узел как безопасный
        return true;
    }
}
