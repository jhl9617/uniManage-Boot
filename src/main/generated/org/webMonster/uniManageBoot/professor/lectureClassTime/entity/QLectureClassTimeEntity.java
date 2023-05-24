package org.webMonster.uniManageBoot.professor.lectureClassTime.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLectureClassTimeEntity is a Querydsl query type for LectureClassTimeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureClassTimeEntity extends EntityPathBase<LectureClassTimeEntity> {

    private static final long serialVersionUID = -2071005806L;

    public static final QLectureClassTimeEntity lectureClassTimeEntity = new QLectureClassTimeEntity("lectureClassTimeEntity");

    public final StringPath dayTime = createString("dayTime");

    public final NumberPath<Long> lectureClassTimeIdx = createNumber("lectureClassTimeIdx", Long.class);

    public final ListPath<org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity, org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.QLectureRoomTimetableEntity> lectureRoomTimetables = this.<org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity, org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.QLectureRoomTimetableEntity>createList("lectureRoomTimetables", org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity.class, org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.QLectureRoomTimetableEntity.class, PathInits.DIRECT2);

    public final StringPath startTime = createString("startTime");

    public final StringPath timecode = createString("timecode");

    public QLectureClassTimeEntity(String variable) {
        super(LectureClassTimeEntity.class, forVariable(variable));
    }

    public QLectureClassTimeEntity(Path<? extends LectureClassTimeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureClassTimeEntity(PathMetadata metadata) {
        super(LectureClassTimeEntity.class, metadata);
    }

}

