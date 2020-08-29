package edu.escuelaing.arep.tallerservidorcliente.httpServer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

public class JSFile implements FileB {
    @Override
    public void getFile(String path, Socket clientSocket) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(System.getProperty("user.dir") + path));
        String cont = "";
        String line;
        while ((line = read.readLine()) != null) {
            cont =
                    cont + line;
        }
        clientSocket.getOutputStream().write(("HTTP/1.1 200 Ok \r\n"
                + "Content-Type: text/javascript \r\n"
                + "\r\n"
                + cont).getBytes());
        read.close();
    }
}
