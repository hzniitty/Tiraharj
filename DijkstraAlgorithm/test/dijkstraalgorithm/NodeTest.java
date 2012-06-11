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
public class NodeTest {
    
    public NodeTest() {
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
     * Test of setNodeNumber method, of class Node.
     */
    @Test
    public void testSetNodeNumber() {
        System.out.println("setNodeNumber");
        int index = 0;
        Node instance = null;
        instance.setNodeNumber(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNodeNumber method, of class Node.
     */
    @Test
    public void testGetNodeNumber() {
        System.out.println("getNodeNumber");
        Node instance = null;
        int expResult = 0;
        int result = instance.getNodeNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDistance method, of class Node.
     */
    @Test
    public void testSetDistance() {
        System.out.println("setDistance");
        int dist = 0;
        Node instance = null;
        instance.setDistance(dist);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDistance method, of class Node.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Node instance = null;
        int expResult = 0;
        int result = instance.getDistance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeapNodeNumber method, of class Node.
     */
    @Test
    public void testSetHeapNodeNumber() {
        System.out.println("setHeapNodeNumber");
        int heapPosition = 0;
        Node instance = null;
        instance.setHeapNodeNumber(heapPosition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeapNodeNumber method, of class Node.
     */
    @Test
    public void testGetHeapNodeNumber() {
        System.out.println("getHeapNodeNumber");
        Node instance = null;
        int expResult = 0;
        int result = instance.getHeapNodeNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPath method, of class Node.
     */
    @Test
    public void testSetPath() {
        System.out.println("setPath");
        int index = 0;
        Node instance = null;
        instance.setPath(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPath method, of class Node.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        Node instance = null;
        int expResult = 0;
        int result = instance.getPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfAdjacentNodes method, of class Node.
     */
    @Test
    public void testGetNumberOfAdjacentNodes() {
        System.out.println("getNumberOfAdjacentNodes");
        Node instance = null;
        int expResult = 0;
        int result = instance.getNumberOfAdjacentNodes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdjacentNode method, of class Node.
     */
    @Test
    public void testSetAdjacentNode() {
        System.out.println("setAdjacentNode");
        Node n = null;
        Node instance = null;
        instance.setAdjacentNode(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdjacentNode method, of class Node.
     */
    @Test
    public void testGetAdjacentNode() {
        System.out.println("getAdjacentNode");
        int ind = 0;
        Node instance = null;
        Node expResult = null;
        Node result = instance.getAdjacentNode(ind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCost method, of class Node.
     */
    @Test
    public void testSetCost() {
        System.out.println("setCost");
        int n = 0;
        Node instance = null;
        instance.setCost(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCost method, of class Node.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        int index = 0;
        Node instance = null;
        int expResult = 0;
        int result = instance.getCost(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Node.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Node p = null;
        int numberOfNodes = 0;
        Node.print(p, numberOfNodes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Node.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Node t = null;
        Node instance = null;
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Node.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Node instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
