/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * This class performs a Dijkstra's algorithm.
 * <p>
 * The program reads first the number of nodes and the start node from the input file.
 * Then program creates a table, which size is the number of the nodes read from input file. The table  
 * Then archs are read from the input file.
 * @author hzniitty
 */
public class DijkstraAlgorithm {

    /**
     * Reads the number of nodes from the input file.
     * @param file input file
     * @return  number of nodes
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
     * Reads the start node from the input file.
     * @param file input file
     * @return start node
     */
    public static int readStartNode(String file) {
        int startNode = 0;
        try {
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
     * Reads archs from the input file and updates adjacent nodes and corresponding costs for the nodes. 
     * <p>
     * Archs are given in the following format:
     * <p>
     * kaari=node,adjacent node,cost
     * @param file input file
     * @param numberOfNodes number of nodes
     * @param nodes Node table
     * @return node table.
     */
    public static Node [] readAdjacentNodes(String file, int numberOfNodes, Node [] nodes) {
        // int numberOfRows = 0;
        int [] [] adjacentMatrix = new int [0] [0];
//        Node [] vierusSolmut;
//        int [] kustannukset;
        try {
            Scanner scan = new Scanner(new File (file));
            int count = 0;
            String [] rowsplit;
            String [] values;
//            adjacentMatrix  = new int [numberOfNodes] [numberOfNodes];
//           vierusSolmut = new Node[numberOfNodes];
//            kustannukset = new int[numberOfNodes];
                    
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
//                    adjacentMatrix[node][adjacentNode]=arvo2;
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
    /*
    public static void printAdjacentMatrix(int [] [] graph) {
        for (int row=0;row<graph.length;++row) {
            for (int column=0;column<graph[row].length;++column) {
                System.out.print(graph[row][column] + "\t");
            }
            System.out.println();
        }
    }
    
    * 
    */
    
    /**
     * Outputs the shortest paths from the start node to the other nodes.
     * @param a 
     * @param file file to be printed output (if selected)
     * @param nodes table containing all nodes in the graph.
     * @param numberOfNodes number of nodes in the graph.
     * @param startNode start node
     * @throws FileNotFoundException  
     */
    public static void printShortestPaths(String a, String file, Node [] nodes, int numberOfNodes, int startNode) throws FileNotFoundException {
        PrintWriter outfile = new PrintWriter(new FileOutputStream(file+".out"),true);     
        if (a.equals("K")) {
             outfile.println("solmujen_lukumaara=" + numberOfNodes);
        }
        else
            System.out.println("solmujen_lukumaara=" + numberOfNodes);
        if (a.equals("K"))
            outfile.println("+++++++++++++Lyhin polku aloitussolmusta " + startNode );
        else   
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
                if (a.equals("K"))
                    outfile.println("*********** solmuun " + (i+1) + " kulkee seuraavien solmujen kautta:");
                else   
                    System.out.println("*********** solmuun " + (i+1) + " kulkee seuraavien solmujen kautta:");
                while (!p.isEmpty()) {
                    int u = p.pop();
                    if (a.equals("K"))
                        outfile.println(u);
                    else  
                        System.out.println(u);
                }
            }
        }
    }
    
    /**
     * Performs Dijkstra's algorithm.
     * @param dijkstranodes nodes that conform the graph
     * @param startNode start node
     * @param numberOfNodes number of nodes
     * @return nodes updated with distance, path and cost information
     */
    public static Node [] Dijkstra(Node [] dijkstranodes, int startNode, int numberOfNodes) {
        int [] distance;
        int [] path ;
        /*
         * sets distance to max value for all nodes, except start node's distance = 0
         * sets path -> null for all nodes
         */
        distance = new int [numberOfNodes];
        path = new int [numberOfNodes];
        for (int v = 0; v < numberOfNodes; v++) {
            distance[v] = Integer.MAX_VALUE;
        }
        distance[startNode-1] = 0;
        // creates a minimum heap
        MinHeap h = new MinHeap(numberOfNodes+1);
        /*
         * inserts nodes to minimum heap according to node's distance value
         * i.e. start node first and then other nodes.
         */
        for (int i=0;i<numberOfNodes;i++) {
            dijkstranodes[i].setDistance(distance[i]);
            dijkstranodes[i].setPath(path[i]);
            h.insert(dijkstranodes[i]);
        }
        
        // DEBUG: print nodes
        /*       
        System.out.println("Heap after creation:");
        h.print();
        */ 
        
        int u;
        Node uSolmu = null;
        while(!(h.isEmpty())) {
            /*
             * Delete the minimum item (according to distance value) from the heap
             */
            uSolmu = h.deleteMin();
            u = uSolmu.getDistance();
            
            /*
             * For all adjacent nodes perform "relax" 
             */
            for (int j=0; j<uSolmu.getNumberOfAdjacentNodes();j++) {
                Node vSolmu = uSolmu.getAdjacentNode(j);
                if (vSolmu != null) {
                    //relax      
                    if (uSolmu.getDistance() + uSolmu.getCost(j) > -1) {
                        if (vSolmu.getDistance() > uSolmu.getDistance() + uSolmu.getCost(j)) {
                            vSolmu.setDistance(uSolmu.getDistance() + uSolmu.getCost(j));
                            vSolmu.setPath(uSolmu.getNodeNumber());
                        }
                    }
                    // decrases adjacent node's key, if the distance value has changed.
                    h.decreaseKey(vSolmu, vSolmu.getDistance());
                }
            }
        }
        return dijkstranodes;
    }
    
    /**
     * 
     * @param args
     * @throws FileNotFoundException  
     */
    public static void main(String[] args) {
        
// Luetaan syötetiedosto
        String file;
        String a="";
        Scanner lukija = new Scanner(System.in);
        System.out.println("Tulostetaanko output (K/E)? ");
        String output = lukija.next();
        if (output.equals("K")) {
            System.out.println("Tulostus tiedostoon (K/E)? ");
            a = lukija.next();
        }
        System.out.println("Luodaanko syötetiedosto (K/E)? ");
        String b = lukija.next();
        if (b.equals("K")) {
            System.out.println("Anna tiedoston nimi:");
            file = lukija.next();
            System.out.println("Anna solmujen lukumäärä:");
            int V = lukija.nextInt();
            System.out.println("Anna kaarien lukumäärä:");
            int E = lukija.nextInt();
            System.out.println("Anna aloitussolmu:");
            int S = lukija.nextInt();
            PrintWriter testfile = null;
            try {
                testfile = new PrintWriter(new FileOutputStream(file),true);
            } catch (FileNotFoundException fe) {
                System.out.println("tiedostoa ei löytynyt");
                System.exit(0);
            }
            testfile.println("solmujen_lukumaara=" + V);
            testfile.println("aloitus_solmu=" + S);
            for (int i = 1; i <= E; i++) {
                int v = (int) (Math.random() * V);
                int w = (int) (Math.random() * V);
                int x = (int) (Math.random() * V);
                // tarkistus, ettei kaarta ole vielä
                if (v != 0 && w != 0)
                    testfile.println("kaari=" + v + "," + w + "," + x);
                else i--;
            }
        }
        else {
            System.out.println("Anna tiedoston nimi:");
            file = lukija.next();
        }
        
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
        
// Aloitusaika        
        long start = System.currentTimeMillis();
// Luodaan solmut
        Node [] nodes;
        Node [] adjacentNodes;
        nodes = new Node[numberOfNodes];
        adjacentNodes = new Node[100];
        int [] costs = new int[100];
        for (int i=1;i<=numberOfNodes;i++) {
            Node v = new Node(i,0,0,0,adjacentNodes,costs);
            nodes[i-1] = v;
        }
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
        
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        float elapsedTimeSec = elapsedTimeMillis/1000F;
        System.out.println("Suoritusaika ms sek: " + elapsedTimeMillis + " " + elapsedTimeSec);
// Tulostetaan lyhimmät polut
        if (output.equals("K")) {
            printShortestPaths(a,file,solmut,numberOfNodes,startNode);
        }
    } 
}
