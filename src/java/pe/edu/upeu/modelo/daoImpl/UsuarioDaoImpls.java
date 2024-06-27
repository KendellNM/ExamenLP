/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.modelo.daoImpl;

import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.modelo.dao.UsuarioDao;
import pe.edu.upeu.modelo.dto.LoginDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import pe.edu.upeu.modelo.config.Conexion;

/**
 *
 * @author USER
 */
public class UsuarioDaoImpls implements UsuarioDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public List<LoginDTO> login(String username, String pass) {
        List<LoginDTO> lista = new ArrayList<>();

        String sql = "SELECT u.idusuario, u.username, u.estado, r.nombre as rol, p.nombre as menu, p.url, p.icono FROM usuario u "
                + "inner join empleado e on u.idempleado = e.idempleado "
                + "inner join rol r on u.idrol=r.idrol "
                + "inner join rol_privilegios rp on r.idrol = rp.idrol "
                + "inner join privilegios p on rp.idprivilegio = p.idprivilegio "
                + "where u.username = ? and u.clave = ?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            while (rs.next()) {

                LoginDTO ld = new LoginDTO();

                if (rs.getString("estado").equals("0")) {
                    System.out.println("Bloqueado");
                    return lista;
                }

                ld.setIdusuario(rs.getInt("idusuario"));
                ld.setUsername(rs.getString("username"));
                ld.setRol(rs.getString("rol"));
                ld.setMenu(rs.getString("menu"));
                ld.setURL(rs.getString("url"));
                ld.setIcon(rs.getString("icono"));
                ld.setEstado(rs.getString("estado"));

                lista.add(ld);
            }
        } catch (Exception e) {
            System.out.println("Consulta: " + e);
        }

        return lista;

    }

    @Override
    public boolean actualizarestado(String username, String estado) {
        String sql = "UPDATE usuario SET estado = ? WHERE username = ?";
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar estado: " + e.getMessage());
        }
        
        return true;
    }

}
