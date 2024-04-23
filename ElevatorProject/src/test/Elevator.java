package test;

public class Elevator {

    // 필드 :
    static int currentFl = 0; // "현재 층"
    private static int minFl = 0; // "최저 층"
    private static int maxFl = 10; // "최고 층"
    private static int[] allFl = new int[maxFl]; // "모든 층 배열"; 1 : 선택된 층
    private static int targetFl = 0; // "목표 층"
    private static Integer[] inputFls = null; // "입력 받은 층들"
    private static Integer[] reInputFls = null; // 엘레베이터 동작 中 inputFls를 재정의한 배열
    private static int reCountFl; // 엘레베이터 동작 中 inputFls를 재정의 할 때 사용하는 변수

    // 게터 :
    public static int getCurrentFl() {
        return currentFl;
    }

    public static int getMinFl() {
        return minFl;
    }

    public static int getMaxFl() {
        return maxFl;
    }

    public static int[] getAllFl() {
        return allFl;
    }

    public static int getTargetFl() {
        return targetFl;
    }

    public static Integer[] getInputFls() {
        return inputFls;
    }

    public static Integer[] getReInputFls() {
        return reInputFls;
    }

    public static int getReCountFl() {
        return reCountFl;
    }

    // 세터 :
    public void setCurrentFl(int currentFl) {
        this.currentFl = currentFl;
    }

    public void setMinFL(int minFl) {
        this.minFl = minFl;
    }

    public void setMaxFl(int maxFl) {
        this.maxFl = maxFl;
    }

    public void setAllFl(int[] allFl) {
        this.allFl = allFl;
    }

    public void setTargetFl(int targetFl) {
        this.targetFl = targetFl;
    }

    public void setInputFls(Integer[] inputFls) {
        this.inputFls = inputFls;
    }

    public void setReInputFls(Integer[] reInputFls) {
        this.reInputFls = reInputFls;
    }

    public void setReCountFl(int reCountFl) {
        this.reCountFl = reCountFl;
    }

    // 기본생성자 :
    // 생성자 :

    // 메써드 :
    public static void selectedFloors(Integer[] inputFls) { // "입력 받은 층들"을 "모든 층 배열"에 1로 입력
        for (int i = 0; i < inputFls.length; i++) {
            allFl[inputFls[i]] = 1;
        }
    }

    public static void printSelectedFloors() { // "모든 층 배열" 출력*****
        System.out.print("[ ");
        for (int i = 0; i < allFl.length; i++) {
            if (allFl[i] == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.print("]" + "\n");
    }

    public static void ascendSetTargetFloor() { // 상승 시 "목표 층" 설정
        for (int i = currentFl; i < maxFl; i++) {
            if (allFl[i] == 1) {
                targetFl = i; // "목표 층" : "입력 받은 층들" 中 최고 층
            }
        }
    }

    public static void descendSetTargetFloor() { // 하강 시 "목표 층" 설정
        for (int i = currentFl; minFl <= i; i--) {
            if (allFl[i] == 1) {
                targetFl = i; // "목표 층" : "입력 받은 층들" 中 최저 층
            }
        }
    }

    public static int ascend() throws InterruptedException { // "현재 층"에서 "목표 층"까지 상승
        System.out.println("\t" + "<올라갑니다>");
        Thread.sleep(250);
        for (int i = currentFl; i <= targetFl; i++) {
            if (allFl[i] == 0) {
                System.out.print("[" + i + " ↑]" + "\t" + "\t" + "\t");
                printSelectedFloors();
                Thread.sleep(250);
            } else {
                System.out.print("[" + i + " ↑]" + "\t" + "\t" + "\t");
                printSelectedFloors();
                Thread.sleep(250);
                alertFl(i);
                door();
            }
        }
        currentFl = targetFl;
        return currentFl;
    }

    public static int descend() throws InterruptedException { // "현재 층"에서 "목표 층"까지 하강
        System.out.println("\t" + "<내려갑니다>");
        Thread.sleep(250);
        for (int i = currentFl; targetFl <= i; i--) {
            if (allFl[i] == 0) {
                System.out.print("[" + i + " ↓]" + "\t" + "\t" + "\t");
                printSelectedFloors();
                Thread.sleep(250);
            } else {
                System.out.print("[" + i + " ↓]" + "\t" + "\t" + "\t");
                printSelectedFloors();
                Thread.sleep(250);
                alertFl(i);
                door();
            }
        }
        currentFl = targetFl;
        return currentFl;
    }

    public static void alertFl(int currentFl) throws InterruptedException { // "목표 층" 도착 알림
        System.out.print("\t" + "<" + currentFl + "층 입니다>" + "\t");
        allFl[currentFl] = 0; // 도착 후, 해당 층 0 대입
        printSelectedFloors();
        Thread.sleep(250);
    }

    public static void door() throws InterruptedException {
        openDoor();
        keepDoorOpen();
        closeDoor();
    }

    public static Integer[] reInputFls(int countFl) { // inputFls를 재정의하는 메써드
        reInputFls = new Integer[countFl];
        for (int i = 0; i < maxFl; i++) {
            if (allFl[i] == 1) {
                reInputFls[reCountFl] = i;
                reCountFl++;
            }
        }
        return reInputFls;
    }

    public static void openDoor() throws InterruptedException { // "문 열림"
        System.out.println("\t" + "<문이 열립니다>" + "\n" + "\t" + "[***|***]");
        Thread.sleep(250);
        System.out.println("\t" + "[**| |**]");
        Thread.sleep(250);
        System.out.println("\t" + "[*|   |*]");
        Thread.sleep(250);
        System.out.print("\t" + "[|     |]");
        Thread.sleep(250);
    }

    public static void keepDoorOpen() throws InterruptedException { // 문을 5초 동안 열린 채로 유지
        System.out.print("\t");
        for (int i = 0; i < 4; i++) {
            System.out.print((" ."));
            Thread.sleep(250);
        }
        System.out.println(" .");
    }

    public static void closeDoor() throws InterruptedException { // "문 닫힘"
        System.out.println("\t" + "<문이 닫힙니다>" + "\n" + "\t" + "[|     |]");
        Thread.sleep(250);
        System.out.println("\t" + "[*|   |*]");
        Thread.sleep(250);
        System.out.println("\t" + "[**| |**]");
        Thread.sleep(250);
        System.out.println("\t" + "[***|***]");
        Thread.sleep(250);
    }
}