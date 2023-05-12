package org.webMonster.uniManageBoot.professor.lectureSchedule.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLectureScheduleEntity is a Querydsl query type for LectureScheduleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureScheduleEntity extends EntityPathBase<LectureScheduleEntity> {

    private static final long serialVersionUID = 564715402L;

    public static final QLectureScheduleEntity lectureScheduleEntity = new QLectureScheduleEntity("lectureScheduleEntity");

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath timecode = createString("timecode");

    public QLectureScheduleEntity(String variable) {
        super(LectureScheduleEntity.class, forVariable(variable));
    }

    public QLectureScheduleEntity(Path<? extends LectureScheduleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureScheduleEntity(PathMetadata metadata) {
        super(LectureScheduleEntity.class, metadata);
    }

}

