package org.webMonster.uniManageBoot.professor.homework.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHomeworkEntity is a Querydsl query type for HomeworkEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHomeworkEntity extends EntityPathBase<HomeworkEntity> {

    private static final long serialVersionUID = 1721928164L;

    public static final QHomeworkEntity homeworkEntity = new QHomeworkEntity("homeworkEntity");

    public final DateTimePath<java.time.LocalDateTime> deadline = createDateTime("deadline", java.time.LocalDateTime.class);

    public final StringPath homeworkContent = createString("homeworkContent");

    public final NumberPath<Long> homeworkId = createNumber("homeworkId", Long.class);

    public final StringPath homeworkName = createString("homeworkName");

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final ComparablePath<Character> submitted = createComparable("submitted", Character.class);

    public QHomeworkEntity(String variable) {
        super(HomeworkEntity.class, forVariable(variable));
    }

    public QHomeworkEntity(Path<? extends HomeworkEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHomeworkEntity(PathMetadata metadata) {
        super(HomeworkEntity.class, metadata);
    }

}

