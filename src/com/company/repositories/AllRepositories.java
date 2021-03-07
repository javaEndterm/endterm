package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.LogIn;
import com.company.entities.Order;
import com.company.repositories.interfaces.IAllRepositories;

import java.sql.*;
import java.time.LocalDate;
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

            //Login
            String sqlLogin = "SELECT \"Login\" FROM \"LogIn\" where \"Login\" = ? and \"Password\" = ?";
            PreparedStatement statementLogin = connection.prepareStatement(sqlLogin);
            statementLogin.setString(1, login);
            statementLogin.setString(2, password);
            statementLogin.execute();

            ResultSet resLogin = statementLogin.getResultSet();

            //Password
            String sqlPassword = "SELECT \"Password\" FROM \"LogIn\" WHERE \"Login\" = ? AND \"Password\" = ?";
            PreparedStatement statementPassword = connection.prepareStatement(sqlPassword);
            statementPassword.setString(1, login);
            statementPassword.setString(2, password);
            statementPassword.execute();

            ResultSet resPassword = statementPassword.getResultSet();

            if ((resLogin.next() == true && resPassword.next() == true) || (resLogin.next() == true)) {
                return true;
            } else {
                return false;
            }
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


    @Override
    public boolean isAdmin(String login, String password) {
        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "SELECT \"ID\" FROM \"LogIn\" WHERE \"Login\"=? AND \"Password\"=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            statement.execute();

            ResultSet result = statement.getResultSet();

            int id;
            while (result.next()) {
                id = result.getInt("ID");
                if (id == 4 || id == 5) {
                    return true;
                } else {
                    return false;
                }
            }
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

    @Override
    public List<LogIn> getAllUsers() {

        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "SELECT * FROM \"LogIn\"";
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);
            List<LogIn> logins = new LinkedList<>();
            while (result.next()) {
                LogIn login = new LogIn(
                        result.getInt("ID"),
                        result.getString("Name"),
                        result.getString("Login"),
                        result.getString("Password"),
                        result.getDate("Reg_date")
                );
                logins.add(login);
            }
            return logins;
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
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "SELECT * FROM \"Orders\"";
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);
            List<Order> orders = new LinkedList<>();
            while (result.next()) {
                Order order = new Order(
                        result.getInt("id"),
                        result.getString("From_city"),
                        result.getString("To_city"),
                        result.getString("From_login"),
                        result.getInt("Days"),
                        result.getInt("Price")
                );
                orders.add(order);
            }
            return orders;
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
        return null;
    }

//    @Override
//    public List<Order> getAllOrdersForUser(String login) {
//        Connection connection = null;
//        try {
//            connection = database.getConnection();
//
//            String sql = "SELECT * FROM \"Orders\" WHERE \"From_login\"=?";
//
//
//            PreparedStatement p_statement = connection.prepareStatement(sql);
//            p_statement.setString(1, login);
//            p_statement.execute();
//
//
//            Statement statement = connection.createStatement();
//
//            ResultSet result = statement.getResultSet();
//            List<Order> orders = new LinkedList<>();
//            while (result.next()) {
//                Order order = new Order(
//                        result.getInt("id"),
//                        result.getString("From_city"),
//                        result.getString("To_city"),
//                        result.getString("From_login"),
//                        result.getInt("Days"),
//                        result.getInt("Price")
//                );
//                orders.add(order);
//            }
//            return orders;
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


    @Override
    public boolean addUser(String name, String login, String password, LocalDate regDate) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "INSERT INTO \"LogIn\"(\"Name\", \"Login\", \"Password\", \"Reg_date\") VALUES(?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, login);
            statement.setString(3, password);
            statement.setDate(4, Date.valueOf(regDate));
            statement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean addPlace(String name, Date starting_date, String reiteration, int price) {
        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "INSERT INTO \"Travel_places\"(\"Name\", \"Starting_date\", \"Reiteration_every...\", \"Price_per_day\") VALUES(?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setDate(2, starting_date);
            statement.setString(3, reiteration);
            statement.setInt(4, price);
            statement.execute();
            return true;
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

    @Override
    public boolean addOrder(String whereFrom, String whereTo, String from_login, int days, int price) {
        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "INSERT INTO \"Orders\"(\"From_city\", \"To_city\", \"From_login\", \"Days\", \"Price\") VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, whereFrom);
            statement.setString(2, whereTo);
            statement.setString(3, from_login);
            statement.setInt(4, days);
            statement.setInt(5, price);
            statement.execute();
            return true;
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


    @Override
    public boolean removeUser(int id) {
        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "DELETE FROM \"LogIn\" WHERE \"ID\"=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }



    @Override
    public boolean removePlace(int id) {
        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "DELETE FROM \"Travel_places\" WHERE \"ID\"=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean removeOrder(String whereFrom, String whereTo, String login) {
        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "DELETE FROM \"Orders\" WHERE \"From_city\"=? AND \"To_city\"=? AND \"From_login\"=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, whereFrom);
            statement.setString(2, whereTo);
            statement.setString(3, login);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }


    @Override
    public boolean isExistsOrder(String whereFrom, String whereTo, String from_login) {


        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "SELECT \"From_city\", \"To_city\", \"From_login\" FROM \"Orders\" WHERE \"From_city\"=? AND \"To_city\"=? AND \"From_login\"=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, whereFrom);
            statement.setString(2, whereTo);
            statement.setString(3, from_login);
            statement.execute();


            ResultSet result = statement.getResultSet();

            String from, to, login;

            while (result.next()) {
                from = result.getString("From_city");
                to = result.getString("To_city");
                login = result.getString("From_login");
                if (from.length() > 0 && to.length() > 0 && login.length() > 0) {
                    return true;
                } else {
                    return false;
                }
            }

//            String sqlFrom = "SELECT \"From_city\" FROM \"Orders\" WHERE \"From_city\"=? AND \"To_city\"=? AND \"From_login\"=?";
//            String sqlTo = "SELECT \"To_city\" FROM \"Orders\" WHERE \"From_city\"=? AND \"To_city\"=? AND \"From_login\"=?";
//            String sqlLogin = "SELECT \"From_login\" FROM \"Orders\" WHERE \"From_city\"=? AND \"To_city\"=? AND \"From_login\"=?";
//
//            PreparedStatement pStatementFrom = connection.prepareStatement(sqlFrom);
//            PreparedStatement pStatementTo = connection.prepareStatement(sqlTo);
//            PreparedStatement pStatementLogin = connection.prepareStatement(sqlLogin);
//
//
//
//            pStatementFrom.setString(1, whereFrom);
//            pStatementFrom.setString(2, whereTo);
//            pStatementFrom.setString(3, from_login);
//
//
//            pStatementTo.setString(1, whereFrom);
//            pStatementTo.setString(2, whereTo);
//            pStatementTo.setString(3, from_login);
//
//
//            pStatementLogin.setString(1, whereFrom);
//            pStatementLogin.setString(2, whereTo);
//            pStatementLogin.setString(3, from_login);
//
//
//
//            Statement statementFrom = connection.createStatement();
//            Statement statementTo = connection.createStatement();
//            Statement statementLogin = connection.createStatement();
//
//            ResultSet resultFrom = statementFrom.executeQuery(sqlFrom);
//            ResultSet resultTo = statementTo.executeQuery(sqlTo);
//            ResultSet resultLogin = statementLogin.executeQuery(sqlLogin);
//
//            String from, to, login;
//            boolean isTrue = false;
//
//            while (resultFrom.next()) {
//                from = resultFrom.getString("From_city");
//                if (from.length() > 0) {
//                    isTrue = true;
//                } else {
//                    isTrue = false;
//                    return isTrue;
//                }
//            }
//            while (resultTo.next()) {
//                to = resultTo.getString("To_city");
//                if (to.length() > 0) {
//                    isTrue = true;
//                } else {
//                    isTrue = false;
//                    return isTrue;
//                }
//            }
//            while (resultLogin.next()) {
//                login = resultLogin.getString("From_login");
//                if (login.length() > 0) {
//                    isTrue = true;
//                } else {
//                    isTrue = false;
//                    return isTrue;
//                }
//            }
//            return isTrue;

//            while (result.next()) {
//                id = result.getInt("ID");
//                if (id == 1 || id == 2) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
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




//        Connection con = null;
//        try {
//            con = database.getConnection();
//            Order order = new Order();
//            int price = order.calculatePrice(whereFrom, whereTo, totalDay);
//            int id = getIdByLogin(login);
//            String sqlOrder = "INSERT INTO Orders VALUES (?, ?, ?, ?, ?)";
//            PreparedStatement statement = con.prepareStatement(sqlOrder);
//            statement.setString(1, whereFrom);
//            statement.setString(2, whereTo);
//            statement.setInt(3, id);
//            statement.setInt(4, totalDay);
//            statement.setInt(5, price);
//            statement.execute();
//            return true;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return false;
    }

//    @Override
//    public int getIdByLogin(String login) {
//        Connection con = null;
//        try{
//            con = database.getConnection();
//
//            String sql = "SELECT id FROM LogIn WHERE login = ?";
//            PreparedStatement st = con.prepareStatement(sql);
//            st.setString(1, login);
//            st.execute();
//            ResultSet rs = st.getResultSet();
//            int id = rs.getInt("id");
//            return id;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return -1;
//    }

    @Override
    public List<Order> getOrdersForUserByLogin(String login) {
        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "SELECT * FROM \"Orders\" WHERE \"From_login\"=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, login);
            ResultSet result = st.executeQuery();
            List<Order> orders = new LinkedList<>();
            while (result.next()) {
                Order order = new Order(
                        result.getInt("id"),
                        result.getString("From_city"),
                        result.getString("To_city"),
                        result.getString("From_login"),
                        result.getInt("Days"),
                        result.getInt("Price")
                );
                orders.add(order);
            }
            return orders;
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
        return null;
    }


    @Override
    public boolean isRemovedOrder(String login, String whereTo, String whereFrom) {
        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "DELETE FROM \"Orders\" WHERE \"From_id\"=? AND From_city = ? AND To_city = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, whereFrom);
            statement.setString(3, whereTo);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
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
//    boolean addOrder(String city1, String city2, int days) {
//        Connection con = null;
//        try {
//            con = database.getConnection();
//            String sqlReg = "INSERT INTO Orders VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement statementReg = con.prepareStatement(sqlReg);
//            statementReg.setString(1, city1);
//            statementReg.setString(2,city2);
//            statementReg.setString(3,);
//            statementReg.setDate(4, Date.valueOf(regDate));
//            statementReg.setString(5, wantTo);
//            statementReg.setDate(6, Date.valueOf(atDate));
//            statementReg.execute();
//            return true;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return false;
//    }


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