package org.webMonster.uniManageBoot.admin.scholarship.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScholarshipEntity is a Querydsl query type for ScholarshipEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScholarshipEntity extends EntityPathBase<ScholarshipEntity> {

    private static final long serialVersionUID = 93405962L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScholarshipEntity scholarshipEntity = new QScholarshipEntity("scholarshipEntity");

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final org.webMonster.uniManageBoot.member.entity.QMemberEntity member;

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Long> schoId = createNumber("schoId", Long.class);

    public final StringPath schoName = createString("schoName");

    public final NumberPath<Long> schoTerm = createNumber("schoTerm", Long.class);

    public QScholarshipEntity(String variable) {
        this(ScholarshipEntity.class, forVariable(variable), INITS);
    }

    public QScholarshipEntity(Path<? extends ScholarshipEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScholarshipEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScholarshipEntity(PathMetadata metadata, PathInits inits) {
        this(ScholarshipEntity.class, metadata, inits);
    }

    public QScholarshipEntity(Class<? extends ScholarshipEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new org.webMonster.uniManageBoot.member.entity.QMemberEntity(forProperty("member"), inits.get("member")) : null;
    }

}

