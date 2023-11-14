package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final static String READ_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final static String READ_MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private final static String COMMA_DELIMITER = ",";

    public InputView() {
    }

    public int readDate() {
        System.out.println(READ_DATE_MESSAGE);
        String date = Console.readLine();
        InputValidator.validateNumeric(date);

        return Integer.parseInt(date);
    }

    public List<String> readMenu() {
        System.out.println(READ_MENU_MESSAGE);
        String menus = Console.readLine();
        InputValidator.validateMenuPattern(menus);

        return Arrays.asList(menus.split(COMMA_DELIMITER));
    }

}
