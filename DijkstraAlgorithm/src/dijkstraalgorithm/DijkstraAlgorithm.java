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
     * @param file
     * @return  
     */
    
    // luokan muuttujat
//    public static int solmujenLkm;
//    private static int aloitusSolmu;
//    private static int [] [] vierus ;
//    private static int [] distance ;
//    private static int [] path ;
//    public static Node [] solmut;
    
    
    public static int readNumberOfNodes(String file) {
        int numberOfNodes = 0;      
        try {
            Scanner scan = new Scanner(new File (file));
            int count = 0;
            String [] rowsplit;
            String [] values;
            
            while(scan.hasNext()) {
                String row = scan.nextLine();
                // tiedoston tarkistukset tähän
                if (row.startsWith("solmujen_lukumaara")) {
                    rowsplit = row.split("=");
                    numberOfNodes = Integer.parseInt(rowsplit [1]);                
            //        System.out.println("solmujenLkm=" + solmujenLkm);
            //        vierus  = new int [solmujenLkm] [solmujenLkm];
         
                return numberOfNodes;  
                } 
            }
        }
        catch(Exception ex) {
        System.out.println("Tiedostoa ei loydy: " + ex);
        return -1;
        }
        return numberOfNodes;  
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
//            Scanner scan = new Scanner(new File("verkko.txt"));
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
                    System.out.println("arvot=" + arvo0 + arvo1 + arvo2);
                    adjacentMatrix[node][adjacentNode]=arvo2;
                    /*
                    int k = 0;
                    vierusSolmut[k]=nodes[j];
                    kustannukset[k] = graph [i] [j];
                    k++;
                    nodes[i].setAdjacentNodes(vierusSolmut);
                    nodes[i].setCosts(kustannukset);
                    * 
                    */
                    System.out.println("arvot=" + node + adjacentNode + arvo2 + nodes[node] + nodes[adjacentNode]);
                    nodes[node].setAdjacentNode(nodes[adjacentNode]);
                    nodes[node].setCost(arvo2);
                    
                }
                    /*
        // Tulostetaan solmut
        System.out.println("SOLMUT");
        for (int i=0;i<numberOfNodes;i++) {  
            Node.print(nodes[i],numberOfNodes);
        }
        System.out.println("SOLMUT LOPPU");
        */            
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
                // tiedoston tarkistukset tähän
               
                if (row.startsWith("aloitus_solmu")) {
                    rowsplit = row.split("=");
                    startNode = Integer.parseInt(rowsplit [1]);
            //        System.out.println("aloitusSolmu=" + aloitusSolmu);
                } 
            }
         
        }
        catch(Exception ex) {
        System.out.println("Tiedostoa ei loydy" + ex);
        }
        return startNode;  
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
   /* 
    public static MinHeap luoMinimiKeko(int numberOfNodes) {
      
        // Minimikeon luonti, indeksi alkaa 1:stä
        MinHeap h = new MinHeap(numberOfNodes+1);
        // Viedään ensin solmut taulukkoon
        // Viedään kekoon solmut distance-arvon mukaan eli aloitussolmu ekaksi
        // ja muut sen jälkeen (muissa distance = max_value)
        solmut = new Node[numberOfNodes];
 //       Solmu [] vierusNodet = new Solmu [solmujenLkm];
        for (int i=1;i<=numberOfNodes;i++) {
            Node v = new Node(i,distance[i-1],path[i-1],0);
            solmut[i-1] = v;
            h.insert(v);
        }
        
        System.out.println("Keko luonnin jälkeen:");
        h.print();
        return h;
    }
    */
    /*
    public static void tulostaDistance() {
        for (int i=0;i<solmujenLkm;i++) {
            System.out.println("Distance[" + i + "]=" + distance[i]);
        }
    }
    
    public static void tulostaPath() {
        for (int i=0;i<solmujenLkm;i++) {
            System.out.println("Path[" + i + "]=" + path[i]);
        }
    }
    */
    /*        
    public static void initializeSingleSource(int solmujenLkm,int aloitusSolmu) {
        distance = new int [solmujenLkm];
        path = new int [solmujenLkm];
        for (int v = 0; v < solmujenLkm; v++) {
            distance[v] = Integer.MAX_VALUE;
        }
        distance[aloitusSolmu-1] = 0;
    }
    */
    /*
    public static void relax (int u, int v, int w) {
        
        System.out.println("u, v, w " + u + " " + v + " " + w);
        
       //  tulostaDistance();
        if (distance[v] > distance[u] + vierus [u] [v]) {
            distance [v] = distance [u] + vierus [u] [v];
            path[v] = u;
       //     tulostaPath();
        }
        tulostaDistance();   
    }
     

     */
    
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
     //   Node [] nodes;
        int [] distance;
        int [] path ;
// Solmujen lukumäärä haettava graphsta
//        int solmutLkm = graph[0].length;
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
        // MinHeap h = luoMinimiKeko(solmutLkm);
       
          // Minimikeon luonti, indeksi alkaa 1:stä
        MinHeap h = new MinHeap(numberOfNodes+1);
        // Viedään ensin solmut taulukkoon
        // Viedään kekoon solmut distance-arvon mukaan eli aloitussolmu ekaksi
        // ja muut sen jälkeen (muissa distance = max_value)
       //  nodes = new Node[numberOfNodes];
 //       Solmu [] vierusNodet = new Solmu [solmujenLkm];
        for (int i=1;i<=numberOfNodes;i++) {
            Node v = new Node(i,distance[i-1],path[i-1],0);
            dijkstranodes[i-1] = v;
            h.insert(v);
        }
        
        System.out.println("Keko luonnin jälkeen:");
        h.print();
     //   return h;
        
        /*
        // Viedään solmuihin vierussolmut
        
        // Solmu [] vierusSolmut = new Solmu[solmujenLkm];
        Node [] vierusSolmut;
        int [] kustannukset;
        for (int i=0;i<numberOfNodes;i++) {  
            
            vierusSolmut = new Node[numberOfNodes];
            kustannukset = new int[numberOfNodes];
            int k = 0;
            for (int j=0;j<numberOfNodes;j++) {
                
                if (graph [i] [j] != 0) {
                    vierusSolmut[k]=nodes[j];
                    kustannukset[k] = graph [i] [j];
           //         System.out.println("Testiä i j k " + i + " " + j + " " + k + " " + solmut[j]);
                    k++;
                    
                }
            }
            nodes[i].setAdjacentNodes(vierusSolmut);
            nodes[i].setCosts(kustannukset);
      //      Solmu.print(solmut[i]);
            
        }
        // Tulostetaan solmut
        System.out.println("SOLMUT");
        for (int i=0;i<numberOfNodes;i++) {  
            Node.print(nodes[i],numberOfNodes);
        }
        System.out.println("SOLMUT LOPPU");
        */
        // käsitellään solmut keosta
        int u;
        Node uSolmu = null;
        while(!(h.isEmpty())) {
            // haetaan ja poistetaan keosta pienin (distance arvon mukaan) eli 
            // eka alkio
            // KÄSITELTÄVÄ SOLMU
            uSolmu = h.deleteMin();
            u = uSolmu.getDistance();
            System.out.println("Keko pienimmän poiston jälkeen");
            h.print();
            
         //   Solmu uSolmu = solmut[0];
           
         //   System.out.println("Solmu u: Solmu Distance" + " " + uSolmu.haeSolmu() + " " + uSolmu.haeDistance());
            System.out.println("Solmu u (keosta poistettu solmu)");
            Node.print(uSolmu, numberOfNodes);
           
            
            // kaikille u:n vierussolmuille 
            for (int j=0; j<uSolmu.getNumberOfAdjacentNodes();j++) {
           //     System.out.println("u j vierusSOlmuLkm" + u + " " + j + " " + uSolmu.vierusSolmuLkm());
                Node vSolmu = uSolmu.getAdjacentNode(j);
                if (vSolmu != null) {
                    System.out.println("Solmu u:n vierussolmu");
                    Node.print(vSolmu, numberOfNodes);
              /*     relax(u,j,vierus[u] [j]);
                    if (vSolmu.haeDistance() > uSolmu.haeDistance() + vierus [uSolmu.haeSolmu()-1] [j]) {
                        vSolmu.asetaDistance(uSolmu.haeDistance() + vierus [uSolmu.haeSolmu()-1] [j]);
                        vSolmu.asetaPolku(uSolmu.haeKekoAlkio());
                    }
                    */
                    if (uSolmu.getDistance() + uSolmu.getCost(j) > -1) {
                    if (vSolmu.getDistance() > uSolmu.getDistance() + uSolmu.getCost(j)) {
                        System.out.println("usolmu.haeKustannus() " + uSolmu.getCost(j) +" " + (uSolmu.getDistance() + uSolmu.getCost(j)) );
                        vSolmu.setDistance(uSolmu.getDistance() + uSolmu.getCost(j));
                //        vSolmu.asetaPolku(uSolmu.haeKekoAlkio());
                        vSolmu.setPath(uSolmu.getNodeNumber());
                    }
                    }
                // vähennetään käsiteltävänä olevan solmun avainta, jos distance muuttunut
                //      h.decreaseKey(j, distance[j]);
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
            System.out.println("Tiedostoa ei löydy");
            return;
        }
        if (numberOfNodes == 0) {
            System.out.println("Epäkelpo syöte: solmujen lukumäärä virheellinen");
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
        
        for (int i=1;i<=numberOfNodes;i++) {
            Node v = new Node(i,0,0,0);
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
