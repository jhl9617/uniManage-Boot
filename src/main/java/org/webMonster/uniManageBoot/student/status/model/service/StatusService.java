package org.webMonster.uniManageBoot.student.status.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.student.status.entity.StatusEntity;
import org.webMonster.uniManageBoot.student.status.entity.StatusRepository;
import org.webMonster.uniManageBoot.student.status.model.dto.StatusDto;

@Slf4j
@RequiredArgsConstructor
@Service
public class StatusService {

    private final StatusRepository statusRepository;


    //학생 휴학신청 추가
    public StatusEntity createTakeOff(StatusDto statusDto) {
        StatusEntity entity = StatusEntity.builder()
                .statusId(statusDto.getStatusId())
                .memberId(statusDto.getMemberId())
                .startDate(statusDto.getStartDate())
                .endDate(statusDto.getEndDate())
                .reasonOfLeave(statusDto.getReasonOfLeave())
                .build();
        return statusRepository.save(entity);
    }

    //학생 휴학/복학신청 후 확인페이지로 넘어감
    public StatusDto getStatusAppliedView(Long id) {
        StatusEntity entity = statusRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return StatusDto.builder()
                .statusId(entity.getStatusId())
                .memberId(entity.getMemberId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .returnDate(entity.getReturnDate())
                .reasonOfLeave(entity.getReasonOfLeave())
                .build();
    }

    //학생 복학신청 추가
    public StatusEntity createReturn(StatusDto statusDto) {
        StatusEntity entity = StatusEntity.builder()
                .statusId(statusDto.getStatusId())
                .memberId(statusDto.getMemberId())
                .returnDate(statusDto.getReturnDate())
                .build();
        return statusRepository.save(entity);
    }
}
