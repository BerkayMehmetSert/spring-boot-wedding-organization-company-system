package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.model.Employment;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
@Slf4j
public class PdfService {

    public ByteArrayInputStream generatePdf(final Employment employment) {
        final String employmentCode = employment.getServiceCode();
        final String employmentName = employment.getServiceName();
        final String employmentDescription = employment.getDescription();
        final String title = "Employment" + " " + employmentCode + " " + employmentName;
        final String fileName = employmentCode + "_" + employmentName + ".pdf";
        final String employmentCodeContent = "Employment Code : " + employmentCode;
        final String employmentNameContent = "Employment Name : " + employmentName;
        final String employmentDescriptionContent = "Employment Description : " + employmentDescription;

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, out);

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

        Paragraph titleParagraph = new Paragraph(title, titleFont);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);

        Paragraph employmentCodeContentParagraph = new Paragraph(employmentCodeContent, contentFont);
        Paragraph employmentNameContentParagraph = new Paragraph(employmentNameContent, contentFont);
        Paragraph employmentDescriptionContentParagraph = new Paragraph(employmentDescriptionContent, contentFont);

        document.open();
        document.addTitle(fileName);
        document.addAuthor("BMS");
        document.addCreator("BMS");
        document.add(titleParagraph);
        document.add(employmentCodeContentParagraph);
        document.add(employmentNameContentParagraph);
        document.add(employmentDescriptionContentParagraph);
        document.setPageSize(PageSize.A5);
        document.close();

        log.info(BusinessLogMessage.Pdf.PDF_CREATED);
        return new ByteArrayInputStream(out.toByteArray());
    }
}
