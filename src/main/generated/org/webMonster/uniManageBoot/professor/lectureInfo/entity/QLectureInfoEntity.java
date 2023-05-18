package org.webMonster.uniManageBoot.professor.lectureInfo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLectureInfoEntity is a Querydsl query type for LectureInfoEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureInfoEntity extends EntityPathBase<LectureInfoEntity> {

    private static final long serialVersionUID = 1604515114L;

    public static final QLectureInfoEntity lectureInfoEntity = new QLectureInfoEntity("lectureInfoEntity");

    public final NumberPath<Long> attendanceId = createNumber("attendanceId", Long.class);

    public final DatePath<java.sql.Date> lectureDate = createDate("lectureDate", java.sql.Date.class);

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final StringPath lectureRoomCode = createString("lectureRoomCode");

    public final NumberPath<Integer> maxCheckin = createNumber("maxCheckin", Integer.class);

    public final NumberPath<Integer> nowCheckin = createNumber("nowCheckin", Integer.class);

    public final StringPath timecode = createString("timecode");

    public QLectureInfoEntity(String variable) {
        super(LectureInfoEntity.class, forVariable(variable));
    }

    public QLectureInfoEntity(Path<? extends LectureInfoEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureInfoEntity(PathMetadata metadata) {
        super(LectureInfoEntity.class, metadata);
    }

}

