package edu.bit.ex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Log4j
@Service
@AllArgsConstructor
public class BoardServiceChild implements BoardService{

	private BoardMapper mapper;
	@Override
	public List<BoardVO> getList(Criteria criteria) {
		log.info("getList...");
		return mapper.getList(criteria);
	}
	@Override
	public void remove(int getbId) {
		mapper.remove(getbId);
		
	}
	@Override
	public BoardVO rest_content_view(int getbId) {
		log.info("rest_content_view...");
		mapper.upHit(getbId);
		return mapper.rest_content_view(getbId);
	}
	@Override
	public BoardVO rest_reply_view(int getbId) {
		log.info("rest_reply_view");
		return mapper.rest_reply_view(getbId);
	}
	@Override
	public int rest_reply(BoardVO boardVO) {
		
		log.info("rest_reply");
		return mapper.rest_reply(boardVO);

	
	}
	@Override
	public int rest_Modify(BoardVO boardVO) {
		log.info("rest_Modify");
		return mapper.rest_Modify(boardVO);
	}
	@Override
	public int rest_write(BoardVO boardVO) {
		log.info("rest_write");
		return mapper.rest_write(boardVO);
	}
	@Override
	public int getTotal(Criteria criteria) {
		log.info("getTotal");
		return mapper.getTotal(criteria);
	}
}
