package com.cwd.fbook.ui.member

import com.huy.source.MvpActivity

/**
 * Created by tykud on 16/06/2018.
 */
class LanguageActivity : MvpActivity<LanguageContract.View,LanguageContract.Presenter>(){

    override fun presenter(): LanguageContract.Presenter? = LanguagePresenter()

}