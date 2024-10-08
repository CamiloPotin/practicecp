package LeetCode.ArraysAndStrings;/*
Best Time to buy and sell stock 121 de leetcode


Problema: 
Se quiere saber cuando se tiene mas ganancia comprando y vendiendo stocks. 
Se tiene un arreglo de precios de stocks y se debe calcular la mayor ganancia posible.

Solucion: 
Se va guardando el minimo de precio de stock y se calcula la diferencia del valor actual con el minimo y se compara con un maximo
*/

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE ;
        int profit = 0 ;
     for (int i = 0; i < prices.length; i++) {
                if(prices[i]<min)
                    min = prices[i];
                if(prices[i]-min>profit)
                    profit = prices[i] - min;
        }
        return profit;

    }
}
