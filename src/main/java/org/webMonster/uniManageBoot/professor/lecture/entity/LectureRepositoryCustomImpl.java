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
import org.webMonster.uniManageBoot.member.entity.QMemberEntity;

import java.util.List;

import static org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity.lectureEntity;

@Repository
public class LectureRepositoryCustomImpl extends QuerydslRepositorySupport implements LectureRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public LectureRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(LectureEntity.class);
        this.queryFactory = queryFactory;
    }


    public Page<LectureEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<LectureEntity> query = queryFactory.selectFrom(lectureEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<LectureEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(lectureEntity.lectureId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    public BooleanExpression searchKeywords(String sk, String sv) {
        if("lecture_title".equals(sk)) {   //강의명으로 검색
            if(StringUtils.hasLength(sv)) {
                return lectureEntity.lectureTitle.contains(sv);
            }
        } else if ("semester".equals(sk)) {   //학기로 검색
            if(StringUtils.hasLength(sv)) {
                return lectureEntity.semester.stringValue().contains(sv);
            }
        }  else if ("name".equals(sk)) {   //교수명으로 검색
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
}
