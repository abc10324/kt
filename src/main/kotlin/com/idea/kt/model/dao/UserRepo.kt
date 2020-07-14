package com.idea.kt.model.dao

import com.idea.kt.model.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepo: MongoRepository<User, ObjectId> {

    @Query("{'no' : ?0 }")
    fun selectByNo(no: Int): User?

    @Query("{'userID' : ?0 }")
    fun selectByUserId(userID: String): User?

    @Query("{'userName' : ?0 }")
    fun selectByUsername(username: String): User?

}