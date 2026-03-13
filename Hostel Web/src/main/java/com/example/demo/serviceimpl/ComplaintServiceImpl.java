package com.example.demo.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.Student;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class ComplaintServiceImpl {
	
	@Autowired
	private ComplaintRepository complaintRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Complaint createComplaint(Long studentId, Complaint complaint) {
		
		Student student = studentRepository.findById(studentId)
			.orElseThrow(() -> new RuntimeException("Student not Found "));
		
		complaint.setStudent(student);
		
		return complaintRepository.save(complaint);
	}
	
	public List<Complaint> getComplaintsByStudent(Long studentId){
		return complaintRepository.findByStudent_Id(studentId);
		
	}
	
	public List<Complaint> getAllComplaints(){
		return complaintRepository.findAll();
		
	}
	
	public Complaint updateStatus(Long ComplaintId, String Status) {
		Complaint complaint = complaintRepository.findById(ComplaintId)
				.orElseThrow(() -> new RuntimeException("Complaint Not Found"));
		
		complaint.setStatus(Status);
		
		if ("RESOLVED".equalsIgnoreCase(Status)) {
            complaint.setResolvedAt(LocalDateTime.now());
        }
		
		return complaintRepository.save(complaint);
	}
}
