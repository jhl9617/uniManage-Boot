package org.webMonster.uniManageBoot.student.freeboard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFreeboardRepEntity is a Querydsl query type for FreeboardRepEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFreeboardRepEntity extends EntityPathBase<FreeboardRepEntity> {

    private static final long serialVersionUID = -498688187L;

    public static final QFreeboardRepEntity freeboardRepEntity = new QFreeboardRepEntity("freeboardRepEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> freeId = createNumber("freeId", Long.class);

    public final StringPath freeRepContent = createString("freeRepContent");

    public final NumberPath<Long> freeRepId = createNumber("freeRepId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public QFreeboardRepEntity(String variable) {
        super(FreeboardRepEntity.class, forVariable(variable));
    }

    public QFreeboardRepEntity(Path<? extends FreeboardRepEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFreeboardRepEntity(PathMetadata metadata) {
        super(FreeboardRepEntity.class, metadata);
    }

}

