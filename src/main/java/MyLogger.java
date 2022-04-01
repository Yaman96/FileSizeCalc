import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class MyLogger
{
    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static final Marker USER_INPUT = MarkerManager.getMarker("INPUT");
    public static final Marker EXCEPTIONS = MarkerManager.getMarker("EXCEPTIONS");
}
