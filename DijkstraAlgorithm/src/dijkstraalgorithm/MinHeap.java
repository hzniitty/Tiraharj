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
//	maxsize = max;
//	Heap = new int[maxsize];
	Heap = new int[max];
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
        for (int i=0;i<=size;i++) {
   //     System.out.println(" heap " + Heap[i]);
        }
    }
    
// decrease the key associated with index k
    public void decreaseKey(int key, int newkey) {
        if ( newkey <= Heap[key]) {
            Heap[key] = newkey;
            pushdown(Heap[key]);
        }
    }
    
     private void heapify(int k)  {
        int l = leftchild(k);
        int r = rightchild(k);
        int smallest = 0;
        if (l <= size && Heap[l] < Heap [k])
            smallest = l;
        else smallest = k;
        if (r <= size && Heap[r] < Heap[smallest]) 
            smallest = r;
        if (smallest != k ) {
            swap(Heap[k],Heap[smallest]);
            heapify(smallest);
        }
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
    
    public void print() {
	int i;
	for (i=1; i<=size;i++) {
	    System.out.print("Solmu " + Heap[i] + " Distance " + keys[i]);
            System.out.println();
        }
    }

    public int removemin() {
	int min = Heap[1];
        Heap[1] = Heap[size];
	size--;
	if (size != 0)
	    pushdown(1);
	return min;
    }

    
}
