package day19;

public class Ex01_String {

	public static void main(String[] args) {

		//주어진 문자열에서 검색어가 몇 번 들어가있는지 확인하는 코드를 작성하세요
		String str = "abcabcaaabcadfasabababcadab";
		String search = "ab";
		
		/* tmp에 str을 저장
		 * 
		 * 반복 : index가 -1이 되면 종료
		 * tmp에서 search가 몇번지에 있는지 확인 : index
		 * index가 0이상이면 index + 1번지부터 부분문자열을 추출해서 tmp에 저장.
		 * count를 1증가
		 * */
		
		String tmp = str;
		
		int index = -1, count = 0;
		
		do {
			index = tmp.indexOf(search);
			if(index != -1) {
				count++;
				int pos = index + search.length(); //검색어를 제외하고 추출할 문자열의 시작 위치
				//추출할 문자열이 없으면
				if(pos >= tmp.length()) {
					index = -1;
					continue;
				}
				tmp = tmp.substring(pos);
			}
			
		}while(index != -1);
		System.out.println(str + "에 " + search + "가 " +count + "번 있습니다.");
	}

}
