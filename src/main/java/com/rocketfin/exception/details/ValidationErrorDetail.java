package com.rocketfin.exception.details;

public class ValidationErrorDetail extends ErrorDetails {

    private String field;
    private String fieldMessage;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public void setFieldMessage(String fieldMessage) {
        this.fieldMessage = fieldMessage;
    }

    public ValidationErrorDetail() {
    }

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String message;
        private String field;
        private String fieldMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder fieldMessage(String fieldMessage) {
            this.fieldMessage = fieldMessage;
            return this;
        }

        public ValidationErrorDetail build() {
            ValidationErrorDetail validationErrorDetail = new ValidationErrorDetail();
            validationErrorDetail.setTitle(title);
            validationErrorDetail.setStatus(status);
            validationErrorDetail.setDetail(detail);
            validationErrorDetail.setTimestamp(timestamp);
            validationErrorDetail.setMessage(message);
            validationErrorDetail.setField(field);
            validationErrorDetail.setFieldMessage(fieldMessage);
            return validationErrorDetail;
        }
    }

}
