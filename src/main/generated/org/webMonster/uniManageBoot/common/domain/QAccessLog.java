package org.webMonster.uniManageBoot.common.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccessLog is a Querydsl query type for AccessLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccessLog extends EntityPathBase<AccessLog> {

    private static final long serialVersionUID = 599265780L;

    public static final QAccessLog accessLog = new QAccessLog("accessLog");

    public final StringPath className = createString("className");

    public final StringPath classSimpleName = createString("classSimpleName");

    public final NumberPath<Long> logNo = createNumber("logNo", Long.class);

    public final StringPath methodName = createString("methodName");

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final StringPath remoteAddr = createString("remoteAddr");

    public final StringPath requestUri = createString("requestUri");

    public final DateTimePath<java.time.LocalDateTime> updDate = createDateTime("updDate", java.time.LocalDateTime.class);

    public QAccessLog(String variable) {
        super(AccessLog.class, forVariable(variable));
    }

    public QAccessLog(Path<? extends AccessLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccessLog(PathMetadata metadata) {
        super(AccessLog.class, metadata);
    }

}

