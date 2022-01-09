package org.byron4j.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseVO<T> {
    private T data;
    private int code;
    private String msg;

    public static ResponseVO ofSuccess(){
        return ResponseVO.builder().code(HttpStatus.OK.value()).msg(HttpStatus.OK.name()).build();
    }
}
