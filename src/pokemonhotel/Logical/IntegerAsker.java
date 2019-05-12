/**
 * 
 */

package pokemonhotel.Logical;
import java.util.Scanner;
import java.io.InputStream;
import java.io.PrintStream;

public class IntegerAsker {
    // Set up a Scanner.
    private final Scanner scanner;
    // Set up a PrintStream
    private final PrintStream out;

    // IntegerAsker Constructor
    public IntegerAsker(InputStream in, PrintStream out)
    {
        scanner = new Scanner(in);
        this.out = out;
    }

    /**
     * Returns an Integer which is inputed by the user
     *
     * @param message This is a message which will be displayed to the user
     * @return
     */
    public int ask(String message)
    {
        System.out.print(message);
        while (true)
        {
            while (!scanner.hasNextInt())
            {
               
                     System.err.println("Incorrect input. Please enter a number");
                     scanner.nextLine(); // Discard junk entries

               
            }
            
            return scanner.nextInt();
        }
  
        
        
        
    }
}

