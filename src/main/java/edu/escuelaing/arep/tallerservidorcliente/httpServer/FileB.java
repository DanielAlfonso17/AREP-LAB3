package edu.escuelaing.arep.tallerservidorcliente.httpServer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * interfaz encargada de generar la respuesta dependiendo del tipo de archivo
 * css, js, html, png
 */
public interface FileB {
    /**
     *
     * @param path ruta del archivo que queremos
     * @param clientSocket socket del cliente para escribir la información solcitada
     * @throws IOException
     */
    public void getFile(String path, Socket clientSocket) throws IOException;

}
