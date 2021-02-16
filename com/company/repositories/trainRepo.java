package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Train;
import com.company.repositories.interfaces.ITrainRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class trainRepo implements ITrainRepository {
    private final IDB db;

    public trainRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createTrain(Train train) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Trains(name, capacity, loko_id) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, train.getName());
            st.setInt(2, train.getCapacity());
            st.setInt(3, train.getLokoID());

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
    public Train getTrain(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, capacity, loko_id FROM Trains WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Train train = new Train(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("capacity"),
                        rs.getInt("loko_id"));

                return train;
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
    public List<Train> getAllTrains() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, capacity, loko_id FROM Trains";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Train> trains = new ArrayList<>();
            while (rs.next()) {
                Train train = new Train(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("capacity"),
                        rs.getInt("loko_id"));

                trains.add(train);
            }

            return trains;
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
