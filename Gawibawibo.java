package javaFund;

import javax.swing.JOptionPane;

public class Gawibawibo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 사용자는 가위, 바위, 보 대신 1, 2, 3을 값으로 낼 수 있음 그럼 프로그램은 이 값을 분석해서 랜덤한 컴퓨터의
		 * 값(Math.random())으로 게임을 진행시키고, 결과를 다음처럼 출력 컴 : 가위, 당신 : 보 컴 승리!
		 * 
		 * 위처럼 결과를 출력 후, 게임을 다시 할건지 물어봄 ex) 계속 할래요? 이때 사용자는 y or n을 입력하게 되고 이에 따라서 게임이
		 * 계속되거나 끝나거나
		 * 
		 * 단, 게임이 끝날때는 총 전적, 승, 패, 무, 승률(소숫점 2째 자리까지)을 출력시키고 게임을 종료
		 */

		int cnt = 0, win = 0, lose = 0, draw = 0; // 총 경기 수, 승, 패
		float winRate; // 승률
		String pc = ""; // pc가 내는 값
		String cont = ""; // 게임을계속 할 지

		do {
			String input = JOptionPane.showInputDialog("게임을 시작함");
			int rnd = (int)(Math.random() * 3) + 1; // 1 ~ 3 랜덤 값
			
			if (rnd == 1) {
				pc = "가위";
			} else if (rnd == 2) {
				pc = "바위";
			} else {
				pc = "보";
			}

			if (input.equals("1")) {
				input = "가위";
			} else if (input.equals("2")) {
				input = "바위";
			} else if (input.equals("3")) {
				input = "보";
			} else {
				while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("가위")
						&& !input.equals("바위") && !input.equals("보")) {
					input = JOptionPane.showInputDialog("올바른 값 입력");
					if (input.equals("1")) {
						input = "가위";
					} else if (input.equals("2")) {
						input = "바위";
					} else if (input.equals("3")) {
						input = "보";
					}
				}
			}

			System.out.printf("컴 : %s, 당신 : %s\n", pc, input);
			
			if(pc.equals(input)) {
				System.out.printf("비김");
				draw++;
				cnt++;
			} else if (pc == "가위") {
				if (input.equals("바위")) {
					System.out.println("당신 승리!");
					win++;
					cnt++;
				} else if(input.equals("보")){
					System.out.println("컴 승리!");
					lose++;
					cnt++;
				}
			} else if (pc == "바위") {
				if (input.equals("가위")) {
					System.out.println("컴 승리!");
					lose++;
					cnt++;
				} else if(input.equals("보")){
					System.out.println("당신 승리!");
					win++;
					cnt++;
				}
			} else if (pc == "보") {
				if (input.equals("가위")) {
					System.out.println("당신 승리!");
					win++;
					cnt++;
				} else if(input.equals("바위")){
					System.out.println("컴 승리!");
					lose++;
					cnt++;
				}
			}
			
			cont = JOptionPane.showInputDialog("계속 할래요?");
			if(!cont.equals("y") && !cont.equals("n")) {
				while(!cont.equals("y") && !cont.equals("n")) {
					cont = JOptionPane.showInputDialog("y 또는 n을 입력해주세요");
				}
			}
		} while (cont.equals("y"));
		
		winRate = (float)win / cnt * 100;
		System.out.printf("총 전적 : %d, 승 : %d, 패 : %d, 무 : %d, 승률 : %.2f\n", cnt, win, lose, draw, winRate);
	}
}