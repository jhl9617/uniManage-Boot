package org.webMonster.uniManageBoot.admin.schedule.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.admin.notice.entity.NoticeEntity;
import org.webMonster.uniManageBoot.admin.notice.model.dto.NoticeDto;
import org.webMonster.uniManageBoot.admin.schedule.entity.ScheduleEntity;
import org.webMonster.uniManageBoot.admin.schedule.entity.ScheduleRepository;
import org.webMonster.uniManageBoot.admin.schedule.entity.ScheduleRepositoryCustom;
import org.webMonster.uniManageBoot.admin.schedule.model.dto.ScheduleDto;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ScheduleRepositoryCustom scheduleRepositoryCustom;

    //교직원 학사일정 리스트 조회
    public Header<List<ScheduleDto>> getScheduleList(Pageable pageable, SearchCondition searchCondition) {
        List<ScheduleDto> dtos = new ArrayList<>();

        Page<ScheduleEntity> ScheduleEntities = scheduleRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (ScheduleEntity entity : ScheduleEntities) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREAN);
            String formattedStartDate = entity.getStartDate().toLocalDate().format(formatter);
            String formattedEndDate = entity.getEndDate().toLocalDate().format(formatter);

            ScheduleDto dto = ScheduleDto.builder()
                    .scheId(entity.getScheId())
                    .scheTitle(entity.getScheTitle())
                    .scheContent(entity.getScheContent())
                    .startDate(formattedStartDate)
                    .endDate(formattedEndDate)
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

    // 교직원 학사일정 추가
    public ScheduleEntity create(ScheduleDto scheduleDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREAN);
        LocalDate parsedStartDate = LocalDate.parse(scheduleDto.getStartDate(), formatter);
        LocalDate parsedEndDate = LocalDate.parse(scheduleDto.getEndDate(), formatter);

        ScheduleEntity entity = ScheduleEntity.builder()
                .scheId(scheduleDto.getScheId())
                .scheTitle(scheduleDto.getScheTitle())
                .scheContent(scheduleDto.getScheContent())
                .startDate(Date.valueOf(parsedStartDate))
                .endDate(Date.valueOf(parsedEndDate))
                .build();
        return scheduleRepository.save(entity);
    }


    //학생정보시스템 메인페이지 학사일정 리스트 4개 조회용
    public List<ScheduleDto> getScheduleList(){
        List<ScheduleDto> list = new ArrayList<>();
        List<ScheduleEntity> entities = scheduleRepository.findAll();
        for (ScheduleEntity entity : entities) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREAN);
            String formattedStartDate = entity.getStartDate().toLocalDate().format(formatter);
            String formattedEndDate = entity.getEndDate().toLocalDate().format(formatter);

            ScheduleDto dto = ScheduleDto.builder()
                    .scheId(entity.getScheId())
                    .scheTitle(entity.getScheTitle())
                    .scheContent(entity.getScheContent())
                    .startDate(formattedStartDate)
                    .endDate(formattedEndDate)
                    .build();
            list.add(dto);
        }
        return list;
    }

}
