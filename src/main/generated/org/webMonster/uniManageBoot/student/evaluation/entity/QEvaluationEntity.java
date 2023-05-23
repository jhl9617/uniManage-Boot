package org.webMonster.uniManageBoot.student.evaluation.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEvaluationEntity is a Querydsl query type for EvaluationEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEvaluationEntity extends EntityPathBase<EvaluationEntity> {

    private static final long serialVersionUID = -89088208L;

    public static final QEvaluationEntity evaluationEntity = new QEvaluationEntity("evaluationEntity");

    public final StringPath comments = createString("comments");

    public final NumberPath<Long> evaluationId = createNumber("evaluationId", Long.class);

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Integer> score1 = createNumber("score1", Integer.class);

    public final NumberPath<Integer> score2 = createNumber("score2", Integer.class);

    public final NumberPath<Integer> score3 = createNumber("score3", Integer.class);

    public final NumberPath<Integer> score4 = createNumber("score4", Integer.class);

    public final NumberPath<Integer> score5 = createNumber("score5", Integer.class);

    public QEvaluationEntity(String variable) {
        super(EvaluationEntity.class, forVariable(variable));
    }

    public QEvaluationEntity(Path<? extends EvaluationEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEvaluationEntity(PathMetadata metadata) {
        super(EvaluationEntity.class, metadata);
    }

}

