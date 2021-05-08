package com.guorui.hak.pojo;

public class Result {

    private String code;
    private String status;
    private Object obj;
    public Result(String code, String status, Object obj) {
        this.code = code;
        this.status = status;
        this.obj = obj;
    }
    private static Result ds = new Result("1","请求成功",null);
    private static Result de = new Result("0","请求失败",null);
    public static Result defaultSuccess(){
        return ds;
    }
    public static Result defaultError(){
        return de;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Result reSetObj(Object obj){
        this.obj = obj;
        return this;
    }
}
