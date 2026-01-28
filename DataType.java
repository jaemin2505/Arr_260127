package javaFund;

/*
 * 자바의 데이터 타입 : 크게 Ptype(기본 자료형), Rtype(객체형)으로 나뉩니다.
 * 기본 자료형은 다시 Data의 성격에 따라서 이래처럼 구분됩니다.
 * 
 * 정수형
 * byte(1byte 크기), short(2byte), int(4byte - default), long(8byte)
 * 
 * 실수형
 * float(4byte), double(8byte default)
 * 
 * 논리형
 * boolean
 * 
 * 문자형(문자열 아님..문자 하나만 담을 수 있는 타입, 내부적으로 정수형을 취함)
 * char(2byte)
 * 
 * 위에 나열한 타입 외에는 전부 Rtype 즉 객체형 타입. ex) String객체
 */
public class DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte b = 125;
		int i = 123456;

		// 기억하세요. 자바에서 리터럴 데이터가 연산을 사게 될 때는 반드시 해당 값의 default 타입의 메모리를 먼저 생성하고 값을 넣은 후
		// 연산을 하게 됩니다.
		// 이때 연산자 피연산항의 타입의 크기가 서로 틀릴 경우엔, 큰 타입으로 변환되어 결과를 나타냅니다

		// b = b + 1; // 1은 int(default)로 생성되어서 오류가 뜸
		i = b + 1;

		long lo = 1L;
		// int in = lo + 1; // 1이 long으로 생성되기 때문에 int로 받지 못함
		long in = lo + 1;

		// casting 연산자 : 우측의 데이터 타입을 지정된 타입으로 강제 형 변형 시키는 연산자
		// 우측 항 하나에만 적용됨
		int it = (int) in + 1; // int it = (int)(l + 1);

		// float : 4byte 정수타입
		float f = 3.14f;

		f = in;
		in = (long) f;

		double d = 3.14;

		double dd = d + 1;

		/*
		 * 과수원을 한다고 가정 배, 오렌지, 사과를 하루에 5, 7, 4개 생산 하루를 기준으로 시간당 총 생산량을 출력 단, 한번의 리터럴데이터와
		 * 캐스팅 연산자 사용
		 */
		int pear = 5;
		int orange = 7;
		int apple = 4;
		int total = pear + orange + apple;
		float avg = (float) (total / 24.0);
		System.out.println("시간당 총 생산량" + avg);

		//문자형 데이터 char
		//''를 이용해서 문자 하나만을 담을 수 있음
		char ch1 = 'a';
		char ch2 = '가';
		
		//Unicode 문자셋을 이용. 때문에 내부적으로는 정수형으로 사용
		ch1 = ++ch1;
		System.out.println(ch1);
		//unicode는 0~65535까지의 문자 주소를 사용하므로, char는 모든 음수를 표현할 수 없음
		//ch2 = -1;
		int chInt = ch1;
		System.out.println(chInt);
		System.out.println((char)chInt);
		
		//논리형 boolean : true or false만 가능
		
		boolean run = true;
		boolean isStop = false;
		
		//println() : 파라미터로 주어지는 값을 콘솔에 출력하는 메소드
		//모든 데이터 타입(Rtype 포함)을 파라미터로 받을 수 있고, 값을 출력
		//리터럴과 변수는 + 를 이용해서 연결한다
		//\를 이용해서 escape문자 사용 가능
		String myName = "김재민";
		System.out.println("안녕하세요 \n\t" + myName + "님");
		
		//printf(포멧 출력)
		//특정 포멧대로 출력을 지원하는 콘솔 출력 메서드
		//%b boolean 형식, %0d : 정수, %o : 8진수 정수, %x : 16진수, %f : 소수점, %c : 문자형식, %s : 문자열 형식
		
		int age = 24; String addr = "강원도";
		System.out.printf("내 나이는 %d 입니다 %n", age);
		System.out.printf("내 나이는 %d 이고, 주소는 %s 입니다 %n", age, addr);
		
		//자리수 지정 여부에 따른 결과
		System.out.printf("자리수 미지정 : %04d%n", 1);
		System.out.printf("자리수 미지정 : %04d%n", 10);
		System.out.printf("자리수 미지정 : %04d%n", 100);
		System.out.printf("자리수 미지정 : %04d%n", 1000);
		
		//소숫점 표현법 : 자릿수로 소숫점 자릿수를 지정할 수 있음
		float ff = 1.23456f;
		System.out.printf("소숫점 자릿수 지정 : %.3f%n", ff);
		
		int year = 2020;
		boolean leapYear = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
		System.out.println(leapYear);
	}

}
