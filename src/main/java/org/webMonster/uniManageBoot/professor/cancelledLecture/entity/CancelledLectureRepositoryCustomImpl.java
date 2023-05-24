package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;


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

import static org.webMonster.uniManageBoot.professor.cancelledLecture.entity.QCancelledLectureEntity.cancelledLectureEntity;


@Repository
public class CancelledLectureRepositoryCustomImpl extends QuerydslRepositorySupport implements CancelledLectureRepositoryCustom {
    private JPAQueryFactory queryFactory;
    public CancelledLectureRepositoryCustomImpl(JPAQueryFactory queryFactory){
        super(CancelledLectureEntity.class);
        this.queryFactory = queryFactory;
    }

    //본인이 신청한 휴강신청 리스트 출력(교수용)
//    public Page<CancelledLectureEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition, HttpSession session) {
//        JPAQuery<CancelledLectureEntity> query = queryFactory.selectFrom(cancelledLectureEntity)
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
//                .where(cancelledLectureEntity.memberId.eq(session.));
//
//        long total = query.fetchCount();
//
//        List<CancelledLectureEntity> results = query
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .orderBy(cancelledLectureEntity.lectureId.desc())
//                .fetch();
//        return new PageImpl<>(results, pageable, total);
//    }

    //본인이 작성한 휴강신청 리스트 조회(교수용)
    public Page<CancelledLectureEntity> findAllBySearchConditionByMemberId(Pageable pageable, SearchCondition searchCondition, long memberId) {
        QCancelledLectureEntity cancelledLectureEntity = QCancelledLectureEntity.cancelledLectureEntity;
        JPAQuery<CancelledLectureEntity> query = queryFactory
                .selectFrom(cancelledLectureEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(cancelledLectureEntity.memberId.eq(memberId));
                long total = query.fetchCount();
                List<CancelledLectureEntity> results = query
                        .offset(pageable.getOffset())
                        .limit(pageable.getPageSize())
                        .orderBy(cancelledLectureEntity.lectureId.desc())
                        .fetch();
        return new PageImpl<>(results, pageable, total);
    }

//    @Repository
//    public class CancelledLectureRepositoryCustomImpl implements CancelledLectureRepositoryCustom {
//        private final EntityManager entityManager;
//
//        public CancelledLectureRepositoryCustomImpl(EntityManager entityManager) {
//            this.entityManager = entityManager;
//        }
//
//        @Override
//        public List<CancelledLectureDto> findCancelledLecturesByWriterId(Pageable pageable, SearchCondition searchCondition, String memberId) {
//            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//            CriteriaQuery<CancelledLectureDto> query = criteriaBuilder.createQuery(CancelledLectureDto.class);
//            Root<CancelledLecture> root = query.from(CancelledLecture.class);
//
//            query.select(criteriaBuilder.construct(
//                    CancelledLectureDto.class,
//                    root.get("lectureId"),
//                    root.get("lectureTitle"),
//                    root.get("writerId")
//            ));
//
//            List<Predicate> predicates = new ArrayList<>();
//            if (searchCondition != null) {
//                if (searchCondition.getStartDate() != null) {
//                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("lectureDate"), searchCondition.getStartDate()));
//                }
//                if (searchCondition.getEndDate() != null) {
//                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("lectureDate"), searchCondition.getEndDate()));
//                }
//                // Add more search conditions as needed
//            }
//
//            predicates.add(criteriaBuilder.equal(root.get("writerId"), memberId));
//
//            if (!predicates.isEmpty()) {
//                query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
//            }
//
//            TypedQuery<CancelledLectureDto> typedQuery = entityManager.createQuery(query);
//            typedQuery.setFirstResult((int) pageable.getOffset());
//            typedQuery.setMaxResults(pageable.getPageSize());
//
//            return typedQuery.getResultList();
//        }
//    }









    @Override
    public Page<CancelledLectureEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        return null;
    }

    //휴강 리스트 검색용(교직원용)
    @Override
    public BooleanExpression searchKeywords(String sk, String sv) {
        if("name".equals(sk)) {                      //교수명으로 검색
            if (StringUtils.hasLength(sv)) {
                QMemberEntity memberEntity = QMemberEntity.memberEntity;
                return cancelledLectureEntity.memberId.in(
                        JPAExpressions.selectFrom(memberEntity)
                                .where(memberEntity.name.contains(sv))
                                .select(memberEntity.memberId)
                );
            }
        }
        return null;
    }
}