/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorithm;

/**
 * This class represents a node (vertex) in the Graph.  
 * 
 * @author Hannu
 */
public class Node implements Comparable<Node>{
    private int node;
    private int distance;
    private int path;
    private int heapPosition;
    private  Node [] adjacentNodes;
    private int [] cost;
    private int numberOfAdjacentNodes;
    
    /**
     * 
     * @param dijkstraNode Node number, used as a key.
     * @param nodeDistance Shortest distance from the start node.
     * @param nodePath From which node the cost is smallest.
     * @param nodeHeapPosition Shows the nodes positions in a Heap.
     * @param nodeAdjacentNodes Nodes adjacent nodes.
     * @param nodeCost  Cost to the adjacent node.
     */
    public Node(int dijkstraNode, int nodeDistance, int nodePath, int nodeHeapPosition, Node[] nodeAdjacentNodes, int[] nodeCost) {
        node=dijkstraNode;
        distance=nodeDistance;
        path=nodePath;
        heapPosition=nodeHeapPosition;
        adjacentNodes= new Node[nodeAdjacentNodes.length];
        cost = new int [nodeCost.length];
        for (int i=0;i<nodeAdjacentNodes.length;i++) {
            if (adjacentNodes[i] != null) {
                adjacentNodes[i]=nodeAdjacentNodes[i];
                cost[i]=nodeCost[i];
            }
        } 
        numberOfAdjacentNodes=0;
    } 
    
    /**
     * 
     * @param dijkstraNode
     * @param nodeDistance
     * @param nodePath
     * @param nodeHeapPosition
     */
    /*
    public Node(int dijkstraNode, int nodeDistance, int nodePath, int nodeHeapPosition) {
        node=dijkstraNode;
        distance=nodeDistance;
        path=nodePath;
        heapPosition=nodeHeapPosition;
        numberOfAdjacentNodes=0;
    } 
    */
    
    /**
    * Sets the number (key) of the node.
    *  
    * @param index The number of the node.
    * @author Hannu
    */
    public void setNodeNumber(int index) {
        this.node=index;
    }
    
    /**
     * Returns the number (key) of the node
     * @return node number
     */
    
    public int getNodeNumber() {
        return node;
    }
    
    /**
     * Sets the distance of the node.
     * @param dist
     */
    public void setDistance(int dist) {
        this.distance=dist;
    }
   
    /**
     * Returns the distance of the node.
     * @return Distance
     */
    public int getDistance() {
        return distance;
    }
    
    /**
     * Sets the position of the node in the heap
     * @param heapPosition 
     */
    public void setHeapNodeNumber(int heapPosition) { 
        this.heapPosition = heapPosition;
    }
       
    /**
     * Returns the position of the node in the heap.
     * @return Heap position
     */
    public int getHeapNodeNumber() {
        return heapPosition;
    }
    
    
    /**
     * Sets the shortest path to the node
     * @param index The index of the node.
     */
    public void setPath(int index) {
        this.path=index;
    }
    
    /**
     * Returns the shortest path of the node.
     * @return shortest path
     */
    public int getPath() {
        return path;
    }
    
    /**
     * Sets the number of adjacent nodes.
     */
    private void setNumberOfAdjacentNodes() {
        numberOfAdjacentNodes++;
    }
    
    /**
     * Returns the number of the adjacent nodes.
     * @return The number of the adjacent nodes.
     */
    public int getNumberOfAdjacentNodes() {
        return numberOfAdjacentNodes;
    }
     
    /**
     * Sets an adjacent node.
     * @param n Adjacent node reference
     */
    public void setAdjacentNode(Node n) {
        this.adjacentNodes[getNumberOfAdjacentNodes()]=n;
        setNumberOfAdjacentNodes();
    }
    
    /**
     * Returns the adjacent node.
     * @param ind The index of the adjacent node.
     * @return The adjacent node reference
     */
    public Node getAdjacentNode(int ind) {
        return adjacentNodes[ind];
    }
    
    
    
    /**
     * 
     * @param nodes
     */
    
    /*
    public void setAdjacentNodes(Node [] nodes) {
        adjacentNodes= new Node[nodes.length];
        for (int i=0;i<nodes.length;i++) {
       //   System.out.println(" i solmu " + i + " " + solmut[i] + " " + solmut.length);
            if (nodes[i] != null) {
       //         System.out.println(" i solmu " + i + " " + solmut[i]);
                this.adjacentNodes[i]=nodes[i];
                setNumberOfAdjacentNodes();
            }
        }
    }
    
    */
    
    /**
     * Sets adjacent node cost.
     * @param n Adjacent node reference
     */
    public void setCost(int n) {
        this.cost[getNumberOfAdjacentNodes()-1]=n;
    }
    
    /**
     * 
     * @param costs
     */
    /*
    public void setCosts(int [] costs) {
        cost= new int [costs.length];
        for (int i=0;i<costs.length;i++) {
       //   System.out.println(" i solmu " + i + " " + solmut[i] + " " + solmut.length);
        //    if (kustannukset[i] != 0) {
       //         System.out.println(" i solmu " + i + " " + solmut[i]);
                this.cost[i]=costs[i];
       //     }
        }
    }
    */
    
    /**
     * Returns the cost of the adjacent node.
     * @param index The key of the adjacent node.
     * @return The cost to the adjacent node.
     */
    public int getCost(int index) {
        return cost[index];
    }
    
    /**
     * Prints the node attributes in formatted output. Used for debugging purposes.
     * @param p The node to the printed.
     * @param numberOfNodes The maximum number of adjacent nodes.
     */
    public static void print(Node p, int numberOfNodes) {
        System.out.println("--------------------------");
        System.out.println("Solmu: " + p.getNodeNumber());
        System.out.println("Distance: " + p.getDistance());
        System.out.println("Polku: " + p.getPath());
        System.out.println("Kekoalkio: " + p.getHeapNodeNumber());
        for (int i=0;i<numberOfNodes;i++) {
            if (p.adjacentNodes[i] != null)
                System.out.println("Vierussolmut: " + p.adjacentNodes[i].getNodeNumber()+ " " + p.getAdjacentNode(i));
        }
        System.out.println("--------------------------");
        
    }

    /**
     * Used for debugging purposes to compare distances of nodes.
     * @param t - node to be compared.
     * @return -1 if this objects distance is less than comparable node's distance.
     * 0, if distances are equal. 
     * 1, if comparable node's distance is bigger than this object's distance.
     */
  
    @Override
    public int compareTo(Node t) {
        if (this.distance < t.distance) {
            return -1;
        } else if (this.distance > t.distance) {
            return 1;
        } else {
            return 0;
        }
    }
    
    /**
     * Used for debugging purposes to show node attributes.
     * @return Node attributes
     */
    @Override
    public String toString() {
        return "Solmu{" + "solmu=" + node + ", polku=" + path + ", distance=" + distance + ", kekoAlkio=" + heapPosition + ", vierusSolmut=" + adjacentNodes + ", kustannus=" + cost + '}';
    }
    
}
