package test;

import java.util.Arrays;
import java.util.Collections;

public class Elevator {
	//필드
    private int currentFloor;
    private Direction direction;
    private final int MAX_FLOORS = 15;
    private final int MIN_FLOORS = 1;
    private Integer[] floors;

    //setter
    public void setFloors(Integer[] floors) {
        this.floors = floors;
    }

    //생성자
    public Elevator() {
        currentFloor = 1;
        direction = Direction.UP;
    }

    //메서드
    
    //이동의 총괄메서드
    public void move(Integer[] requestedFloors) throws InterruptedException {
        setFloors(requestedFloors);
    
        sortFloors();
    
        for (int floor : this.floors) {
            if (floor > currentFloor && floor <= MAX_FLOORS) {
                handleMoveUp(floor);
            } else if (floor < currentFloor && floor >= MIN_FLOORS) {
                handleMoveDown(floor);
            } else if (floor == currentFloor) {
                System.out.println("이미 " + currentFloor + "층입니다.");
            } else {
                System.out.println("잘못된 층입니다: " + floor);
            }
        }
    }

    
    //입력된 층수를 저장한 배열을 정렬
    private void sortFloors() {
        if (direction == Direction.UP) {
            Arrays.sort(this.floors);
        } else if (direction == Direction.DOWN) {
            Arrays.sort(this.floors, Collections.reverseOrder());
        }
    }
    
    //상승 핸들
    private void handleMoveUp(int targetFloor) throws InterruptedException {
    	System.out.println("올라갑니다");
        direction = Direction.UP;
        moveElevator(targetFloor);
    }
    
    //하강 핸들
    private void handleMoveDown(int targetFloor) throws InterruptedException {
    	System.out.println("내려갑니다");
        direction = Direction.DOWN;
        moveElevator(targetFloor);
    }

    
    //이동 기능을 구현한 메서드
    private void moveElevator(int targetFloor) throws InterruptedException {
        while (currentFloor != targetFloor) {
            if (direction == Direction.UP) {
                currentFloor++;
            } else if (direction == Direction.DOWN) {
                currentFloor--;
            }
    
            System.out.println(currentFloor + "층.....");
            // Thread.sleep(1000); // Uncomment this line if you want to add a delay
    
            if (Arrays.asList(floors).contains(currentFloor)) {
                stopAtFloor(currentFloor);
            }
    
            if (currentFloor == floors[floors.length - 1]) {
                initializeArray();
                direction = Direction.NONE;
                break;
            }
    
            if (currentFloor == MAX_FLOORS) {
                direction = Direction.DOWN;
                initializeArray();
                break;
            }
    
            if (currentFloor == MIN_FLOORS) {
                direction = Direction.UP;
                initializeArray();
                break;
            }
        }
    }

    //배열 초기화 메서드
    private void initializeArray() {
        floors = new Integer[0];
    }

    //멈춤 메서드
    private void stopAtFloor(int floor) {
        openDoor();
        closeDoor();
        displayCurrentFloorAndDirection();
    }

    //문 열림
    private void openDoor() {
        System.out.println(currentFloor + "층입니다. " + "문이 열립니다...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //문 닫힘
    private void closeDoor() {
        System.out.println("문이 닫힙니다...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //현재 층수 출력
    private void displayCurrentFloorAndDirection() {
        System.out.println("현재 층수: " + currentFloor + "층");
    }
}
