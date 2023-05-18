package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLectureRoomTimetableEntity is a Querydsl query type for LectureRoomTimetableEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureRoomTimetableEntity extends EntityPathBase<LectureRoomTimetableEntity> {

    private static final long serialVersionUID = 435895508L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLectureRoomTimetableEntity lectureRoomTimetableEntity = new QLectureRoomTimetableEntity("lectureRoomTimetableEntity");

    public final org.webMonster.uniManageBoot.professor.lectureClass.entity.QLectureClassEntity lectureClass;

    public final org.webMonster.uniManageBoot.professor.lectureClassTime.entity.QLectureClassTimeEntity lectureClassTime;

    public final StringPath lectureRoomCode = createString("lectureRoomCode");

    public final NumberPath<Long> lectureRoomTimetableIdx = createNumber("lectureRoomTimetableIdx", Long.class);

    public final ComparablePath<Character> operation = createComparable("operation", Character.class);

    public final StringPath timecode = createString("timecode");

    public QLectureRoomTimetableEntity(String variable) {
        this(LectureRoomTimetableEntity.class, forVariable(variable), INITS);
    }

    public QLectureRoomTimetableEntity(Path<? extends LectureRoomTimetableEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLectureRoomTimetableEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLectureRoomTimetableEntity(PathMetadata metadata, PathInits inits) {
        this(LectureRoomTimetableEntity.class, metadata, inits);
    }

    public QLectureRoomTimetableEntity(Class<? extends LectureRoomTimetableEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lectureClass = inits.isInitialized("lectureClass") ? new org.webMonster.uniManageBoot.professor.lectureClass.entity.QLectureClassEntity(forProperty("lectureClass")) : null;
        this.lectureClassTime = inits.isInitialized("lectureClassTime") ? new org.webMonster.uniManageBoot.professor.lectureClassTime.entity.QLectureClassTimeEntity(forProperty("lectureClassTime")) : null;
    }

}

