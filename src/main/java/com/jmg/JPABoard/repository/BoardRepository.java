package com.jmg.JPABoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jmg.JPABoard.Model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	@Query(value = "SELECT * FROM board WHERE id = :id ",nativeQuery = true)
	Board mFindById(int id);
	
	@Modifying //수정, 삭제, 저장에 필수 (select만 빼고 전부)
	@Query(value = "DELETE FROM board WHERE id = :id ",nativeQuery = true)
	int mDeleteById(int id);
}
