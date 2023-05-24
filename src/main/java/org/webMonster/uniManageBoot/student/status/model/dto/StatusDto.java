package org.webMonster.uniManageBoot.student.status.model.dto;

import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StatusDto {

    private long statusId;
    private long memberId;
    private Date startDate;
    private Date endDate;
    private String reasonOfLeave;
    private Date returnDate;
    private Date applyLeaveDate;
    private Date applyReturnDate;
    private char allowedLeave;

}
