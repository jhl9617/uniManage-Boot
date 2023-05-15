package org.webMonster.uniManageBoot.student.freeboard.model.dto;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FreeboardWithRepDto {
    private FreeboardDto freeboard;
    private List<FreeboardRepDto> freeboardReps;
}
