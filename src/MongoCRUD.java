
import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class MongoCRUD {

    private final MongoCollection<Document> collection;

    public MongoCRUD() {
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = client.getDatabase("school");
        collection = database.getCollection("IST888IST888");
    }

    public void create(Customer customer) {
        Document doc = new Document("id", customer.getId())
                .append("firstName", customer.getFirstName())
                .append("lastName", customer.getLastName())
                .append("email", customer.getEmail())
                .append("phone", customer.getPhone())
                .append("address", customer.getAddress());

        collection.insertOne(doc);
        System.out.println("MongoDB INSERTED: " + customer);
    }

    public List<Document> readAll() {
        List<Document> docs = new ArrayList<>();
        collection.find().into(docs);
        return docs;
    }

    public void update(int id, String newEmail) {
        collection.updateOne(
                new Document("id", id),
                new Document("$set", new Document("email", newEmail))
        );
        System.out.println("MongoDB UPDATED ID: " + id);
    }

    public void delete(int id) {
        collection.deleteOne(new Document("id", id));
        System.out.println("MongoDB DELETED ID: " + id);
    }
}