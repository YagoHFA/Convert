package com.hfa;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.rendering.ImageType;

public class ConvertPDFtoJPEG {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java -jar PdfToImageConverter.jar <pdf-file-path>");
            return;
        }

        String pdfPath = args[0];  // Get the PDF file from command-line argument
        String outputDir = "output_images/"; // Directory to save images

        convertPdfToImages(pdfPath, outputDir);;
    }

    public static void convertPdfToImages(String pdfPath, String outputDir) {
        System.out.println("path:" + pdfPath);
        try {
            PDDocument document = PDDocument.load(new File(pdfPath));
            PDFRenderer pdfRenderer = new PDFRenderer(document);

            File dir = new File(outputDir);
            if (!dir.exists()) dir.mkdirs();

            for (int page = 0; page < document.getNumberOfPages(); page++) {
                BufferedImage image = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                File outputFile = new File(outputDir + "page_" + (page + 1) + ".jpg");
                ImageIO.write(image, "JPEG", outputFile);
                System.out.println("Saved: " + outputFile.getAbsolutePath());
            }

            document.close();
            System.out.println("PDF converted successfully!");

        } catch (IOException e) {
            System.err.println("Error processing PDF: " + e.getMessage());
        }
    }
}