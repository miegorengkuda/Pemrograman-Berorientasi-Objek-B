import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

/**
 * ImageFileManager is a small utility class with static methods to load
 * and save images.
 *
 * The files on disk can be in JPG or PNG image format.
 *
 * @author Michael Kolling and David J Barnes
 * @version 2.0
 */
public class ImageFileManager
{
    // A constant for the image format that this writer uses for writing.
    private static final String IMAGE_FORMAT = "jpg";

    /**
     * Read an image file from disk and return it as an OFImage. This method
     * can read JPG and PNG file formats. In case of any problem (e.g the file
     * does not exist, is in an undecodable format, or any other read error)
     * this method returns null.
     *
     * @param imageFile The image file to be loaded.
     * @return The OFImage object or null is it could not be read.
     */
    public static OFImage loadImage(File imageFile)
    {
        try {
            BufferedImage image = ImageIO.read(imageFile);
            if(image == null || (image.getWidth(null) < 0)) {
                // we could not load the image - probably invalid file format
                return null;
            }
            return new OFImage(image);
        }
        catch(IOException exc) {
            // Log the error but return null
            System.err.println("Error loading image: " + exc.getMessage());
            return null;
        }
    }

    /**
     * Write an image file to disk. The file format is JPG. In case of any
     * problem the method just silently returns.
     *
     * @param image The image to be saved.
     * @param file The file to save to.
     */
    public static void saveImage(OFImage image, File file)
    {
        try {
            ImageIO.write(image, IMAGE_FORMAT, file);
        }
        catch(IOException exc) {
            // In a simple app, we just return on failure
            System.err.println("Error saving image: " + exc.getMessage());
            return;
        }
    }
}