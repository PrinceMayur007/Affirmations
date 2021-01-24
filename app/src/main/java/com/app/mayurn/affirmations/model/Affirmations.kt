package com.app.mayurn.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//we given annotation to avoid risk of interchanging the values of of string resource and drawable resource with each other
//and you will get also a warning if you mistakenly interchanged used image resource id for string or vice versa
data class Affirmations(@StringRes val stringResourceId: Int, @DrawableRes val imageResourceId: Int)
//data because this class contains data for affirmations, data make it simple instead of writing getters and setters.