package test;

import java.util.Scanner;

public class ElevatorMain {

    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);

        String input = null; // comma로 구분해 입력 받은 층들
        String[] _inputFls = null; // 입력 받은 층들을 comma로 구분해 입력한 String 배열
        Integer[] inputFls = null; // 입력 받은 층들을 comma로 구분해 입력한 Integer 배열
        int currentFl = 0;
        int targetFl = 0;
        int countFl = 0; // "입력 받은 층 개수"
        Integer[] reInputFls = null; // 엘레베이터 동작 中 inputFls를 재정의한 배열

        Elevator.door();

        while (true) {
            System.out.print("[" + Elevator.getCurrentFl() + " -]" + "\t" + "\t" + "\t" + "(comma로 구분해 층을 입력하세요) ");

            input = scan.next();
            _inputFls = input.split(",");

            inputFls = new Integer[_inputFls.length];

            for (int i = 0; i < _inputFls.length; i++) {
                inputFls[i] = Integer.parseInt(_inputFls[i]);
            }

            targetFl = inputFls[0]; // 가장 먼저 입력 받은 층 기준으로 상승/하강 정함

            countFl = 1; // 0일 때 while문을 탈출해야 하므로 1로 초기화

            move: while (countFl != 0) { // 목표 층 방향으로 우선 이동하고, 남은 층이 있으면 그 방향으로 다시 이동
                if (currentFl < targetFl) {
                    Elevator.selectedFloors(inputFls);
                    Elevator.ascendSetTargetFloor();
                    currentFl = Elevator.ascend();
                } else if (targetFl < currentFl) {
                    Elevator.selectedFloors(inputFls);
                    Elevator.descendSetTargetFloor();
                    currentFl = Elevator.descend();
                }

                countFl = 0; // 남은 "입력 받은 층 개수"를 세기 위해 0 대입

                for (int i = 0; i < Elevator.getAllFl().length; i++) {
                    if (Elevator.getAllFl()[i] != 0) {
                        countFl += Elevator.getAllFl()[i]; // 남은 "입력 받은 층 개수"
                    }
                }

                if (countFl == 0) { // 남은 "입력 받은 층 개수"가 없으면
                    break move; // 정지
                } else {
                    for (int i = 0; i < Elevator.getAllFl().length; i++) {
                        if (Elevator.getAllFl()[i] == 1) {
                            targetFl = i; // 남은 "입력 받은 층 개수"가 있으면, allFl[]를 아래에서부터 찾아 첫번째를 targetFl에 대입
                        }
                    }
                }
                inputFls = Elevator.reInputFls(countFl);
            }
        }
    }
}