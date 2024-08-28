package LeetCode.StacksAndQueues;/*
Evaluate Reverse Polish Notation 150 de leetcode

Problema:
Se tiene un String de numeros y signos que representan una ecuacion reversa se quiere saber el numero resultante

Solucion:
Se va guardndo los operandos en una pila y cuando el String es un signo se hace la 
suma correspondiente con esos dos operandos.


*/



class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String ch : tokens){
            
            if(ch.equals("+") || ch.equals("-") || ch.equals("/") || ch.equals("*")){
                int num1= stack.pop();
                int num2= stack.pop();
                if(ch.equals("+") )   stack.push(num2+num1);
                else if(ch.equals("-") )   stack.push(num2-num1);
                else if(ch.equals("/") )   stack.push(num2/num1);
                else  stack.push(num2*num1);
                //System.out.println(num2+" "+ch+" "+num1);
              
            } else stack.push(Integer.parseInt(ch));
        }
        return stack.pop();


    }
}
