//Program to read a textfile into a graph and experiment on the performance of dijkstras shortest paths algorithm
//Shaylin Velen
//25/04/2023

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;

public class GraphExperiment extends Graph{


    public static void main(String args[]) {

        
        try {
        
        FileWriter excel = new FileWriter("count.csv", true);
        excel.write("Vertices;" + "Edges;" + "Theoretical complexity;" + "vCount;" + "eCount;" + "pqCount;" + "Total Count" + "\n");
        excel.close();

        for (int i=0; i<5; i++) {
            for (int k=0; k<5; k++) {
            new GenerateGraph(i, k);
            
            Graph g = new Graph( );
            
            try
            {   
                    
                FileReader fin = new FileReader("dataset_" + GenerateGraph.vertices[i] + "_" + GenerateGraph.edges[i][k]);//"dataset_" + numVertices + "_" + numEdges
                
                Scanner graphFile = new Scanner( fin );

                // Read the edges and insert
                
                String line = graphFile.nextLine();
                String start = line.substring(0, line.indexOf(" "));
                line = line.replace(start + " ", "");

                String dest = line.substring(0, line.indexOf(" "));
                line = line.replace(dest + " ", "");

                int cost = Integer.parseInt(line);
                g.addEdge(start, dest, cost);
                        
                while( graphFile.hasNextLine( ) )
                {
                    line = graphFile.nextLine( );
                    

                    StringTokenizer st = new StringTokenizer( line );

                    try
                    {
                        if( st.countTokens( ) != 3 )
                        {
                            System.err.println( "Skipping ill-formatted line " + line );
                            continue;
                        }
                        String source  = st.nextToken( );                    
                        dest    = st.nextToken( );
                        cost    = Integer.parseInt( st.nextToken( ) );
                        g.addEdge( source, dest, cost );
                        
                        
                    }
                    catch( NumberFormatException e )
                    { System.err.println( "Skipping ill-formatted line " + line ); }
                }

                Graph.processRequest(g, start);
                
            }
            catch( IOException e )
            { System.err.println( e ); }

    }

    }

}

catch (IOException e){
    System.err.println("IO Exception");
}

}

}