package LeetCode.StacksAndQueues;/*
Daily Temperatures 739 de leetcode

Problema:
Se tiene una arreglo de temperaturas por cada dia y se quiere saber cuando mejoran las temperaturas

Solucion:
Se lleva en una pila las temperaturs y sus indices y por cada nueva temperatura se va comparando con las guardadas en la pila
y en caso de que sean mayores se guarda la diferencia entre indices en la temperatura correspondiente

*/


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < temp) {
                int[] prev = stack.pop();
                answer[prev[1]] = i - prev[1];
            }
            stack.push(new int[]{temp, i});
        }
        return answer;
    }
}
