import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Testing program for Rectangles Assignment
 * Created by Dave on 1/16/2016.
 */

public class Main {

  static final String ANSI_RESET = "\u001B[0m";
  static final String ANSI_BLACK = "\u001B[30m";
  static final String ANSI_RED = "\u001B[31m";
  static final String ANSI_GREEN = "\u001B[32m";
  static final String ANSI_YELLOW = "\u001B[33m";
  static final String ANSI_BLUE = "\u001B[34m";
  static final String ANSI_PURPLE = "\u001B[35m";
  static final String ANSI_CYAN = "\u001B[36m";
  static final String ANSI_WHITE = "\u001B[37m";

  public static void main( String[] args ) throws Exception{

    // Create a bunch of rectangles to test
    ArrayList rects = new ArrayList<Rect2D>();

    rects.add( new Rect2D( 100, 100, 50, 50, "R1" ) );     // R1
    rects.add( new Rect2D( 75, 75, 50, 50, "R2" ) );       // R2

    rects.add( new Rect2D( 200, 100, 50, 50, "R3" ) );     // R3
    rects.add( new Rect2D( 200, 100, 50, 50, "R4" ) );     // R4

    rects.add( new Rect2D( 75, 200, 50, 50, "R5" ) );      // R5
    rects.add( new Rect2D( 135, 200, 50, 50, "R6" ) );     // R6

    rects.add( new Rect2D( 205, 200, 50, 50, "R7" ) );     // R7
    rects.add( new Rect2D( 235, 200, 50, 50, "R8" ) );     // R8

    rects.add( new Rect2D( 100, 350, 150, 50, "R9" ) );    // R9
    rects.add( new Rect2D( 100, 350, 50, 150, "R10" ) );   // R10

    rects.add( new Rect2D( 300, 350, 50, 150, "R11" ) );   // R11
    rects.add( new Rect2D( 300, 325, 50, 50, "R12" ) );    // R12

    rects.add( new Rect2D( 350, 100, 75, 75, "R13" ) );   // R11
    rects.add( new Rect2D( 350, 100, 50, 50, "Dave" ) );    // R12

    boolean result;

    // R1 vs R2
    CompareRectangles( rects, 0, 1, "R1", "R2" );
    System.out.println();

    // R3 vs R4
    result = ( (Rect2D)( rects.get( 2 ) ) ).overlaps( (Rect2D)rects.get( 3 ) );
    System.out.println( "R3 Overlaps R4 (true) :" + colorError( true, result ) );

    result = ( (Rect2D)( rects.get( 3 ) ) ).overlaps( (Rect2D)rects.get( 2 ) );
    System.out.println( "R4 Overlaps R3 (true) :" + colorError( true, result ) );

    result = ( (Rect2D)( rects.get( 2 ) ) ).contains( (Rect2D)rects.get( 3 ) );
    System.out.println( "R3 Contains R4 (true) :" + colorError( true, result ) );

    result = ( (Rect2D)( rects.get( 3 ) ) ).contains( (Rect2D)rects.get( 2 ) );
    System.out.println( "R4 Contains R3 (true) :" + colorError( true, result ) );
    System.out.println();

    // R5 vs R6
    result = ( (Rect2D)( rects.get( 4 ) ) ).contains( (Rect2D)rects.get( 5 ) );
    System.out.println( "R5 Contains R6 (false):" + colorError( false, result ) );

    result = ( (Rect2D)( rects.get( 5 ) ) ).contains( (Rect2D)rects.get( 4 ) );
    System.out.println( "R6 Contains R5 (false):" + colorError( false, result ) );

    result = ( (Rect2D)( rects.get( 4 ) ) ).overlaps( (Rect2D)rects.get( 5 ) );
    System.out.println( "R5 Overlaps R6 (false):" + colorError( false, result ) );

    result = ( (Rect2D)( rects.get( 5 ) ) ).overlaps( (Rect2D)rects.get( 4 ) );
    System.out.println( "R6 Overlaps R5 (false):" + colorError( false, result ) );
    System.out.println();

    // R7 vs R8
    result = ( (Rect2D)( rects.get( 6 ) ) ).contains( (Rect2D)rects.get( 7 ) );
    System.out.println( "R7 Contains R8 (false):" + colorError( false, result ) );

    result = ( (Rect2D)( rects.get( 7 ) ) ).contains( (Rect2D)rects.get( 6 ) );
    System.out.println( "R8 Contains R7 (false):" + colorError( false, result ) );

    result = ( (Rect2D)( rects.get( 6 ) ) ).overlaps( (Rect2D)rects.get( 7 ) );
    System.out.println( "R7 Overlaps R8 (true) :" + colorError( true, result ) );

    result = ( (Rect2D)( rects.get( 7 ) ) ).overlaps( (Rect2D)rects.get( 6 ) );
    System.out.println( "R8 Overlaps R7 (true) :" + colorError( true, result ) );
    System.out.println();

     // R9 vs R10
    result = ( (Rect2D)( rects.get( 8 ) ) ).contains( (Rect2D)rects.get( 9 ) );
    System.out.println( "R9 Contains R10 (false):" + colorError( false, result ) );

    result = ( (Rect2D)( rects.get( 9 ) ) ).contains( (Rect2D)rects.get( 8 ) );
    System.out.println( "R10 Contains R9 (false):" + colorError( false, result ) );

    result = ( (Rect2D)( rects.get( 8 ) ) ).overlaps( (Rect2D)rects.get( 9 ) );
    System.out.println( "R9 Overlaps R10 (true) :" + colorError( true, result ) );

    result = ( (Rect2D)( rects.get( 9 ) ) ).overlaps( (Rect2D)rects.get( 8 ) );
    System.out.println( "R10 Overlaps R9 (true) :" + colorError( true, result ) );
    System.out.println();

    // R11 vs R12
    result = ( (Rect2D)( rects.get( 10 ) ) ).contains( (Rect2D)rects.get( 11 ) );
    System.out.println( "R11 Contains R12 (false):" + colorError( false, result ) );

    result = ( (Rect2D)( rects.get( 11 ) ) ).contains( (Rect2D)rects.get( 10 ) );
    System.out.println( "R12 Contains R11 (false):" + colorError( false, result ) );

    result = ( (Rect2D)( rects.get( 10 ) ) ).overlaps( (Rect2D)rects.get( 11 ) );
    System.out.println( "R11 Overlaps R12 (true) :" + colorError( true, result ) );

    result = ( (Rect2D)( rects.get( 11 ) ) ).overlaps( (Rect2D)rects.get( 10 ) );
    System.out.println( "R12 Overlaps R11 (true) :" + colorError( true, result ) );
    System.out.println();

    // R13 vs R14
    result = ( (Rect2D)( rects.get( 12 ) ) ).contains( (Rect2D)rects.get( 13 ) );
    System.out.println( "R13 Contains R14 (true):" + colorError( true, result ) );

    result = ( (Rect2D)( rects.get( 11 ) ) ).contains( (Rect2D)rects.get( 10 ) );
    System.out.println( "R14 Contains R13 (false):" + colorError( false, result ) );

    result = ( (Rect2D)( rects.get( 12 ) ) ).overlaps( (Rect2D)rects.get( 13 ) );
    System.out.println( "R13 Overlaps R14 (false) :" + colorError( true, result ) );

    result = ( (Rect2D)( rects.get( 13 ) ) ).overlaps( (Rect2D)rects.get( 12 ) );
    System.out.println( "R14 Overlaps R13 (false) :" + colorError( true, result ) );
    System.out.println();

//    availableEngine();
    SwingUtilities.invokeLater( new Runnable() {
      @Override
      public void run(){
        new DrawRectangles( rects ).setVisible( true );
      }
    } );
  }

  private static void CompareRectangles( ArrayList rects, int r1, int r2, String rname1, String rname2 ){
    Rect2D rect1 = (Rect2D)rects.get( r1 );
    Rect2D rect2 = (Rect2D)rects.get( r2 );

    boolean result = rect1.overlaps( rect2 );
    System.out.println( rect1.rectName + " Overlaps " + rect2.rectName + " (true) :" + colorError( true, result ) );

    result = rect2.overlaps( rect1 );
    System.out.println( rect2.rectName + "Overlaps " + rect1.rectName + " (true) :" + colorError( true, result ) );

    result = rect1.contains( rect2 );
    System.out.println( "R1 Contains R2 (false):" + colorError( false, result ) );

    result = ( rect2 ).contains( rect1 );
    System.out.println( "R2 Contains R1 (false):" + colorError( false, result ) );
  }

  public static String colorError( boolean expecting, boolean received ){
    String resultString = received ? "TRUE" : "FALSE";
    return ( expecting == received ? ANSI_GREEN : ANSI_RED ) + resultString + ANSI_RESET;
  }

//  private static void availableEngine()
//  {
//    ScriptEngineManager mgr = new ScriptEngineManager();
//    List<ScriptEngineFactory> factories = mgr.getEngineFactories();
//    for (ScriptEngineFactory factory : factories)
//    {
//      System.out.println("ScriptEngineFactory Info");
//      String engName = factory.getEngineName();
//      String engVersion = factory.getEngineVersion();
//      String langName = factory.getLanguageName();
//      String langVersion = factory.getLanguageVersion();
//      System.out.printf("\tScript Engine: %s (%s)\n", engName, engVersion);
//      List<String> engNames = factory.getNames();
//      for (String name : engNames)
//      {
//        System.out.printf("\tEngine Alias: %s\n", name);
//      }
//      System.out.printf("\tLanguage: %s (%s)\n", langName, langVersion);
//    }
//  }
}