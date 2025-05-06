package model;

/**
 * Клас для элементів списка
 * */
public class Item {
    private String value; // значення

    public Item(String value) {
        this.value = value;
    }

    // Метод який повертає значення
    public String getValue() {
        return value;
    }

    // Метод який міняє значення
    // @params нове значення
    public void setValue(String value) {
        //  Перевірна на те, щоб вхідне значення не було пустим
        if (value.isEmpty()) {
            System.out.println("Нічого");
            return;
        }
        this.value = value;
    }
}
