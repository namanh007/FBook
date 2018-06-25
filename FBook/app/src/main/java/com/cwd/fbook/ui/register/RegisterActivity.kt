package com.cwd.fbook.ui.register

import android.support.v7.widget.LinearSnapHelper
import android.view.View
import com.cwd.fbook.R
import com.cwd.fbook.ui.model.Sex
import com.huy.source.MvpActivity
import com.cwd.fbook.util.checkedButton
import com.cwd.fbook.util.initDotView
import com.cwd.fbook.util.setLinearAdapter
import com.cwd.fbook.util.setUpWithSlideView
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.view_birth.*
import kotlinx.android.synthetic.main.view_congratulation.*
import kotlinx.android.synthetic.main.view_name.*
import kotlinx.android.synthetic.main.view_password.*
import kotlinx.android.synthetic.main.view_sex.*
import kotlinx.android.synthetic.main.view_term.*

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Tykudo 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
class RegisterActivity : MvpActivity<RegisterContract.View, RegisterContract.Presenter>(),
        RegisterContract.View {

    override fun layout() = R.layout.activity_register

    override fun presenter() = RegisterPresenter()

    override fun onCreate() {
        register_tabLayout.setUpWithSlideView(register_slideView)
        addOnClick(register_view_back, register_view_next)
        LinearSnapHelper().attachToRecyclerView(birth_recyclerView)
    }

    override fun onViewClick(v: View) {
        when(v) {
            register_view_back -> onBackStep()
            register_view_next -> onNextStep()
        }
    }

    override fun swipeNextView() {
        register_slideView.showNext()
        register_tabLayout.getTabAt(register_slideView.indexOfChild(currentFocus))?.select()
    }

    override fun showFirstNameHint(stringRes: Int) {
        name_inputView_firstName.error = if(stringRes == 0) null else getString(stringRes)
    }

    override fun showLastNameHint(stringRes: Int) {
        name_inputView_lastName.error = if(stringRes == 0) null else getString(stringRes)
    }

    override fun showPasswordHint(stringRes: Int) {
        password_inputView_password.error = if(stringRes == 0) null else getString(stringRes)
    }

    override fun showRetypePasswordHint(stringRes: Int) {
        password_inputView_retypePassword.error = if(stringRes == 0) null else getString(stringRes)
    }

    // PRIVATE FUNCTION
    private fun onBackStep() {
        if(register_slideView.currentView == name_view_content)
            super.onBackPressed()
        else
            register_slideView.showPrevious()
    }

    private fun onNextStep() {
        when(register_slideView.currentView) {
            name_view_content -> onValidateUserName()
            sex_radioGroup_content -> onAttachSex()
            birth_view_content -> onAttachBirth()
            password_view_content -> onValidatePassword()
            term_view_content -> onRegisterRequest()
            congratulation_view_content -> register_slideView.showPrevious()
        }
    }

    private fun onValidateUserName() {
        presenter?.validateUserName(
                name_inputView_firstName.text,
                name_inputView_lastName.text
        )
    }

    private fun onAttachSex() {
        presenter?.attachSex(
                when(sex_radioGroup_content.checkedButton()) {
                    sex_radioButton_female -> Sex.FEMALE
                    sex_radioButton_male -> Sex.MALE
                    sex_radioButton_lesbian -> Sex.LESBIAN
                    sex_radioButton_gay -> Sex.GAY
                    else -> Sex.UNISEX
                }
        )
        birth_recyclerView.setLinearAdapter(presenter?.yearAdt)
    }

    private fun onAttachBirth() {
        presenter?.attachBirth()
    }

    private fun onValidatePassword() {
        presenter?.validatePassword(
                password_inputView_password.text,
                password_inputView_retypePassword.text
        )
    }

    private fun onRegisterRequest() {
        if(term_checkBox_agree.isChecked)
            presenter?.register()
        else
            notify(R.string.term_has_not_agree)
    }
}
