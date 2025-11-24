import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

/**
 * An ImagePanel is a Swing component that can display an OFImage.
 * It is constructed as a subclass of JComponent with the added functionality
 * of setting an OFImage that will be displayed on the surface of this
 * component.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 1.0
 */
public class ImagePanel extends JComponent
{
    // The current width and height of this panel
    private int width, height;
    // An internal image buffer that is used for painting.
    private OFImage panelImage;

    /**
     * Create a new, empty ImagePanel.
     */
    public ImagePanel()
    {
        width = 360; // arbitrary size for empty panel
        height = 240;
        panelImage = null;
    }

    /**
     * Set the image that this panel should show.
     *
     * @param image The image to be displayed.
     */
    public void setImage(OFImage image)
    {
        if(image != null) {
            width = image.getWidth();
            height = image.getHeight();
            panelImage = image;
            repaint();
        }
    }

    /**
     * Clear the image on this panel and reset the background.
     */
    public void clearImage()
    {
        panelImage = null;
        repaint(); // forces a repaint to show the cleared background
    }

    // The following methods are redefinitions of methods
    // inherited from superclasses.

    /**
     * Tell the layout manager how big we would like to be.
     * (This method gets called by layout managers for placing
     * the components.)
     *
     * @return The preferred dimension for this component.
     */
    public Dimension getPreferredSize()
    {
        return new Dimension(width, height);
    }

    /**
     * This component needs to be redisplayed. Copy the internal image
     * to screen. (This method gets called by the Swing screen painter
     * every time it want this component displayed.)
     *
     * @param g The graphics context that can be used to draw on this component.
     */
    public void paintComponent(Graphics g)
    {
        Dimension size = getSize();
        // Clear the background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, size.width, size.height);

        // Draw the image if one is set
        if(panelImage != null) {
            g.drawImage(panelImage, 0, 0, null);
        }
    }
}