import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        String input ="";
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        for(;;)
        {
            try {
                System.out.print("Type file path: ");
                input = userInput.readLine();
                Path path = Paths.get(input);
                MyLogger.LOGGER.info(MyLogger.USER_INPUT,"User typed this path: " + input);
                SizeCalculator.getSize(path);
                break;
            } catch (IOException io) {
                System.out.println(Arrays.toString(io.getStackTrace()));
                MyLogger.LOGGER.info(MyLogger.EXCEPTIONS,"Exception found: " + io + " User typed this path: " + input);
            }
        }
    }
}

