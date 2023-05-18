package org.webMonster.uniManageBoot.student.department.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDepartmentEntity is a Querydsl query type for DepartmentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepartmentEntity extends EntityPathBase<DepartmentEntity> {

    private static final long serialVersionUID = 299093212L;

    public static final QDepartmentEntity departmentEntity = new QDepartmentEntity("departmentEntity");

    public final StringPath category = createString("category");

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final StringPath departmentName = createString("departmentName");

    public final ListPath<org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity, org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity> lectureEntities = this.<org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity, org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity>createList("lectureEntities", org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity.class, org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity.class, PathInits.DIRECT2);

    public final ListPath<org.webMonster.uniManageBoot.member.entity.MemberEntity, org.webMonster.uniManageBoot.member.entity.QMemberEntity> members = this.<org.webMonster.uniManageBoot.member.entity.MemberEntity, org.webMonster.uniManageBoot.member.entity.QMemberEntity>createList("members", org.webMonster.uniManageBoot.member.entity.MemberEntity.class, org.webMonster.uniManageBoot.member.entity.QMemberEntity.class, PathInits.DIRECT2);

    public QDepartmentEntity(String variable) {
        super(DepartmentEntity.class, forVariable(variable));
    }

    public QDepartmentEntity(Path<? extends DepartmentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDepartmentEntity(PathMetadata metadata) {
        super(DepartmentEntity.class, metadata);
    }

}

