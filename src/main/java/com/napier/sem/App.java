package com.napier.sem;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class App {
    public static void main(String[] args) {
        // Connect to MongoDB server using the new driver version with hostname
        //MongoClient mongoClient = MongoClients.create("mongodb://mongo-dbserver");
        // Connect to MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");


        // Get a database - will create it if it does not exist
        MongoDatabase database = mongoClient.getDatabase("mydb");

        // Get a collection from the database
        MongoCollection<Document> collection = database.getCollection("test");

        // Create a document to store
        Document doc = new Document("name", "Kevin Sim")
                .append("class", "Software Engineering Methods")
                .append("year", "2021")
                .append("result", new Document("CW", 95).append("EX", 85));

        // Add document to collection
        collection.insertOne(doc);

        // Check document in collection
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());

        // Close the MongoDB client
        mongoClient.close();
    }
}
