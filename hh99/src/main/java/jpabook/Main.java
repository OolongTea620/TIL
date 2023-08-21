package jpabook;


import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public int solution16(int[] absolutes, boolean[] signs) {
        int answer = 0;

        answer = IntStream.range(0, absolutes.length)
                .map(index -> signs[index] ? absolutes[index] : absolutes[index] * -1)
                .sum(); 
        

        return answer;
    }
    public String solution17(String phone_number) {
        String answer = "";

        int length = phone_number.length();
        int repeat = length - 4; // * 반복할 갯수
        answer += "*".repeat(repeat);
        answer += phone_number.substring(length - 4,length);
        return answer;
    }

    public int solution18(int[] numbers) {
        int answer;
        int init = 45; // 왜 45인지는 생략 
        int sub = Arrays.stream(numbers).distinct().sum();
        answer = init - sub;
        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.solution17("01033334444"));

    }

}