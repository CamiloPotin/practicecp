/*
509. Fibonacci Number

Problema:
Se quiere hacer un algoritmo para calcular el numero de fibonacci

Solucion:
Se hizo la solucion recursiva

*/


class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        return fib(n-1) + fib(n-2);
    }
}
