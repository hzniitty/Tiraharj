/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package dijkstraalgorithm;

/**
 *
 * @author fi72031
 */

// import java.util.Iterator;
// import java.util.NoSuchElementException;

public class MinHeap {
    private Solmu[] Heap;
    private int maxsize;
    private int size;
    private int[] keys;
    private Solmu[] solmut;

    public MinHeap(int max) {
//	maxsize = max;
//	Heap = new int[maxsize];
	Heap = new Solmu[max];
	size = 0 ;
	Heap[0] = new Solmu(0,0,0,0);
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
	Solmu tmp;

	tmp = Heap[pos1];
	Heap[pos1] = Heap[pos2];
	Heap[pos2] = tmp;
        Heap[pos1].asetaKekoAlkio(pos2);
        Heap[pos2].asetaKekoAlkio(pos1);
    }

    public void insert(Solmu solmu) {
        size++;
	Heap[size] = solmu;
        int current = size;
        if (Heap[parent(current)] != null) {
            while (Heap[current].haeDistance() < Heap[parent(current)].haeDistance()) {
                swap(current, parent(current));
                current = parent(current);
            }
            solmu.asetaKekoAlkio(current);
        
   //     for (int i=0;i<=size;i++) {
   //     System.out.println(" heap " + Heap[i]);
   //     }
        }
        else solmu.asetaKekoAlkio(1);
    }
    
    
    /*
        public void insert(int elem, int key) {
	size++;
	Heap[size] = elem;
        int current = size;
        keys[elem] = key;
	while (Heap[current] < Heap[parent(current)]) {
	    swap(current, parent(current));
	    current = parent(current);
	}
   //     for (int i=0;i<=size;i++) {
   //     System.out.println(" heap " + Heap[i]);
   //     }
    }
    
        */
// decrease the key associated with index k
    public void decreaseKey(Solmu key, int newkey) {
        System.out.println("DECREASEKEY: solmu distance newkey " + key.haeSolmu() + " " + key.haeDistance() + " " + newkey + " ");
        if ( newkey <= key.haeDistance()) {
            key.asetaDistance(newkey);
  //          pushdown(Heap[key]);
       //     heapify(key);
       //     heapify(Heap[0]);
            int current = key.haeKekoAlkio();
            while (Heap[current].haeDistance() < Heap[parent(current)].haeDistance()) {
                swap(current, parent(current));
                current = parent(current);
            }
        }
    }
    
    private void heapify(Solmu k)  {
        // haetaan solmun vasemmanpuolinen alkio
        int l = leftchild(k.haeKekoAlkio());
        // haetaan solmun oikeanpuolinen alkio
        int r = rightchild(k.haeKekoAlkio());
        l++; r++;
        Solmu [] apu; 
        Solmu smallest = k;   
       System.out.println("HPF1: size left right k.haeKekoAlkio()" +size +" "+ l + " " + r + " " + k.haeKekoAlkio() );
        System.out.println("HPF1:size left right Heap[l].haeDistance()Heap[r].haeDistance()k.haeDistance() k.haeSolmu()");
   //     System.out.println("HPF1:"+size+" "+l+" "+r+" "+Heap[l].haeDistance()+" "+Heap[r].haeDistance()+" "+k.haeDistance()+" "+k.haeSolmu());
        
        // Jos solmulla on vasemmanpuoleinen lapsi ja lapsen distance on pienempi kuin käsiteltävän solmun distance,
        // niin smallest saa vasemmanpuoleisen lapsen arvon, muuten smallest saa käsiteltävänä olevan solmun distance-arvon
        if (l <= size && Heap[l].haeDistance() < k.haeDistance()) {
            smallest.asetaDistance(Heap[l].haeDistance()); 
        }
        else {
            smallest.asetaDistance(k.haeDistance());
        }
        if (r <= size && Heap[r].haeDistance() < smallest.haeDistance())  {
            smallest.asetaDistance(Heap[r].haeDistance());
        }
        if (smallest.haeDistance() != k.haeDistance() ) {
            swap(k.haeKekoAlkio(),smallest.haeKekoAlkio());
            heapify(smallest);
        }
  //      System.out.println("SOLMU Heapifyn jälkeen");
   //     Solmu.print(k);
    }
     
    
    /* 
     private void pushdown(int position) {
//	Solmu dSolmu = solmut[position];
        
         int smallestchild;
	while (!isleaf(position)) {
	    smallestchild = leftchild(position);
            System.out.print("Smallestchild = " + smallestchild);
	    if ((smallestchild < size) && (Heap[smallestchild] > Heap[smallestchild+1]))
		smallestchild = smallestchild + 1;
	    if (Heap[position] <= Heap[smallestchild]) return;
	    swap(position,smallestchild);
	    position = smallestchild;
	}
  //      dSolmu.kekoAlkio(position);
    }
    */
    public void print() {
        System.out.println("KEKO:---------------------------------------------");
	int i;
	for (i=1; i<=size;i++) {
	    System.out.println("Heap: ind, solmu, kekoalkio, distance: " +i+" "+Heap[i].haeSolmu()+" "+Heap[i].haeKekoAlkio()+" "+Heap[i].haeDistance());
        }
        System.out.println("--------------------------------------------------");
	
    }

    public Solmu deleteMin() {
   
	Solmu min = Heap[1];
        Heap[1] = Heap[size];
        Heap[1].asetaKekoAlkio(1);
	size--;
	if (size != 0)
//	    pushdown(1);
            heapify(Heap[1]);
	return min;
    }

    
}
