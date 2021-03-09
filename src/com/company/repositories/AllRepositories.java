package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.*;
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

            return (resLogin.next() && resPassword.next()) || (resLogin.next());
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

    public boolean hasLogin(String login) {
        Connection connection = null;
        try {
            connection = database.getConnection();

            //Login
            String sqlLogin = "SELECT \"Login\" FROM \"LogIn\" where \"Login\" = ?";
            PreparedStatement statementLogin = connection.prepareStatement(sqlLogin);
            statementLogin.setString(1, login);
            statementLogin.execute();

            ResultSet resLogin = statementLogin.getResultSet();

            return resLogin.next();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

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
            if (result.next()) {
                id = result.getInt("ID");
                return id == 4 || id == 5;
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

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

            if (result.next()) {
                from = result.getString("From_city");
                to = result.getString("To_city");
                login = result.getString("From_login");
                return from.length() > 0 && to.length() > 0 && login.length() > 0;
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

    ///

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
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

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
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

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
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

    public List<Travel_places> getAllPlaces() {
        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "SELECT * FROM \"Travel_places\"";
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);
            List<Travel_places> travelPlaces = new LinkedList<>();
            while (result.next()) {
                Travel_places travelPlace = new Travel_places(
                        result.getInt("ID"),
                        result.getString("Place1"),
                        result.getString("Place2"),
                        result.getDate("Date"),
                        result.getString("Reiteration_every"),
                        result.getInt("Price_per_day")
                );
                travelPlaces.add(travelPlace);
            }
            return travelPlaces;
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

    ///

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
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

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
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

    public boolean addPlace(String name, Date starting_date, String reiteration, int price) {
        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "INSERT INTO \"Travel_places\"(\"Name\", \"Starting_date\", \"Reiteration_every...\") VALUES(?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setDate(2, starting_date);
            statement.setString(3, reiteration);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

    ///

    public boolean removeUser(int id) {
        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "DELETE FROM \"LogIn\" WHERE \"ID\"=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

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
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

    public boolean removePlace(int id) {
        Connection connection = null;
        try {
            connection = database.getConnection();

            String sql = "DELETE FROM \"Travel_places\" WHERE \"ID\"=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }
}