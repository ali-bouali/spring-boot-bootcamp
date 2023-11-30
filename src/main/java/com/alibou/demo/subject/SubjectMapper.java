package com.alibou.demo.subject;

import org.springframework.stereotype.Service;

@Service
public class SubjectMapper {
    public Subject toSubject(SubjectRequest s) {
        if (s == null) {
            return Subject.builder().build();
        }
        return Subject.builder()
                .id(s.getId())
                .name(s.getName())
                .build();
    }

    public SubjectResponse toSubjectResponse(Subject subject) {
        return SubjectResponse.builder()
                .name(subject.getName())
                .build();
    }
}
