package lesson1_CreateProgrammWindow;

import javax.swing.*;
import java.awt.*;

public class CreateWindow {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setSize(500, 300);
        jFrame.setLocation(dimension.width/2 - 250, dimension.height/2 - 150);
        jFrame.setTitle("Tittle text");
    }
}
