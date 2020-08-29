package edu.escuelaing.arep.tallerservidorcliente.httpServer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.FileReader;
import java.net.Socket;
import java.util.Base64;


public class IMGFile implements FileB {

    @Override
    public void getFile(String path, Socket clientSocket) throws IOException {
        File archivo = new File(System.getProperty("user.dir") + path);
        FileInputStream fis = new FileInputStream(archivo);
        byte[] data = new byte[(int) (archivo.length())];
        fis.read(data);
        fis.close();
        DataOutputStream binaryOut = new DataOutputStream(clientSocket.getOutputStream());
        binaryOut.writeBytes("HTTP/1.0 200 OK\r\n");
        binaryOut.writeBytes("Content-Type: image/png\r\n");
        binaryOut.writeBytes("Content-Length: " + data.length);
        binaryOut.writeBytes("\r\n\r\n");
        binaryOut.write(data);

        binaryOut.close();

    }
}
