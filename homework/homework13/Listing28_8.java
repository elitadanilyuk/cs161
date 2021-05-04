import java.util.*;

public class Listing28_8 {

	public static void main(String[] args) {
		
		// Graphs - depthFirstTraversal()
		GraphHelper graph = createGraph();
        GraphHelper.GraphIterator itr = graph.iterator();
        
        System.out.println("Adjacency vertex lists:");
        while (itr.hasNext())
            System.out.println(itr.next());
        
		String graphRoot = "Bob";

		System.out.println("\nPerforming a depth first traversal of the graph");
		System.out.println(depthFirstTraversal(graph, graphRoot));

	}
	
//*******************************************Graphs***************************************************

	static GraphHelper createGraph() {
		GraphHelper graph = new GraphHelper();
		graph.addVertex("Bob");
		graph.addVertex("Alice");
		graph.addVertex("Mark");
		graph.addVertex("Rob");
		graph.addVertex("Maria");
		graph.addEdge("Bob", "Alice");
		graph.addEdge("Bob", "Rob");
		graph.addEdge("Alice", "Mark");
		graph.addEdge("Rob", "Mark");
		graph.addEdge("Alice", "Maria");
		graph.addEdge("Rob", "Maria");
		return graph;
	}
    
	// TODO fill in these methods
	static Set<String> depthFirstTraversal(GraphHelper graph, String root) {
		LinkedHashSet<String> dftSet = new LinkedHashSet<>();
		LinkedHashSet<String> visited = new LinkedHashSet<>();
		return dfs(graph, root, dftSet, visited);
    }
    
    static Set<String> dfs(GraphHelper graph, String root, LinkedHashSet<String> dftSet, LinkedHashSet<String> visited) {
		// TODO
		dftSet.add(root); //adding the first root
		visited.add(root); //marking the first root as visited

		//for-each to visit each neighbor of a root
		for (String currRoot: graph.getAdjVertices(root)) {
			if(!visited.contains(currRoot)){
				//base instance to recursively call dft() to make sure each node is visited
				dfs(graph, currRoot, dftSet, visited);
			}
		} //end for-each

		// returning the complete dftSet
		return dftSet;
	}
}


