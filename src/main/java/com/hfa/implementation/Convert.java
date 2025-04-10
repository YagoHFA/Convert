package com.hfa.implementation;

import com.hfa.Interfaces.PDF.ConvertPDF;
import com.hfa.Interfaces.PNG.ConvertPNG;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Convert implements ConvertPNG, ConvertPDF {

    @Override
    public void ConvertPDFtoJPEG(String filepath, String outPath) {
        try {
            PDDocument document = PDDocument.load(new File(filepath));
            PDFRenderer pdfRenderer = new PDFRenderer(document);

            File dir = new File(outPath);
            if (!dir.exists()) dir.mkdirs();

            for (int page = 0; page < document.getNumberOfPages(); page++) {
                BufferedImage image = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                File outputFile = new File(outPath + "page_" + (page + 1) + ".jpg");
                ImageIO.write(image, "JPEG", outputFile);
                System.out.println("Saved: " + outputFile.getAbsolutePath());
            }

            document.close();
            System.out.println("PDF converted successfully!");

        } catch (IOException e) {
            System.err.println("Error processing PDF: " + e.getMessage());
        }
    }

    @Override
    public void ConvertPNGtoJPEG(String filepath, String outPath) {

    }
}
