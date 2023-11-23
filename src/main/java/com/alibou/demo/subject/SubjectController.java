package com.alibou.demo.subject;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService service;


    @PostMapping
    public ResponseEntity<Void> save(
            @RequestBody @Valid SubjectRequest subjectRequest
    ) {
        service.save(subjectRequest);
        return ResponseEntity
                .accepted()
                .build();
    }

    @PatchMapping("/{subject-id}/student/{student-id}")
    public ResponseEntity<Void> assignSubjectToStudent(
            @PathVariable("subject-id") Integer subjectId,
            @PathVariable("student-id") Integer studentId
    ) {
        service.assignSubjectToStudent(subjectId, studentId);
        return ResponseEntity
                .accepted()
                .build();
    }

    @GetMapping("/{subject-id}")
    public ResponseEntity<SubjectResponse> findById(
            @PathVariable("subject-id") Integer studentId
    ) {
        return ResponseEntity.ok(service.findById(studentId));
    }

    @GetMapping
    public ResponseEntity<List<SubjectResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
