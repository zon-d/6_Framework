package edu.kh.project.board.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Board {
	
    private int boardNo;
    private String boardTitle;
    private String boardContent;
    private String boardCreateDate;
    private String boardUpdateDate;
    private int readCount;
    private int commentCount;
    private int likeCount;
    private String memberNickname;
    private String thumbnail;
    private int memberNo;
    private String profileImage;
    private int boardCode;
    
    // 이미지 목록
    List<BoardImage> imageList;
    
    // 댓글 목록
    List<Comment> commentList;

}
