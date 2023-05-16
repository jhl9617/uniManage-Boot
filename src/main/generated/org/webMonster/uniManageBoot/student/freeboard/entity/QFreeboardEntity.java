package org.webMonster.uniManageBoot.student.freeboard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFreeboardEntity is a Querydsl query type for FreeboardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFreeboardEntity extends EntityPathBase<FreeboardEntity> {

    private static final long serialVersionUID = -1593211490L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFreeboardEntity freeboardEntity = new QFreeboardEntity("freeboardEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final ListPath<FreeboardRepEntity, QFreeboardRepEntity> freeboardRepEntities = this.<FreeboardRepEntity, QFreeboardRepEntity>createList("freeboardRepEntities", FreeboardRepEntity.class, QFreeboardRepEntity.class, PathInits.DIRECT2);

    public final StringPath freeContent = createString("freeContent");

    public final NumberPath<Long> freeId = createNumber("freeId", Long.class);

    public final StringPath freeTitle = createString("freeTitle");

    public final org.webMonster.uniManageBoot.member.entity.QMemberEntity member;

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public QFreeboardEntity(String variable) {
        this(FreeboardEntity.class, forVariable(variable), INITS);
    }

    public QFreeboardEntity(Path<? extends FreeboardEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFreeboardEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFreeboardEntity(PathMetadata metadata, PathInits inits) {
        this(FreeboardEntity.class, metadata, inits);
    }

    public QFreeboardEntity(Class<? extends FreeboardEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new org.webMonster.uniManageBoot.member.entity.QMemberEntity(forProperty("member"), inits.get("member")) : null;
    }

}

