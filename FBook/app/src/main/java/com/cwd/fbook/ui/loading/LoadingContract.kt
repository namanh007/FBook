package com.cwd.fbook.ui.loading

import com.huy.source.MvpPresenterInt
import com.huy.source.MvpViewInt

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
interface LoadingContract{

    interface View : MvpViewInt

    interface Presenter : MvpPresenterInt<View>
}
