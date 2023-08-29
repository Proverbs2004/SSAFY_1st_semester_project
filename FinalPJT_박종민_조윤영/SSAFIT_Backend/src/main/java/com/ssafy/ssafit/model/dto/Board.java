package com.ssafy.ssafit.model.dto;

public class Board {
	
	private int boardSeq; 
	private String boardType;
	
	public Board() { }

	public Board(int boardSeq, String boardType) {
		super();
		this.boardSeq = boardSeq;
		this.boardType = boardType;
	}

	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	
	
}
