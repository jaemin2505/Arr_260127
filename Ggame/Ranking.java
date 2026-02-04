package Ggame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ranking {
	static Scanner sc = new Scanner(System.in);
    static String path = "C:\\Temp\\user.txt";

    public static void showRanking() throws Exception {
        List<User> userList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            Record r = new Record(
                Integer.parseInt(data[3]),
                Integer.parseInt(data[4]),
                Integer.parseInt(data[5])
            );

            User u = new User(data[0], data[1], data[2], r);
            userList.add(u);
        }
        br.close();

        System.out.print("1. 승률 높은순  2. 승률 낮은순 : ");
        String sel = sc.nextLine();
        
        if (sel.equals("1")) {
        	userList.sort((a, b) -> Double.compare(b.getRecord().getRate(), a.getRecord().getRate()));
        }else {
        	userList.sort((a, b) -> Double.compare(a.getRecord().getRate(), b.getRecord().getRate()));
        }

        System.out.println("===== 랭킹 =====");

        int rank = 1;
        for (User u : userList) {
            System.out.printf(
                "%d위 | %s | 승:%d 패:%d 무:%d | 승률: %.2f%%\n",
                rank++,
                u.getId(),
                u.getRecord().getWin(),
                u.getRecord().getLose(),
                u.getRecord().getDraw(),
                u.getRecord().getRate()
            );
        }
    }
}