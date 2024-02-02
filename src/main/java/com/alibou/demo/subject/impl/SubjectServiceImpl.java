package com.alibou.demo.subject.impl;

import com.alibou.demo.common.PageResponse;
import com.alibou.demo.exception.StudentAssignmentException;
import com.alibou.demo.student.StudentRepository;
import com.alibou.demo.subject.Subject;
import com.alibou.demo.subject.SubjectMapper;
import com.alibou.demo.subject.SubjectRepository;
import com.alibou.demo.subject.SubjectRequest;
import com.alibou.demo.subject.SubjectResponse;
import com.alibou.demo.subject.SubjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private final SubjectMapper mapper;

    @Override
    public Integer save(SubjectRequest request) {
        Subject subject = mapper.toSubject(request);
        return this.subjectRepository.save(subject).getId();
    }

    @Override
    public void assignSubjectToStudent(Integer subjectId, Integer studentId) {
        // let's suppose:
        // a student can attend only 3 subjects
        var student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("No student found with ID:: " + studentId));

        if (student.getSubjects().size() >= 3) {
            throw new StudentAssignmentException("Student cannot be assigned to more than 3 subjects");
        }

        var alreadyAssigned = student.getSubjects()
                .stream()
                .map(Subject::getId)
                .anyMatch(id -> Objects.equals(id, subjectId));
        if (alreadyAssigned) {
            throw new StudentAssignmentException("Student is already assigned to this subject");
        }

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
    public PageResponse<SubjectResponse> findAll(int page, int size) {
        var pageResult = this.subjectRepository.findAll(PageRequest.of(page, size));
        return PageResponse.<SubjectResponse>builder()
                .content(
                        pageResult.getContent()
                                .stream()
                                .map(mapper::toSubjectResponse)
                                .toList()
                )
                .totalPages(pageResult.getTotalPages())
                .build();
    }

    @Override
    public void deleteById(Integer id) {
        this.subjectRepository.deleteById(id);
    }
}
