/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package dijkstraalgorithm;

/**
 *
 * @author fi72031
 */

public class MinHeap {
    private Node[] Heap;
    private int size;
    
    /**
     * 
     * @param max
     */
    public MinHeap(int max) {
//	maxsize = max;
//	Heap = new int[maxsize];
	Heap = new Node[max];
	size = 0 ;
	Heap[0] = new Node(0,0,0,0);
    }

    /**
     * 
     * @return
     */
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
	Node tmp;
	tmp = Heap[pos1];
	Heap[pos1] = Heap[pos2];
	Heap[pos2] = tmp;
        Heap[pos1].setHeapNodeNumber(pos2);
        Heap[pos2].setHeapNodeNumber(pos1);
    }

    /**
     * 
     * @param solmu
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
        
   //     for (int i=0;i<=size;i++) {
   //     System.out.println(" heap " + Heap[i]);
   //     }
        }
        else solmu.setHeapNodeNumber(1);
    }
    
    
    /**
     * 
     * @param n
     * @param newkey
     */
    public void decreaseKey(Node n, int newkey) {
//        System.out.println("DECREASEKEY: solmu distance newkey " + n.getNodeNumber() + " " + n.getDistance() + " " + newkey + " ");
        if ( newkey <= n.getDistance()) {
            n.setDistance(newkey);
  //          pushdown(Heap[key]);
       //     heapify(key);
       //     heapify(Heap[0]);
            int current = n.getHeapNodeNumber();
            while (Heap[current].getDistance() < Heap[parent(current)].getDistance()) {
                swap(current, parent(current));
                current = parent(current);
            }
        }
    }
    
    private void heapify(Node k)  {
        // haetaan solmun vasemmanpuolinen alkio
        int l = leftchild(k.getHeapNodeNumber());
        // haetaan solmun oikeanpuolinen alkio
        int r = rightchild(k.getHeapNodeNumber());
        l++; r++;
        Node [] apu; 
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
     * 
     */
    public void print() {
        System.out.println("KEKO:---------------------------------------------");
	int i;
	for (i=1; i<=size;i++) {
	    System.out.println("Heap: ind, solmu, kekoalkio, distance: " +i+" "+Heap[i].getNodeNumber()+" "+Heap[i].getHeapNodeNumber()+" "+Heap[i].getDistance());
        }
        System.out.println("--------------------------------------------------");
	
    }

    /**
     * 
     * @return
     */
    public Node deleteMin() {
   
	Node min = Heap[1];
        Heap[1] = Heap[size];
        Heap[1].setHeapNodeNumber(1);
	size--;
	if (size != 0)
//	    pushdown(1);
            heapify(Heap[1]);
	return min;
    }  
}
