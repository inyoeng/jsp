package com.yedam.app.board.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReplyVO extends BoardVO{
	private int rno;
	//private int bno;
	private String reply;
	private String replyer;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date replyDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updateDate;
	
}
