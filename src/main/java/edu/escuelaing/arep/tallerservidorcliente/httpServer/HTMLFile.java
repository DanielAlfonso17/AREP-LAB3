package edu.escuelaing.arep.tallerservidorcliente.httpServer;

import java.io.*;
import java.io.FileReader;
import java.net.Socket;

public class HTMLFile implements FileB {

    @Override
    public void getFile(String path, Socket clientSocket) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(System.getProperty("user.dir") + path));
        String cont = "";
        String line;
        while ((line = read.readLine()) != null) {
            cont =
                    cont + line;
        }
        clientSocket.getOutputStream().write(("HTTP/1.1 200 OK \r\n"
                + "Content-Type: text/html; charset=\"utf-8\" \r\n"
                + "\r\n"
                + cont).getBytes());
        read.close();
    }
}
