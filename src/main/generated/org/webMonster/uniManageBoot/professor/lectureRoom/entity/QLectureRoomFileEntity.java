package org.webMonster.uniManageBoot.professor.lectureRoom.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLectureRoomFileEntity is a Querydsl query type for LectureRoomFileEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureRoomFileEntity extends EntityPathBase<LectureRoomFileEntity> {

    private static final long serialVersionUID = -1819744986L;

    public static final QLectureRoomFileEntity lectureRoomFileEntity = new QLectureRoomFileEntity("lectureRoomFileEntity");

    public final StringPath fileName = createString("fileName");

    public final StringPath fileRename = createString("fileRename");

    public final NumberPath<Long> lectureRoomId = createNumber("lectureRoomId", Long.class);

    public QLectureRoomFileEntity(String variable) {
        super(LectureRoomFileEntity.class, forVariable(variable));
    }

    public QLectureRoomFileEntity(Path<? extends LectureRoomFileEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureRoomFileEntity(PathMetadata metadata) {
        super(LectureRoomFileEntity.class, metadata);
    }

}

