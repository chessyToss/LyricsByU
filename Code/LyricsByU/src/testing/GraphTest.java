package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import graph.Graph;

public class GraphTest {

	Graph testGraph;
	
	@Before
	public void setUp() throws Exception {
		testGraph = new Graph();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(testGraph.E());
		System.out.println(testGraph.V());
		for (int i : testGraph.adj(0))
			System.out.println(i);
		fail("Not yet implemented");
	}

}
