package org.webMonster.uniManageBoot.admin.notice.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNoticeEntity is a Querydsl query type for NoticeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNoticeEntity extends EntityPathBase<NoticeEntity> {

    private static final long serialVersionUID = -1329823852L;

    public static final QNoticeEntity noticeEntity = new QNoticeEntity("noticeEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath noticeContent = createString("noticeContent");

    public final NumberPath<Long> noticeId = createNumber("noticeId", Long.class);

    public final StringPath noticeTitle = createString("noticeTitle");

    public final NumberPath<Integer> readcount = createNumber("readcount", Integer.class);

    public QNoticeEntity(String variable) {
        super(NoticeEntity.class, forVariable(variable));
    }

    public QNoticeEntity(Path<? extends NoticeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNoticeEntity(PathMetadata metadata) {
        super(NoticeEntity.class, metadata);
    }

}

