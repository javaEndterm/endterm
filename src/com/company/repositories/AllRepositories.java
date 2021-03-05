package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Back;
import com.company.entities.Front;
import com.company.repositories.interfaces.IAllRepositories;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AllRepositories implements IAllRepositories {
    private final IDB database;

    public AllRepositories(IDB database) {
        this.database = database;
    }

    public boolean hasUser(String login, String password) {
        Connection connection = null;
        try {
            connection = database.getConnection();


//            String sql = "INSERT INTO \"Front-end_dev\"(\"First_name\", \"Age\", \"Started_working\", \"Level\", \"Salary\")\n" +
//                    "VALUES(?, ?, ?, ?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, front.getF_name());
//            statement.setInt(2, front.getAge());
//            statement.setDate(3, front.getStarted_working());
//            statement.setInt(4, front.getLevel());
//            statement.setInt(5, front.getSalary());
//            statement.execute();
//            return true;


            //Login
            String sqlLogin = "SELECT \"Login\" FROM \"LogIn\" where \"Login\" = ? and \"Password\" = ?";
            PreparedStatement statementLogin = connection.prepareStatement(sqlLogin);
            statementLogin.setString(1, login);
            statementLogin.setString(2, password);
            statementLogin.execute();
//            Statement statementLogin = connection.createStatement();

            ResultSet resLogin = statementLogin.getResultSet();

            //Password
            String sqlPassword = "SELECT \"Password\" FROM \"LogIn\" where \"Login\" = ? and \"Password\" = ?";
            PreparedStatement statementPassword = connection.prepareStatement(sqlPassword);
            statementPassword.setString(1, login);
            statementPassword.setString(2, password);
            statementPassword.execute();
            //            Statement statementPassword = connection.createStatement();

            ResultSet resPassword = statementPassword.getResultSet();


            if (resLogin.next() == true && resPassword.next() == true) {
                return true;
            } else {
                return false;
            }

//            ResultSet compareLogin = statementLogin.getResultSet()

//            ResultSet res = statement.getResultSet();
//            int sumFront = 0;
//            int sumBack = 0;
//            int allSum = 0;
//
//            if (res.next()) {
//                sumFront = res.getInt("sum");
//            }
//
//            sql = "SELECT SUM (\"Salary\") FROM \"Back-end_dev\"";
//            statement = connection.createStatement();
//
//            result = statement.executeQuery(sql);
//
//            res = statement.getResultSet();
//            if (res.next()) {
//                sumBack = res.getInt("sum");
//            }
//
//            allSum = sumFront + sumBack;
//            return allSum;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }



//    @Override
//    public List<Front> getAllFront() {
//        Connection connection = null;
//        try {
//            connection = database.getConnection();
//
//            String sql = "SELECT * FROM \"Front-end_dev\"";
//            Statement statement = connection.createStatement();
//
//            ResultSet result = statement.executeQuery(sql);
//            List<Front> fronts = new LinkedList<>();
//            while (result.next()) {
//                Front front = new Front(
//                        result.getInt("ID"),
//                        result.getString("First_name"),
//                        result.getInt("Age"),
//                        result.getDate("Started_working"),
//                        result.getInt("Level"),
//                        result.getInt("Salary")
//                );
//                fronts.add(front);
//            }
//            return fronts;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Back> getAllBack() {
//        Connection connection = null;
//        try {
//            connection = database.getConnection();
//
//            String sql = "SELECT * FROM \"Back-end_dev\"";
//            Statement statement = connection.createStatement();
//
//            ResultSet result = statement.executeQuery(sql);
//            List<Back> backs = new LinkedList<>();
//            while (result.next()) {
//                Back back = new Back(
//                        result.getInt("ID"),
//                        result.getString("First_name"),
//                        result.getInt("Age"),
//                        result.getDate("Started_working"),
//                        result.getInt("Level"),
//                        result.getInt("Salary")
//                );
//                backs.add(back);
//            }
//            return backs;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean addFront(Front front) {
//        Connection connection = null;
//        try {
//            connection = database.getConnection();
//
//            String sql = "INSERT INTO \"Front-end_dev\"(\"First_name\", \"Age\", \"Started_working\", \"Level\", \"Salary\")\n" +
//                    "VALUES(?, ?, ?, ?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, front.getF_name());
//            statement.setInt(2, front.getAge());
//            statement.setDate(3, front.getStarted_working());
//            statement.setInt(4, front.getLevel());
//            statement.setInt(5, front.getSalary());
//            statement.execute();
//            return true;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean addBack(Back back) {
//        Connection connection = null;
//        try {
//            connection = database.getConnection();
//
//            String sql = "INSERT INTO \"Back-end_dev\"(\"First_name\", \"Age\", \"Started_working\", \"Level\", \"Salary\")\n" +
//                    "VALUES(?, ?, ?, ?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, back.getF_name());
//            statement.setInt(2, back.getAge());
//            statement.setDate(3, back.getStarted_working());
//            statement.setInt(4, back.getLevel());
//            statement.setInt(5, back.getSalary());
//            statement.execute();
//            return true;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteFront(int id) throws PSQLException  {
//        Connection connection = null;
//        try {
//            connection = database.getConnection();
//
//            String sql = "DELETE FROM \"Front-end_dev\" WHERE \"ID\"=?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
//            statement.execute();
//            return true;
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteBack(int id){
//        Connection connection = null;
//        try {
//            connection = database.getConnection();
//
//            String sql = "DELETE FROM \"Back-end_dev\" WHERE \"ID\"=?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
//            statement.execute();
//
//            return true;
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public int getSalary() {
//        Connection connection = null;
//        try {
//            connection = database.getConnection();
//
//            String sql = "SELECT SUM (\"Salary\") FROM \"Front-end_dev\"";
//            Statement statement = connection.createStatement();
//
//            ResultSet result = statement.executeQuery(sql);
//
//            ResultSet res = statement.getResultSet();
//            int sumFront = 0;
//            int sumBack = 0;
//            int allSum = 0;
//
//            if (res.next()) {
//                sumFront = res.getInt("sum");
//            }
//
//            sql = "SELECT SUM (\"Salary\") FROM \"Back-end_dev\"";
//            statement = connection.createStatement();
//
//            result = statement.executeQuery(sql);
//
//            res = statement.getResultSet();
//            if (res.next()) {
//                sumBack = res.getInt("sum");
//            }
//
//            allSum = sumFront + sumBack;
//            return allSum;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return 0;
//    }
}