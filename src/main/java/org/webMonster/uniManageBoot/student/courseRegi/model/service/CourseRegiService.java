package org.webMonster.uniManageBoot.student.courseRegi.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.student.courseRegi.entity.CourseRegiEntity;
import org.webMonster.uniManageBoot.student.courseRegi.entity.CourseRegiRepository;
import org.webMonster.uniManageBoot.student.courseRegi.model.dto.CourseRegiDto;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardEntity;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardRepEntity;
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardDto;
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardRepDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CourseRegiService {


    @Autowired
    private CourseRegiRepository courseRegiRepository;

    public List<CourseRegiDto> courseRegiList(Long id) {
        List<CourseRegiDto> list = new ArrayList<>();
        List<CourseRegiEntity> entity = courseRegiRepository.findByMemberId(id);
        for (CourseRegiEntity coentity : entity) {
            CourseRegiDto dto = CourseRegiDto.builder()
                    .courseRegiTerm(coentity.getCourseRegiTerm())
                    .lectureId(coentity.getLectureId())
                    .lectureTitle(coentity.getLecture().getLectureTitle())
                    .courseRegiId(coentity.getCourseRegiId())
                    .timecode1(coentity.getLecture().getTimecode1())
                    .timecode2(coentity.getLecture().getTimecode2())
                    .timecode3(coentity.getLecture().getTimecode3())
                    .build();
            list.add(dto);
        }
        return list;

    }


    public CourseRegiEntity create(CourseRegiDto courseRegiDto) {
        CourseRegiEntity entity = CourseRegiEntity.builder()
                .courseRegiId(courseRegiDto.getCourseRegiId())
                .memberId(courseRegiDto.getMemberId())
                .lectureId(courseRegiDto.getLectureId())
                .courseRegiTerm(courseRegiDto.getCourseRegiTerm())
                .build();
        return courseRegiRepository.save(entity);
    }


}

