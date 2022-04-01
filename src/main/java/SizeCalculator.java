import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class SizeCalculator
{
    private static double getSizeInKiloBytes(double sizeInByte)
    {
        return sizeInByte/1024;
    }
    private static double getSizeInMegaBytes(double sizeInByte)
    {
        return sizeInByte/1048576;
    }
    private static double getSizeInGigaBytes(double sizeInByte)
    {
        return sizeInByte/(1048576*1024);
    }
    public static void getSize(Path path) throws IOException {
        double sizeInBytes;
        sizeInBytes = Files.walk(path)
                .map(Path::toFile)
                .filter(File::isFile)
                .mapToLong(File::length)
                .sum();

        if(sizeInBytes < 1024) {
            System.out.printf("%.2f",sizeInBytes);
            System.out.println(" Bytes");
        }
        else if (sizeInBytes > 1024 && sizeInBytes < 1048576) {
            System.out.printf("%.2f",getSizeInKiloBytes(sizeInBytes));
            System.out.println(" KiloBytes");
        }
        else if (sizeInBytes > 1048576 && sizeInBytes < 1048576*1024) {
            System.out.printf("%.2f",getSizeInMegaBytes(sizeInBytes));
            System.out.println(" MegaBytes");
        }
        else {
            System.out.printf("%.2f",getSizeInGigaBytes(sizeInBytes));
            System.out.println(" GigaBytes");
        }
    }
}
