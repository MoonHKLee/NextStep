package com.mf3110;
/*문자열계산기 요구사항
 -문자열계산기의 요구사항은 전달하는 문자를 구분자로 분리한 후 각 숫자의 합을 구해 반환해야 한다.
 -쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 순자의 합을 반환한다.
 ex) ""->0 , "1,2"->3 , "1,2,3"->6 , "1,2:3"->6
 -앞의 기본 구분자 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열의 앞부분의 "//"와 "\n" 사이에
 위치하는 문자를 커스텀 구분자로 사용한다. 예를들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며
 결과값은 6이 반환되어야 한다.
 -문자열 계산기에 음수를 전달하는 경우 RuntimeException 으로 처리해야 한다.

 !곧바로 구현을 시작하지 말고 요구사항을 더 작은 단위로 나눠 테스트 할 경우의 수를 분리해본다.
 구현을 시작하기 전에 작은 단위로 나누는 연습을 해야한다.
 java 공식문서를 보고 String 클래스의 메소드들을 활용하면 문제들을 좀 더 쉽게 해결할 수 있다.
 */

//추가 요구사항
//1개의 메소드에는 1개의 기능만 담는다.
//한 개의 메소드는 한 번의 들여쓰기만 사용한다.
//else문을 사용하지 않는다.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    //메소드를 통해 리턴된 최종 문자열의 숫자의 합
    private int sum;

    //문자열의 배열
    private String[] words;

    //스플릿 된 모든 문자를 다 더하는 메소드
    public int add(String inputString){
        sum=0;
        //문자열이 비어 있을 때
        if(inputString==""||inputString==null){
            return 0;
        }

        //커스텀 문자를 기준으로 문자열 스플릿
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if(matcher.find()){
            words=split(matcher.group(2),matcher.group(1));
            for (int i = 0; i < words.length; i++) {
                int num = Integer.parseInt(words[i]);
                sum += num;
            }
            return sum;
        } else {
            //(,|:)를 기준으로 문자열 스플릿
            words = split(inputString, ",|:");
            for (int i = 0; i < words.length; i++) {
                int num = Integer.parseInt(words[i]);
                sum += num;
            }
            return sum;
        }
    }

    //매개변수를 기준으로 문자열을 스플릿 하는 메소드
    public String[] split(String input,String customDelimeter){
        String words[]  = input.split(customDelimeter);
        return words;
    }

    //커스텀 구분자를 반환하는 메소드
//    public String getDelimeter(){
//        String customDelimeter = this.matcher.group(0);
//        return customDelimeter;
//    }
}