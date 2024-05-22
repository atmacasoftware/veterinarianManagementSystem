package net.atmacacode.veterinarian.core.utilies;

import net.atmacacode.veterinarian.core.result.Result;
import net.atmacacode.veterinarian.core.result.ResultData;
import org.springframework.data.domain.Page;

import java.util.List;

public class ResultHelper {
    public static <T> ResultData<T> created(T data) {
        return new ResultData<>(true, Msg.CREATED, "201", data);
    }

    public static <T> ResultData<T> validateError(T data) {
        return new ResultData<>(false, Msg.VALIDATE_ERROR, "400", data);
    }

    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(true, Msg.OK, "200", data);
    }

    public static Result ok() {
        return new Result(true, Msg.OK, "200");
    }

    public static Result notFoundError(String msg) {
        return new Result(true, Msg.NOT_FOUND, "404");
    }

    public static Result uniqueError(String msg) {
        return new Result(true, Msg.IS_EXIST, "422");
    }

    public static Result notValid(String msg) {
        return new Result(true, msg, "400");
    }

    public static Result numberFormat(String msg) {
        return new Result(true, msg, "400");
    }

    public static <T> ResultData<List<T>> list(List<T> list) {
        return new ResultData<>(true, Msg.OK, "200", list);
    }

}
