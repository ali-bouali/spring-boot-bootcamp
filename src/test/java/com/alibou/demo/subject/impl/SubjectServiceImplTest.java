package com.alibou.demo.subject.impl;

import com.alibou.demo.exception.StudentAssignmentException;
import com.alibou.demo.student.Student;
import com.alibou.demo.student.StudentRepository;
import com.alibou.demo.subject.Subject;
import com.alibou.demo.subject.SubjectMapper;
import com.alibou.demo.subject.SubjectRepository;
import com.alibou.demo.subject.SubjectRequest;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SubjectServiceImplTest {

    @Mock
    private SubjectRepository subjectRepository;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private SubjectMapper mapper;

    @InjectMocks
    private SubjectServiceImpl subjectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_save_subject_successfully() {
        SubjectRequest request = new SubjectRequest();
        request.setId(null);
        request.setName("Math");

        Subject subject = Subject.builder()
                .id(null)
                .name("Math")
                .build();

        when(mapper.toSubject(request)).thenReturn(subject);

        subjectService.save(request);

        verify(subjectRepository, times(1)).save(subject);
    }

    @Test
    public void should_assign_subject_to_student() {

        // GIVEN
        Integer subjectId = 1;
        Integer studentId = 2;

        Subject subject = new Subject();
        subject.setId(subjectId);
        subject.setStudents(new ArrayList<>());

        Student student = new Student();
        student.setId(studentId);
        student.setSubjects(new ArrayList<>());


        when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(student));

        when(subjectRepository.findById(subjectId))
                .thenReturn(Optional.of(subject));
        // WHEN
        subjectService.assignSubjectToStudent(subjectId, studentId);

        // THEN
        assertTrue(student.getSubjects().contains(subject));
        assertTrue(subject.getStudents().contains(student));

        verify(subjectRepository, times(1)).save(subject);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void should_throw_EntityNotFoundException_if_student_not_found() {

        when(studentRepository.findById(Mockito.anyInt()))
                .thenThrow(new EntityNotFoundException("No student found with ID::"));

        var exp = assertThrows(EntityNotFoundException.class, () -> subjectService.assignSubjectToStudent(1, 1));
        assertTrue(exp.getMessage().startsWith("No student found with ID::"));
    }


    @Test
    public void should_throw_StudentAssignmentException_when_student_is_assigned_to_3_subjects() {

        // GIVEN
        Integer subjectId = 1;
        Integer studentId = 2;

        Subject subject = new Subject();
        subject.setId(subjectId);
        subject.setStudents(new ArrayList<>());

        Student student = new Student();
        student.setId(studentId);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(Subject.builder().id(10).build());
        subjects.add(Subject.builder().id(20).build());
        subjects.add(Subject.builder().id(30).build());

        student.setSubjects(subjects);

        when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(student));

        // THEN
        var exp = assertThrows(StudentAssignmentException.class, () -> subjectService.assignSubjectToStudent(subjectId, studentId));
        assertEquals(exp.getMessage(), "Student cannot be assigned to more than 3 subjects");
    }
}
