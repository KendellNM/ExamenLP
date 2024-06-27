/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.modelo.test;

import com.google.gson.Gson;
import pe.edu.upeu.modelo.config.Conexion;
import pe.edu.upeu.modelo.dao.RolDao;
import pe.edu.upeu.modelo.dao.UsuarioDao;
import pe.edu.upeu.modelo.daoImpl.RolDaoImpls;
import pe.edu.upeu.modelo.daoImpl.UsuarioDaoImpls;

/**
 *
 * @author USER
 */
public class test {

    static UsuarioDao udao = new UsuarioDaoImpls();
    static Gson g = new Gson();
    static RolDao rdao = new RolDaoImpls();

    public static void main(String[] args) {
        if (Conexion.getConnection() != null) {
            System.out.println("Conectado");

        } else {
            System.out.println("Error");
        }
        udao.actualizarestado("Kendell", "1");

        System.out.println(g.toJson(udao.login("Kendell", "123")));
        UsuarioDao udao = new UsuarioDaoImpls();

        udao.actualizarestado("Kendell", "0");
    }
}
