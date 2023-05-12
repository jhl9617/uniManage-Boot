package org.webMonster.uniManageBoot.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberEntity is a Querydsl query type for MemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEntity extends EntityPathBase<MemberEntity> {

    private static final long serialVersionUID = -1823131047L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final NumberPath<Integer> auth = createNumber("auth", Integer.class);

    public final DatePath<java.sql.Date> birthday = createDate("birthday", java.sql.Date.class);

    public final org.webMonster.uniManageBoot.student.department.entity.QDepartmentEntity department;

    public final NumberPath<Integer> departmentId = createNumber("departmentId", Integer.class);

    public final StringPath email = createString("email");

    public final ListPath<org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardEntity, org.webMonster.uniManageBoot.student.freeboard.entity.QFreeboardEntity> freeboardEntities = this.<org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardEntity, org.webMonster.uniManageBoot.student.freeboard.entity.QFreeboardEntity>createList("freeboardEntities", org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardEntity.class, org.webMonster.uniManageBoot.student.freeboard.entity.QFreeboardEntity.class, PathInits.DIRECT2);

    public final NumberPath<Integer> grade = createNumber("grade", Integer.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Long> memberIdx = createNumber("memberIdx", Long.class);

    public final StringPath memberPwd = createString("memberPwd");

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> postcode = createNumber("postcode", Integer.class);

    public QMemberEntity(String variable) {
        this(MemberEntity.class, forVariable(variable), INITS);
    }

    public QMemberEntity(Path<? extends MemberEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberEntity(PathMetadata metadata, PathInits inits) {
        this(MemberEntity.class, metadata, inits);
    }

    public QMemberEntity(Class<? extends MemberEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new org.webMonster.uniManageBoot.student.department.entity.QDepartmentEntity(forProperty("department")) : null;
    }

}

