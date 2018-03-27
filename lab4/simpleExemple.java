import java.net.UnknownHostException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.bson.Document;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

public class simpleExemple {

	/**
	 * @param args
	 */
	 public static void importJsonIntoCollection(String fichier, String dbname, String collname) {
		   try{
			   // Connexion � la base de donn�e distante
			// Standard URI format: mongodb://[dbuser:dbpassword@]host:port/dbname
			String   uri="mongodb://bruno:salut@ds151508.mlab.com:51508/tp4";//� d�finir
			MongoClientURI clientUri  = new MongoClientURI(uri); 
	        MongoClient client = new MongoClient(clientUri);
	        MongoDatabase db=client.getDatabase(dbname);
	        MongoCollection<Document> coll = db.getCollection(collname);
	        JSONParser parser = new JSONParser();
	        JSONArray jsonarray =null;
		//R�cup�ation des donn�es du fichier JSON
			jsonarray = (JSONArray)parser.parse(new FileReader(fichier));
	       //Parcours du tableau pour r�cup�rer chacun des documents et l'ins�rer dans la collection
			for (int i=0; i<jsonarray.size(); i++) {
				    Document doc = Document.parse(jsonarray.get(i).toString());
				     coll.insertOne(doc);//Insertion dans la BD
			}
			client.close();		
			}catch (FileNotFoundException e){
			 		e.printStackTrace();
			} catch (IOException e) {
			 		e.printStackTrace();
				} catch (ParseException e) {
				 		e.printStackTrace();
	 			}
		   		catch (NullPointerException e) {
		 		e.printStackTrace();
		}
			  	
	}
	
	public static void main(String[] args) throws UnknownHostException{
		// TODO Auto-generated method stub
		importJsonIntoCollection("/usagers/frlabj/workspace/lab4/dblp.json", "tp4", "dblp");
       
    }
}
