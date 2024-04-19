package test;

public class Elevator {
	
	// field : 
	private static int lastFl = 0; // 종착 층
	private static int currentFl = 0; // 현재 층
	private static String currentDr = null; // 문 상태
	private static int enterFl = 0; // 현재 입력한 층
	private static String moveDr = null; // 현재 엘리베이터 상태
	// 층 문자열? 배열? class?
	
	
	// constructor : 
	
	// method : 
	public static void goUp(int highestFl) { // lastFloor까지 상승
		lastFl = highestFl;
	}
	
	public static void goDown(int lowestFl) { // lastFloor까지 하강
		lastFl = lowestFl;
	}
	
	public static void stop(int asdf) {
		// currentFl가 움직이면서 층 모임 中 하나랑 값이 같으면 멈춤
	}
	
	// 표시*****
	public static void currentFloor(int currentFl, int lastFl) { // 현재 층 + 상승/하강 표시
		System.out.println(currentFl);
		if(currentFl < lastFl) {
			System.out.println("올라가는 중");
		} else if(lastFl < currentFl) {
			System.out.println("내려가는 중");
		} else {
			System.out.println("표시 X");
		}
	}
	// 표시*****
	public static void selectedFloor() { // 입력 받은 모든 층 표시
		// 층 모임 모두 출력
	}

	public static void openDoor() { // 문 상태 : 열림
		 currentDr = "열림";
	}

	public static void closeDoor() { // 문 상태 : 닫힘
		 currentDr = "닫힘";
	}
	// 층 입력
	public static void enterFloor() { // 층 입력
		// 층 모임 + enterFl
	}
}