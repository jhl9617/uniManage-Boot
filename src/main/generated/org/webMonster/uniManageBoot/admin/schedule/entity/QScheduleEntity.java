package org.webMonster.uniManageBoot.admin.schedule.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QScheduleEntity is a Querydsl query type for ScheduleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScheduleEntity extends EntityPathBase<ScheduleEntity> {

    private static final long serialVersionUID = -611031214L;

    public static final QScheduleEntity scheduleEntity = new QScheduleEntity("scheduleEntity");

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final StringPath scheContent = createString("scheContent");

    public final NumberPath<Long> scheId = createNumber("scheId", Long.class);

    public final StringPath scheTitle = createString("scheTitle");

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public QScheduleEntity(String variable) {
        super(ScheduleEntity.class, forVariable(variable));
    }

    public QScheduleEntity(Path<? extends ScheduleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QScheduleEntity(PathMetadata metadata) {
        super(ScheduleEntity.class, metadata);
    }

}

