package christmas.view;

import static christmas.view.ViewConstant.COMMA_DELIMITER;
import static christmas.view.ViewConstant.READ_DATE_MESSAGE;
import static christmas.view.ViewConstant.READ_MENU_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.MenuInfo;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public InputView() {
    }

    public int readDate() {
        System.out.println(READ_DATE_MESSAGE);
        String date = Console.readLine();
        InputValidator.validateNumeric(date);

        return Integer.parseInt(date);
    }

    public List<MenuInfo> readMenu() {
        System.out.println(READ_MENU_MESSAGE);
        String menus = Console.readLine();
        InputValidator.validateMenuPattern(menus);

        return toMenuInfos(menus);
    }

    private List<MenuInfo> toMenuInfos(String menu) {
        List<String> menus = Arrays.asList(menu.split(COMMA_DELIMITER));
        return menus.stream()
                .map(MenuInfo::from)
                .collect(Collectors.toList());
    }

}
