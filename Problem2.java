import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ConcordanceExample {
    @SuppressWarnings("rawtypes")
	public static void main(String[] args ) {
        try {
        	String line;
        	TreeMap<String,LinkedList<Integer>> mapWords = new TreeMap<String,LinkedList<Integer>>( );
            BufferedReader br = new BufferedReader( new FileReader( "input.txt" ) );

            for( int lineNum = 1; ( line = br.readLine( ) ) != null; lineNum++ ) {
                StringTokenizer st = new StringTokenizer( line );
                while( st.hasMoreTokens( ) ){
                    String word = st.nextToken( );
                    LinkedList<Integer> lines =  mapWords.get( word );
                    if( lines == null ){
                        lines = new LinkedList<Integer>( );
                        mapWords.put( word, lines );
                    }
                    lines.addLast( new Integer( lineNum ) );
                }
            }

            for( Iterator itr = mapWords.entrySet( ).iterator( ); itr.hasNext( ); ){
            	printData( (Map.Entry) itr.next( ) );
            }
            br.close();
         }catch( Exception e ){ 
        	 System.err.println( "Error while processing = " + e ); 
         }
    }

    @SuppressWarnings("rawtypes")
	public static void printData( Map.Entry entry ){
         System.out.println( entry.getKey( ) + ":" );
         Iterator it = ( (LinkedList)(entry.getValue( )) ).iterator( );
         System.out.print( "\t {" + it.next( ) );
         while( it.hasNext( ) )
             System.out.print( ", " + it.next( ) );
         System.out.print("}");
         System.out.println( );
    }
}