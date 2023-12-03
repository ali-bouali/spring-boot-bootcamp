package com.alibou.demo.subject;

import java.util.List;

public interface SubjectService {

    Integer save(SubjectRequest s);
    SubjectResponse findById(Integer id);
    List<SubjectResponse> findAll();
    void deleteById(Integer id);

    void assignSubjectToStudent(Integer subjectId, Integer studentId);
}
