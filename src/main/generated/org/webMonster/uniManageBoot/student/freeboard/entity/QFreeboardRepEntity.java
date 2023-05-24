package org.webMonster.uniManageBoot.student.freeboard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFreeboardRepEntity is a Querydsl query type for FreeboardRepEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFreeboardRepEntity extends EntityPathBase<FreeboardRepEntity> {

    private static final long serialVersionUID = -498688187L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFreeboardRepEntity freeboardRepEntity = new QFreeboardRepEntity("freeboardRepEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final QFreeboardEntity freeboard;

    public final NumberPath<Long> freeId = createNumber("freeId", Long.class);

    public final StringPath freeRepContent = createString("freeRepContent");

    public final NumberPath<Long> freeRepId = createNumber("freeRepId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public QFreeboardRepEntity(String variable) {
        this(FreeboardRepEntity.class, forVariable(variable), INITS);
    }

    public QFreeboardRepEntity(Path<? extends FreeboardRepEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFreeboardRepEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFreeboardRepEntity(PathMetadata metadata, PathInits inits) {
        this(FreeboardRepEntity.class, metadata, inits);
    }

    public QFreeboardRepEntity(Class<? extends FreeboardRepEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.freeboard = inits.isInitialized("freeboard") ? new QFreeboardEntity(forProperty("freeboard"), inits.get("freeboard")) : null;
    }

}

