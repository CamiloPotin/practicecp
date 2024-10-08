package LeetCode.StacksAndQueues;/*
Valid Parentesis 20 de leetcode

Problema:
Se tiene un arreglo de parentesis ("{}","()","[]") y se quiere saber si todos cierran perfecto

Solucion:
Se usa una pila y se compara cada caracter
*/

import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
         for(int i=0;i<s.length();i++){
             char c= s.charAt(i);
             if(c==')' || c==']' || c=='}'){
                    if(stack.empty()) return false;
                    char aux=stack.pop();
                    switch(c){
                        case ')': if(aux!='(') return false;
                        break;
                        case ']': if(aux!='[') return false;
                        break;
                        case '}': if(aux!='{') return false;
                    }

             } else stack.push(c);
         }
        return stack.empty();
    }
}
