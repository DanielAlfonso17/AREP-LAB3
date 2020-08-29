package edu.escuelaing.arep.tallerservidorcliente.httpServer;

import java.io.IOException;
import java.net.Socket;

public class FileReader {
    FileB fileB;
    String path;

    public FileReader(String filePath){
        path = filePath;
        if(path.contains(".html")){
            fileB = new HTMLFile();
        }else if(path.contains(".jpg")||path.contains(".png")){
            fileB = new IMGFile();
        }else if(path.contains(".js")){
            fileB = new JSFile();
        }else if(path.contains(".css")){
            fileB = new CssFile();
        }
    }

    public void getFile(Socket clientSocket) throws IOException{
        fileB.getFile(path,clientSocket);
    }
}
