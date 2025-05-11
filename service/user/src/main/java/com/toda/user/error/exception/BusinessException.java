package com.toda.user.error.exception;

import com.toda.user.error.interfaces.Errors;
import lombok.Getter;

@Getter
public class BusinessException extends AppException {

    public BusinessException(Errors<?, ?> error) {
        super(error);
    }

    public BusinessException(Errors<?, ?> error, Object... args) {
        super(error, args);
    }
}
