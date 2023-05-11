

import java.awt.TextField;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.client.*;

/*import com.mongodb.client.result.InsertOneResult;*/

public class AccesoMongo {
	
	public static MongoClient crearConexion() {
		System.out.println("PRUEBA CONEXIÓN");
		MongoClient mongo = null;
		String host = "mongodb://localhost:27017";
		mongo = MongoClients.create(host);
		return mongo;
	}
	public static void insertarUsuario(String coleccion, String nombre, String correo, String contra) {
		MongoClient mongo = crearConexion();
		if(mongo != null) {
		      //Connecting to the database
		      MongoDatabase database = mongo.getDatabase("JuegoOnline");
			
			if(database.getCollection(coleccion) == null) {
				database.createCollection(coleccion);
			}
		
		MongoCollection<Document> collection = database.getCollection(coleccion);
		Document nombreQuery = new Document("nombre", nombre);
		Document correoQuery = new Document("correo", correo);
		FindIterable<Document> docs =collection.find(nombreQuery);
		FindIterable<Document> docs2 =collection.find(correoQuery);
		Document nombreRes = docs.first();
		Document correoRes = docs2.first();
		if (nombreRes != null) {
	         System.out.println("El nombre existe. No se ha insertado en la base de datos.");
	         JOptionPane.showMessageDialog(null, "El nombre introducido ya existe. Intete con otro.", "Registrarse", JOptionPane.INFORMATION_MESSAGE);
	      } else
	    	  if(correoRes != null) {
	    		  JOptionPane.showMessageDialog(null, "El correo introducido ya existe. Intete con otro.", "Registrarse", JOptionPane.INFORMATION_MESSAGE);
	    		  System.out.println("El correo existe. No se ha insertado en la base de datos.");
	    	  }
		else {
	    	  Document document = new Document();
	  		  document.append("nombre", nombre);
	  		  document.append("correo", correo);
	  		  document.append("contra", contra);
	  		  database.getCollection(coleccion).insertOne(document);
	  		  System.out.println("Document(register) inserted successfully");
	  		  JOptionPane.showMessageDialog(null, "Registrado Correctamente!", "Registrarse", JOptionPane.INFORMATION_MESSAGE);
	      }
		}
		
	}	
	
	public static void insertarEstadisticas(String coleccion, int score, String time, String name) {
		MongoClient mongo = crearConexion();
		if(mongo != null) {
		      //Connecting to the database
		      MongoDatabase database = mongo.getDatabase("JuegoOnline");
			
			if(database.getCollection(coleccion) == null) {
				database.createCollection(coleccion);
			}
		LocalDate fechaActual = LocalDate.now();
			
	    Document document = new Document();
	    document.append("nombre", name);
	    document.append("puntuacion", score);
	    document.append("tiempo", time);
	    document.append("fecha", fechaActual);
	    
	    document.append("usuario_id", buscarIdUsuario(database, name));
	    database.getCollection(coleccion).insertOne(document);
	    System.out.println("Document(stats) inserted successfully");
	    JOptionPane.showMessageDialog(null, "Estadísticas de partida guardadas. Ya puede consultar en www.letrillas.com", "Estadíscas", JOptionPane.INFORMATION_MESSAGE);
	      
		}
		
	}	
	
	public static String buscarIdUsuario(MongoDatabase database, String nombre) {
		MongoCollection<Document> collection = database.getCollection("Usuarios");
		 Document document = collection.find(new Document("nombre", nombre)).first();
		 String id = document.getObjectId("_id").toString();
		 return id;
	}
	
	public static boolean verificarLogin(String nombre, String hashedPassword) {
		String coleccion = "Usuarios";
		MongoClient mongo = crearConexion();
		if(mongo != null) {
		      //Connecting to the database
		      MongoDatabase database = mongo.getDatabase("JuegoOnline");
			
			if(database.getCollection(coleccion) == null) {
				database.createCollection(coleccion);
			}
		MongoCollection<Document> collection = database.getCollection(coleccion);
		Document nombreQuery = new Document("nombre", nombre);
		Document hashQuery = new Document("contra", hashedPassword);
		FindIterable<Document> docs =collection.find(nombreQuery);
		FindIterable<Document> docs2 =collection.find(hashQuery);
		Document nombreRes = docs.first();
		Document hashRes = docs2.first();
		if ((nombreRes != null) && (hashRes != null)) {
	         System.out.println("Nombre y contraseña correctos");
	         return true;
	      }else {
	    	  System.out.println("Nombre o contraseña incorrectos");
	    	   return false;   
	      }
	    	 
		}else
			return false;
	}
	
	public static boolean verificarEmail(String correo) {
		String coleccion = "Usuarios";
		MongoClient mongo = crearConexion();
		if(mongo != null) {
		      //Connecting to the database
		      MongoDatabase database = mongo.getDatabase("JuegoOnline");
			
			if(database.getCollection(coleccion) == null) {
				database.createCollection(coleccion);
			}
		MongoCollection<Document> collection = database.getCollection(coleccion);
		Document correoQuery = new Document("correo", correo);
		FindIterable<Document> docs =collection.find(correoQuery);
		Document correoRes = docs.first();
		if ((correoRes != null)) {
	         System.out.println("Existe el correo");
	         return true;
	      }else {
	    	  System.out.println("El correo no existe");
	    	   return false;   
	      }
	    	 
		}else
			return false;
	}
	
	public static List<Document> obtenerEstadisticas() {
		MongoClient mongo = crearConexion();
		MongoDatabase database = mongo.getDatabase("JuegoOnline");
		MongoCollection<Document> estadisticasCollection = database.getCollection("Estadisticas");
	 // Obtener los documentos de la colección "estadisticas"
        List<Document> documentos = new ArrayList<>();
	    MongoCursor<Document> cursor = estadisticasCollection.find().iterator();
	    while (cursor.hasNext()) {
	    	Document documento = cursor.next();
	        documentos.add(documento);
	    }
	 // Ordenar los documentos por puntuación de mayor a menor
        Comparator<Document> comparadorPuntuacion = Comparator.comparingInt(d -> d.getInteger("puntuacion"));
	    Collections.sort(documentos, comparadorPuntuacion.reversed());
	    System.out.println(documentos);
	    return documentos;
	}
	
}
