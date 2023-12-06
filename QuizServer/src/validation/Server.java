/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

/**
 *
 * @author Nguyen
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getInetAddress());

                new Thread(() -> {
                    try {
                        Robot robot = new Robot();
                        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

                        while (true) {
                            BufferedImage screenshot = robot.createScreenCapture(new Rectangle(screenSize));
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            ImageIO.write(screenshot, "jpg", baos);

                            byte[] imgBytes = baos.toByteArray();
                            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

                            dos.writeInt(imgBytes.length);
                            dos.write(imgBytes);
                            dos.flush();

                            Thread.sleep(100); // Wait for a while before capturing the next screenshot
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
