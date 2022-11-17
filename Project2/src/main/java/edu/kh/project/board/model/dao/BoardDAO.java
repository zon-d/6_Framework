package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.vo.Board;
import edu.kh.project.board.model.vo.Pagination;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 게시판 이름 목록 조회
	 * @return
	 */
	public List<Map<String, Object>> selectBoardType() {
		
		return sqlSession.selectList("boardMapper.selectBoardType");
	}

	/**
	 * 게시글 수 조회
	 * @param boardCode
	 * @return listCount
	 */
	public int getListCount(int boardCode) {
		
		return sqlSession.selectOne("boardMapper.getListCount", boardCode);
		// 마이바티스 객체 이용해서 1행만 조회
		// boardMapper mapper파일의 getListCount를 호출, parameter는 boardCode
	}

	/**
	 * 특정 게시판 목록 조회
	 * @param pagination
	 * @param boardCode
	 * @return boardList
	 */
	public List<Board> selectBoardList(Pagination pagination, int boardCode) {

		// RowBounds 객체(마이바티스)
		// - 여러 행 조회 결과 중 특정 위치부터 지정된 행의 개수만 조회하는 객체
		//					(몇 행을 건너 뛸것인가?)
		
		int offset = (pagination.getCurrentPage() -1) * pagination.getLimit();
		
											// offset , limit
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("boardMapper.selectBoardList", boardCode, rowBounds); // rowBounds는 항상 세번째 자리에 위치해야함
										// namespace.id			, 파라미터 , RowBounds 객체
										// 						  파라미터가 없을 경우 null 대입
		
	}

}
