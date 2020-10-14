package com.jmg.JPABoard.Model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	@Id // 기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private int readCount;
	@CreationTimestamp
	private Timestamp createDate; 

}
