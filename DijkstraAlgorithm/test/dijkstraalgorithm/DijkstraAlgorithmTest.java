/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorithm;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author fi72031
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
    public void testReadNumberOfNodes_noFile() {
        System.out.println("readNumberOfNodes");
        String file = "testiverkkoasdasd.txt";
        int expResult = 0;
        int result = DijkstraAlgorithm.readNumberOfNodes(file);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of readNumberOfNodes method, of class DijkstraAlgorithm.
     */
    @Test
    public void testReadNumberOfNodes() {
        System.out.println("readNumberOfNodes");
        String file = "testiverkko.txt";
        int expResult = 6;
        int result = DijkstraAlgorithm.readNumberOfNodes(file);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of readAdjacentNodes method, of class DijkstraAlgorithm.
     */
    @Test
    public void testReadAdjacentNodes() {
        System.out.println("readAdjacentNodes");
        String file = "";
        int[][] expResult = null;
        int[][] result = DijkstraAlgorithm.readAdjacentNodes(file);
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
        String file = "testiverkko.txt";
        int expResult = 1;
        int result = DijkstraAlgorithm.readStartNode(file);
        assertEquals(expResult, result);
    }

    /**
     * Test of printAdjacentMatrix method, of class DijkstraAlgorithm.
     */
    @Test
    public void testPrintAdjacentMatrix() {
        System.out.println("printAdjacentMatrix");
        int[][] graph = null;
        DijkstraAlgorithm.printAdjacentMatrix(graph);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printShortestPaths method, of class DijkstraAlgorithm.
     */
    @Test
    public void testPrintShortestPaths() {
        System.out.println("printShortestPaths");
        Node[] nodes = null;
        int numberOfNodes = 0;
        int startNode = 0;
        DijkstraAlgorithm.printShortestPaths(nodes, numberOfNodes, startNode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Dijkstra method, of class DijkstraAlgorithm.
     */
    @Test
    public void testDijkstra0() {
        System.out.println("Dijkstra: 1 solmu, ei nuolta itseensä");
        int[][] graph = { {0}
                        };
        int startNode = 1;
        int numberOfNodes = 1;
        Node[] expResult = new Node [numberOfNodes];
        for (int i=0;i<numberOfNodes;i++) {
            expResult[i] = new Node(i,i,0,i);
        }
        expResult[0].setPath(0);
        Node[] result = DijkstraAlgorithm.Dijkstra(graph, startNode, numberOfNodes);
        for (int i=0;i<numberOfNodes;i++) {
            assertEquals(expResult[i].getPath(), result[i].getPath());
        }
    }
    @Test
    public void testDijkstra1() {
        System.out.println("Dijkstra: 1 solmu, nuoli itseensä");
        int[][] graph = { {5}
                        };
        int startNode = 1;
        int numberOfNodes = 1;
        Node[] expResult = new Node [numberOfNodes];
        for (int i=0;i<numberOfNodes;i++) {
            expResult[i] = new Node(i,i,0,i);
        }
        expResult[0].setPath(0);
        Node[] result = DijkstraAlgorithm.Dijkstra(graph, startNode, numberOfNodes);
        for (int i=0;i<numberOfNodes;i++) {
            assertEquals(expResult[i].getPath(), result[i].getPath());
        }
    }

    @Test
    public void testDijkstra2() {
        System.out.println("Dijkstra: 2 solmua");
        int[][] graph = { {0,1},
                          {1,0}
                        };
        int startNode = 1;
        int numberOfNodes = 2;
        Node[] expResult = new Node [numberOfNodes];
        for (int i=0;i<numberOfNodes;i++) {
            expResult[i] = new Node(i,i,0,i);
        }
        expResult[0].setPath(0);
        expResult[1].setPath(1);
    //    expResult[1].setPath(1);
        Node[] result = DijkstraAlgorithm.Dijkstra(graph, startNode, numberOfNodes);
        for (int i=0;i<numberOfNodes;i++) {
            assertEquals(expResult[i].getPath(), result[i].getPath());
        }
    }
    
    @Test
    public void testDijkstra3() {
        System.out.println("Dijkstra: 2 solmua");
        int[][] graph = { {0,1},
                          {1,0}
                        };
        int startNode = 1;
        int numberOfNodes = 2;
        Node[] expResult = new Node [numberOfNodes];
        for (int i=0;i<numberOfNodes;i++) {
            expResult[i] = new Node(i,i,0,i);
        }
        expResult[0].setPath(0);
        expResult[1].setPath(1);
    //    expResult[1].setPath(1);
        Node[] result = DijkstraAlgorithm.Dijkstra(graph, startNode, numberOfNodes);
        for (int i=0;i<numberOfNodes;i++) {
            assertEquals(expResult[i].getPath(), result[i].getPath());
        }
    }
    
    
    /**
     * Test of main method, of class DijkstraAlgorithm.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DijkstraAlgorithm.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
