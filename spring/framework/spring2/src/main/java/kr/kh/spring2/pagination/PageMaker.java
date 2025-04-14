package kr.kh.spring2.pagination;

import lombok.Data;

@Data
public class PageMaker {
	private int totalCount; //전체 컨텐츠 개수 => 마지막 페이지네이션의 마지막 페이지를 계산하기 위해
	private int startPage;//페이지네이션 시작 페이지번호
	private int endPage;//페이지네이션 마지막 페이지번호
	private boolean prev;//이전버튼 활성화
	private boolean next;//다음버튼 활성화
	private int displayPageNum;//한 페이지네이션에서 보여준 페이지의 최대 숫자 개수
	private Criteria cri;
	
	//이전 페이지 활성화 여부, 다음 페이지 활성화 여부, 마지막 페이지 번호를 계산하는 메소드
	public void calculate() {
		
		//컨텐츠 수와 상관 없이 현재 페이지에 가능한 최대 마지막 페이지를 계산
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		
		//최대 마지막 페이지를 이용하여 시작 페이지를 계산 
		startPage = endPage - displayPageNum + 1;
		
		//컨텐츠 개수를 이용하여 계산한 모든 페이지의 최대 페이지 번호
		int tmpEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		
		//최대 페이지가 현재 페이지에서 가능한 최대 페이지보다 작으면 현재 페이지에서 가능한 최대 페이지를 수정
		//마지막 페이지네이션이고, 컨텐츠 수가 마지막 페이지까지 못 가는 경우
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		//첫번째 페이지네이션이면 false 아니면 true
		prev = startPage == 1 ? false : true;
		//마지막 페이지네이션이면 false 아니면 true
		next = endPage == tmpEndPage ? false : true;
	}
	public PageMaker(int displayPageNum, Criteria cri, int totalCount) {
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		this.totalCount = totalCount;
		calculate();
	}
}