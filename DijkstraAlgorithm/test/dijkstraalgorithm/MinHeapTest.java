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
     * Test of isEmpty method, of class MinHeap.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MinHeap instance = null;
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class MinHeap.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Node solmu = null;
        MinHeap instance = null;
        instance.insert(solmu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMin method, of class MinHeap.
     */
    @Test
    public void testDeleteMin() {
        System.out.println("deleteMin");
        MinHeap instance = null;
        Node expResult = null;
        Node result = instance.deleteMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decreaseKey method, of class MinHeap.
     */
    @Test
    public void testDecreaseKey() {
        System.out.println("decreaseKey");
        Node n = null;
        int newkey = 0;
        MinHeap instance = null;
        instance.decreaseKey(n, newkey);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class MinHeap.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        MinHeap instance = null;
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
