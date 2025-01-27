package org.example;

import java.util.ArrayList;
import java.util.List;

/* 1462. Course Schedule IV
>У нас есть набор курсов, которые нужно пройти. Их номера идут от 0 до numCourses - 1.
>А также есть список prerequisites, где каждая пара [a, b] означает: чтобы пройти курс b, сначала нужно пройти курс a.
>Также у нас есть список вопросов queries. Каждый вопрос [u, v] спрашивает: "Является ли курс u необходимым (прямо или косвенно) для прохождения курса v?"
>\Нужно вернуть массив ответов, где каждый элемент отвечает на вопрос в queries


numCourses = 2, prerequisites = [[1, 0]], queries = [[0, 1], [1, 0]]
Ответ: [false, true]
- [1, 0]: Курс 1 обязателен для курса 0.
- [0, 1]: Курс 0 не обязателен для курса 1.
 *
* */
public class Solution1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //reachable[i][j] будет обозначать: "Можно ли добраться из курса i до курса j?"
        boolean[][] reachable = new boolean[numCourses][numCourses];


        //мы проходим по массиву prerequisites и отмечаем прямые зависимости
        for (int[] pre : prerequisites) {
            reachable[pre[0]][pre[1]] = true;
        }


        //Найти все зависимости (прямые и косвенные)
        //Для этого мы применяем алгоритм Флойда-Уоршелла
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }


        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }

        return result;
    }
}
