package com.hfa.Interfaces.PDF;

import com.hfa.Interfaces.PDF.Functions.ConvertPDFToJPEG;

public interface ConvertPDF extends ConvertPDFToJPEG {
    void ConvertPDFtoJPEG(String filepath, String outPath);
}
