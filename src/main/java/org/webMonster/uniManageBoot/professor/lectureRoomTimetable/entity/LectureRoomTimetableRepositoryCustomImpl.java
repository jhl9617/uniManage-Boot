package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class LectureRoomTimetableRepositoryCustomImpl extends QuerydslRepositorySupport implements LectureRoomTimetableRepositoryCustom {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public LectureRoomTimetableRepositoryCustomImpl(Class<?> domainClass) {
        super(domainClass);
    }
}

