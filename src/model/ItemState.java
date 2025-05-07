package model;

public class ItemState extends Item {
    private boolean isChecked;
    private String id;
    public ItemState(String id, String value, Boolean isChecked) {
        super(value);
        this.isChecked = (isChecked != null) ? isChecked : false;
        this.id = id;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public String getId() {
        return id;
    }
}
