/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorithm;

/**
 * This class represents a Node in the Graph.
 * this is the second line.
 * @author Hannu
 */
public class Solmu implements Comparable<Solmu>{
    private int solmu;
    private int polku;
    private int distance;
    private int kekoAlkio;
    public  Solmu [] vierusSolmut;
    private int [] kustannus;
    
    // konstruktori
    public Solmu(int dijkstraSolmu, int solmunDistance, int edSolmu, int kekoSijainti, Solmu[] vierus, int[] kust) {
        solmu=dijkstraSolmu;
        distance=solmunDistance;
        polku=edSolmu;
        kekoAlkio=kekoSijainti;
        vierusSolmut= new Solmu[DijkstraAlgorithm.solmujenLkm];
        for (int i=0;i<DijkstraAlgorithm.solmujenLkm;i++) {
            if (vierusSolmut[i] != null) 
                vierusSolmut[i]=vierus[i];
            kustannus[i]=kust[i];
            
        }   
    } 
    
    // konstruktori
    public Solmu(int dijkstraSolmu, int solmunDistance, int edSolmu, int kekoSijainti) {
        solmu=dijkstraSolmu;
        distance=solmunDistance;
        polku=edSolmu;
        kekoAlkio=kekoSijainti;
       
    } 
    
    public void asetaSolmu(int alkio) {
        this.solmu=alkio;
    }
    
    public int haeSolmu() {
        return solmu;
    }
    
    public int haeDistance() {
        return distance;
    }
    
    public void asetaDistance(int dist) {
        this.distance=dist;
    }
    
    public int haeKekoAlkio() {
        return kekoAlkio;
    }
    
    public void asetaKekoAlkio(int kekoSijainti) {
     
        this.kekoAlkio = kekoSijainti;
    }
    
    public void asetaPolku(int alkio) {
        this.polku=alkio;
    }
    
    public int haePolku() {
        return polku;
    }
     
    public int vierusSolmuLkm() {
        return vierusSolmut.length;
    }
     
    public Solmu haeVierusSolmu(int ind) {
        return vierusSolmut[ind];
    }
    
    public void asetaVierusSolmut(Solmu [] solmut) {
        vierusSolmut= new Solmu[solmut.length];
        for (int i=0;i<solmut.length;i++) {
       //   System.out.println(" i solmu " + i + " " + solmut[i] + " " + solmut.length);
            if (solmut[i] != null) {
       //         System.out.println(" i solmu " + i + " " + solmut[i]);
                this.vierusSolmut[i]=solmut[i];
            }
        }
    }
    
    /**
     * Selostus.
     * rivi 2
     * @param p the node to the printed
     */
    public static void print(Solmu p) {
        System.out.println("--------------------------");
        System.out.println("Solmu: " + p.haeSolmu());
        System.out.println("Distance: " + p.haeDistance());
        System.out.println("Polku: " + p.haePolku());
        System.out.println("Kekoalkio: " + p.haeKekoAlkio());
        for (int i=0;i<DijkstraAlgorithm.solmujenLkm;i++) {
            if (p.vierusSolmut[i] != null)
                System.out.println("Vierussolmut: " + p.vierusSolmut[i].haeSolmu()+ " " + p.haeVierusSolmu(i));
        }
        System.out.println("--------------------------");
        
    }

    @Override
    public int compareTo(Solmu t) {
        if (this.distance < t.distance) {
            return -1;
        } else if (this.distance > t.distance) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Solmu{" + "solmu=" + solmu + ", polku=" + polku + ", distance=" + distance + ", kekoAlkio=" + kekoAlkio + ", vierusSolmut=" + vierusSolmut + ", kustannus=" + kustannus + '}';
    }
    
}
