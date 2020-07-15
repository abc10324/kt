package com.idea.kt.model.dao

import com.google.gson.Gson
import com.idea.kt.model.User
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.Updates.combine
import com.mongodb.client.model.Updates.set
import org.bson.Document
import org.bson.conversions.Bson
import org.bson.types.ObjectId
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

    fun update(_id: ObjectId, user: User){

        val updates = mutableListOf<Bson>()
        updates.add(set("userID",user.userID))
        updates.add(set("userName",user.userName))

        collection.findOneAndUpdate(eq("_id",_id),combine(updates))
    }

    fun delete(_id: ObjectId){
        collection.findOneAndDelete(eq("_id",_id))
    }

    fun findAll():List<User>{
        var userList = ArrayList<User>();

        var docList = collection.find()

        for (doc in docList){
            var user = gson.fromJson<User>(doc.toJson(),User::class.java)
            user._id = doc.getObjectId("_id")
            userList.add(user)
        }

        return userList
    }

    fun selectByUserId(userID: String): User?{
        var doc = collection.find(eq("userID",userID)).first()

        var json = doc?.toJson() ?: return null

        var user = gson.fromJson<User>(json,User::class.java)
        user._id = doc.getObjectId("_id")

        return user
    }

    fun selectByUsername(username: String): User?{
        var doc = collection.find(eq("userName",username)).first()

        var json = doc?.toJson() ?: return null

        var user = gson.fromJson<User>(json,User::class.java)
        user._id = doc.getObjectId("_id")

        return user
    }

}