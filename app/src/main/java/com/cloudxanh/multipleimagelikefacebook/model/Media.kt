package com.cloudxanh.multipleimagelikefacebook.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


/**
 * @Created by Sonpxp on 10/29/2022.
 * @Website: Cloudxanh.com
 * @Email: sonpxp@gmail.com
 */
@Parcelize
data class Media(
    var uri: String?,
    var ratio: String?,
    var description: String,
    var reactCount: Int,
    var commentCount: Int,
    var shareCount: Int
) : Parcelable
