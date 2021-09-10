package com.co.app.miscellaneous.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

public class ArchivoUtils {

    public static void createFile(String filePath, String fileData64 )
    {
        byte[] data = Base64.getDecoder().decode(fileData64);

        try (OutputStream stream = new FileOutputStream(filePath))
        {
            stream.write(data);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getExtension(String type)
    {
        if (type.equalsIgnoreCase("image/png"))
            return ".png";
        else
            return ".tmp";
    }

}
