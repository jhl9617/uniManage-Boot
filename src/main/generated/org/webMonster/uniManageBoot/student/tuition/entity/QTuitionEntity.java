package org.webMonster.uniManageBoot.student.tuition.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTuitionEntity is a Querydsl query type for TuitionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTuitionEntity extends EntityPathBase<TuitionEntity> {

    private static final long serialVersionUID = 2098673566L;

    public static final QTuitionEntity tuitionEntity = new QTuitionEntity("tuitionEntity");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final ComparablePath<Character> paid = createComparable("paid", Character.class);

    public final NumberPath<Integer> tuitionAmount = createNumber("tuitionAmount", Integer.class);

    public final NumberPath<Long> tuitionId = createNumber("tuitionId", Long.class);

    public final NumberPath<Integer> tuitionTerm = createNumber("tuitionTerm", Integer.class);

    public QTuitionEntity(String variable) {
        super(TuitionEntity.class, forVariable(variable));
    }

    public QTuitionEntity(Path<? extends TuitionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTuitionEntity(PathMetadata metadata) {
        super(TuitionEntity.class, metadata);
    }

}

