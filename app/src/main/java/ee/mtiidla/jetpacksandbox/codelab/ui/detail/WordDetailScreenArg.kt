package ee.mtiidla.jetpacksandbox.codelab.ui.detail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WordDetailScreenArg(val word: String) : Parcelable