package com.idea.kt.model

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.idea.kt.util.ObjectIdSerializer
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class User(@BsonId
                @JsonSerialize(using = ObjectIdSerializer::class ,`as` = ObjectId::class)
                var _id: ObjectId?,
                var no: Int,
                var userID: String,
                var pwd: String,
                var userName: String)