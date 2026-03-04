
public class Main {

    public static void main(String[] args) {

        MySQLCRUD mysql = new MySQLCRUD();
        MongoCRUD mongo = new MongoCRUD();

        Customer c1 = new Customer(1,"Sarah","Kelly","sarah@email.com","111-222","NY");
        Customer c2 = new Customer(2,"Grace","Smith","gracesmith@email.com","333-444","LA");
        Customer c3 = new Customer(3,"Mike","Morris","mike@email.com","555-666","TX");

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