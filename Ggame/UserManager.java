package Ggame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

class UserManager {
	private final String PATH = "C:\\Temp\\user.txt";
	Scanner sc = new Scanner(System.in);

	public User login(String id) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("비밀번호: ");
	    String pass = sc.nextLine();

	    BufferedReader br = new BufferedReader(new FileReader(PATH));
	    String line;

	    while ((line = br.readLine()) != null) {
	        String[] d = line.split(",");
	        if (d[0].equals(id) && d[1].equals(pass)) {

	            Record r = new Record(
	                Integer.parseInt(d[3]),
	                Integer.parseInt(d[4]),
	                Integer.parseInt(d[5])
	            );

	            br.close();
	            return new User(id, pass, d[2], r);
	        }
	    }
	    br.close();
	    return null;
	}
	
	// 회원가입
	public User register() throws Exception {
	    System.out.println("=== 회원가입 ===");

	    String id;
	    while (true) {
	        System.out.print("이메일: ");
	        id = sc.nextLine();

	        if (!id.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
	            System.out.println("이메일 형식이 아닙니다.");
	            continue;
	        }

	        if (isIdExists(id)) {
	            System.out.println("이미 존재하는 아이디입니다.");
	            continue;
	        }

	        break;
	    }

	    String pass;
	    while (true) {
	        System.out.print("비밀번호: ");
	        pass = sc.nextLine();

	        if (pass.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,12}$")) break;
	        System.out.println("비밀번호 조건: 대문자 + 숫자 + 특수문자 포함 8~12자");
	    }

	    BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
	    bw.write(id + "," + pass + ",-,0,0,0");
	    bw.newLine();
	    bw.close();

	    System.out.println("회원가입 완료");
	    Record r = new Record(0, 0, 0);
	    return new User(id, pass, "-", r);
	}

	// 저장
	public void updateUser(User user) throws Exception {
	    BufferedReader br = new BufferedReader(new FileReader(PATH));
	    StringBuilder sb = new StringBuilder();
	    String line;

	    while ((line = br.readLine()) != null) {
	        String[] data = line.split(",");

	        if (data[0].equals(user.getId())) {
	            data[1] = user.getPassword();
	            data[2] = LocalDateTime.now().toString();  // 로그인 시간 갱신
	            data[3] = String.valueOf(user.getRecord().getWin());
	            data[4] = String.valueOf(user.getRecord().getLose());
	            data[5] = String.valueOf(user.getRecord().getDraw());
	            line = String.join(",", data);
	        }
	        sb.append(line).append("\n");
	    }
	    br.close();

	    BufferedWriter bw = new BufferedWriter(new FileWriter(PATH));
	    bw.write(sb.toString());
	    bw.close();
	}

	public boolean exists(String id) throws Exception {
	    BufferedReader br = new BufferedReader(new FileReader(PATH));
	    String line;
	    while ((line = br.readLine()) != null) {
	        if (line.split(",")[0].equals(id)) {
	            br.close();
	            return true;
	        }
	    }
	    br.close();
	    return false;
	}
	
	private boolean isIdExists(String id) throws Exception {
	    BufferedReader br = new BufferedReader(new FileReader(PATH));
	    String line;

	    while ((line = br.readLine()) != null) {
	        String[] data = line.split(",");
	        if (data[0].equals(id)) {
	            br.close();
	            return true;
	        }
	    }
	    br.close();
	    return false;
	}
}