package org.webMonster.uniManageBoot.professor.attendance.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAttendanceEntity is a Querydsl query type for AttendanceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAttendanceEntity extends EntityPathBase<AttendanceEntity> {

    private static final long serialVersionUID = -696366122L;

    public static final QAttendanceEntity attendanceEntity = new QAttendanceEntity("attendanceEntity");

    public final NumberPath<Long> attendanceId = createNumber("attendanceId", Long.class);

    public final NumberPath<Long> attendanceIdx = createNumber("attendanceIdx", Long.class);

    public final ComparablePath<Character> attended = createComparable("attended", Character.class);

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public QAttendanceEntity(String variable) {
        super(AttendanceEntity.class, forVariable(variable));
    }

    public QAttendanceEntity(Path<? extends AttendanceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAttendanceEntity(PathMetadata metadata) {
        super(AttendanceEntity.class, metadata);
    }

}

