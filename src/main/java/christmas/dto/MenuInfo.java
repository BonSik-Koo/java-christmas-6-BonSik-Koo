package christmas.dto;

public class MenuInfo {
    private final static String HYPHEN = "-";
    private final String name;
    private final int amount;

    public MenuInfo(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public static MenuInfo from(String menus) {
        String[] menuInfo = menus.split(HYPHEN);
        return new MenuInfo(menuInfo[0], Integer.parseInt(menuInfo[1]));
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

}
