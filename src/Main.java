
public class Main {

    public static void main(String[] args) {

        MySQLCRUD mysql = new MySQLCRUD();
        MongoCRUD mongo = new MongoCRUD();

        com.retail.Customer c1 = new com.retail.Customer(1,"John","Doe","john@email.com","111-222","NY");
        com.retail.Customer c2 = new com.retail.Customer(2,"Jane","Smith","jane@email.com","333-444","LA");
        com.retail.Customer c3 = new com.retail.Customer(3,"Mike","Brown","mike@email.com","555-666","TX");

        // CREATE
        mysql.create(c1);
        mysql.create(c2);
        mysql.create(c3);

        mongo.create(c1);
        mongo.create(c2);
        mongo.create(c3);

        // READ
        System.out.println("MySQL READ:");
        mysql.readAll().forEach(System.out::println);

        System.out.println("Mongo READ:");
        mongo.readAll().forEach(System.out::println);

        // UPDATE
        c1.setEmail("updated@email.com");
        mysql.update(c1);
        mongo.update(1, "updated@email.com");

        // DELETE
        mysql.delete(3);
        mongo.delete(3);
    }
}
