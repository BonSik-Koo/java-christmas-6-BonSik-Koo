package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String READ_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public int readDate() {
        System.out.println(READ_DATE_MESSAGE);
        String date = Console.readLine();
        InputValidator.validateNumeric(date);

        return Integer.parseInt(date);
    }

}
