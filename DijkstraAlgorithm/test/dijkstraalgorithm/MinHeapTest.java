/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorithm;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author hzniitty
 */
public class MinHeapTest {
    
    public MinHeapTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class MinHeap. Heap is empty.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MinHeap instance = new MinHeap(2);
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of insert  and deleteMin methods, of class MinHeap.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Node [] a;
        int [ ] b;
        a = new Node [1];
        b = new int [1];
        Node solmu = new Node(1,0,0,0,a,b);
        Node result = solmu;
        MinHeap instance = new MinHeap(2);
        instance.insert(solmu);
        Node expResult = instance.deleteMin();
        assertEquals(expResult, result);
    }

    /**
     * Test of decreaseKey method, of class MinHeap.
     */
    @Test
    public void testDecreaseKey() {
        System.out.println("decreaseKey");
        Node [] a;
        int [ ] b;
        a = new Node [1];
        b = new int [1];
        Node solmu = new Node(1,20,20,20,a,b);  
        MinHeap instance = new MinHeap(2);
        instance.insert(solmu);
        int newkey = 10;
        instance.decreaseKey(solmu,10);
        int result = solmu.getDistance();
        int expResult = 10;
        assertEquals(expResult, result);
    }

}
