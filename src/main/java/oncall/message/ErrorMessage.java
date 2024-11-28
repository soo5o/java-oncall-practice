package oncall.message;

public enum ErrorMessage {
    INVALID_INPUT("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
