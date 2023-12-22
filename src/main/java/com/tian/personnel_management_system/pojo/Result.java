package com.tian.personnel_management_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//ResultCode，1 成功; 0　失败
    private String msg;  //Resultメッセージ
    private Object data; //データ

    //削除、更新、新規 成功Result
    public static Result success(){
        return new Result(1,"success",null);
    }
    // 検索成功Result
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    //失敗Result
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
