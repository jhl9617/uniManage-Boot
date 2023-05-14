package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLectureRoomTimetableEntity is a Querydsl query type for LectureRoomTimetableEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureRoomTimetableEntity extends EntityPathBase<LectureRoomTimetableEntity> {

    private static final long serialVersionUID = 435895508L;

    public static final QLectureRoomTimetableEntity lectureRoomTimetableEntity = new QLectureRoomTimetableEntity("lectureRoomTimetableEntity");

    public final StringPath lectureRoomCode = createString("lectureRoomCode");

    public final NumberPath<Long> lectureRoomTimetableIdx = createNumber("lectureRoomTimetableIdx", Long.class);

    public final StringPath timecode = createString("timecode");

    public QLectureRoomTimetableEntity(String variable) {
        super(LectureRoomTimetableEntity.class, forVariable(variable));
    }

    public QLectureRoomTimetableEntity(Path<? extends LectureRoomTimetableEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureRoomTimetableEntity(PathMetadata metadata) {
        super(LectureRoomTimetableEntity.class, metadata);
    }

}

