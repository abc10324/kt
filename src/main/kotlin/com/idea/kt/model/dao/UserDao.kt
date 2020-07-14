package com.idea.kt.model.dao

import com.google.gson.Gson
import com.idea.kt.model.User
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters.eq
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.annotation.PostConstruct

@Repository
class UserDao {

    @Autowired
    private lateinit var mongoClient: MongoClient

    private lateinit var collection: MongoCollection<Document>

    private var gson = Gson()


    @PostConstruct
    private fun init(){
        collection = mongoClient.getDatabase("UserSystem")
                                .getCollection("User")
    }

    fun insert(user: User){
        collection.insertOne(Document.parse(gson.toJson(user)))
    }

    fun findAll():List<User>{
        var userList = ArrayList<User>();

        var docList = collection.find()

        for (doc in docList){
            userList.add(gson.fromJson<User>(doc.toJson(),User::class.java))
        }

        return userList
    }

    fun selectByUserId(userID: String): User?{
        var doc = collection.find(eq("userID",userID)).first()

        var json = doc?.toJson() ?: return null

        return gson.fromJson<User>(json,User::class.java)
    }

    fun selectByUsername(username: String): User?{
        var doc = collection.find(eq("userName",username)).first()

        var json = doc?.toJson() ?: return null

        return gson.fromJson<User>(json,User::class.java)
    }

}