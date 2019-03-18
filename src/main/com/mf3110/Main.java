package com.mf3110;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("계산 할 문자열을 입력하세요:");
        Scanner scan = new Scanner(System.in);
        String inputString=scan.next();//아마도 여기서 입력받는 부분에서 문제가 생긴것 같은데 왜 문제가 발생한지는 모르겠다.
        //테스트케이스를 작성해서 테스트를 돌려 본 결과에서는 이상이 없는데 메인함수에서
        //문자열을 입력받아 해결하는 과정에서 문자가 생긴다.
        StringCalculator cal = new StringCalculator();
        System.out.println(cal.add(inputString));
    }
}
