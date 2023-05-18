package org.webMonster.uniManageBoot.student.courseRegi.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCourseRegiEntity is a Querydsl query type for CourseRegiEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCourseRegiEntity extends EntityPathBase<CourseRegiEntity> {

    private static final long serialVersionUID = -1912735784L;

    public static final QCourseRegiEntity courseRegiEntity = new QCourseRegiEntity("courseRegiEntity");

    public final NumberPath<Long> courseRegiId = createNumber("courseRegiId", Long.class);

    public final NumberPath<Long> courseRegiTerm = createNumber("courseRegiTerm", Long.class);

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public QCourseRegiEntity(String variable) {
        super(CourseRegiEntity.class, forVariable(variable));
    }

    public QCourseRegiEntity(Path<? extends CourseRegiEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCourseRegiEntity(PathMetadata metadata) {
        super(CourseRegiEntity.class, metadata);
    }

}

