package LeetCode.StacksAndQueues;/* Min Stack 155 de leetcode

Problema:
Se quiere crear una pila que soporte las siguientes oepraciones:
  -push
  -pop
  -top devuelve el tope de la pil
  - getMin devuelve el minimo de la pila


Solucion:
Se resuleve usando dos pilas una para los valores y otra para los minimos
*/

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
