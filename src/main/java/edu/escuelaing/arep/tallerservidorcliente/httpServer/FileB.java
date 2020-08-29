package edu.escuelaing.arep.tallerservidorcliente.httpServer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public interface FileB {
    public void getFile(String path, Socket clientSocket) throws IOException;

}
