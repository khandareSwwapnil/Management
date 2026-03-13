package com.example.demo.serviceimpl;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminOrganizationDto;
import com.example.demo.entity.Organization;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.service.OrganizationAdminService;

@Service
public class OrganizationAdminServiceImpl implements OrganizationAdminService {

	@Autowired
	private OrganizationRepository organizationRepository;

	private AdminOrganizationDto mapToDto(Organization o) {
		AdminOrganizationDto dto = new AdminOrganizationDto();
		dto.setEmail(o.getEmail());
		dto.setStatus(o.getStatus());
		dto.setCreatedDate(o.getCreatedAt());
		dto.setOrgId(o.getOrgId());
		dto.setOrgName(o.getOrgName());
		dto.setPhone(o.getPhone());
		
		return dto;
	}

	@Override
	public List<AdminOrganizationDto> getAllOrganizations() {
		return organizationRepository.findAll()
				.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}

	@Override
	public void updateStatus(Long id, String status) {
		Organization org = organizationRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Organization not found with id: " + id));
		org.setStatus(status);
		organizationRepository.save(org);
	}

	

	// ✅ Feature-1 Export Excel
	@Override
	public byte[] exportExcel() {
		// currently dummy implementation
		// If you want real Excel I will give Apache POI code
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		String content = "Excel export not implemented yet.";
		try {
			out.write(content.getBytes());
		} catch (Exception e) {}
		return out.toByteArray();
	}

	// ✅ Feature-1 Export PDF
	@Override
	public byte[] exportPdf() {
	    try {
	        List<Organization> list = organizationRepository.findAll();

	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        com.lowagie.text.Document document = new com.lowagie.text.Document();
	        com.lowagie.text.pdf.PdfWriter.getInstance(document, out);

	        document.open();

	        document.add(new com.lowagie.text.Paragraph("Organizations Report"));
	        document.add(new com.lowagie.text.Paragraph(" "));
	        
	        com.lowagie.text.pdf.PdfPTable table = new com.lowagie.text.pdf.PdfPTable(5);
	        table.setWidthPercentage(100);

	        table.addCell("ID");
	        table.addCell("Name");
	        table.addCell("Email");
	        table.addCell("Contact");
	        table.addCell("Status");

	        for (Organization o : list) {
	            table.addCell(String.valueOf(o.getOrgId()));
	            table.addCell(o.getOrgName());
	            table.addCell(o.getEmail());
	            table.addCell(o.getPhone());
	            table.addCell(o.getStatus());
	        }

	        document.add(table);
	        document.close();

	        return out.toByteArray();
	    } catch (Exception e) {
	        throw new RuntimeException("PDF export failed", e);
	    }
	}

	@Override
	public void updateTag(Long id, String tag) {
		// TODO Auto-generated method stub
		
	}

	

	
}
