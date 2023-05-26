package org.webMonster.uniManageBoot.student.department.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DepartmentDto {

    private long departmentId;
    private String departmentName;
    private String category;
}
