package test;

import java.util.Arrays;
import java.util.Collections;

public class Elevator {
    private int currentFloor;
    private Direction direction;
    private final int MAX_FLOORS = 15;
    private final int MIN_FLOORS = 1;
    private Integer[] floors;

    public void setFloors(Integer[] floors) {
        this.floors = floors;
    }

    public Elevator() {
        currentFloor = 1;
        direction = Direction.NONE;
    }

    public void move(Integer[] floors) {
        setFloors(floors);

        if(direction == Direction.UP){
            Arrays.sort(this.floors);
        } else if(direction == Direction.DOWN){
            Arrays.sort(this.floors, Collections.reverseOrder());
        }

        for (int floor : this.floors) {
            if (floor > currentFloor && floor <= MAX_FLOORS) {
                if (direction == Direction.DOWN) {
                    System.out.println("엘리베이터가 내려가는 중입니다, 올라갈 수 없습니다.");
                    continue;
                }
                moveUp(floor, floors);
            } else if (floor < currentFloor && floor >= MIN_FLOORS) {
                if (direction == Direction.UP) {
                    System.out.println("엘리베이터가 올라가는 중입니다, 내려갈 수 없습니다.");
                    continue;
                }
                moveDown(floor, floors);
            } else if (floor == currentFloor) {
                System.out.println("이미 " + currentFloor + "층입니다.");
            } else {
                System.out.println("잘못된 층입니다: " + floor);
            }
        }
    }

    private void moveUp(int targetFloor, Integer[] floors) {
        direction = Direction.UP;
        while (currentFloor < targetFloor) {
            currentFloor++;
            System.out.println(currentFloor + "층.....");
            if (currentFloor == MAX_FLOORS) {
                if (hasMoreFloorsToVisitInDirection(targetFloor, Direction.UP)) {
                    initializeArray();
                    break;
                } else{
                    direction = Direction.DOWN;
                }
            }
            if (Arrays.asList(floors).contains(currentFloor)) {
                stopAtFloor(currentFloor);
            }
        }
    }

    private void moveDown(int targetFloor, Integer[] floors) {
        direction = Direction.DOWN;
        while (currentFloor > targetFloor) {
            currentFloor--;
            System.out.println(currentFloor + "층.....");
            if (currentFloor == MIN_FLOORS) {
                if (hasMoreFloorsToVisitInDirection(targetFloor, Direction.DOWN)) {
                    initializeArray();
                    break;
                }
                direction = Direction.UP;
            }
            if (Arrays.asList(floors).contains(currentFloor)) {
                stopAtFloor(currentFloor);
            }
        }
    }

    private boolean hasMoreFloorsToVisitInDirection(int targetFloor, Direction dir) {
        if (dir == Direction.UP) {
            return Collections.max(Arrays.asList(floors)) > targetFloor;
        } else if (dir == Direction.DOWN) {
            return Collections.min(Arrays.asList(floors)) < targetFloor;
        }
        return false;
    }

    private void initializeArray() {
        floors = new Integer[0];
    }

    private void stopAtFloor(int floor) {
        openDoor();
        closeDoor();
        displayCurrentFloorAndDirection();
    }

    private void openDoor() {
        System.out.println(currentFloor + "층입니다. " + "문이 열립니다...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void closeDoor() {
        System.out.println("문이 닫힙니다...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void displayCurrentFloorAndDirection() {
        System.out.print(currentFloor + "층입니다.");
        if (direction.equals(Direction.UP)) {
            System.out.println("올라갑니다.");
        } else if(direction.equals(Direction.DOWN)){
            System.out.println("내려갑니다.");
        }
    }
}
