package LeetCode.StacksAndQueues;/*
Baseball Game 682 de leetode

Problema:
Se tiene un arreglo de Strings que contienen las siguientes caracteres:
  - x un integer que se debe agregar para sumar
  - "C" es una operacion de eliminar el ultimo entero que se agrego
  - "D" es para duplicar el ultimo entero que se agrego y se agrego tambien 
  - "+" se suman los dos ultimos enteros agregados y se agrega al final

Solucion:
Se usa una Pila y se van guardando los valores segun las distintas operaciones que se encuentren
en el arreglo

*/


class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String ch : operations){
            if(ch.equals("C")){
                stack.pop();
            } else if(ch.equals("D")){
                        int num = stack.pop();
                        stack.push(num);
                        stack.push(num*2);
            } else if(ch.equals("+")){
                        int num1= stack.pop();
                        int num2= stack.pop();
                        stack.push(num2);
                        stack.push(num1);
                        stack.push(num1+num2);

            } else stack.push( Integer.parseInt(ch));

        }
        int sum = 0;
        while(!stack.isEmpty()){
                sum+= stack.pop();
        }
        return sum;
    }
}
