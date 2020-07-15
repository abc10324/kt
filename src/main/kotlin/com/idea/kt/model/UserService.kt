package com.idea.kt.model

import com.idea.kt.model.dao.UserDao
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {


    @Autowired
    lateinit var userDao: UserDao

    fun addUser(user: User){
        userDao.insert(user)
    }

    fun modifyUser(_id: ObjectId,user: User){
        userDao.update(_id, user)
    }

    fun deleteUser(_id: ObjectId){
        userDao.delete(_id)
    }


    fun getUserByUserID(userId: String): User?{
        return userDao.selectByUserId(userId)
    }

    fun getUser(username: String): User?{
        return userDao.selectByUsername(username)
    }

    fun getAllUser(): List<User>{
        return userDao.findAll()
    }

}