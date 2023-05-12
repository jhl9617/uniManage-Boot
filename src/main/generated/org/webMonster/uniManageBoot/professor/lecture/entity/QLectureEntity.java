package org.webMonster.uniManageBoot.professor.lecture.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLectureEntity is a Querydsl query type for LectureEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureEntity extends EntityPathBase<LectureEntity> {

    private static final long serialVersionUID = -137465238L;

    public static final QLectureEntity lectureEntity = new QLectureEntity("lectureEntity");

    public final ComparablePath<Character> classification = createComparable("classification", Character.class);

    public final NumberPath<Integer> credit = createNumber("credit", Integer.class);

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final ComparablePath<Character> lectureApplyStatus = createComparable("lectureApplyStatus", Character.class);

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final StringPath lectureTitle = createString("lectureTitle");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Integer> numberOfStudent = createNumber("numberOfStudent", Integer.class);

    public final StringPath roomcode1 = createString("roomcode1");

    public final StringPath roomcode2 = createString("roomcode2");

    public final StringPath roomcode3 = createString("roomcode3");

    public final NumberPath<Long> semester = createNumber("semester", Long.class);

    public final StringPath syllabusRename = createString("syllabusRename");

    public final StringPath syllabusTitle = createString("syllabusTitle");

    public final StringPath timecode1 = createString("timecode1");

    public final StringPath timecode2 = createString("timecode2");

    public final StringPath timecode3 = createString("timecode3");

    public QLectureEntity(String variable) {
        super(LectureEntity.class, forVariable(variable));
    }

    public QLectureEntity(Path<? extends LectureEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureEntity(PathMetadata metadata) {
        super(LectureEntity.class, metadata);
    }

}

