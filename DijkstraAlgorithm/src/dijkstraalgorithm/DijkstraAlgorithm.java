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
    private static int solmujenLkm;
    private static int aloitusSolmu;
    private static int [] [] vierus ;
    private static int [] distance ;
    private static int [] path ;
    
    
    public static void lueTiedosto() {
    try {
        Scanner scan = new Scanner(new File("verkko.txt"));
        int count = 0;
        String [] rivisplit;
        String [] arvot;
        
        
        while(scan.hasNext()) {
            // System.out.println("eka");
            String rivi = scan.nextLine();
            //tarkistukset tähän
            
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
                arvo0--; arvo1--;
        //        System.out.println("arvot=" + arvo0 + arvo1 + arvo2);
                vierus[arvo0][arvo1]=arvo2;
            }
        }
        
        }
    
    catch(Exception ex) {
        System.out.println("Tiedostoa ei loydy" + ex);
    }
    }
    
    public static void tulostaVierus() {
        for (int rivi=0;rivi<vierus.length;++rivi) {
            for (int sarake=0;sarake<vierus[rivi].length;++sarake) {
                System.out.print(vierus[rivi][sarake] + "\t");
            }
            System.out.println();
        }
    }
    
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
    
            
    public static void initializeSingleSource(int solmujenLkm,int aloitusSolmu) {
        distance = new int [solmujenLkm];
        path = new int [solmujenLkm];
        for (int v = 0; v < solmujenLkm; v++) {
            distance[v] = Integer.MAX_VALUE;
        }
        distance[aloitusSolmu-1] = 0;
    }
    
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
     
    public static void tulostaPolut() {
        tulostaPath();
        
        for (int i=1;i<solmujenLkm;i++) {
            Stack p = new Stack(10);
            // tähän looppi
            int u = path[i];
            if (u != aloitusSolmu) {
                System.out.println("u = " + u);
                p.push(u);
                u = path[u];
            }
        
        System.out.println("Lyhin polku aloitussolmusta " + aloitusSolmu + " solmuun " + i + "kulkee seuraavien solmujen kautta:");
        while (!p.isEmpty()) {
           u = p.pop();
           System.out.println(u);
        }
        }
    }
    
    public static void main(String[] args) {
        // luetaan syötetiedosto
        lueTiedosto();
        tulostaVierus();
        // kaikille solmuille distance -> Max-value, paitsi aloitussolmu distance = 0
        // kaikille solmuille path = null
        initializeSingleSource(solmujenLkm,aloitusSolmu);
        // Minimikeon luonti, indeksi alkaa 1:stä
        MinHeap h = new MinHeap(solmujenLkm+1);
        // Viedään kekoon solmut distance-arvon mukaan
        for (int i=1;i<=solmujenLkm;i++) {
            h.insert(i, distance[i-1]);
        }
        h.print();
        // käsitellään solmut keosta
        int u;
        while(!(h.isEmpty())) {
            // haetaan keosta distance arvon mukaan pienin
            u = h.removemin();
            h.print();
            // kaikille u:n vierussolmuille 
            for (int j=0; j<solmujenLkm;j++) {
                if (vierus [u-1][j] != 0) {
                    relax(u-1,j,vierus[u-1] [j]);
                    // järjestetään keko uudelleen
                    h.decreaseKey(j, distance[j]);
                }
            }
            
        }
       
        tulostaPolut();
    
    }
}
