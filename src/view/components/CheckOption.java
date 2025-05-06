package view.components;

public class CheckOption {
    private String Label;
    private String value;
    private boolean status;

    public CheckOption(String Label, String value, boolean status) {

        this.Label = Label;
        this.value = value;
        this.status = status;
    }

    public String getLabel() {
        return Label;
    }

    public String getValue() {
        return value;
    }

    public boolean isStatus() {
        return status;
    }
}
