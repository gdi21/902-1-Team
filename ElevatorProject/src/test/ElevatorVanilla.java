package test;

public class ElevatorVanilla {

	public static void main(String[] args) {

		/*
		 * 발표 :
		 * - 프로그램의 목표 명시
		 * - (명사) 필드 설명
		 * - (동사) main class + method (의 짜임)
		 */

		/*
		 * 엘리베이터 제어 프로그램 : *****************층을 입력받고, 해당 층까지 확실하게 이동하고, 정지(하고, 문을 열고
		 * 닫음)*****************
		 * 기능 :
		 * 1. 엘리베이터 작동
		 * 1.1. 상승 > 눌려진 최고 층 수에 도달할 때까지 무조건 상승 유지
		 * 1.2. 하강 > "
		 * 1.3. 멈춤
		 * for문도 가능
		 * 2. 문 작동
		 * 2.1. 열림
		 * 2.1.1. 열림 버튼
		 * 2.2. 닫힘
		 * 2.2.1. 닫힘 버튼
		 * 4. 층 수 입력 받음
		 * 4.1. 입력 받은 층 수 표시***
		 * StringBufferexample > append + 입력 + 공백으로 저장
		 * > 공백 기준 서치/트림
		 * O 5. 현재 층수 표시
		 * O 5.1. 상승, 하강 여부 표시***
		 * 
		 * (6. 스피커
		 * 6.1. 층 도착 알림
		 * 6.2. 문 개폐 알림
		 * 6.3. 상승/하강 알림)
		 * (7. 비상호출
		 * > 정지 + 관리실 호출 + 통화)
		 * 출력 : ***
		 * 
		 * 입력 可한 타입 : only int
		 */
	}
}
/*
 * (모든 동작 사이에 1초간 sleeping)
 * 
 * 필드 :
 * - "현재 층"
 * - "방금 입력 받은 층"
 * - "모든 층" : 배열
 * 각 층-1의 i에 0으로 초기화 : [0] <> 이중배열 : [층][0] ex) [-1][0] ~ [5][1]
 * - "층 확인" = 0;
 * 메써드:
 * - "입력 받기"
 * 숫자 : 층 < 언제든지 입력 받을 수 있어야 함 *****
 * 열림, 닫힘 버튼 : 상승, 하강 중에는 입력 무시
 * - "상승" / "하강" / "정지" / "일시정지" / "층 검색"
 * "상승" / "하강" : "출력" + 올라/내려갑니다
 * "일시정지" : "문 출력" + 문 5초간 열림(*~*****)
 * "상승 층 검색" : "상승" 中 위로 "층 확인" = 1인 더 큰 i를 찾고 없으면 상승 종료 > "하강 층 검색"
 * "하강 층 검색" : "하강" 中 아래로 "층 확인" = 1인 더 작은 i를 찾고 없으면 하강 종료 > "상승 층 검색"
 * "정지" : "입력 받기" 대기
 * - "출력" : "현재 층" + 상승/하강 방향, "입력 받은 모든 층"
 * - "문 출력" : 문이 열립니다 + \n + [****] ~ [* *] ~ [ ] + \n + 문이 닫힙니다
 * 
 * 1. 최대/최소 층(0) 초기화 *****
 * let) 해당하는 배열의 위치 : i
 * 2. "방금 입력 받은 층"의 i에 1 대입
 * 3. "방금 입력 받은 층"이 "현재 층"보다 높으면 "상승" 메써드 실행; 낮으면 "하강" 메써드 실행
 * "현재 층"의 i에서 "방금 입력 받은 층"의 i까지 for문 실행 :
 * i가 1일 때 까지 매초 "출력"
 * "방금 입력 받은 층" 매초 갱신 + 배열의 i에 대입
 * 4. "일시정지" : i가 1이면 0으로 바꿈
 * "상승" 中 : "상승 층 검색"; 없으면 "하강 층 검색"
 * "하강" 中 : "하강 층 검색"; 없으면 "상승 층 검색"
 * 둘 다 없으면 "정지"
 * 
 */