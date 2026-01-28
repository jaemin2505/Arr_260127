package javaFund;

import java.util.Arrays;

public class ArrayExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intArr[] = new int[4]; //4개 길이의 int 타입의 배열
		double[] douArr = {1, 2, 3};
		String[] strArr = new String[] {"A", "B", "C"};
		
		//위 구문은 배열 생성식입니다. 기억해두세요
		//배열 객체는 만약 초기값을 주지 않은 상태로 생성하면 각 타입의 기본값으로 자동으로 세팅됨
		//정수는 0, 실수는 0.0, boolean은 false, Object는 null
		
		System.out.println(strArr);
		System.out.println(Arrays.toString(strArr));
		for(int i=0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		//향상된 for
		for(String str : strArr) {
			System.out.println(str); //str 변수가 배열의 리턴되는 값을 자동으로 대입해서 출력
		}
		
		strArr[0] = "hello";
		//intArr[0] = false;
		douArr[0] = 10;
		
//		System.out.println(strArr[strArr.length]);
		
		//다중 배열..배열 내부에 배열을 가지고 있는 형태
		int[] multi[] = new int[2][3];
		multi[0][0] = 10;
		multi[1][2] = 50;
		
		for(int i=0; i<multi.length; i++) {
			for(int j=0; j<multi[i].length; j++){
				System.out.println(multi[i][j]);
			}
		}
		
		//Score.java 파일을 생성해서 아래와 같은 결과를 도출하는 로직을 작성
		/*
		 * 학생의 성적을 국, 영, 수로 입력받아서 총점, 평균, 학점(A, B, C, F) 를 출력하도록 하는 프로그램
		 * 프로그램이 시작되면 각 과목을 입력받도록 하는데, 입력된 점수는 반드시 0~100점 사이여야 함
		 * 만약 이 범위를 벗어나면 해당 과목을 다시 입력받로고 함. 다른 과목의 입력으로 넘어가면 안됨
		 * 
		 * 만약 올바른값이 모두 입력되면, 위 결과를 출력
		 * 
		 * 모든 점수는 배열로 관리되어야 함
		 * 학점은 90점 이상 A, 80 이상 B, 나머진 F처리하는데, switch case 사용
		 */
	}

}
