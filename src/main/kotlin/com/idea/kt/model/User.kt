package com.idea.kt.model

import org.bson.types.ObjectId
//import org.springframework.data.mongodb.core.mapping.Document

//@Document(collection = "User")
data class User(var no: Int,
                var userID: String,
                var pwd: String,
                var userName: String)