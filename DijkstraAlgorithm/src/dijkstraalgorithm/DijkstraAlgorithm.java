/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorithm;

import java.io.File;
import java.util.Scanner;
/**
 *
 * @author hzniitty
 */
public class DijkstraAlgorithm {

    /**
     * @param args the command line arguments
     */
    
    // luokan muuttujat
    public static int solmujenLkm;
    private static int aloitusSolmu;
    private static int [] [] vierus ;
    private static int [] distance ;
    private static int [] path ;
    public static Solmu [] solmut;
    
    
    public static int [][] lueTiedosto(String file) {
        try {
//            Scanner scan = new Scanner(new File("verkko.txt"));
            Scanner scan = new Scanner(new File (file));
            int count = 0;
            String [] rivisplit;
            String [] arvot;
 //           int [] [] vierus;
                
            while(scan.hasNext()) {
                String rivi = scan.nextLine();
                // tiedoston tarkistukset tähän
                if (rivi.startsWith("solmujen_lukumaara")) {
                    rivisplit = rivi.split("=");
                    solmujenLkm = Integer.parseInt(rivisplit [1]);
            //        System.out.println("solmujenLkm=" + solmujenLkm);
                    vierus  = new int [solmujenLkm] [solmujenLkm];
                } 
                if (rivi.startsWith("aloitus_solmu")) {
                    rivisplit = rivi.split("=");
                    aloitusSolmu = Integer.parseInt(rivisplit [1]);
            //        System.out.println("aloitusSolmu=" + aloitusSolmu);
                } 
                if (rivi.startsWith("kaari")) {
                    rivisplit = rivi.split("=");
                    arvot = rivisplit[1].split(",");
                    int arvo0 = Integer.parseInt(arvot[0]);
                    int arvo1 = Integer.parseInt(arvot[1]);
                    int arvo2 = Integer.parseInt(arvot[2]);
                    arvo0--; 
                    arvo1--;
            //        System.out.println("arvot=" + arvo0 + arvo1 + arvo2);
                    vierus[arvo0][arvo1]=arvo2;
                }
            }
         
        }
        catch(Exception ex) {
        System.out.println("Tiedostoa ei loydy" + ex);
        }
         return vierus;  
    }
    
    public static void tulostaVierus(int [] [] graph) {
        for (int rivi=0;rivi<graph.length;++rivi) {
            for (int sarake=0;sarake<graph[rivi].length;++sarake) {
                System.out.print(graph[rivi][sarake] + "\t");
            }
            System.out.println();
        }
    }
    
    public static MinHeap luoMinimiKeko() {
      
        // Minimikeon luonti, indeksi alkaa 1:stä
        MinHeap h = new MinHeap(solmujenLkm+1);
        // Viedään ensin solmut taulukkoon
        // Viedään kekoon solmut distance-arvon mukaan eli aloitussolmu ekaksi
        // ja muut sen jälkeen (muissa distance = max_value)
        solmut = new Solmu[solmujenLkm];
 //       Solmu [] vierusNodet = new Solmu [solmujenLkm];
        for (int i=1;i<=solmujenLkm;i++) {
            Solmu v = new Solmu(i,distance[i-1],path[i-1],0);
            solmut[i-1] = v;
            h.insert(v);
        }
        
        System.out.println("Keko luonnin jälkeen:");
        h.print();
        return h;
    }
    
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
            
    public static void initializeSingleSource(int solmujenLkm,int aloitusSolmu) {
        distance = new int [solmujenLkm];
        path = new int [solmujenLkm];
        for (int v = 0; v < solmujenLkm; v++) {
            distance[v] = Integer.MAX_VALUE;
        }
        distance[aloitusSolmu-1] = 0;
    }
    
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
    
    public static void tulostaPolut() {
        System.out.println("+++++++++++++Lyhin polku aloitussolmusta " + aloitusSolmu );
        for (int i=0;i<solmujenLkm;i++) {
            Stack p = new Stack(solmujenLkm);
            Solmu s = solmut[i];
            if (i!=aloitusSolmu-1) {
                while (s.haePolku() != 0) {
                    
//                    System.out.println("Push BEGIN:------------------------");
//                    Solmu.print(s);
                    int u = s.haePolku();
                    if (u != 0)
                        p.push(u);
//                    System.out.println("Push END:------------------------");
                    s = solmut[u-1];
                }
                System.out.println("*********** solmuun " + (i+1) + " kulkee seuraavien solmujen kautta:");
                while (!p.isEmpty()) {
                    int u = p.pop();
                    System.out.println(u);
                }
            }
        }
    }
    
    public static void Dijkstra(int [] [] graph, int alkuSolmu) {
 
// Solmujen lukumäärä haettava graphsta
        int solmutLkm = graph[0].length;
// kaikille solmuille distance -> Max-value, paitsi aloitussolmu distance = 0
// kaikille solmuille path = null
        initializeSingleSource(solmutLkm,alkuSolmu);
                // Luodaan Heap
        MinHeap h = luoMinimiKeko();
       // Viedään solmuihin vierussolmut
        
        // Solmu [] vierusSolmut = new Solmu[solmujenLkm];
        Solmu [] vierusSolmut;
        int [] kustannukset;
        for (int i=0;i<solmutLkm;i++) {  
            
            vierusSolmut = new Solmu[solmutLkm];
            kustannukset = new int[solmutLkm];
            int k = 0;
            for (int j=0;j<solmutLkm;j++) {
                
                if (graph [i] [j] != 0) {
                    vierusSolmut[k]=solmut[j];
                    kustannukset[k] = graph [i] [j];
           //         System.out.println("Testiä i j k " + i + " " + j + " " + k + " " + solmut[j]);
                    k++;
                    
                }
            }
            solmut[i].asetaVierusSolmut(vierusSolmut);
            solmut[i].asetaKustannukset(kustannukset);
      //      Solmu.print(solmut[i]);
            
        }
        // Tulostetaan solmut
        System.out.println("SOLMUT");
        for (int i=0;i<solmutLkm;i++) {  
            Solmu.print(solmut[i]);
        }
        System.out.println("SOLMUT LOPPU");
        
        // käsitellään solmut keosta
        int u;
        Solmu uSolmu = null;
        while(!(h.isEmpty())) {
            // haetaan ja poistetaan keosta pienin (distance arvon mukaan) eli 
            // eka alkio
            // KÄSITELTÄVÄ SOLMU
            uSolmu = h.deleteMin();
            u = uSolmu.haeDistance();
            System.out.println("Keko pienimmän poiston jälkeen");
            h.print();
            
         //   Solmu uSolmu = solmut[0];
           
         //   System.out.println("Solmu u: Solmu Distance" + " " + uSolmu.haeSolmu() + " " + uSolmu.haeDistance());
            System.out.println("Solmu u (keosta poistettu solmu)");
            Solmu.print(uSolmu);
           
            
            // kaikille u:n vierussolmuille 
            for (int j=0; j<uSolmu.vierusSolmuLkm();j++) {
           //     System.out.println("u j vierusSOlmuLkm" + u + " " + j + " " + uSolmu.vierusSolmuLkm());
                Solmu vSolmu = uSolmu.haeVierusSolmu(j);
                if (vSolmu != null) {
                    System.out.println("Solmu u:n vierussolmu");
                    Solmu.print(vSolmu);
              /*     relax(u,j,vierus[u] [j]);
                    if (vSolmu.haeDistance() > uSolmu.haeDistance() + vierus [uSolmu.haeSolmu()-1] [j]) {
                        vSolmu.asetaDistance(uSolmu.haeDistance() + vierus [uSolmu.haeSolmu()-1] [j]);
                        vSolmu.asetaPolku(uSolmu.haeKekoAlkio());
                    }
                    */
                    if (uSolmu.haeDistance() + uSolmu.haeKustannus(j) > -1) {
                    if (vSolmu.haeDistance() > uSolmu.haeDistance() + uSolmu.haeKustannus(j)) {
                        System.out.println("usolmu.haeKustannus() " + uSolmu.haeKustannus(j) +" " + (uSolmu.haeDistance() + uSolmu.haeKustannus(j)) );
                        vSolmu.asetaDistance(uSolmu.haeDistance() + uSolmu.haeKustannus(j));
                //        vSolmu.asetaPolku(uSolmu.haeKekoAlkio());
                        vSolmu.asetaPolku(uSolmu.haeSolmu());
                    }
                    }
                // vähennetään käsiteltävänä olevan solmun avainta, jos distance muuttunut
                //      h.decreaseKey(j, distance[j]);
                    h.decreaseKey(vSolmu, vSolmu.haeDistance());
                    System.out.println("Keko decreaseKeyn jälkeen");
                    h.print();
                }
         //       }
            }
        }
    }
    
    public static void main(String[] args) {
// Tähän tiedoston kysely
        
// Luetaan syötetiedosto ja luodaan vierusmatriisi
        String file = "verkko.txt";
        int [] [] graph = lueTiedosto(file);

// DEBUG: Vierusmatriisin tulostus
        tulostaVierus(graph);
        
// Lasketaan lyhimmät polut       
        Dijkstra(graph,aloitusSolmu);
        
// DEBUG: Tulostetaan solmut
        System.out.println("SOLMUT");
        for (int i=0;i<solmujenLkm;i++) {  
            Solmu.print(solmut[i]);
        }
        
// Tulostetaan lyhimmät polut
        tulostaPolut();
    
    } 
}
