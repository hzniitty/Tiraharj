/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorithm;

/**
 *
 * @author fi72031
 */
public class Stack {
    
    private static int [] table;
    private static int top;
    
    /**
     * 
     * @param n
     */
    public Stack (int n) {
        top = -1;
        table = new int[n];
    }
    
    /**
     * 
     * @return
     */
    public int pop(){
        int poptop = table[top];
        top--;
        return poptop;
    }
    
    /**
     * 
     * @param x
     */
    public void push(int x){
        top++;
        table[top] = x;
    }

    /**
     * 
     * @return
     */
    public boolean isEmpty(){
        return top==-1;
    }
    
}
