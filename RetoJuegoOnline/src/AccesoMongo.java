

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.client.*;

/*import com.mongodb.client.result.InsertOneResult;*/

public class AccesoMongo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "mongodb://localhost:27017";
		
		MongoClient mongo = MongoClients.create(host);
		
	      //Connecting to the database
	      MongoDatabase database = mongo.getDatabase("JuegoOnline");
	      //Creating a collection
	      database.createCollection("partida");
	      //Preparing a document
	      Document document = new Document();
	      document.append("name", "Ram");
	      document.append("age", 26);
	      document.append("city", "Hyderabad");
	      //Inserting the document into the collection
	      database.getCollection("Usuario").insertOne(document);
	      System.out.println("Document inserted successfully");
	}

}
