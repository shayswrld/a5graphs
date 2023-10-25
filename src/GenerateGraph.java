//Class to generate a set of vertices and edges into a textfile and count the numeber of operations on these graphs
//Shaylin Velen
//2023/04/23

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.HashSet;

public class GenerateGraph
//A class to generate a graph and write the graph into a textfile in the format NodeXX NodeDest distance
{
public static final int[] vertices = {10, 20, 30, 40, 50};
public static final int[][] edges = {{20, 35, 50, 65, 80}, {76, 152, 228, 304, 380}, {174, 348, 522, 696, 870}, {312, 624, 936, 1248, 1560}, {490, 980, 1470, 1960, 2450}};
//edge numbers are proportional to vertex numbers for graphs
//edgenum = ((vNum*vNum - vNum)/5) * vIndex
//In the 2d array numEdges = 


  public GenerateGraph (int vIndex,int eIndex) throws IOException

  { 
      Random rand = new Random();
      HashSet<String[]> uniquePairs= new HashSet<>();//Hash set containing a key and the edge specified by two vertices
      //using a hash set prevents duplicates so you cannot specify a path twice

      int numVertices = vertices[vIndex];
      int numEdges = (edges[vIndex][eIndex]);
      double tComplexity = (numEdges)*((Math.log(numVertices))/Math.log(2));//ElogV
        
        String[] nodes = new String[numVertices]; //List declaration to store names of nodes to create graph with of size number of vertices the graph should have

        //for each vertex give it a name and store it in a list
        for (int j = 0; j< numVertices; j++) {


          nodes[j] = "Node" + Integer.toString(j + 1); //We want the form Node1, index of the array is one less than the number we need
        }

        int weight = rand.nextInt(10) + 1;//weight must be 1..10

          int sourceIndex = rand.nextInt(nodes.length);
          int destIndex = rand.nextInt(nodes.length);
      
          while (sourceIndex == destIndex) {

          destIndex = rand.nextInt(nodes.length);
        }

        //for each edge assign a weight and get two random vertices that are unequal
        //Continue creating and adding unique pairs until the number of edges neeed is satisfied
        while (uniquePairs.size() < numEdges) {

          weight = rand.nextInt(10) + 1;

          sourceIndex = rand.nextInt(nodes.length);
          destIndex = rand.nextInt(nodes.length);
      
          while (sourceIndex == destIndex) {

          destIndex = rand.nextInt(nodes.length);
        }

          //populate a hashset with source, dest and weight
          uniquePairs.add(new String[] {nodes[sourceIndex], nodes[destIndex], Integer.toString(weight)});
        
        }

          String tfName = "dataset_" + numVertices + "_" + numEdges; //Name of the textfile to be created
          
          FileWriter writer = new FileWriter(tfName);
          
          for (String[] el : uniquePairs)
          //Traverse the hashset where el is an array containing a source node, destination node and distance
          {
              
            String line = el[0] + " " + el[1] + " " + el[2] + "\n"; 
            writer.write(line);
            
            
          }
         FileWriter results = new FileWriter("results.txt", true);
         FileWriter excel = new FileWriter("count.csv", true);
      
         results.write("\nVertices: " + Integer.toString(numVertices) + "\n");
         results.write("Edges: " + Integer.toString(numEdges) + "\n");         
         String formatComp = String.format("%.2f", tComplexity);
         results.write("Theoretical complexity: O(" + formatComp + ")\n");
         results.close();
         writer.close();

         excel.write(numVertices + ";" + numEdges + ";" + formatComp + ";");                  
         excel.close();


  }

}
         
