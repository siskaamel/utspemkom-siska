/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produk;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.UpdateResult;
import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author acer
 */
public class TestDB {
    public static void main(String[] args) {
        try{
            MongoDatabase database = koneksi.sambungDB();
            
            //melihat daftar koleksi
            System.out.println("=====================");
            System.out.println("Menambahkan data");
            MongoIterable<String> tables = database.listCollectionNames();
            for (String name : tables) {
                System.out.println(name);
            }
            
            //menambah data
            
        } catch (Exception e) {
           
           
        }
    }
    
}
