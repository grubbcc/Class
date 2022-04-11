import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

public class BipartiteMatching {

    Node[] nodes;
    HashMap<Integer, ArrayList<Node>> adj_list;         // adjacency list representation of graph
    int[] match;                                        // which node a node is matched with
    int M, N;                                           // M, N are number of machines and cards respectively
    boolean[] used;                                     // whether a node has been already used in matching or not

    /**
    * initialize constructor function. 
    * @param M : number of machines
    * @param N : number of cards
    */
    public BipartiteMatching(int M, int N) {
        nodes = new Node[M + N];
        adj_list = new HashMap<>(M + N);
        match = new int[M + N];
        this.M = M;
        this.N = N;
        used = new boolean[M + N];

        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
            adj_list.put(i, new ArrayList<>());
        }

    }

    /**
     * gradually build the graph by inserting edges
     * this function inserts all the nodes connected with node u
     * I'm not sure if this will ever be necessary, but just in case 
     * I added a check to make sure duplicate nodes
     
     * @param u : node under consideration
     * @param node_list : all the nodes connected with node u
    **/
    public void insList(int u, int[] node_list) {
        for(int adjacency : node_list) {
            if(!adj_list.get(u).contains(nodes[adjacency]))
                adj_list.get(u).add(nodes[adjacency]);
        }
        for(int v : node_list) {
            if(!adj_list.get(v).contains(nodes[u]))
                adj_list.get(v).add(nodes[u]);
        }
    }

    /** TODO
    * implement DFS function
    *
    * @param v : starting node for DFS 
    *
    * @return true if there is an augment path; if no, return false.
    */
    boolean dfs(int v) {
        return false;
    }

    /** TODO
    *
    * implement the bipartite matching algorithm
    * traverse the nodes
    * call dfs to see if there exists any augment path
    *
    * @return the max matching
    */
    int bipartiteMatching() {
        return 0;
    }

    /**
     *
     */

    public static void main(String[] args) {
        BipartiteMatching model = null;
        try {
            Scanner reader = new Scanner(new File("./src/sampleBipartiteData.txt"));
            int line = 0;
            while (reader.hasNextLine()) {

                int[] data = Stream.of(reader.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                if(line++ == 0) {
                    model = new BipartiteMatching(data[0], data[1]);
                }
                else {
                    model.insList(line - 1, data);
                }
            }
            reader.close();

            int res = model.bipartiteMatching();
            System.out.println("BipartiteMatching is: " + res);
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
