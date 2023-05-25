package org.webMonster.uniManageBoot.student.department.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.student.department.entity.DepartmentEntity;
import org.webMonster.uniManageBoot.student.department.entity.DepartmentRepository;
import org.webMonster.uniManageBoot.student.department.model.dto.DepartmentDto;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDto> departmentList(Long id) {
        List<DepartmentDto> list = new ArrayList<>();
        List<DepartmentEntity> entity = departmentRepository.findByDepartmentId(id);
        for(DepartmentEntity dentity : entity) {
            DepartmentDto dto = DepartmentDto.builder()
                    .departmentId(dentity.getDepartmentId())
                    .departmentName(dentity.getDepartmentName())
                    .category(dentity.getCategory())
                    .build();
            list.add(dto);
        }
        return list;
    }
}
