package org.webMonster.uniManageBoot.student.score.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QScoreEntity is a Querydsl query type for ScoreEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScoreEntity extends EntityPathBase<ScoreEntity> {

    private static final long serialVersionUID = -2067324642L;

    public static final QScoreEntity scoreEntity = new QScoreEntity("scoreEntity");

    public final NumberPath<Integer> assignScore = createNumber("assignScore", Integer.class);

    public final NumberPath<Integer> finalScore = createNumber("finalScore", Integer.class);

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Integer> midScore = createNumber("midScore", Integer.class);

    public final NumberPath<Long> scoreId = createNumber("scoreId", Long.class);

    public final NumberPath<Integer> totalScore = createNumber("totalScore", Integer.class);

    public QScoreEntity(String variable) {
        super(ScoreEntity.class, forVariable(variable));
    }

    public QScoreEntity(Path<? extends ScoreEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QScoreEntity(PathMetadata metadata) {
        super(ScoreEntity.class, metadata);
    }

}

