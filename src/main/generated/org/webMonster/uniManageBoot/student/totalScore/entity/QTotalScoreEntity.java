package org.webMonster.uniManageBoot.student.totalScore.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTotalScoreEntity is a Querydsl query type for TotalScoreEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTotalScoreEntity extends EntityPathBase<TotalScoreEntity> {

    private static final long serialVersionUID = 1049524372L;

    public static final QTotalScoreEntity totalScoreEntity = new QTotalScoreEntity("totalScoreEntity");

    public final NumberPath<Integer> maxCredit = createNumber("maxCredit", Integer.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Integer> nowCredit = createNumber("nowCredit", Integer.class);

    public final NumberPath<Integer> totalAverage = createNumber("totalAverage", Integer.class);

    public QTotalScoreEntity(String variable) {
        super(TotalScoreEntity.class, forVariable(variable));
    }

    public QTotalScoreEntity(Path<? extends TotalScoreEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTotalScoreEntity(PathMetadata metadata) {
        super(TotalScoreEntity.class, metadata);
    }

}

