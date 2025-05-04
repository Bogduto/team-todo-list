package schemas;

/**
 * Клас, який представляє задачу у списку TODO.
 * Містить інформацію про ідентифікатор задачі, дату її створення та опис.
 */
public class Task {
    private String value; // Опис задачі
    private String createdAt; // Дата та час створення задачі
    private boolean isActive; // Активність задачі
    /**
     * Конструктор класу Task.
     *
     * @param createdAt Дата та час створення задачі
     * @param value     Опис задачі
     * @param isActive  Активність задачі
     */
//    public Task(String id, String createdAt, String value, Boolean isActive) {
//        this.id = id;
//        this.createdAt = createdAt;
//        this.value = value;
//        this.isActive = isActive;
//    }

    public Task(boolean isActive, String createdAt, String value)
    {
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.value = value;
    }

    /**
     * Отримати опис задачі.
     *
     * @return Опис задачі
     */

    public String getValue() {
        return value;
    }

    /**
     * Змінює опис задачі на нове значення.
     *
     * @param value новий опис задачі.
     */

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Отримати дату та час створення задачі.
     *
     * @return Дата та час створення задачі
     */
    public String getCreatedAt() {
        return createdAt;
    }

/**
     * Метод, який повертає активність задачі
     *
     * @return активність задачі
     */
    public Boolean getIsActive() {
        return isActive;
    }


    /**
     * Перемикає стан активності.
     * Якщо об'єкт був активним — стане неактивним, і навпаки.
     */
    public void setIsActive() {
        this.isActive = !this.isActive;
    }

    /**
     * Переоприділений метод toString для повернення текстового представлення задачі.
     *
     * @return Текстове представлення задачі
     */
    @Override
    public String toString()
    {
        return "Task{" +
                "value='" + value + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
