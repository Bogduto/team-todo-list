package model;

public class ItemState extends Item {
    private boolean isChecked;

    public ItemState(String value) {
        super(value);
        this.isChecked = false;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void toggleChecked() {
        this.isChecked = !this.isChecked;
    }
}
