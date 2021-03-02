package edu.bit.ex.service;

import java.util.List;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> getList(Criteria criteria) ;

	public void remove(int getbId);

	public BoardVO rest_content_view(int getbId);

	public BoardVO rest_reply_view(int getbId);

	public int rest_reply(BoardVO boardVO);

	public int rest_Modify(BoardVO boardVO);

	public int rest_write(BoardVO boardVO);

	public int getTotal(Criteria criteria);

}
