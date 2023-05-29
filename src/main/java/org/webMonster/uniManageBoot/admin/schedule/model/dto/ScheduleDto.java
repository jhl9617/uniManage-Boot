package org.webMonster.uniManageBoot.admin.schedule.model.dto;

import lombok.*;
import org.webMonster.uniManageBoot.admin.schedule.entity.ScheduleEntity;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class ScheduleDto {

    private long scheId;
    private String scheTitle;
    private String scheContent;
    private String startDate;
    private String endDate;

    public static ScheduleDto fromEntity(ScheduleEntity scheduleEntity) {
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setScheId(scheduleEntity.getScheId());
        scheduleDto.setScheTitle(scheduleEntity.getScheTitle());

        // java.sql.Date를 문자열로 변환하여 setStartDate에 전달
        if (scheduleEntity.getStartDate() != null) {
            String startDateString = scheduleEntity.getStartDate().toString();
            scheduleDto.setStartDate(startDateString);
        }

        // java.sql.Date를 문자열로 변환하여 setEndDate에 전달
        if (scheduleEntity.getEndDate() != null) {
            String endDateString = scheduleEntity.getEndDate().toString();
            scheduleDto.setEndDate(endDateString);
        }

        return scheduleDto;
    }


}
