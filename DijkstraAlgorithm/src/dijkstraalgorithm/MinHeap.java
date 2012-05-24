/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package dijkstraalgorithm;

/**
 *
 * @author fi72031
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinHeap {
    private int[] Heap;
    private int maxsize;
    private int size;
    private int[] keys;

    public MinHeap(int max) {
	maxsize = max;
	Heap = new int[maxsize];
	size = 0 ;
	Heap[0] = Integer.MIN_VALUE;
        keys = new int[max];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    private int leftchild(int pos) {
	return 2*pos;
    }
    private int rightchild(int pos) {
	return 2*pos + 1;
    }

    private int parent(int pos) {
	return  pos / 2;
    }
    
    private boolean isleaf(int pos) {
	return ((pos > size/2) && (pos <= size));
    }

    private void swap(int pos1, int pos2) {
	int tmp;

	tmp = Heap[pos1];
	Heap[pos1] = Heap[pos2];
	Heap[pos2] = tmp;
    }

    public void insert(int elem, int key) {
	size++;
	Heap[size] = elem;
        int current = size;
        keys[elem] = key;
	while (Heap[current] < Heap[parent(current)]) {
	    swap(current, parent(current));
	    current = parent(current);
	}	
    }
    
// decrease the key associated with index k
    public void decreaseKey(int key, int newkey) {
        if ( newkey <= Heap[key]) {
            Heap[key] = newkey;
            heapify(Heap[key]);
        }
    }
    
     private void heapify(int k)  {
        int l = leftchild(k);
        int r = rightchild(k);
        int largest = 0;
        if (r <= size) {
           if (Heap[l] > Heap [r])
                   largest = l;
           else largest = r;
           if (Heap[k] < Heap[largest]) {
               int a = Heap[k];int b = Heap[largest];
               Heap[k] = b; Heap[largest] = a;
               heapify(largest);
           } 
           else if (l == size && Heap[k] < Heap[l]) {
               int a = Heap[k];int b = Heap[l];
               Heap[k] = b; Heap[largest] = a;
           }
        }
    }
    
    public void print() {
	int i;
	for (i=1; i<=size;i++)
	    System.out.print(Heap[i] + " ");
	System.out.println();
    }

    public int removemin() {
	swap(1,size);
	size--;
	if (size != 0)
	    pushdown(1);
	return Heap[size+1];
    }

    private void pushdown(int position) {
	int smallestchild;
	while (!isleaf(position)) {
	    smallestchild = leftchild(position);
	    if ((smallestchild < size) && (Heap[smallestchild] > Heap[smallestchild+1]))
		smallestchild = smallestchild + 1;
	    if (Heap[position] <= Heap[smallestchild]) return;
	    swap(position,smallestchild);
	    position = smallestchild;
	}
    }
}
