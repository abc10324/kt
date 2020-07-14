package com.idea.kt.model

import com.idea.kt.model.dao.UserDao
import com.idea.kt.model.dao.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepo: UserRepo

    @Autowired
    lateinit var userDao: UserDao

    fun addUser(user: User){
//        userRepo.insert(user)
        userDao.insert(user)
    }

    fun getUserByNo(no: Int): User?{
        return userRepo.selectByNo(no)
    }

    fun getUserByUserID(userId: String): User?{
//        return userRepo.selectByUserId(userId)
        return userDao.selectByUserId(userId)
    }

    fun getUser(username: String): User?{
//        return userRepo.selectByUsername(username)
        return userDao.selectByUsername(username)
    }

    fun getAllUser(): List<User>{
//        return userRepo.findAll()
        return userDao.findAll()
    }

}