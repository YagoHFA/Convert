package com.hfa;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.hfa.implementation.Convert;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.rendering.ImageType;

public class ConvertPDFtoJPEG {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: PdfToImageConverter.exe <file-path> <file-type>");
            return;
        }


        String filePath = args[0];  // Get the PDF file from command-line argument
        String outputDir = "output_images/"; // Directory to save images
        Convert convert = new Convert();
        switch (args[1]) {
            case "PDF":
                convert.ConvertPDFtoJPEG(filePath, outputDir);
                break;
            case "JPEG":
                convert.ConvertPNGtoJPEG(filePath, outputDir);
                break;
            case "PNG":

                break;
            default:

        }
    }
}