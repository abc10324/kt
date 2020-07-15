package com.idea.kt.controller


import com.idea.kt.model.User
import com.idea.kt.model.UserService
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
class KtController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/Test")
    fun getData() : Map<String,String>{
        return Collections.singletonMap("status","success")
    }

    @GetMapping("/User")
    fun getAllUser():List<User>{
        return userService.getAllUser()
    }

    @GetMapping("/User/{username}")
    fun getUser(@PathVariable username: String) : User?{
        return userService.getUser(username)
    }

    @PostMapping("/User")
    fun addUser(@RequestBody user: User) : Map<String,String>{

        userService.addUser(user)

        return Collections.singletonMap("status","success")
    }

    @PutMapping("/User/{_id}")
    fun modifyUser(@PathVariable _id: ObjectId,@RequestBody user: User) : Map<String,String>{

        userService.modifyUser(_id,user)

        return Collections.singletonMap("status","success")
    }

    @DeleteMapping("/User/{_id}")
    fun deleteUser(@PathVariable _id: ObjectId) : Map<String,String>{

        userService.deleteUser(_id)

        return Collections.singletonMap("status","success")
    }

}