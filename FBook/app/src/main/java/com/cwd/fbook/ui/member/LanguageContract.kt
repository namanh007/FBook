package com.cwd.fbook.ui.member

import com.cwd.fbook.app.mvp.MvpViewInt
import com.huy.source.MvpPresenterInt

/**
 * Created by tykud on 16/06/2018.
 */
interface LanguageContract{

    interface View : MvpViewInt{

    }

    interface Presenter : MvpPresenterInt<View>{

    }
}