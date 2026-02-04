package Ggame;

import java.util.Scanner;

class Game {

    Scanner sc = new Scanner(System.in);

    public void play(Record record) {

        int pc;
        int user;
        String cont = "";

        System.out.println("\n🎮 가위바위보 시작!");

        do {
            System.out.print("가위(1) 바위(2) 보(3) 입력: ");
            String input = sc.nextLine();

            try {
                user = Integer.parseInt(input);
            } catch (Exception e) {
                switch (input) {
                    case "가위": user = 1; break;
                    case "바위": user = 2; break;
                    case "보": user = 3; break;
                    default: user = 4;
                }
            }

            if (user < 1 || user > 3) {
                System.out.println("잘못 입력했습니다!");
                continue;
            }

            pc = (int)(Math.random() * 3) + 1;

            System.out.printf("컴퓨터: %s | 당신: %s\n", toKor(pc), toKor(user));

            if (pc == user) {
                System.out.println("👉 비김");
                record.addDraw();
            }
            else if ((pc == 1 && user == 2) ||
                     (pc == 2 && user == 3) ||
                     (pc == 3 && user == 1)) {
                System.out.println("🎉 당신 승리!");
                record.addWin();
            }
            else {
                System.out.println("💀 컴퓨터 승리!");
                record.addLose();
            }

            System.out.print("계속? (y/n): ");
            cont = sc.nextLine();

        } while (cont.equalsIgnoreCase("y"));

        System.out.println("게임 종료!\n");
    }

    private String toKor(int n) {
        switch (n) {
            case 1: return "가위";
            case 2: return "바위";
            case 3: return "보";
        }
        return "";
    }
}