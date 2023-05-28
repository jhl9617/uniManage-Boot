package org.webMonster.uniManageBoot.student.courseRegi.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.webMonster.uniManageBoot.student.courseRegi.model.dto.SearchTerm;
import org.webMonster.uniManageBoot.student.courseRegi.entity.CourseRegiEntity;
import org.webMonster.uniManageBoot.student.courseRegi.entity.CourseRegiRepository;

import org.webMonster.uniManageBoot.student.courseRegi.entity.CourseRegiRepositoryCustom;
import org.webMonster.uniManageBoot.student.courseRegi.model.dto.CourseRegiDto;




import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CourseRegiService {

    @Autowired
    private CourseRegiRepository courseRegiRepository;



    @Autowired
    private CourseRegiRepositoryCustom courseRegiRepositoryCustom;



    public List<CourseRegiDto> courseRegiList(Long id) {
        List<CourseRegiDto> list = new ArrayList<>();
        List<CourseRegiEntity> entity = courseRegiRepository.findByMemberId(id);
        for (CourseRegiEntity coentity : entity) {
            CourseRegiDto dto = CourseRegiDto.builder()
                    .courseRegiTerm(coentity.getCourseRegiTerm())
                    .name(coentity.getLecture().getMember().getName())
                    .lectureId(coentity.getLectureId())
                    .lectureTitle(coentity.getLecture().getLectureTitle())
                    .courseRegiId(coentity.getCourseRegiId())
                    .timecode1(coentity.getLecture().getTimecode1())
                    .timecode2(coentity.getLecture().getTimecode2())
                    .timecode3(coentity.getLecture().getTimecode3())
                    .roomcode1(coentity.getLecture().getRoomcode1())
                    .roomcode2(coentity.getLecture().getRoomcode2())
                    .roomcode3(coentity.getLecture().getRoomcode3())
                    .credit(coentity.getLecture().getCredit())
                    .build();
            list.add(dto);
        }
        return list;

    }

    public List<CourseRegiDto> getCourseRegiTimetable(SearchTerm searchTerm) {
        List<CourseRegiDto> list = new ArrayList<>();
        List<CourseRegiEntity> entity = courseRegiRepositoryCustom.findAllBySearchTerm(searchTerm);
        for (CourseRegiEntity coentity : entity) {
            CourseRegiDto dto = CourseRegiDto.builder()
                    .courseRegiTerm(coentity.getCourseRegiTerm())
                    .name(coentity.getLecture().getMember().getName())
                    .lectureId(coentity.getLectureId())
                    .lectureTitle(coentity.getLecture().getLectureTitle())
                    .courseRegiId(coentity.getCourseRegiId())
                    .timecode1(coentity.getLecture().getTimecode1())
                    .timecode2(coentity.getLecture().getTimecode2())
                    .timecode3(coentity.getLecture().getTimecode3())
                    .roomcode1(coentity.getLecture().getRoomcode1())
                    .roomcode2(coentity.getLecture().getRoomcode2())
                    .roomcode3(coentity.getLecture().getRoomcode3())
                    .credit(coentity.getLecture().getCredit())
                    .build();
            list.add(dto);
        }
        return list;

    }

    //학생 수강신청용 insert
    public CourseRegiEntity create(CourseRegiDto courseRegiDto) {
        log.info(String.valueOf(courseRegiDto.getLectureId()));
        log.info(String.valueOf(courseRegiDto.getMemberId()));

        CourseRegiEntity entity = CourseRegiEntity.builder()
                .courseRegiId(courseRegiDto.getCourseRegiId())
                .courseRegiTerm(courseRegiDto.getCourseRegiTerm())
                .memberId(courseRegiDto.getMemberId())
                .lectureId(courseRegiDto.getLectureId())
                .build();
        return courseRegiRepository.save(entity);
    }
}


