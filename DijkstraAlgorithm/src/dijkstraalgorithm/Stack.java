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
    
    public Stack (int n) {
        top = -1;
        table = new int[n];
    }
    
    public int pop(){
        int pois = table[top];
        top--;
        return pois;
    }
    
    public void push(int x){
        top++;
        table[top] = x;
    }

    public boolean isEmpty(){
        return top==-1;
    }
    
}
