package org.webMonster.uniManageBoot.admin.notice.entity;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
    Page<NoticeEntity>findAllByOrderByIdxDesc(Pageable pageable);
}
