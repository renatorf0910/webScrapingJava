package com.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import io.github.cdimascio.dotenv.Dotenv;

public class App 
{
    public static void main( String[] args )
    {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("URL_GOV");
        String outputDir = "downloads/";
        try {
            Files.createDirectories(Paths.get(outputDir));
            Document doc = Jsoup.connect(url).get();
            for (Element link : doc.select("a[href$=.pdf]")) {
                String pdfUrl = link.absUrl("href");
                if (pdfUrl.contains("Anexo")) {
                    downloadFile(pdfUrl, outputDir);
                }
            }

            zipFiles(outputDir, "compact_pdf.zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void downloadFile(String fileURL, String saveDir) {
        try (InputStream in = new URL(fileURL).openStream()) {
            Path filePath = Paths.get(saveDir, new File(fileURL).getName());
            Files.copy(in, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error download: " + fileURL);
        }
    }

    private static void zipFiles(String folder, String zipFile) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            Files.walk(Paths.get(folder)).filter(Files::isRegularFile).forEach(file -> {
                try (InputStream fis = Files.newInputStream(file)) {
                    ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                    zos.putNextEntry(zipEntry);
                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = fis.read(bytes)) >= 0) {
                        zos.write(bytes, 0, length);
                    }
                    zos.closeEntry();
                } catch (Exception e) {
                    System.err.println("Error add zip: " + file);
                }
            });
        } catch (IOException e) {
            System.err.println("Error create zip");
        }
    }
}
