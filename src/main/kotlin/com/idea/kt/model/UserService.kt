package com.idea.kt.model

import com.idea.kt.model.dao.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {


    @Autowired
    lateinit var userDao: UserDao

    fun addUser(user: User){
        userDao.insert(user)
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