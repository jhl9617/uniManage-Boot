package org.webMonster.uniManageBoot.student.freeboard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFreeboardEntity is a Querydsl query type for FreeboardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFreeboardEntity extends EntityPathBase<FreeboardEntity> {

    private static final long serialVersionUID = -1593211490L;

    public static final QFreeboardEntity freeboardEntity = new QFreeboardEntity("freeboardEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath freeContent = createString("freeContent");

    public final NumberPath<Long> freeId = createNumber("freeId", Long.class);

    public final StringPath freeTitle = createString("freeTitle");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public QFreeboardEntity(String variable) {
        super(FreeboardEntity.class, forVariable(variable));
    }

    public QFreeboardEntity(Path<? extends FreeboardEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFreeboardEntity(PathMetadata metadata) {
        super(FreeboardEntity.class, metadata);
    }

}

