package org.webMonster.uniManageBoot.admin.scholarship.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QScholarshipEntity is a Querydsl query type for ScholarshipEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScholarshipEntity extends EntityPathBase<ScholarshipEntity> {

    private static final long serialVersionUID = 93405962L;

    public static final QScholarshipEntity scholarshipEntity = new QScholarshipEntity("scholarshipEntity");

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Long> schoId = createNumber("schoId", Long.class);

    public final StringPath schoName = createString("schoName");

    public final NumberPath<Long> schoTerm = createNumber("schoTerm", Long.class);

    public QScholarshipEntity(String variable) {
        super(ScholarshipEntity.class, forVariable(variable));
    }

    public QScholarshipEntity(Path<? extends ScholarshipEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QScholarshipEntity(PathMetadata metadata) {
        super(ScholarshipEntity.class, metadata);
    }

}

