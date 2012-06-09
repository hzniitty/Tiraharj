/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorithm;

/**
 * This class represents a Node (Vertex) in the Graph. 
 * 
 * @author Hannu
 */
public class Node implements Comparable<Node>{
    private int node;
    private int distance;
    private int path;
    private int heapPosition;
    /**
     * 
     */
    public  Node [] adjacentNodes;
    private int [] cost;
    private int numberOfAdjacentNodes;
    
    /**
     * 
     * @param dijkstraNode Node number, used as a key
     * @param nodeDistance
     * @param nodePath
     * @param nodeHeapPosition 
     * @param nodeAdjacentNodes
     * @param nodeCost  
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
    
    // konstruktori
    /**
     * 
     * @param dijkstraSolmu
     * @param nodeDistance
     * @param nodePath
     * @param nodeHeapPosition
     */
    public Node(int dijkstraSolmu, int nodeDistance, int nodePath, int nodeHeapPosition) {
        node=dijkstraSolmu;
        distance=nodeDistance;
        path=nodePath;
        heapPosition=nodeHeapPosition;
        numberOfAdjacentNodes=0;
    } 
    
 /**
 * This method sets the number of the Node.
 * this is the second line.
 * @param index 
 * @author Hannu
 */
    public void setNodeNumber(int index) {
        this.node=index;
    }
    
    /**
     * 
     * @return
     */
    public int getNodeNumber() {
        return node;
    }
    
    /**
     * 
     * @return
     */
    public int getDistance() {
        return distance;
    }
    
    /**
     * 
     * @param dist
     */
    public void setDistance(int dist) {
        this.distance=dist;
    }
    
    /**
     * 
     * @return
     */
    public int getHeapNodeNumber() {
        return heapPosition;
    }
    
    /**
     * 
     * @param heapPosition
     */
    public void setHeapNodeNumber(int heapPosition) {
     
        this.heapPosition = heapPosition;
    }
    
    /**
     * 
     * @param index
     */
    public void setPath(int index) {
        this.path=index;
    }
    
    /**
     * 
     * @return
     */
    public int getPath() {
        return path;
    }
     
    /**
     * 
     * @return
     */
    public int getNumberOfAdjacentNodes() {
        return numberOfAdjacentNodes;
    }
    
    /**
     * 
     */
    public void setNumberOfAdjacentNodes() {
        numberOfAdjacentNodes++;
    }
    
    /**
     * 
     * @param ind
     * @return
     */
    public Node getAdjacentNode(int ind) {
        return adjacentNodes[ind];
    }
    
    /**
     * 
     * @param n
     */
    public void setAdjacentNode(Node n) {
        this.adjacentNodes[getNumberOfAdjacentNodes()]=n;
        setNumberOfAdjacentNodes();
//        System.out.println("setAdjacentNode " + getNumberOfAdjacentNodes() + this + "vierussolmu"+ n);
    }
    
    /**
     * 
     * @param nodes
     */
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
    
    /**
     * 
     * @param n
     */
    public void setCost(int n) {
        this.cost[getNumberOfAdjacentNodes()-1]=n;
    }
    
    /**
     * 
     * @param costs
     */
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
    
    /**
     * 
     * @param index
     * @return
     */
    public int getCost(int index) {
        return cost[index];
    }
    
    /**
     * Selostus.
     * rivi 2
     * @param p the node to the printed
     * @param numberOfNodes  
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
     * 
     * @param t
     * @return
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
     * 
     * @return
     */
    @Override
    public String toString() {
        return "Solmu{" + "solmu=" + node + ", polku=" + path + ", distance=" + distance + ", kekoAlkio=" + heapPosition + ", vierusSolmut=" + adjacentNodes + ", kustannus=" + cost + '}';
    }
    
}
