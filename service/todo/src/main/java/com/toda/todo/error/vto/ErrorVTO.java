package com.toda.todo.error.vto;//package com.toda.todo.error.vto;
//
//
//import com.toda.todo.error.interfaces.Errors;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import java.text.MessageFormat;
//import java.util.List;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class ErrorVTO {
//    private String code;
//    private String domain;
//    private String message;
//    private List<FormError> formErrors;
//
//    public static ErrorVTO of(Errors<?, ?> error) {
//        return ErrorVTO.builder().code(error.code()).domain(error.domain().name()).message(error.defaultMessage()).build();
//    }
//
//    public static ErrorVTO of(Errors<?, ?> error, Object[] args) {
//        return ErrorVTO.builder().code(error.code()).domain(error.domain().name())
//                .message(MessageFormat.format(error.defaultMessage(), args)).build();
//    }
//}
