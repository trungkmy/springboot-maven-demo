package com.act.techtalk2022.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStatus implements Serializable {
    public static final String SUCCESS_CODE = "success";
    public static final String SUCCESS_MESSAGE = "Success";
    public static final String GENERAL_ERROR = "error";

    private static final long serialVersionUID = 3606330944680588781L;

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (ObjectUtils.isEmpty(object) || getClass() != object.getClass()) {
            return false;
        }

        ResponseStatus that = (ResponseStatus) object;
        return Objects.equals(code, that.code) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }
}
