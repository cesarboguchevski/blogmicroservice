package br.com.blogMicroservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum implements  ErrorCode {
    ERROR_LISTALL_SELECTION_PROCESS("error.list.all.selection.process"),
    ERROR_SEARCHING_SELECTION_PROCESS("error.searching.selection.process")
    ;

    private final String messageKey;
}
