/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorithm;

/**
 * This class represents a stack. Stack is used to print the shortest paths from the start node to the other nodes.
 * @author fi72031
 */
public class Stack {
    
    private static int [] table;
    private static int top;
    
    /**
     * Creates a table repsenting stack.
     * @param n - size of the table (stack)
     */
    public Stack (int n) {
        top = -1;
        table = new int[n];
    }
    
    /**
     * Stack pop operation 
     * @return The last element of the table (stack)
     */
    public int pop(){
        int poptop = table[top];
        top--;
        return poptop;
    }
    
    /**
     * Stack push operation 
     * @param x The element to be added into table (stack).
     */
    public void push(int x){
        top++;
        table[top] = x;
    }

    /**
     * Checks, if the stack is empty.
     * @return - true, if the table (stack) is empty, otherwise false.
     */
    public boolean isEmpty(){
        return top==-1;
    }
    
}
