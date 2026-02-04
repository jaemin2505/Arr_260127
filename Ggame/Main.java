package Ggame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager();
        User currentUser = null;

        String id;
        while (true) {
            System.out.print("로그인 하세요\n아이디(이메일) 입력: ");
            id = sc.nextLine();

            if (id.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
                break;

            System.out.println("이메일 형식이 아닙니다");
        }
        
        if (userManager.exists(id)) {
            // 기존 회원 로그인
            currentUser = userManager.login(id);
            if (currentUser == null) {
                System.out.println("비밀번호 틀림");
                return;
            }
        } else {
            // 신규 회원 회원가입
            System.out.println("처음 사용자입니다");
            currentUser = userManager.register();
        }

        boolean run = true;

        while (run) {
            System.out.println("\n===== 메뉴 =====");
            System.out.println("1. 로그아웃");
            System.out.println("2. 게임 시작");
            System.out.println("3. 내 전적 보기");
            System.out.println("4. 전체 랭킹 보기");
            System.out.println("5. 비밀번호 변경");
            System.out.print("선택: ");

            String menu = sc.nextLine();

            switch (menu) {
                case "1": // 로그아웃
                    userManager.updateUser(currentUser);
                    System.out.println("로그아웃");
                    run = false;
                    break;

                case "2": // 게임 시작
                    Game game = new Game();
                    game.play(currentUser.getRecord());
                    break;

                case "3": //내 전적
                    Record r = currentUser.getRecord();
                    System.out.printf("전적: %d승 %d패 %d무 | 승률: %.2f%%\n",
                            r.getWin(), r.getLose(), r.getDraw(), r.getRate());
                    break;

                case "4": //전체 랭킹(승률별 오름/내림차순으로)
                    Ranking.showRanking();
                    break;

                case "5": //비밀번호 변경
                    String newPass;

                    while (true) {
                        System.out.print("새 비밀번호 입력: ");
                        newPass = sc.nextLine();

                        if (newPass.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,12}$")) break;
                        System.out.println("비밀번호 조건: 대문자 + 숫자 + 특수문자 포함 8~12자");
                    }

                    currentUser.setPassword(newPass);
                    userManager.updateUser(currentUser);
                    System.out.println("비밀번호 변경 완료!");
                    break;

                default:
                    System.out.println("잘못된 입력");
            }
        }
        sc.close();
    }
}
