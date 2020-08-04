package com.rambo.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 翟博文 on 2020/7/28 22:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBody<T> {
    private Integer code;
    private String message;
    private T data;

    public ResultBody(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
