/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package config;
import javax.xml.crypto.Data;
import java.awt.dnd.DropTarget;
import java.sql.*;
/**
 *
 * @author LENOVO
 */
public class Database {
    public static Connection getConnection()
    {
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_ppdb_kuliah";
        String username = "root";
        String password = "";
        try{
            Class.forName(driver);
            
            return DriverManager.getConnection(url,username,password);
        }catch(Exception e){
            System.out.println(e);
        }
        return conn;
    }

    public static void printTable()
    {
        Connection conn = Database.getConnection();
        String sql = "SELECT * FROM JURUSAN";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt("ID_JURUSAN")
                        + " | " + rs.getInt("ID_KAMPUS")
                        + " | " + rs.getString("NAMA_JURUSAN")
                        + " | " + rs.getInt("HARGA"));
            }
        }catch (SQLException e){

        }
    }

    public static void updateNamaJurusan()
    {
        Connection conn = Database.getConnection();
        String sql = "UPDATE JURUSAN SET NAMA_JURUSAN = ? WHERE ID_JURUSAN = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "TEKNIK INDUSTRI");
            ps.setInt(2, 450000);
            ps.executeUpdate();
            System.out.println("Update Success");
        }catch (SQLException E){

        }
    }

    public static void insertJurusan()
    {
        Connection conn = Database.getConnection();
        String sql = "INSERT INTO JURUSAN VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 8);
            ps.setInt(2, 15);
            ps.setString(3, "TEKNIK SIPIL");
            ps.setInt(4, 1000000);
            ps.executeUpdate();
        }catch (Exception E){

        }
    }


    public static void selectPendaftaran()
    {
        Connection conn = Database.getConnection();
        String sql = "SELECT * FROM PENDAFTARAN";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getInt("ID_PENDAFTARAN")
                        + " | " + rs.getInt("ID_GELOMBANG")
                        + " | " + rs.getInt("ID_PESERTA")
                        + " | " + rs.getInt("ID_JURUSAN")
                        + " | " + rs.getInt("UANG_GEDUNG")
                        + " | " + rs.getInt("UANG_PENDAFTARAN")
                        + " | " + rs.getInt("TAHUN_PENDAFTARAN"));
            }
        } catch (Exception E) {

        }
    }

    public static void joinPesertaKampusJurusan()
    {
        Connection conn = Database.getConnection();
        String sql = "SELECT PESERTA.Nama_peserta, KAMPUS.NAMA_KAMPUS, JURUSAN.NAMA_JURUSAN FROM PESERTA\n" +
                "JOIN PENDAFTARAN ON PESERTA.id_peserta = PENDAFTARAN.id_peserta\n" +
                "JOIN JURUSAN ON JURUSAN.ID_JURUSAN = PENDAFTARAN.ID_JURUSAN\n" +
                "JOIN KAMPUS ON KAMPUS.ID_KAMPUS = JURUSAN.ID_KAMPUS;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("Nama_peserta")
                        + " | " + rs.getString("NAMA_KAMPUS")
                        + " | " + rs.getString("NAMA_JURUSAN")) ;
            }
        }catch (SQLException E){

        }
    }

    public static void selectPeserta()
    {
        Connection conn = Database.getConnection();
        String sql = "SELECT * FROM peserta";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getInt("id_peserta")
                        + " | " + rs.getString("Nama_peserta")
                        + " | " + rs.getString("Alamat_peserta")
                        + " | " + rs.getString("Asal_sekolah")
                        + " | " + rs.getString("Email")
                        + " | " + rs.getString("no_hp")
                        + " | " + rs.getString("TTL"));
            }
        } catch (Exception E) {

        }
    }

    public static void selectKampus()
    {
        Connection conn = Database.getConnection();
        String sql = "SELECT * FROM KAMPUS";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getInt("ID_KAMPUS")
                        + " | " + rs.getString("NAMA_KAMPUS")
                        + " | " + rs.getString("ALAMAT_KAMPUS"));
            }
        } catch (Exception E) {

        }
    }

    public static void selectGelombang_Pendaftaran()
    {
        Connection conn = Database.getConnection();
        String sql = "SELECT * FROM GELOMBANG_PENDAFTARAN";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getInt("ID_GELOMBANG")
                        + " | " + rs.getInt("JENIS_GELOMBANG"));
            }
        } catch (Exception E) {

        }
    }

    //public static void deleteJurusan()
    //{
      //  Connection conn = Database.getConnection();
       // String sql = "DELETE FROM JURUSAN WHERE HARGA = 450000";
        //try {
          //  PreparedStatement ps = conn.prepareStatement(sql);
            //ps.execute();
        //}catch (SQLException e){
          //  System.out.println(e);
        //}
    //}

    public static void deletePendaftaran()
    {
        Connection conn = Database.getConnection();
        String sql = "DELETE FROM pendaftaran WHERE ID_PENDAFTARAN = 9";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Delete Success");
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void tambahkampus()
    {
        Connection conn = Database.getConnection();
        String sql = "INSERT INTO kampus values (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 22);
            ps.setString(2, "ITS");
            ps.setString(3, "JL.TEKNIK KIMIA");
            ps.executeUpdate();
            System.out.println("Tambah Kampus Sukses");
        }catch (Exception E){

        }
    }



    public static void main(String[] args){

        //updateNamaJurusan();
        //tambahkampus();
          deletePendaftaran();
        //printTable();
        //insertJurusan();
//        printTable();
        //deleteJurusan();
        //printTable();
        //insertJurusan();
        //selectPeserta();
        //printTable();
        //insertJurusan();
//        deleteGelombang_pendaftaran();
        //printTable();
        //selectGelombang_Pendaftaran();

    }
}
