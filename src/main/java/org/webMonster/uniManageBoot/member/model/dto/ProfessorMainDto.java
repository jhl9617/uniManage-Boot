package org.webMonster.uniManageBoot.member.model.dto;

import lombok.*;
import org.webMonster.uniManageBoot.admin.notice.model.dto.NoticeDto;
import org.webMonster.uniManageBoot.admin.schedule.model.dto.ScheduleDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class ProfessorMainDto {
    private List<NoticeDto> noticeDto;
    private List<ScheduleDto> scheduleDto;
}
