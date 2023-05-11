package org.webMonster.uniManageBoot.professor.lectureNotice.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLectureNoticeEntity is a Querydsl query type for LectureNoticeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureNoticeEntity extends EntityPathBase<LectureNoticeEntity> {

    private static final long serialVersionUID = 1474822058L;

    public static final QLectureNoticeEntity lectureNoticeEntity = new QLectureNoticeEntity("lectureNoticeEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final StringPath lectureNoticeContent = createString("lectureNoticeContent");

    public final NumberPath<Long> lectureNoticeId = createNumber("lectureNoticeId", Long.class);

    public final StringPath lectureNoticeTitle = createString("lectureNoticeTitle");

    public final NumberPath<Integer> readcount = createNumber("readcount", Integer.class);

    public QLectureNoticeEntity(String variable) {
        super(LectureNoticeEntity.class, forVariable(variable));
    }

    public QLectureNoticeEntity(Path<? extends LectureNoticeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureNoticeEntity(PathMetadata metadata) {
        super(LectureNoticeEntity.class, metadata);
    }

}

