/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorithm;

import java.io.File;
import java.util.Scanner;
/**
 * This class 
 * @author hzniitty
 */
public class DijkstraAlgorithm {

    /**
     * This method reads the number of nodes from input file.
     * @param file input file
     * @return  
     */
    
    public static int readNumberOfNodes(String file) {
        int numberOfNodes = 0;      
        try {
            Scanner scan = new Scanner(new File (file));
            int count = 0;
            String [] rowsplit;
            String [] values;
            while(scan.hasNext()) {
                String row = scan.nextLine();
                if (row.startsWith("solmujen_lukumaara")) {
                    rowsplit = row.split("=");
                    numberOfNodes = Integer.parseInt(rowsplit [1]);   
                return numberOfNodes;  
                } 
            }
        }
        catch(Exception ex) {
        System.out.println("Virhe syötteessä: " + ex);
        return -1;
        }
        return numberOfNodes;  
    }
    
    /**
     * 
     * @param file
     * @return
     */
    public static int readStartNode(String file) {
        int startNode = 0;
        try {
//            Scanner scan = new Scanner(new File("verkko.txt"));
            Scanner scan = new Scanner(new File (file));
            int count = 0;
            String [] rowsplit;
            
            while(scan.hasNext()) {
                String row = scan.nextLine();
                if (row.startsWith("aloitus_solmu")) {
                    rowsplit = row.split("=");
                    startNode = Integer.parseInt(rowsplit [1]);
                } 
            }
         
        }
        catch(Exception ex) {
        System.out.println("Virhe syötteen käsittelyssä" + ex);
        }
        return startNode;  
    }
    
    /**
     * 
     * @param file
     * @return
     */
    public static Node [] readAdjacentNodes(String file, int numberOfNodes, Node [] nodes) {
        // int numberOfRows = 0;
        int [] [] adjacentMatrix = new int [0] [0];
        Node [] vierusSolmut;
        int [] kustannukset;
        try {
            Scanner scan = new Scanner(new File (file));
            int count = 0;
            String [] rowsplit;
            String [] values;
            adjacentMatrix  = new int [numberOfNodes] [numberOfNodes];
            vierusSolmut = new Node[numberOfNodes];
            kustannukset = new int[numberOfNodes];
                    
            while(scan.hasNext()) {
                String row = scan.nextLine();
                // tiedoston tarkistukset tähän
                
                if (row.startsWith("kaari")) {
                    rowsplit = row.split("=");
                    values = rowsplit[1].split(",");
                    int arvo0 = Integer.parseInt(values[0]);
                    int arvo1 = Integer.parseInt(values[1]);
                    int arvo2 = Integer.parseInt(values[2]);
                    int node = --arvo0; 
                    int adjacentNode= --arvo1;
//                    System.out.println("arvot=" + arvo0 + arvo1 + arvo2);
                    adjacentMatrix[node][adjacentNode]=arvo2;
//                    System.out.println("arvot=" + node + adjacentNode + arvo2 + nodes[node] + nodes[adjacentNode]);
                    nodes[node].setAdjacentNode(nodes[adjacentNode]);
                    nodes[node].setCost(arvo2);
                    
                }
            }
            
        }
        catch(Exception ex) {
        System.out.println("Tiedostoa ei loydy" + ex);
        }
        // return adjacentMatrix;  
        return nodes;
    }
    
    
    /**
     * 
     * @param graph
     */
    public static void printAdjacentMatrix(int [] [] graph) {
        for (int row=0;row<graph.length;++row) {
            for (int column=0;column<graph[row].length;++column) {
                System.out.print(graph[row][column] + "\t");
            }
            System.out.println();
        }
    }
    
    /**
     * 
     * @param nodes
     * @param numberOfNodes
     * @param startNode
     */
    public static void printShortestPaths(Node [] nodes, int numberOfNodes, int startNode) {
        System.out.println("+++++++++++++Lyhin polku aloitussolmusta " + startNode );
        for (int i=0;i<numberOfNodes;i++) {
            Stack p = new Stack(numberOfNodes);
            Node s = nodes[i];
            if (i!=startNode-1) {
                while (s.getPath() != 0) {
                    
//                    System.out.println("Push BEGIN:------------------------");
//                    Solmu.print(s);
                    int u = s.getPath();
                    if (u != 0)
                        p.push(u);
//                    System.out.println("Push END:------------------------");
                    s = nodes[u-1];
                }
                System.out.println("*********** solmuun " + (i+1) + " kulkee seuraavien solmujen kautta:");
                while (!p.isEmpty()) {
                    int u = p.pop();
                    System.out.println(u);
                }
            }
        }
    }
    
    /**
     * 
     * @param graph
     * @param startNode
     * @param numberOfNodes
     * @return
     */
    public static Node [] Dijkstra(Node [] dijkstranodes, int startNode, int numberOfNodes) {
        int [] distance;
        int [] path ;
// kaikille solmuille distance -> Max-value, paitsi aloitussolmu distance = 0
// kaikille solmuille path = null
        // initializeSingleSource(solmutLkm,alkuSolmu);
        distance = new int [numberOfNodes];
        path = new int [numberOfNodes];
        for (int v = 0; v < numberOfNodes; v++) {
            distance[v] = Integer.MAX_VALUE;
        }
        distance[startNode-1] = 0;
       
// Luodaan Heap
// Minimikeon luonti, indeksi alkaa 1:stä
        MinHeap h = new MinHeap(numberOfNodes+1);
// Viedään kekoon solmut distance-arvon mukaan eli aloitussolmu ekaksi
// ja muut sen jälkeen (muissa distance = max_value)
        for (int i=0;i<numberOfNodes;i++) {
            dijkstranodes[i].setDistance(distance[i]);
            dijkstranodes[i].setPath(path[i]);
            h.insert(dijkstranodes[i]);
        }
        
// DEBUG: Tulostetaan solmut
/*       
        System.out.println("Keko luonnin jälkeen:");
        h.print();
*/ 
        
        int u;
        Node uSolmu = null;
        while(!(h.isEmpty())) {
            // haetaan ja poistetaan keosta pienin (distance arvon mukaan) eli 
            // eka alkio
            // KÄSITELTÄVÄ SOLMU
            uSolmu = h.deleteMin();
            u = uSolmu.getDistance();
            
// DEBUG: 
/*       
         
            System.out.println("Keko pienimmän poiston jälkeen");
            h.print();
            
            System.out.println("Solmu uSolmu (keosta poistettu solmu) " + uSolmu);
            Node.print(uSolmu, numberOfNodes);
             
*/
// kaikille u:n vierussolmuille 
            for (int j=0; j<uSolmu.getNumberOfAdjacentNodes();j++) {
           //     System.out.println("u j vierusSOlmuLkm" + u + " " + j + " " + uSolmu.vierusSolmuLkm());
                Node vSolmu = uSolmu.getAdjacentNode(j);
                if (vSolmu != null) {
                    System.out.println("Solmu u:n vierussolmu");
                    Node.print(vSolmu, numberOfNodes);
//relax      
                    if (uSolmu.getDistance() + uSolmu.getCost(j) > -1) {
                    if (vSolmu.getDistance() > uSolmu.getDistance() + uSolmu.getCost(j)) {
                        System.out.println("usolmu.haeKustannus() " + uSolmu.getCost(j) +" " + (uSolmu.getDistance() + uSolmu.getCost(j)) );
                        vSolmu.setDistance(uSolmu.getDistance() + uSolmu.getCost(j));
                //        vSolmu.asetaPolku(uSolmu.haeKekoAlkio());
                        vSolmu.setPath(uSolmu.getNodeNumber());
                    }
                    }
// vähennetään käsiteltävänä olevan solmun avainta, jos distance muuttunut
                    h.decreaseKey(vSolmu, vSolmu.getDistance());
                    System.out.println("Keko decreaseKeyn jälkeen");
                    h.print();
                }
         //       }
            }
        }
        return dijkstranodes;
    }
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
// Tähän tiedoston kysely
        
// Luetaan syötetiedosto ja luodaan vierusmatriisi
        String file = "verkko.txt";
        int numberOfNodes = readNumberOfNodes(file);
        if (numberOfNodes == -1) {
            System.out.println("Virhe syötteen käsittelyssä");
            return;
        }
        if (numberOfNodes == 0) {
            System.out.println("Epäkelpo syöte: solmuja oltava vähintään yksi");
            return;
        }
  
        int startNode = readStartNode(file);
        if (startNode < 1 || startNode > numberOfNodes) {
            System.out.println("Epäkelpo syöte: aloitussolmu virheellinen");
            return;
        }
        
// Luodaan solmut
        Node [] nodes;
        nodes = new Node[numberOfNodes];
        int [] costs = new int[numberOfNodes];
        for (int i=1;i<=numberOfNodes;i++) {
            Node v = new Node(i,0,0,0,nodes,costs);
            nodes[i-1] = v;
        }
        
  //      int [] [] graph = readAdjacentNodes(file, numberOfNodes, nodes);
        Node [] dijkstranodes = readAdjacentNodes(file, numberOfNodes, nodes);

        
// DEBUG: Vierusmatriisin tulostus
//        printAdjacentMatrix(graph);
        
// Lasketaan solmujen lyhimmät polut       
        Node [] solmut = Dijkstra(dijkstranodes,startNode,numberOfNodes);
        
// DEBUG: Tulostetaan solmut
/*
        System.out.println("SOLMUT ------------------");
        for (int i=0;i<numberOfNodes;i++) {  
            Node.print(solmut[i],numberOfNodes);
        }
        System.out.println("SOLMUT LOPPU ------------");
        
  * 
  */
        
// Tulostetaan lyhimmät polut
        printShortestPaths(solmut,numberOfNodes,startNode);
    
    } 
}
