package io.github._0AndWild;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {

    /**
     * <pre>
     *  사용가능한 특수문자 이외의 특수문자가 있는지 검사하는 메서드
     * </pre>
     * @param s - 검사할 String
     * @param specialCharacters - 포함가능한 특수문자, 특수문자를 []에 감싸서 입력 ex) "[!@#$^&+]"
     */

    public static boolean validateSpecialCharacters(String s, String specialCharacters){
        boolean result = true;
        Pattern pattern = Pattern.compile("\\W");
        Pattern isOkPattern = Pattern.compile(specialCharacters);
        String removeEmptySpace = s.replace(" ", "");

        for (int i = 0; i < removeEmptySpace.length(); i++) {
            String character = String.valueOf(removeEmptySpace.charAt(i));
            Matcher matcher = pattern.matcher(character);
            if (matcher.find()) {
                Matcher checkPattern = isOkPattern.matcher(character);
                if (!checkPattern.find()) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

}
