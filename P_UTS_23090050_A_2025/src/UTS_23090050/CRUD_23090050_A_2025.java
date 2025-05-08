/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_23090050;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.UpdateResult;
import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.Arrays;
/**
 *
 * @author acer
 */
public class CRUD_23090050_A_2025 {
    public static void main(String[] args) {
        try{
            MongoDatabase database = koneksi.sambungDB();
            
            //melihat daftar koleksi
            System.out.println("=====================");
            System.out.println("Menambahkan data");
            // Mendapatkan koleksi
            MongoCollection<Document> collection = database.getCollection("coll_23090050_A_2025");
            // Dokumen 1: Mahasiswa
            Document doc1 = new Document("nim", "23090050")
                    .append("nama", "Siska")
                    .append("jurusan", "Informatika")
                    .append("angkatan", 2023);

            // Dokumen 2: Produk
            Document doc2 = new Document("produk_id", "P001")
                    .append("nama_produk", "Teh Hijau")
                    .append("harga", 25000)
                    .append("stok", 50)
                    .append("kategori", "Minuman");

            // Dokumen 3: Transaksi
            Document doc3 = new Document("transaksi_id", "T1001")
                    .append("tanggal", new Date())
                    .append("total", 50000)
                    .append("pembayaran", new Document("metode", "QRIS").append("status", "Lunas"))
                    .append("items", Arrays.asList(
                            new Document("produk_id", "P001").append("jumlah", 2),
                            new Document("produk_id", "P002").append("jumlah", 1)
                    ));

            // Insert ke koleksi
            collection.insertMany(Arrays.asList(doc1, doc2, doc3));

            System.out.println(" Berhasil menambahkan 3 dokumen ke MongoDB.");
            
            // Menampilkan semua data
            System.out.println("\n========= DATA DALAM KOLEKSI =========");
            MongoCursor<Document> cursor = collection.find().iterator();

            int i = 1;
            while (cursor.hasNext()) {
                System.out.println("Dokumen #" + i++);
                System.out.println(cursor.next().toJson());
                System.out.println("--------------------------------------");
            }

            cursor.close();
            // ===== UPDATE DATA =====
            System.out.println("=== UPDATE DATA ===");
UpdateResult result = collection.updateOne(
    eq("produk_id", "P001"),
    new Document("$set", new Document("harga", 30000))
);
System.out.println("Jumlah dokumen yang diupdate: " + result.getModifiedCount());

// ===== DELETE DATA =====
System.out.println("=== DELETE DATA ===");
long deleteCount = collection.deleteOne(eq("transaksi_id", "T1001")).getDeletedCount();
System.out.println("Jumlah dokumen yang dihapus: " + deleteCount);

        }  catch (Exception e){
           
                
        }
    
    
    }
    
}


