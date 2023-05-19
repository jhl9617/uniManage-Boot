package org.webMonster.uniManageBoot.student.courseRegi.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCourseRegiEntity is a Querydsl query type for CourseRegiEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCourseRegiEntity extends EntityPathBase<CourseRegiEntity> {

    private static final long serialVersionUID = -1912735784L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCourseRegiEntity courseRegiEntity = new QCourseRegiEntity("courseRegiEntity");

    public final NumberPath<Long> courseRegiId = createNumber("courseRegiId", Long.class);

    public final NumberPath<Long> courseRegiTerm = createNumber("courseRegiTerm", Long.class);

    public final org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity lecture;

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public QCourseRegiEntity(String variable) {
        this(CourseRegiEntity.class, forVariable(variable), INITS);
    }

    public QCourseRegiEntity(Path<? extends CourseRegiEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCourseRegiEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCourseRegiEntity(PathMetadata metadata, PathInits inits) {
        this(CourseRegiEntity.class, metadata, inits);
    }

    public QCourseRegiEntity(Class<? extends CourseRegiEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lecture = inits.isInitialized("lecture") ? new org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity(forProperty("lecture"), inits.get("lecture")) : null;
    }

}

