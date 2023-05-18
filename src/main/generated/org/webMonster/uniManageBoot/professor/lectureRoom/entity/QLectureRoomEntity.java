package org.webMonster.uniManageBoot.professor.lectureRoom.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLectureRoomEntity is a Querydsl query type for LectureRoomEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureRoomEntity extends EntityPathBase<LectureRoomEntity> {

    private static final long serialVersionUID = 744586250L;

    public static final QLectureRoomEntity lectureRoomEntity = new QLectureRoomEntity("lectureRoomEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final StringPath lectureRoomContent = createString("lectureRoomContent");

    public final NumberPath<Long> lectureRoomId = createNumber("lectureRoomId", Long.class);

    public final ListPath<org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity, org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.QLectureRoomTimetableEntity> lectureRoomTimetables = this.<org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity, org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.QLectureRoomTimetableEntity>createList("lectureRoomTimetables", org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity.class, org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.QLectureRoomTimetableEntity.class, PathInits.DIRECT2);

    public final StringPath lectureRoomTitle = createString("lectureRoomTitle");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Integer> readcount = createNumber("readcount", Integer.class);

    public QLectureRoomEntity(String variable) {
        super(LectureRoomEntity.class, forVariable(variable));
    }

    public QLectureRoomEntity(Path<? extends LectureRoomEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureRoomEntity(PathMetadata metadata) {
        super(LectureRoomEntity.class, metadata);
    }

}

