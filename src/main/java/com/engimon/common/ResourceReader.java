package com.engimon.common;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.imageio.ImageIO;

public final class ResourceReader {

    private InputStream inputStream;
    private String fileName;

    public ResourceReader(String fileName) {
        this.fileName = fileName;

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }
        this.inputStream = inputStream;

    }

    public final String getFilename() {
        return this.fileName;
    }

    public final InputStream getStream() {
        return this.inputStream;
    }

    public final InputStreamReader getStreamReader() {
        return new InputStreamReader(this.inputStream, StandardCharsets.UTF_8);
    }

    public static final Image getImage(String fileName, int width, int height) {
        ResourceReader rr = new ResourceReader(fileName);
        try {
            BufferedImage image = ImageIO.read(rr.getStream());
            Image resized = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return resized;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public final void printInputStream() {

        try (InputStreamReader streamReader = new InputStreamReader(this.inputStream, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
