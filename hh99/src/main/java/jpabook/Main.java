package jpabook;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    int[] count = new int[10];
    int[] place = new int[3];
    public static int randomMaker() {
        double dValue = Math.random();
        return (int) (dValue * 10);
    }
    public void match3Random() {
        for (int i =0; i< 3; i++) {
            int num = randomMaker();
            if (this.count[num] > 0 ) {
                --i;
            } else {
                this.count[num] = 1;
                this.place[i] = num;
            }
        }
    }

    public int search(int num) {
        int idx;
        for (idx = 0; idx < this.place.length; idx++) {
            if (this.place[idx] == num) return idx;
        }
        return -1;
    }

    public String checkAnswer(String input) {
        String[] nums = input.split("");
        int strike  = 0;
        int ball = 0;
        for(int i = 0; i < nums.length; i++) {
            int index = this.search(Integer.parseInt(nums[i]));
            if (index >= 0) {
                if (i == index) strike += 1;
                else ball += 1;
            }
        }

        if (ball == 0 && strike == 0) return "0S0B";
        else if (ball == 3) return "3B";
        else if (strike == 3) return "3S";
        return String.format("%dB%dS",ball,strike);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();

        int total_try = 0;
        String status = "";
        main.match3Random();
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        while(true) {
            System.out.printf("%d번째 시도 : ",total_try + 1);
            String input = sc.next();
            status = main.checkAnswer(input);
            System.out.println(status);
            if (status.equals("3S")) {
                break;
            } else {
                total_try += 1;
            }
        }
        System.out.printf("%d번만에 맞히셨습니다%n",total_try);
        System.out.println("게임을 종료합니다");
    }
}