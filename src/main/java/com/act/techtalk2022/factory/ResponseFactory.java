package com.act.techtalk2022.factory;

import com.act.techtalk2022.controller.response.GeneralResponse;
import com.act.techtalk2022.controller.response.ResponseStatus;
import com.act.techtalk2022.exception.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseFactory {
    public static final String SUCCESS_CODE = "success";

    public static final String SUCCESS_MESSAGE = "Success";

    private ResponseFactory() {
    }

    public ResponseEntity<GeneralResponse<Object>> error(HttpStatus httpStatus, ResponseStatus responseStatus) {
        return error(httpStatus, responseStatus, null, Object.class);
    }

    public <T> ResponseEntity<GeneralResponse<T>> error(HttpStatus httpStatus, ResponseStatus responseStatus, Object data, Class<T> clazz) {
        return createInstance(httpStatus, new StatusInformation(responseStatus.getCode(), responseStatus.getMessage()), data, clazz);
    }

    public ResponseEntity<GeneralResponse<Object>> error(HttpStatus httpStatus, CommonException exception) {
        return error(httpStatus, exception.getCode(), exception.getMessage());
    }

    public ResponseEntity<GeneralResponse<Object>> error(HttpStatus httpStatus, String errorCode, String errorMessage) {
        return createInstance(httpStatus, new StatusInformation(errorCode, errorMessage), null, Object.class);
    }

    public <T> ResponseEntity<GeneralResponse<T>> error(HttpStatus httpStatus, String errorCode, String errorMessage, Object data, Class<T> clazz) {
        return createInstance(httpStatus, new StatusInformation(errorCode, errorMessage), data, clazz);
    }

    public ResponseEntity<GeneralResponse<Object>> success() {
        return createInstance(HttpStatus.OK, new StatusInformation(SUCCESS_CODE, SUCCESS_MESSAGE), null, Object.class);
    }

    public <T> ResponseEntity<GeneralResponse<T>> success(Object data, Class<T> clazz) {
        return createInstance(HttpStatus.OK, new StatusInformation(SUCCESS_CODE, SUCCESS_MESSAGE), data, clazz);
    }

    private static class StatusInformation {
        private final String errorCode;

        private final String errorMessage;

        public StatusInformation(String errorCode, String errorMessage) {
            this.errorCode = errorCode;

            this.errorMessage = errorMessage;

        }

        public String getErrorCode() {
            return errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

    private <T> ResponseEntity<GeneralResponse<T>> createInstance(HttpStatus httpStatus, StatusInformation statusInformation, Object data, Class<T> clazz) {
        GeneralResponse<T> responseObject = new GeneralResponse<>();

        responseObject.setStatus(new ResponseStatus(statusInformation.getErrorCode(), statusInformation.getErrorMessage()));
        responseObject.setData(clazz.cast(data));

        return new ResponseEntity<>(responseObject, httpStatus);
    }
}
