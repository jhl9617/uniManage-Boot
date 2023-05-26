package org.webMonster.uniManageBoot.student.courseRegi.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import org.springframework.stereotype.Repository;
import org.webMonster.uniManageBoot.student.courseRegi.model.dto.SearchTerm;

import java.util.List;

import static org.webMonster.uniManageBoot.student.courseRegi.entity.QCourseRegiEntity.courseRegiEntity;
@Repository
public class CourseRegiRepositoryCustomImpl extends QuerydslRepositorySupport implements CourseRegiRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public CourseRegiRepositoryCustomImpl(JPAQueryFactory queryFactory){
        super(CourseRegiEntity.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<CourseRegiEntity> findAllBySearchTerm(SearchTerm searchTerm) {

        JPAQuery<CourseRegiEntity> query = queryFactory.selectFrom(courseRegiEntity)
                .where(searchKeywords(searchTerm.getSv1(), searchTerm.getSv2(), searchTerm.getSv3()));

        return query
                .orderBy(courseRegiEntity.courseRegiId.asc())
                .fetch();
    }

    @Override
    public BooleanExpression searchKeywords(Long sv1, String sv2, String sv3) {
        BooleanExpression expression = null;

        if (sv1 != null) {
            expression = courseRegiEntity.memberId.eq(sv1);
        }

        if (sv2 != null && sv3 != null) {
            String sv = sv2 + sv3;
            BooleanExpression courseRegiTermExpression = courseRegiEntity.courseRegiTerm.eq(Long.parseLong(sv));

            if (expression != null) {
                expression = expression.and(courseRegiTermExpression);
            } else {
                expression = courseRegiTermExpression;
            }
        }

        return expression;
    }
}
