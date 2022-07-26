package lesson2_drawTextFiguresImages;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.net.MalformedURLException;
import java.net.URL;

public class DrawTextFiguresImages {
    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        jFrame.add(new MyComponent());
    }

    public static class MyComponent extends JComponent {
        private Graphics2D painter;
        @Override
        protected void paintComponent(Graphics g) {
            painter = (Graphics2D) g;
            paintText();
            paintEllipse();
            paintFullRedRectangle();
            paintImageGoogle();
        }
        private void paintText (){
            Font font = new Font("Arial", Font.BOLD,25);
            painter.setFont(font);
            painter.drawString("Some text for user", 30, 30);
        }
        private void paintEllipse (){
            Ellipse2D ellipse2D = new Ellipse2D.Double(80, 60, 90, 130);
            painter.draw(ellipse2D);
        }
        private void paintFullRedRectangle (){
            Rectangle2D rectangle2D = new Rectangle2D.Double(180, 60, 90, 80);
            var defaultColor = painter.getColor();
            painter.setPaint(Color.red);
            painter.fill(rectangle2D);
            painter.setPaint(defaultColor);
        }
        private void paintImageGoogle(){
            try {
                URL googleImagesLink = new URL("https://www.google.com/images/branding/"
                                                + "googlelogo/2x/googlelogo_color_92x30dp.png");
                Image googleImage = new ImageIcon(googleImagesLink).getImage();
                painter.drawImage(googleImage,20,200, null);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static JFrame getFrame (){
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setSize(500, 300);
        jFrame.setLocation(dimension.width/2 - 250, dimension.height/2 - 150);
        jFrame.setTitle("Tittle text");
        return jFrame;
    }
}
