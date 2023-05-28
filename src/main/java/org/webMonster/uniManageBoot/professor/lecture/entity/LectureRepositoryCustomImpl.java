package org.webMonster.uniManageBoot.professor.lecture.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.common.SearchRoom;
import org.webMonster.uniManageBoot.member.entity.QMemberEntity;
import org.webMonster.uniManageBoot.professor.lecture.model.dto.SearchValues;

import java.util.List;

import static org.webMonster.uniManageBoot.member.entity.QMemberEntity.memberEntity;
import static org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity.lectureEntity;
import static org.webMonster.uniManageBoot.professor.lectureClass.entity.QLectureClassEntity.lectureClassEntity;
import static org.webMonster.uniManageBoot.professor.lectureClass.entity.QLectureClassEntity.lectureClassEntity;
import static org.webMonster.uniManageBoot.professor.lectureClassTime.entity.QLectureClassTimeEntity.lectureClassTimeEntity;
import static org.webMonster.uniManageBoot.student.courseRegi.entity.QCourseRegiEntity.courseRegiEntity;

@Repository
public class LectureRepositoryCustomImpl extends QuerydslRepositorySupport implements LectureRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public LectureRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(LectureEntity.class);
        this.queryFactory = queryFactory;
    }

//    public Page<LectureEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
//        JPAQuery<LectureEntity> query = queryFactory.selectFrom(lectureEntity)
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));
//
//        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업
//
//        List<LectureEntity> results = query
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .orderBy(lectureEntity.lectureId.desc())
//                .fetch();
//
//        return new PageImpl<>(results, pageable, total);
//    }

    //교직원 개설강의관리 리스트 출력
    public Page<LectureEntity> findAllBySearchConditionAndStatus(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<LectureEntity> query = queryFactory.selectFrom(lectureEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(lectureEntity.lectureApplyStatus.eq('2'));

        long total = query.fetchCount();

        List<LectureEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(lectureEntity.lectureId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    //교직원 강의개설요청관리 리스트 출력
    public Page<LectureEntity> findAllBySearchConditionsAndStatus(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<LectureEntity> query = queryFactory.selectFrom(lectureEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(lectureEntity.lectureApplyStatus.eq('1'));

        long total = query.fetchCount();

        List<LectureEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(lectureEntity.lectureId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    //교직원 개설강의관리 리스트에서 검색용
    public BooleanExpression searchKeywords(String sk, String sv) {
        if ("lecture_title".equals(sk)) {   //강의명으로 검색
            if (StringUtils.hasLength(sv)) {
                return lectureEntity.lectureTitle.contains(sv);
            }
        } else if ("semester".equals(sk)) {   //학기로 검색
            if (StringUtils.hasLength(sv)) {
                return lectureEntity.semester.stringValue().contains(sv);
            }
        } else if ("name".equals(sk)) {   //교수명으로 검색
            if (StringUtils.hasLength(sv)) {
                // 다른 테이블의 name 컬럼을 조인하여 검색
                QMemberEntity memberEntity = QMemberEntity.memberEntity;
                return lectureEntity.memberId.in(
                        JPAExpressions.select(memberEntity)
                                .from(memberEntity)
                                .where(memberEntity.name.contains(sv))
                                .select(memberEntity.memberId)
                );
            }
        }

        return null;
    }


    //학생 학생정보시스템 수강신청 가능한 강의 목록 출력
    public Page<LectureEntity> findAllBySearchRoomAndStatus(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<LectureEntity> query = queryFactory.selectFrom(lectureEntity)
                .where(searchKeyword(Long.valueOf(searchCondition.getSk()), searchCondition.getSv()));

        long total = query.fetchCount();

        List<LectureEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(lectureEntity.lectureId.asc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    //학생 학생정보시스템 수강신청시 강의 검색용
    public BooleanExpression searchKeyword(Long sk, String sv) {
        BooleanExpression expression = null;

        if (sk != null) {
            expression = lectureEntity.department.departmentId.eq(sk);
        }

        if (sv != null) {
            BooleanExpression ASExpression = lectureEntity.classification.eq(sv.charAt(0));
            expression = (expression != null) ? expression.and(ASExpression) : ASExpression;
        }

        if (expression != null) {
            return lectureEntity.lectureId.in(
                    JPAExpressions.select(lectureEntity.lectureId)
                            .from(lectureEntity)
                            .where(expression)
            );
        }

        return null;
    }


    //교수 강의개설요청관리 리스트 출력
    public Page<LectureEntity> findBySearchConditionAndStatus(Pageable pageable, SearchCondition searchCondition, Long memberId) {
        JPAQuery<LectureEntity> query = queryFactory.selectFrom(lectureEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(lectureEntity.memberId.eq(memberId));

        long total = query.fetchCount();

        List<LectureEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(lectureEntity.lectureId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    //교수 승인강의 리스트 출력
    public Page<LectureEntity> findBySearchConditionsAndStatus(Pageable pageable, SearchCondition searchCondition, Long memberId) {
        JPAQuery<LectureEntity> query = queryFactory.selectFrom(lectureEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(lectureEntity.memberId.eq(memberId))
                .where(lectureEntity.lectureApplyStatus.eq('2'));

        long total = query.fetchCount();

        List<LectureEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(lectureEntity.lectureId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    @Override
    public Page<LectureEntity> findBySearchValues(Pageable pageable, SearchValues searchValues) {
        JPAQuery<LectureEntity> query = queryFactory.selectFrom(lectureEntity)
                .where(searchValues(searchValues.getSv1(), searchValues.getSv2(), searchValues.getSv3(), searchValues.getSv4()));


        long total = query.fetchCount();

        List<LectureEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(lectureEntity.lectureId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    @Override
    public BooleanExpression searchValues(String sv1, String sv2, String sv3, Long sv4) {
        BooleanExpression expression = null;

        if (sv3 != null) {
            expression = lectureEntity.classification.eq(sv3.charAt(0));
        }

        if (sv4 != null) {
            BooleanExpression departmentExpression = lectureEntity.departmentId.eq(sv4);
            expression = expression.and(departmentExpression);
        }

        if (sv1 != null && sv2 != null) {
            String sv = sv1 + sv2;
            BooleanExpression semesterExpression = lectureEntity.semester.eq(Long.parseLong(sv));
            expression = expression.and(semesterExpression);
        }
        return expression;
    }

}
