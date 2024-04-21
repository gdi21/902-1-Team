package test;

import java.util.Arrays;
import java.util.Scanner;

public class ElevatorMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Elevator elevator = new Elevator();

        System.out.println("===========================================");
        System.out.println("             엘리베이터 프로그램             ");
        System.out.println("===========================================");

        while (true) {
            System.out.print("층수를 comma로 구분해 입력하세요.(or -1 to exit): ");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                System.out.println("엘리베이터 시스템을 종료합니다.");
                break;
            }

            String[] floorStrings = input.split(",");
            Integer[] floors = new Integer[floorStrings.length];
            int index = 0;
            boolean validInput = true;
            for (String floorStr : floorStrings) {
                floorStr = floorStr.trim();
                if (!InputValidator.validateInput(floorStr)) {
                    System.out.println("잘못된 입력: " + floorStr + ". 1~15의 정수로만 입력하세요.");
                    validInput = false;
                    break;
                }
                int floor = Integer.parseInt(floorStr);
                floors[index++] = floor;
            }

            if (validInput) {
                Integer[] validFloors = Arrays.copyOf(floors, index);
                elevator.move(validFloors);
            }
        }

        scanner.close();
    }
}
