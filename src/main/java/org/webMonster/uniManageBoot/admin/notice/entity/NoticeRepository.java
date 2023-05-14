package org.webMonster.uniManageBoot.admin.notice.entity;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
    @Query("SELECT n FROM NoticeEntity n ORDER BY n.noticeId DESC")
    Page<NoticeEntity>findAllByOrderByNotice_idDesc(Pageable pageable);
}
