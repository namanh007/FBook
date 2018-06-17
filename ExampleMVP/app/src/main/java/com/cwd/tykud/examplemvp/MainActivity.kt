package com.cwd.tykud.examplemvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.cwd.tykud.examplemvp.Login.PresenterLogicSuLyDangNhap
import com.cwd.tykud.examplemvp.Login.ViewSuLyDangNhap
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ViewSuLyDangNhap,View.OnClickListener{

    var suLyDangNhap = PresenterLogicSuLyDangNhap(this)

    override fun onClick(p0: View?) {
        suLyDangNhap.kiemTraDangNhap(edt_Id.text.toString(), edt_Pas.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_DangNhap.setOnClickListener(this)
    }




    override fun suLyDangNhapThanhCong() {
        Toast.makeText(this,"Đăng Nhập Thành Công",Toast.LENGTH_LONG).show()

    }

    override fun suLyDangNhapThatBai() {
        Toast.makeText(this,"Đăng Nhập Thất Bại",Toast.LENGTH_LONG).show()
    }

}
