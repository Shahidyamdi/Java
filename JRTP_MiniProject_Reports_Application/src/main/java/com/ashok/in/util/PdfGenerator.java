package com.ashok.in.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashok.in.entity.CitizenPlan;
import com.ashok.in.repository.CitizenPlanRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
@Component
public class PdfGenerator {
	@Autowired
	CitizenPlanRepository citizenPlanRepo;

	public void generate(HttpServletResponse response, List<CitizenPlan> records, File file) throws Exception {

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();

		// Creating font
		// Setting font style and size
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("Citizen Plans Info", fontTitle);

		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		// Adding the created paragraph in document
		document.add(paragraph);

		PdfPTable table = new PdfPTable(7);
		table.setSpacingBefore(5);
		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan Start Date");
		table.addCell("Plan End Date");
		table.addCell("Benefit Amount");

		List<CitizenPlan> allRecords = citizenPlanRepo.findAll();

		for (CitizenPlan plan : allRecords) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			if (plan.getPlanStartDate() != null) {
				table.addCell(plan.getPlanStartDate() + "");
			} else {
				table.addCell("N/A");
			}
			if (plan.getPlanEndDate() != null) {
				table.addCell(plan.getPlanEndDate() + "");
			} else {
				table.addCell("N/A");
			}
			table.addCell(String.valueOf(plan.getBenefitAmount()));
		}

		document.add(table);
		document.close();

		
	}

}
