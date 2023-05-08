package org.webMonster.uniManageBoot.admin.notice.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.webMonster.uniManageBoot.common.SearchCondition;
import java.util.List;

import static org.webMonster.uniManageBoot.admin.notice.entity.QNoticeEntity.noticeEntity;

@RequiredArgsConstructor
@Repository
public class NoticeRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public Page<NoticeEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<NoticeEntity> query = queryFactory.selectFrom(noticeEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<NoticeEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(noticeEntity.notice_id.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv) {
        if("member_id".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                long memberId;
                try {
                    memberId = Long.parseLong(sv);
                } catch (NumberFormatException e) {
                    return null; // Invalid input, skip filtering
                }
            }
        } else if ("notice_title".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return noticeEntity.notice_title.contains(sv);
            }
        } else if ("notice_content".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return noticeEntity.notice_content.contains(sv);
            }
        }

        return null;
    }
}
