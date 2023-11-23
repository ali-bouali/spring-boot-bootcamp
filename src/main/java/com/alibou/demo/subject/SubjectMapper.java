package com.alibou.demo.subject;

import com.alibou.demo.subject.Subject;
import com.alibou.demo.subject.SubjectRequest;
import com.alibou.demo.subject.SubjectResponse;
import org.springframework.stereotype.Service;

@Service
public class SubjectMapper {
    public Subject toSubject(SubjectRequest s) {
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
