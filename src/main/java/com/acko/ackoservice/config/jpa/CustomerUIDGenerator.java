package com.acko.ackoservice.config.jpa;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class CustomerUIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "CUSTOMER_100";
        Connection connection = session.connection();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(uid) as Id from customers");

            if (rs.next()) {
                Integer id = rs.getInt(1) + 1;
                String generatedId = prefix + new Integer(id);
                return generatedId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
