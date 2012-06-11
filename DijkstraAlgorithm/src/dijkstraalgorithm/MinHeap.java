/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package dijkstraalgorithm;

/**
 * This class represents a minimum heap. 
 * @author fi72031
 */

public class MinHeap {
    private Node[] Heap;
    private int size;
    
    /**
     * Creates a table representing a heap and initializes the first item.
     * @param max Heap size
     */
    public MinHeap(int max) {
	Heap = new Node[max];
	size = 0 ;
        Node [] a;
        int [ ] b;
        a = new Node [1];
        b = new int [1];
	Heap[0] = new Node(0,0,0,0,a,b);
    }

    /**
     * Checks, if the heap is empty.
     * @return true, if empty, otherwise returns false.
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    
    // returns left child's position in the heap
    private int leftchild(int pos) {
	return 2*pos;
    }
    
    // returns right child's position in the heap
    private int rightchild(int pos) {
	return 2*pos + 1;
    }

    // returns parent's position in the heap
    private int parent(int pos) {
	return  pos / 2;
    }
   
        // Swaps positions in the heap and updates heap position of the node
    private void swap(int pos1, int pos2) {
	Node tmp;
	tmp = Heap[pos1];
	Heap[pos1] = Heap[pos2];
	Heap[pos2] = tmp;
        Heap[pos1].setHeapNodeNumber(pos2);
        Heap[pos2].setHeapNodeNumber(pos1);
    }

    /**
     * Inserts the node to the heap. The heap is arranged according to the distance value of the node.
     * @param solmu Node to be inserted
     */
    public void insert(Node solmu) {
        size++;
	Heap[size] = solmu;
        int current = size;
        if (Heap[parent(current)] != null) {
            while (Heap[current].getDistance() < Heap[parent(current)].getDistance()) {
                swap(current, parent(current));
                current = parent(current);
            }
            solmu.setHeapNodeNumber(current);
        }
        else solmu.setHeapNodeNumber(1);
    }
    
    /**
     * Deletes the minimum value (index=1) of the heap 
     * @return the node in the heap position 1
     */
    public Node deleteMin() {
   
	Node min = Heap[1];
        Heap[1] = Heap[size];
        Heap[1].setHeapNodeNumber(1);
	size--;
	if (size != 0)
            heapify(Heap[1]);
	return min;
    }  
    
    /**
     * Decreases distance value of the node in the heap.
     * @param n Node, which distance value is decreased.
     * @param newkey New key value.
     */
    public void decreaseKey(Node n, int newkey) {
        if ( newkey <= n.getDistance()) {
            n.setDistance(newkey);
            int current = n.getHeapNodeNumber();
            while (Heap[current].getDistance() < Heap[parent(current)].getDistance()) {
                swap(current, parent(current));
                current = parent(current);
            }
        }
    }
    
    /*
     * Moves the node based on the nodes distance value to the correct place in the heap.
     */
    private void heapify(Node k)  {
        // haetaan solmun vasemmanpuolinen alkio
        int l = leftchild(k.getHeapNodeNumber());
        // haetaan solmun oikeanpuolinen alkio
        int r = rightchild(k.getHeapNodeNumber());
        l++; r++;
  //      Node [] apu; 
        Node smallest = k;   
   //    System.out.println("HPF1: size left right k.haeKekoAlkio()" +size +" "+ l + " " + r + " " + k.getHeapNodeNumber() );
   //     System.out.println("HPF1:size left right Heap[l].haeDistance()Heap[r].haeDistance()k.haeDistance() k.haeSolmu()");
   //     System.out.println("HPF1:"+size+" "+l+" "+r+" "+Heap[l].haeDistance()+" "+Heap[r].haeDistance()+" "+k.haeDistance()+" "+k.haeSolmu());
        
        // Jos solmulla on vasemmanpuoleinen lapsi ja lapsen distance on pienempi kuin käsiteltävän solmun distance,
        // niin smallest saa vasemmanpuoleisen lapsen arvon, muuten smallest saa käsiteltävänä olevan solmun distance-arvon
        if (l <= size && Heap[l].getDistance() < k.getDistance()) {
            smallest.setDistance(Heap[l].getDistance()); 
        }
        else {
            smallest.setDistance(k.getDistance());
        }
        if (r <= size && Heap[r].getDistance() < smallest.getDistance())  {
            smallest.setDistance(Heap[r].getDistance());
        }
        if (smallest.getDistance() != k.getDistance() ) {
            swap(k.getHeapNodeNumber(),smallest.getHeapNodeNumber());
            heapify(smallest);
        }
  //      System.out.println("SOLMU Heapifyn jälkeen");
   //     Solmu.print(k);
    }
     
    
    /**
     * Shows the content of the heap
     */
    public void print() {
        System.out.println("KEKO:---------------------------------------------");
	int i;
	for (i=1; i<=size;i++) {
	    System.out.println("Heap: ind, solmu, kekoalkio, distance: " +i+" "+Heap[i].getNodeNumber()+" "+Heap[i].getHeapNodeNumber()+" "+Heap[i].getDistance());
        }
        System.out.println("--------------------------------------------------");
	
    }

    
}
