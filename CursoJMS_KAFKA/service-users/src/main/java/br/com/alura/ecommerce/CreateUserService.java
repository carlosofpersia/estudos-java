package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class CreateUserService {

    private final Connection connection;

    CreateUserService() throws SQLException {
        String url = "jdbc:sqlite:target/users_database.db";
        connection = DriverManager.getConnection(url);
        try {
            connection.createStatement().execute("create table Users ( uuid varchar (200) primary key, email varchar(200)  )");
        } catch (SQLException ex) {
            // be careful, the sql could be wrong, be realllly careful
            ex.printStackTrace();
        }


    }

    public static void main(String[] args) throws SQLException {
        var createUserService = new CreateUserService();
        try (var service = new KafkaService<Order>(CreateUserService.class.getSimpleName()
                , "ECOMMERCE_NEW_ORDER", createUserService::parse, Order.class
                , new HashMap<>())) {
            service.run();
        };
    }

    private void parse(ConsumerRecord<String, Message<Order>> record) throws SQLException {

        var message = record.value();
        System.out.println("---------------------------------------------");
        System.out.println("Processing new order, checking for new USER");
        System.out.println("KEY: " + record.key() + " / VALUE: " + record.value());
        System.out.println(record.topic() + ":::partition: " + record.partition() + " / offset: " + record.offset() + " / timestamp: " + record.timestamp());
        System.out.println("Order processed!");

        var order = message.getPayload();
        if(!isNewUser(order.getEmail())) {
            insertNewUser(order.getEmail());
        } else {
            System.out.println("****** Email existe!");
        }
    }

    private void insertNewUser(String email) throws SQLException {
        var insert = connection.prepareStatement("insert into Users (uuid, email) values (?, ? )");
        String uuid = UUID.randomUUID().toString();
        insert.setString(1, uuid);
        insert.setString(2, email);
        insert.execute();
        System.out.println("****** Usuario criado com sucesso, [" + uuid + "] " + email);
    }

    private boolean isNewUser(String email) throws SQLException {

        var exists = connection.prepareStatement("select uuid from Users where email = ? limit 1");
        exists.setString(1, email);
        var results = exists.executeQuery();
        return results.next();
    }

}
