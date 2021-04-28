package com.algorithm.prac.knowledge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


// 인접리스트 구현
public class DFS {
    
    public static ArrayList<Integer>[] arrList;
    public static boolean[] visited; 


    public static void dfs(int node) {
        
        visited[node] = true;
        System.out.println(node + " ");
        for (int val : arrList[node]) {
            if (!visited[val]) {
                dfs(val);
            }
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println("==// 정점의 개수 n : " + n);
        int m = sc.nextInt();
        System.out.println("==// 간선의 개수 m : " + m);
        int start = sc.nextInt();
        System.out.println("==// 시작할 정점 start : " + start);

        arrList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arrList[i] = new ArrayList<Integer>();
        }


        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            arrList[u].add(v);
            arrList[v].add(u);
        }

        dfs(start);

        System.out.println("======================//");
        System.out.println("==// arrList : " + Arrays.toString(arrList));
        System.out.println("==// visited : " + Arrays.toString(visited));
   

    }
}
