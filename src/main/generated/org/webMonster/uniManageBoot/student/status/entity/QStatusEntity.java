package org.webMonster.uniManageBoot.student.status.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStatusEntity is a Querydsl query type for StatusEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStatusEntity extends EntityPathBase<StatusEntity> {

    private static final long serialVersionUID = 92284316L;

    public static final QStatusEntity statusEntity = new QStatusEntity("statusEntity");

    public final ComparablePath<Character> allowedLeave = createComparable("allowedLeave", Character.class);

    public final DatePath<java.sql.Date> applyLeaveDate = createDate("applyLeaveDate", java.sql.Date.class);

    public final DatePath<java.sql.Date> applyReturnDate = createDate("applyReturnDate", java.sql.Date.class);

    public final DatePath<java.sql.Date> endDate = createDate("endDate", java.sql.Date.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath reasonOfLeave = createString("reasonOfLeave");

    public final DatePath<java.sql.Date> returnDate = createDate("returnDate", java.sql.Date.class);

    public final DatePath<java.sql.Date> startDate = createDate("startDate", java.sql.Date.class);

    public final NumberPath<Long> statusId = createNumber("statusId", Long.class);

    public QStatusEntity(String variable) {
        super(StatusEntity.class, forVariable(variable));
    }

    public QStatusEntity(Path<? extends StatusEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStatusEntity(PathMetadata metadata) {
        super(StatusEntity.class, metadata);
    }

}

