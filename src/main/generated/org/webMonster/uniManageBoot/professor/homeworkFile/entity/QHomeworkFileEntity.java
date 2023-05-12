package org.webMonster.uniManageBoot.professor.homeworkFile.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHomeworkFileEntity is a Querydsl query type for HomeworkFileEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHomeworkFileEntity extends EntityPathBase<HomeworkFileEntity> {

    private static final long serialVersionUID = -442168676L;

    public static final QHomeworkFileEntity homeworkFileEntity = new QHomeworkFileEntity("homeworkFileEntity");

    public final StringPath fileName = createString("fileName");

    public final StringPath fileRename = createString("fileRename");

    public final NumberPath<Long> homeworkId = createNumber("homeworkId", Long.class);

    public QHomeworkFileEntity(String variable) {
        super(HomeworkFileEntity.class, forVariable(variable));
    }

    public QHomeworkFileEntity(Path<? extends HomeworkFileEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHomeworkFileEntity(PathMetadata metadata) {
        super(HomeworkFileEntity.class, metadata);
    }

}

