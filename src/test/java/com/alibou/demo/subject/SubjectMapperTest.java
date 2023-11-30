package com.alibou.demo.subject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectMapperTest {

    private final SubjectMapper mapper = new SubjectMapper();


    @BeforeEach
    void setUp() {
        System.out.println("hello");
    }

    @Test
    public void should_successfully_transform_subject_request_to_Subject() {
        SubjectRequest request = new SubjectRequest();
        request.setId(null);
        request.setName("Math");

        Subject subject = mapper.toSubject(request);

        assertNull(subject.getId());
        assertEquals( "Math", subject.getName());
        assertNull(subject.getStudents());
        assertNull(subject.getChapters());
    }

    @Test
    public void should_successfully_transform_null_subject_request_to_Subject() {
        Subject subject = mapper.toSubject(null);
        assertNotNull(subject);
    }

}
