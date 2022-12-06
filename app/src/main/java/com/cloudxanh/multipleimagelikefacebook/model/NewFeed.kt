package com.cloudxanh.multipleimagelikefacebook.model


/**
 * Created by sonpxp on 4/17/2022.
 * Email: sonmob202@gmail.com
 */
data class NewFeed(
    val userId: String,
    val userName: String,
    val verifiedBadge: Boolean,
    val avatar: String,
    val timeTemp: String,
    val postId: String,
    val postTitle: String,
    val postDesc: String,
    val postImage: String?,
    val reactCount: Long,
    val commentCount: Long,
    val media: List<Media>,
)
