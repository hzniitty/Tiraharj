/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorithm;

/**
 *
 * @author Hannu
 */
public class Solmu {
    private int solmu;
    private int kustannus;
    private int polku;
    private int distance;
    private int kekoAlkio;
    // konstruktori
    public Solmu(int dijkstraSolmu, int solmunDistance, int edSolmu) {
        solmu=dijkstraSolmu;
        distance=solmunDistance;
        polku=edSolmu;
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
}
