package com.jmg.JPABoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmg.JPABoard.Model.Board;
import com.jmg.JPABoard.config.args.ArgsNotFound;
import com.jmg.JPABoard.dto.BoardSaveRequestDto;
import com.jmg.JPABoard.repository.BoardRepository;


@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	public List<Board> boardList() {
		List<Board> boards = boardRepository.findAll();
		return boards;
	}
	
	//글쓰기
	@Transactional
	public void boardWrite(BoardSaveRequestDto dto) {
		Board boardEntity = BoardSaveRequestDto.toEntity(dto);
		boardRepository.save(boardEntity);
	}
	
	//글 하나보기
	@Transactional
	public Board boardRead(int id) throws ArgsNotFound {
		Board board = boardRepository.findById(id).orElseThrow(()-> new ArgsNotFound("ID 값 오류"));
		board.setReadCount(board.getReadCount()+1);
		return board;
	}
	
	@Transactional
	public void boardDelete(int id)	{
		boardRepository.mDeleteById(id);
	}
	
	@Transactional
	public void boardUpdate(int id, BoardSaveRequestDto dto)	{
		//더티 체킹
		//Board boardEntity = boardRepository.findById(id).orElseThrow(()-> new RuntimeException("ID값 잘못들어왔어요"));
		Board boardEntity = boardRepository.mFindById(id);
		boardEntity.setTitle(dto.getTitle());
		boardEntity.setContent(dto.getContent());
	}
	
}
