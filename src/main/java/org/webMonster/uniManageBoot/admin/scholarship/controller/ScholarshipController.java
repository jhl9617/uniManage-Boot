package org.webMonster.uniManageBoot.admin.scholarship.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webMonster.uniManageBoot.admin.scholarship.model.dto.ScholarshipDto;
import org.webMonster.uniManageBoot.admin.scholarship.model.service.ScholarshipService;
import org.webMonster.uniManageBoot.common.Header;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class ScholarshipController {
    private final ScholarshipService scholarshipService;



}
