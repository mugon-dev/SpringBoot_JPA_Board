package com.jmg.JPABoard.dto;

import com.jmg.JPABoard.Model.Board;

import lombok.Data;

@Data
public class BoardSaveRequestDto {
	private String title;
	private String content;
	
	public static Board toEntity(BoardSaveRequestDto dto) {
		Board board = Board.builder()
				.title(dto.getTitle())
				.content(dto.content)
				.build();
		return board;
	}
}
