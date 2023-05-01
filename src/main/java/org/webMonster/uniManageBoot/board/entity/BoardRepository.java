package org.webMonster.uniManageBoot.board.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


//얘가 JPA임
//mybatis의 session 만드는 친구같은 애임
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    Page<BoardEntity> findAllByOrderByIdxDesc(Pageable pageable);
}