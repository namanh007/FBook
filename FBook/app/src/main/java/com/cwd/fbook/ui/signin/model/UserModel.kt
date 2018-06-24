package com.cwd.fbook.ui.signin.model

/**
 * Created by tykud on 21/06/2018.
 */
public class UserModel{
    var userId : String ?=null
    var passWord : String ?=null

    constructor(userId: String?, passWord: String?) {
        this.userId = userId
        this.passWord = passWord
    }
}