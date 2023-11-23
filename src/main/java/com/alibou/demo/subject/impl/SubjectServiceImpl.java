package com.alibou.demo.subject.impl;

import com.alibou.demo.student.StudentRepository;
import com.alibou.demo.subject.Subject;
import com.alibou.demo.subject.SubjectMapper;
import com.alibou.demo.subject.SubjectRepository;
import com.alibou.demo.subject.SubjectRequest;
import com.alibou.demo.subject.SubjectResponse;
import com.alibou.demo.subject.SubjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private final SubjectMapper mapper;

    @Override
    public void save(SubjectRequest s) {
        Subject student = mapper.toSubject(s);
        this.subjectRepository.save(student);
    }

    @Override
    public void assignSubjectToStudent(Integer subjectId, Integer studentId) {
        var student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("no student found with ID:: " + studentId));

        var subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new EntityNotFoundException("no subject found with ID:: " + studentId));

        student.getSubjects().add(subject);
        subject.getStudents().add(student);

        studentRepository.save(student);
        subjectRepository.save(subject);

    }

    @Override
    public SubjectResponse findById(Integer id) {
        return this.subjectRepository.findById(id)
                .map(mapper::toSubjectResponse)
                .orElse(new SubjectResponse());
    }

    @Override
    public List<SubjectResponse> findAll() {
        return this.subjectRepository.findAll()
                .stream()
                .map(mapper::toSubjectResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        this.subjectRepository.deleteById(id);
    }
}
