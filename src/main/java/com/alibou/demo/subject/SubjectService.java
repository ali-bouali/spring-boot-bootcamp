package com.alibou.demo.subject;

import com.alibou.demo.common.PageResponse;

import java.util.List;

public interface SubjectService {

    Integer save(SubjectRequest s);
    SubjectResponse findById(Integer id);
    PageResponse<SubjectResponse> findAll(int page, int size);
    void deleteById(Integer id);

    void assignSubjectToStudent(Integer subjectId, Integer studentId);
}
