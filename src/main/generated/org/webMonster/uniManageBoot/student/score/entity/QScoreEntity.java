package org.webMonster.uniManageBoot.student.score.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScoreEntity is a Querydsl query type for ScoreEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScoreEntity extends EntityPathBase<ScoreEntity> {

    private static final long serialVersionUID = -2067324642L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScoreEntity scoreEntity = new QScoreEntity("scoreEntity");

    public final NumberPath<Integer> assignScore = createNumber("assignScore", Integer.class);

    public final NumberPath<Integer> finalScore = createNumber("finalScore", Integer.class);

    public final org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity lecture;

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final org.webMonster.uniManageBoot.member.entity.QMemberEntity member;

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Integer> midScore = createNumber("midScore", Integer.class);

    public final NumberPath<Long> scoreId = createNumber("scoreId", Long.class);

    public final NumberPath<Integer> totalScore = createNumber("totalScore", Integer.class);

    public QScoreEntity(String variable) {
        this(ScoreEntity.class, forVariable(variable), INITS);
    }

    public QScoreEntity(Path<? extends ScoreEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScoreEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScoreEntity(PathMetadata metadata, PathInits inits) {
        this(ScoreEntity.class, metadata, inits);
    }

    public QScoreEntity(Class<? extends ScoreEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lecture = inits.isInitialized("lecture") ? new org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity(forProperty("lecture"), inits.get("lecture")) : null;
        this.member = inits.isInitialized("member") ? new org.webMonster.uniManageBoot.member.entity.QMemberEntity(forProperty("member"), inits.get("member")) : null;
    }

}

