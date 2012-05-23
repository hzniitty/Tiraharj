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
    private static double [] distance ;
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
            //tarkistukset
            // ohitetaan kommentit ja tyhjät rivit
            // ilmoitetaan virheestä, jos rivillä jotain väärää
            // 1. merkitsevällä oltava solmujen lkm
            // 2. merkitsevällä rivillä oltava aloitussolmu
            // seuraavien rivien syntaksi oltava oikein
            // tarkista rivin vaihto lopussa
            if (rivi.startsWith("solmujen_lukumaara")) {
                rivisplit = rivi.split("=");
                solmujenLkm = Integer.parseInt(rivisplit [1]);
                System.out.println("solmujenLkm=" + solmujenLkm);
                vierus  = new int [solmujenLkm] [solmujenLkm];
            } 
            if (rivi.startsWith("aloitus_solmu")) {
                rivisplit = rivi.split("=");
                aloitusSolmu = Integer.parseInt(rivisplit [1]);
                System.out.println("aloitusSolmu=" + aloitusSolmu);
            } 
            if (rivi.startsWith("kaari")) {
                rivisplit = rivi.split("=");
                arvot = rivisplit[1].split(",");
                int arvo0 = Integer.parseInt(arvot[0]);
                int arvo1 = Integer.parseInt(arvot[1]);
                int arvo2 = Integer.parseInt(arvot[2]);
                arvo0--; arvo1--;
                System.out.println("arvot=" + arvo0 + arvo1 + arvo2);
                vierus[arvo0][arvo1]=arvo2;
            }
        }
        
        }
    
    catch(Exception ex) {
        System.out.println("Tiedostoa ei loydy" + ex);
    }
    tulostaVierus(vierus);
    }
    
    public static void tulostaVierus(int [][] matriisi) {
        for (int rivi=0;rivi<matriisi.length;++rivi) {
            for (int sarake=0;sarake<matriisi[rivi].length;++sarake) {
                System.out.print(matriisi[rivi][sarake] + "\t");
            }
            System.out.println();
        }
    }
            
            
    public static void initializeSingleSource(int solmujenLkm,int aloitusSolmu) {
        distance = new double [--solmujenLkm];
        path = new int [--solmujenLkm];
        for (int v = 0; v < solmujenLkm; v++) {
            distance[v] = Double.POSITIVE_INFINITY;
        }
        distance[--aloitusSolmu] = 0;
    }
    
    /*
    public static String tulostaPolut() {
        
        
    }
    */
    public static void main(String[] args) {
        lueTiedosto();
        initializeSingleSource(solmujenLkm,aloitusSolmu);
  /*
        minHeap H = new heap minHeap;
        for (int i=0;i<solmujenLkm;i++) {
            H.insert(vierus [i] [0], distance[i]);
        }
        while(H.notEmpty) {
            u = H.heap-del-min;
            for (int j=0; j<solmujenLkm;j++) {
                relax(u,j,vierus[u] [j]);
                H.heap-decrease-key(j, distance[j]);
            }
        }
       
        tulostaPolut();
    */
    }
}
