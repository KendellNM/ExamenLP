/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.modelo.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.modelo.config.Conexion;
import pe.edu.upeu.modelo.dao.RolDao;
import pe.edu.upeu.modelo.entity.RolEntity;

/**
 *
 * @author USER
 */
public class RolDaoImpls implements RolDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int createRol(RolEntity r) {
        int x = 0;
        String SQL = "INSERT INTO rol(nombre, estado) VALUES(?,1)";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, r.getNombre());
            x = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return x;
    }

    @Override
    public int updateRol(RolEntity r) {

        int x = 0;
        String SQL = "UPDATE rol SET nombre=?, estado=? WHERE idrol=?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, r.getNombre());
            ps.setInt(2, r.getEstado());
            ps.setInt(3, r.getIdrol());

            x = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return x;
    }

    @Override
    public int deleteRol(int id) {
        int x = 0;
        String SQL = "DELETE FROM rol WHERE idrol=?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);

            x = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return x;
    }

    @Override
    public RolEntity readRol(int id) {
        RolEntity re = new RolEntity();

        String SQL = "SELECT *FROM rol WHERE idrol=?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                re.setIdrol(rs.getInt("idrol"));
                re.setNombre(rs.getString("nombre"));
                re.setEstado(rs.getInt("estado"));

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return re;
    }

    @Override
    public List<RolEntity> readAll() {
        List<RolEntity> lista = new ArrayList<>();
        String SQL = "SELECT *FROM rol";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                RolEntity re = new RolEntity();
                re.setIdrol(rs.getInt("idrol"));
                re.setNombre(rs.getString("nombre"));
                re.setEstado(rs.getInt("estado"));
                lista.add(re);

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return lista;
    }

}
