package org.webMonster.uniManageBoot.professor.cancelledLecture.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.professor.cancelledLecture.entity.CancelledLectureRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class CancelledLectureService {
    @Autowired
    private CancelledLectureRepository cancelledLectureRepository;
}
