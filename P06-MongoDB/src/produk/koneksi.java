/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produk;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
/**
 *
 * @author acer
 */
public class koneksi {
   public static MongoDatabase sambungDB(){
      try{
          MongoClient client = MongoClients.create();
          MongoDatabase database = client.getDatabase("product");
          System.out.println("Koneksi sukses");
          return database;
      } catch (Exception e){
          System.out.println("koneksi gagal: "+e.getMessage());
      }
      
      return null;
   
   } 
}
