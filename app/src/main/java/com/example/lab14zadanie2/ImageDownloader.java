package com.example.lab14zadanie2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ImageDownloader {
    public static String downloadImage(String imageUrl, String destinationPath) {
        try (InputStream input = new URL(imageUrl).openStream();
             FileOutputStream output = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            return destinationPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
