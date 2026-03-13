package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Beds;
import com.example.demo.entity.Student;
import com.example.demo.repository.BedsRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private BedsRepository bedsRepository;

	public StudentServiceImpl(StudentRepository studentRepository, BedsRepository bedRepository) {
		this.studentRepository = studentRepository;
		this.bedsRepository = bedsRepository;
	}

	@Override
	public Student createStudent(Student student, Long bedId) {

		Beds beds = bedsRepository.findById(bedId).orElseThrow(() -> new RuntimeException("Bed not found"));

		if (beds.isOccupied()) {
			throw new RuntimeException("Bed already occupied!");
		}

		// allocate bed
		student.setBeds(beds);
		beds.setOccupied(true);
		bedsRepository.save(beds);

		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByStatus(String status) {
        return studentRepository.findByStatus(status);
    }

    @Override
    public Student updateStudent(Long id, Student studentData) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(studentData.getName());
        student.setPhone(studentData.getPhone());
        student.setEmail(studentData.getEmail());
        student.setAddress(studentData.getAddress());
        student.setJoinDate(studentData.getJoinDate());
        student.setStatus(studentData.getStatus());
        student.setBeds(studentData.getBeds());
        student.setFloor(studentData.getFloor());
        
        student.setHostelName(studentData.getHostelName());
        student.setParentContact(studentData.getParentContact());
        
        

        return studentRepository.save(student);
    }

    @Override
    public Student changeBed(Long studentId, Long newBedId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Beds newBed = bedsRepository.findById(newBedId)
                .orElseThrow(() -> new RuntimeException("Bed not found"));

        if (newBed.isOccupied()) {
            throw new RuntimeException("New bed already occupied!");
        }

        // free old bed
        Beds oldBed = student.getBeds();
        if (oldBed != null) {
            oldBed.setOccupied(false);
            bedsRepository.save(oldBed);
        }

        // assign new bed
        newBed.setOccupied(true);
        bedsRepository.save(newBed);

        student.setBeds(newBed);

        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // free the bed
        Beds bed = student.getBeds();
        if (bed != null) {
            bed.setOccupied(false);
            bedsRepository.save(bed);
        }

        studentRepository.delete(student);
    }

	@Override
	public Student saveStudent(Student student, Long bedId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
