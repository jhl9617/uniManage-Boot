package org.webMonster.uniManageBoot.common.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPerformanceLog is a Querydsl query type for PerformanceLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPerformanceLog extends EntityPathBase<PerformanceLog> {

    private static final long serialVersionUID = 1593095872L;

    public static final QPerformanceLog performanceLog = new QPerformanceLog("performanceLog");

    public final NumberPath<Long> durationTime = createNumber("durationTime", Long.class);

    public final NumberPath<Long> logNo = createNumber("logNo", Long.class);

    public final DateTimePath<java.util.Date> regDate = createDateTime("regDate", java.util.Date.class);

    public final StringPath signatureName = createString("signatureName");

    public final StringPath signatureTypeName = createString("signatureTypeName");

    public final DateTimePath<java.util.Date> updDate = createDateTime("updDate", java.util.Date.class);

    public QPerformanceLog(String variable) {
        super(PerformanceLog.class, forVariable(variable));
    }

    public QPerformanceLog(Path<? extends PerformanceLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerformanceLog(PathMetadata metadata) {
        super(PerformanceLog.class, metadata);
    }

}

