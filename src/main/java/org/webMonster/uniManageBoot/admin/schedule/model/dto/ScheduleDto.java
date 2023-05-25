package org.webMonster.uniManageBoot.admin.schedule.model.dto;

import lombok.*;


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

}
