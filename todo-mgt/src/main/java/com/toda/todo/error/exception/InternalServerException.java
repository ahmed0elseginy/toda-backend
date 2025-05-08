package com.toda.todo.error.exception;


import com.toda.todo.error.interfaces.Errors;
import lombok.Getter;

@Getter
public class InternalServerException extends AppException {

    public InternalServerException(Errors<?, ?> error) {
        super(error);
    }

    public InternalServerException(Errors<?, ?> error, Object... args) {
        super(error, args);
    }
}
