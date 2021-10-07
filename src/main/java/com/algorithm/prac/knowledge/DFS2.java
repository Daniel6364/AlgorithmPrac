package com.algorithm.prac.knowledge;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DFS2 {

    static final int MAN_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAN_N][MAN_N];
//    static boolean[] Visited = new boolean[MAN_N];

    static void dfs(int node) {

        System.out.println("============// dfs - node : " + node);

        boolean[] visited = new boolean[MAN_N];

        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {
            int currentNode = stack.pop();
            System.out.println("현재 노드는? => " + currentNode);

            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            System.out.println(currentNode + " ");
            System.out.println("visited : " + Arrays.toString(visited));


            for (int nextNode = 0; nextNode < N; ++nextNode) {
                if (!visited[nextNode] && Graph[currentNode][nextNode] != 0) {
                    stack.push(nextNode);
                }
            }
        }

    }

    static void bfs(int node) {

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=====// 몇개의 노드를 설정하시겠습니까?");
        N = sc.nextInt();
        System.out.println("==// 1. 노드의 개수 N : " + N);


        System.out.println("=====// 몇개의 간선을 설정하시겠습니까?");
        E = sc.nextInt();
        System.out.println("==// 2. 간선의 개수 E : " + E);

        System.out.println("==// 노드간 간선의 형태 설정 시작!");
        for (int i = 0; i < E; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            System.out.println("u / v ==> " + u + " / " + v);

            Graph[u][v] = Graph[v][u] = 1;
            System.out.println("Graph["+u+"]["+v+"] : " +Graph[u][v]);

        }
        dfs(0);
//        bfs(0);
    }
}
