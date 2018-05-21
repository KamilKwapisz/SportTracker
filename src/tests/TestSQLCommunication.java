package tests;

import core.SQLCommunication;

import java.io.IOException;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestSQLCommunication {

    SQLCommunication sql;

    public void test(){
        try {
            sql = new SQLCommunication();

            assertThat( sql.buildUpdateQuery("users", "height", "192", "sex", "male", "where", "login", "Login123") )
                    .as("Checking the correctness of 'build' query building")
                    .isEqualTo( "update users set height = '192', sex = 'male' where login = 'Login123'");

            assertThat( sql.buildSelectQuery("users", "login", "height") )
                    .as("Checking the correctness of 'select' query building")
                    .isEqualTo( "Select login, height from users" );

            assertThat( sql.buildSelectWhereQuery("users", "login", "Login123", "sex", "female", "+", "height") )
                    .as("Checking the correctness of 'select-where' query building")
                    .isEqualTo( "Select login, sex, height from users where login = 'Login123' and sex = 'female'" );

            assertThat( sql.buildAddQuery("cities", "name", "Warsaw", "capital", "true") )
                    .as("Checking the correctness of 'add' query building")
                    .isEqualTo( "insert into cities ( name, capital ) values ( 'Warsaw', 'true')" );

            assertThat( sql.buildDeleteQuery("users", "login" ,"Smith1990") )
                    .as("Checking the correctness of 'delete' query building")
                    .isEqualTo( "delete from users where login = 'Smith1990'" );

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        TestSQLCommunication sql = new TestSQLCommunication();
        sql.test();
    }
}
