package org.conan.tools.core.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Conan
 */
public class WriteFile {

    public WriteFile(String filePath, String fileString) {
        writeFile(filePath, fileString);
    }

    public void writeFile(String filePath, String fileString) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(filePath));
            pw.print(fileString);
            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }

    public static void main(String[] args) {
        new WriteFile("/home/conan/aa.txt", "aaaa是砂工");
    }
}
