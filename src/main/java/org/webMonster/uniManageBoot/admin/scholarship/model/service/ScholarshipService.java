package org.webMonster.uniManageBoot.admin.scholarship.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.admin.scholarship.entity.ScholarshipEntity;
import org.webMonster.uniManageBoot.admin.scholarship.entity.ScholarshipRepository;
import org.webMonster.uniManageBoot.admin.scholarship.entity.ScholarshipRepositoryCustom;
import org.webMonster.uniManageBoot.admin.scholarship.model.dto.ScholarshipDto;
import org.webMonster.uniManageBoot.admin.scholarship.model.dto.ScholarshipMemberDto;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ScholarshipService {
    private final ScholarshipRepository scholarshipRepository;
    private final ScholarshipRepositoryCustom scholarshipRepositoryCustom;

    //교직원 장학금관리 리스트 조회
    public Header<List<ScholarshipDto>> getScholarshipList(Pageable pageable, SearchCondition searchCondition) {
        List<ScholarshipDto> dtos = new ArrayList<>();

        Page<ScholarshipEntity> scholarshipEntities = scholarshipRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (ScholarshipEntity entity : scholarshipEntities) {
            ScholarshipDto dto = ScholarshipDto.builder()
                    .schoId(entity.getSchoId())
                    .schoTerm(entity.getSchoTerm())
                    .schoName(entity.getSchoName())
                    .amount(entity.getAmount())
                    .memberId(entity.getMemberId())
                    .build();
            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) scholarshipEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(dtos, pagination);
    }
   
    //교직원 장학금관리 글 상세보기 조회
//    public ScholarshipMemberDto getScholarship(Long id) {
//        ScholarshipEntity entity = scholarshipRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 글을 찾을 수 없습니다."));
//        return ScholarshipMemberDto.builder()
//                .schoId(entity.getSchoId())
//                .schoTerm(entity.getSchoTerm())
//                .schoName(entity.getSchoName())
//                .amount(entity.getAmount())
//                .name(entity.getMember().getName())
//                .build();
//    }

    //교직원 장학금관리 추가
    public ScholarshipEntity create(ScholarshipDto scholarshipDto) {
        ScholarshipEntity entity = ScholarshipEntity.builder()
                .schoTerm(scholarshipDto.getSchoTerm())
                .schoName(scholarshipDto.getSchoName())
                .amount(scholarshipDto.getAmount())
                .memberId(scholarshipDto.getMemberId())
                .build();
        return scholarshipRepository.save(entity);
    }
    
    //교직원 장학금관리 수정
    public ScholarshipEntity update(ScholarshipDto scholarshipDto) {
        ScholarshipEntity entity = scholarshipRepository.findById(scholarshipDto.getSchoId()).orElseThrow(() -> new RuntimeException("해당 글을 찾을 수 없습니다."));
        entity.setSchoTerm(scholarshipDto.getSchoTerm());
        entity.setSchoName(scholarshipDto.getSchoName());
        return scholarshipRepository.save(entity);
    }
    
    //교직원 장학금관리 삭제
    public void delete(Long id) {
        ScholarshipEntity entity = scholarshipRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 글을 찾을 수 없습니다."));
        scholarshipRepository.delete(entity);
    }
}
