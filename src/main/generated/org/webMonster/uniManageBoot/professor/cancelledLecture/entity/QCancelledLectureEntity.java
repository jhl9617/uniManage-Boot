package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCancelledLectureEntity is a Querydsl query type for CancelledLectureEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCancelledLectureEntity extends EntityPathBase<CancelledLectureEntity> {

    private static final long serialVersionUID = 1172295518L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCancelledLectureEntity cancelledLectureEntity = new QCancelledLectureEntity("cancelledLectureEntity");

    public final NumberPath<Integer> attendanceDay = createNumber("attendanceDay", Integer.class);

    public final ComparablePath<Character> cancelledApply = createComparable("cancelledApply", Character.class);

    public final StringPath cancelledFile = createString("cancelledFile");

    public final StringPath cancelledFileRename = createString("cancelledFileRename");

    public final NumberPath<Long> cancelledLectureIdx = createNumber("cancelledLectureIdx", Long.class);

    public final org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity lecture;

    public final org.webMonster.uniManageBoot.professor.lectureClass.entity.QLectureClassEntity lectureClass;

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final StringPath lectureRoomCode = createString("lectureRoomCode");

    public final org.webMonster.uniManageBoot.member.entity.QMemberEntity member;

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath reason = createString("reason");

    public final DatePath<java.sql.Date> supplyDate = createDate("supplyDate", java.sql.Date.class);

    public QCancelledLectureEntity(String variable) {
        this(CancelledLectureEntity.class, forVariable(variable), INITS);
    }

    public QCancelledLectureEntity(Path<? extends CancelledLectureEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCancelledLectureEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCancelledLectureEntity(PathMetadata metadata, PathInits inits) {
        this(CancelledLectureEntity.class, metadata, inits);
    }

    public QCancelledLectureEntity(Class<? extends CancelledLectureEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lecture = inits.isInitialized("lecture") ? new org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity(forProperty("lecture"), inits.get("lecture")) : null;
        this.lectureClass = inits.isInitialized("lectureClass") ? new org.webMonster.uniManageBoot.professor.lectureClass.entity.QLectureClassEntity(forProperty("lectureClass")) : null;
        this.member = inits.isInitialized("member") ? new org.webMonster.uniManageBoot.member.entity.QMemberEntity(forProperty("member"), inits.get("member")) : null;
    }

}

