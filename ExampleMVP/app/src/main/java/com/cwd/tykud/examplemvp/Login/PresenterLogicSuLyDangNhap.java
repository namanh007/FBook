package com.cwd.tykud.examplemvp.Login;

/**
 * Created by tykud on 17/06/2018.
 */

public class PresenterLogicSuLyDangNhap implements PresenterImpSuLyDangNhap{

    ViewSuLyDangNhap viewSuLyDangNhap;

    public PresenterLogicSuLyDangNhap(ViewSuLyDangNhap viewSuLyDangNhap) {
        this.viewSuLyDangNhap = viewSuLyDangNhap;
    }

    @Override
    public void kiemTraDangNhap(String email, String pass) {
        if(email.equals("tykudopk@gmail.com")&& pass.equals("123")){
            viewSuLyDangNhap.suLyDangNhapThanhCong();
        }
        else {
            viewSuLyDangNhap.suLyDangNhapThatBai();
        }
    }
}
