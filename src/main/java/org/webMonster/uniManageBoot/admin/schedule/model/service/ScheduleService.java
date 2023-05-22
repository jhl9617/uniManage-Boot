package org.webMonster.uniManageBoot.admin.schedule.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.admin.schedule.entity.ScheduleEntity;
import org.webMonster.uniManageBoot.admin.schedule.entity.ScheduleRepository;
import org.webMonster.uniManageBoot.admin.schedule.entity.ScheduleRepositoryCustom;
import org.webMonster.uniManageBoot.admin.schedule.model.dto.ScheduleDto;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ScheduleRepositoryCustom scheduleRepositoryCustom;

    //교직원 강의실관리 리스트 조회
    public Header<List<ScheduleDto>> getScheduleList(Pageable pageable, SearchCondition searchCondition) {
        List<ScheduleDto> dtos = new ArrayList<>();

        Page<ScheduleEntity> ScheduleEntities = scheduleRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (ScheduleEntity entity : ScheduleEntities) {
            ScheduleDto dto = ScheduleDto.builder()
                    .scheId(entity.getScheId())
                    .scheTitle(entity.getScheTitle())
                    .scheContent(entity.getScheContent())
                    .startDate(entity.getStartDate().format(DateTimeFormatter.ofPattern("yyyy년MM월dd일")))
                    .endDate(entity.getEndDate().format(DateTimeFormatter.ofPattern("yyyy년MM월dd일")))
                    .build();
            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) ScheduleEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(dtos, pagination);
    }

}
