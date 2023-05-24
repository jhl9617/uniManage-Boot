package org.webMonster.uniManageBoot.professor.lectureClass.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLectureClassEntity is a Querydsl query type for LectureClassEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureClassEntity extends EntityPathBase<LectureClassEntity> {

    private static final long serialVersionUID = -1766442056L;

    public static final QLectureClassEntity lectureClassEntity = new QLectureClassEntity("lectureClassEntity");

    public final StringPath buildingCode = createString("buildingCode");

    public final StringPath buildingName = createString("buildingName");

    public final NumberPath<Integer> classCapacity = createNumber("classCapacity", Integer.class);

    public final NumberPath<Long> lectureClassIdx = createNumber("lectureClassIdx", Long.class);

    public final StringPath lectureRoomCode = createString("lectureRoomCode");

    public final StringPath lectureRoomNum = createString("lectureRoomNum");

    public final ListPath<org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity, org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.QLectureRoomTimetableEntity> lectureRoomTimetables = this.<org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity, org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.QLectureRoomTimetableEntity>createList("lectureRoomTimetables", org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity.class, org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.QLectureRoomTimetableEntity.class, PathInits.DIRECT2);

    public final NumberPath<Integer> numberFloor = createNumber("numberFloor", Integer.class);

    public QLectureClassEntity(String variable) {
        super(LectureClassEntity.class, forVariable(variable));
    }

    public QLectureClassEntity(Path<? extends LectureClassEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureClassEntity(PathMetadata metadata) {
        super(LectureClassEntity.class, metadata);
    }

}

