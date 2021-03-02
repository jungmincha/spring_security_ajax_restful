package edu.bit.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {

	public List<BoardVO> getList(Criteria criteria);

	public void remove(int getbId);

	public BoardVO rest_content_view(int getbId);

	public BoardVO rest_reply_view(int getbId);

	public int rest_reply(BoardVO boardVO);

	public void replyshape(BoardVO boardVO);

	public int rest_Modify(BoardVO boardVO);

	public int rest_write(BoardVO boardVO);

	public void upHit(int getbId);

	public int getTotal(Criteria criteria);



}
