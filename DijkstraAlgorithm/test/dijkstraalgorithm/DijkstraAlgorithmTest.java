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
public class DijkstraAlgorithmTest {
    
    public DijkstraAlgorithmTest() {
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
     * Test of readNumberOfNodes method, of class DijkstraAlgorithm.
     */
    @Test
    public void testReadNumberOfNodes() {
        System.out.println("readNumberOfNodes");
        String file = "";
        int expResult = 0;
        int result = DijkstraAlgorithm.readNumberOfNodes(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readStartNode method, of class DijkstraAlgorithm.
     */
    @Test
    public void testReadStartNode() {
        System.out.println("readStartNode");
        String file = "";
        int expResult = 0;
        int result = DijkstraAlgorithm.readStartNode(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readAdjacentNodes method, of class DijkstraAlgorithm.
     */
    @Test
    public void testReadAdjacentNodes() {
        System.out.println("readAdjacentNodes");
        String file = "";
        int numberOfNodes = 0;
        Node[] nodes = null;
        Node[] expResult = null;
        Node[] result = DijkstraAlgorithm.readAdjacentNodes(file, numberOfNodes, nodes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printShortestPaths method, of class DijkstraAlgorithm.
     */
    @Test
    public void testPrintShortestPaths() throws Exception {
        System.out.println("printShortestPaths");
        String a = "";
        String file = "";
        Node[] nodes = null;
        int numberOfNodes = 0;
        int startNode = 0;
        DijkstraAlgorithm.printShortestPaths(a, file, nodes, numberOfNodes, startNode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Dijkstra method, of class DijkstraAlgorithm.
     */
    @Test
    public void testDijkstra() {
        System.out.println("Dijkstra");
        Node[] dijkstranodes = null;
        int startNode = 0;
        int numberOfNodes = 0;
        Node[] expResult = null;
        Node[] result = DijkstraAlgorithm.Dijkstra(dijkstranodes, startNode, numberOfNodes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DijkstraAlgorithm.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        DijkstraAlgorithm.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
