package data.helpers;

import data.sqlTableObjects.CreditTableObject;
import data.sqlTableObjects.OrderTableObject;
import data.sqlTableObjects.PaymentTableObject;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();
    private static Connection conn;

    private SQLHelper() {
    }

    private static Connection getConnectionPostgeSQL() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "pass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void cleanDB() {
        var creditRequest = "DELETE FROM credit_request_entity";
        var order = "DELETE FROM order_entity";
        var payment = "DELETE FROM payment_entity";
        try (var conn = getConnectionPostgeSQL()) {
            runner.update(conn, creditRequest);
            runner.update(conn, order);
            runner.update(conn, payment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PaymentTableObject getPaymentEntity() {
        var sqlRequest = "SELECT * FROM payment_entity";
        try (var conn = getConnectionPostgeSQL()) {
            var requestResult = runner.query(conn, sqlRequest, new BeanHandler<>(PaymentTableObject.class));
            return requestResult;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static CreditTableObject getCreditEntity() {
        var sqlRequest = "SELECT * FROM credit_request_entity";
        try (var conn = getConnectionPostgeSQL()) {
            var requestResult = runner.query(conn, sqlRequest, new BeanHandler<>(CreditTableObject.class));
            return requestResult;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static OrderTableObject getOrderEntity() {
        var sqlRequest = "SELECT * FROM order_entity";
        try (var conn = getConnectionPostgeSQL()) {
            var requestResult = runner.query(conn, sqlRequest, new BeanHandler<>(OrderTableObject.class));
            return requestResult;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
