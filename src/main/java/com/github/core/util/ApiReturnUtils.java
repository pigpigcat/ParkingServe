package com.github.core.util;

import com.github.core.domain.ApiReturnObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wulitech
 */
public class ApiReturnUtils implements Serializable {

    private static final long serialVersionUID = -447055943147737686L;

    public static ApiReturnObject error(Object errorMessage) {
        System.out.println(errorMessage);
        List<Object> object = new ArrayList<>();
        return new ApiReturnObject("01", errorMessage, object);
    }

    public static ApiReturnObject error(Object errorMessage, Object returnObject) {
        List<Object> object = new ArrayList<>();
        object.add(returnObject);
        return new ApiReturnObject("01", errorMessage, object);
    }

    public static ApiReturnObject success(Object returnObject) {
        if (returnObject instanceof java.util.List) {
            return new ApiReturnObject("00", "success", returnObject);
        } else {
            List<Object> object = new ArrayList<>();
            object.add(returnObject);
            return new ApiReturnObject("00", "success", object);
        }
    }

    public static ApiReturnObject success(Object errorMessage, Object returnObject) {
        if (returnObject instanceof java.util.List) {
            return new ApiReturnObject("00", errorMessage, returnObject);
        } else {
            List<Object> object = new ArrayList<>();
            object.add(returnObject);
            return new ApiReturnObject("00", errorMessage, object);
        }
    }
}
