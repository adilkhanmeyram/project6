package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Lokomotive;
import com.company.entities.Train;
import com.company.repositories.interfaces.ILokoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LokoRepo implements ILokoRepository {
    private final IDB db;

    public LokoRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createLokomotive(Lokomotive lokomotive) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Lokomotives(name) VALUES (?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, lokomotive.getName());

            boolean executed = st.execute();
            return executed;
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
    public Lokomotive getLokomotive(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name FROM Lokomotives WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Lokomotive lokomotive = new Lokomotive(rs.getInt("id"),
                        rs.getString("name"));


                return lokomotive;
            }
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
        return null;
    }

    @Override
    public List<Lokomotive> getAllLokomotives() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name FROM Lokomotives";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Lokomotive> lokomotives = new ArrayList<>();
            while (rs.next()) {
                Lokomotive lokomotive = new Lokomotive(rs.getInt("id"),
                        rs.getString("name"));


                lokomotives.add(lokomotive);
            }

            return lokomotives;
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
        return null;
    }
}
