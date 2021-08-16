package com.kali_corporation.vividcooleditor.ui.ChristopherEssex;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LeonaEdmiston {
    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {

        } finally {
            try {
                is.close();
            } catch (IOException e) {

            }
        }
        return sb.toString();
    }

    public static void closeStream(Closeable stream) {
        try {
            if (stream != null)
                stream.close();
        } catch (IOException e) {

        }
    }

    public static byte[] InputStreamToByte(InputStream is) throws IOException {

        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        int ch;
        while ((ch = is.read()) != -1) {
            bytestream.write(ch);
        }
        byte byteData[] = bytestream.toByteArray();
        bytestream.close();
        return byteData;
    }
}
