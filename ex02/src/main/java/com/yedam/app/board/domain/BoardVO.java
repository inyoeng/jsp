package com.yedam.app.board.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class BoardVO {
	private long bno; //게시글 번호
	private String title; //제목
	private String content; //내용
	private String writer; //사용자
	//날짜 형식 바꿔주기
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date regdate; //작성일자
	@JsonIgnore //수정일자 안보이게 하기 위해
	private Date updateDate; //수정일자
	
}
