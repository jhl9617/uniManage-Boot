package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCancelledLectureEntity is a Querydsl query type for CancelledLectureEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCancelledLectureEntity extends EntityPathBase<CancelledLectureEntity> {

    private static final long serialVersionUID = 1172295518L;

    public static final QCancelledLectureEntity cancelledLectureEntity = new QCancelledLectureEntity("cancelledLectureEntity");

    public final NumberPath<Integer> attendanceDay = createNumber("attendanceDay", Integer.class);

    public final ComparablePath<Character> cancelledApply = createComparable("cancelledApply", Character.class);

    public final StringPath cancelledFile = createString("cancelledFile");

    public final StringPath cancelledRename = createString("cancelledRename");

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final StringPath lectureRoomCode = createString("lectureRoomCode");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath reason = createString("reason");

    public final DatePath<java.sql.Date> supplyDate = createDate("supplyDate", java.sql.Date.class);

    public QCancelledLectureEntity(String variable) {
        super(CancelledLectureEntity.class, forVariable(variable));
    }

    public QCancelledLectureEntity(Path<? extends CancelledLectureEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCancelledLectureEntity(PathMetadata metadata) {
        super(CancelledLectureEntity.class, metadata);
    }

}

