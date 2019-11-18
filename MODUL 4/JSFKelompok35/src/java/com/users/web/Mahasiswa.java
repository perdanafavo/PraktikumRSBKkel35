/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author Hakushuu
 */
@ManagedBean
@RequestScoped
public class Mahasiswa {

   private UIComponent buttontambah, buttonupdate;

   private String NIM;
    public void setNIM(String NIM) {
        this.NIM = NIM;
    }
    public String getNIM() {
        return NIM;
    }

    private String NAMA;
    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }
    public String getNAMA() {
        return NAMA;
    }
    
    private String PENJURUSAN;
    public void setPENJURUSAN(String PENJURUSAN) {
        this.PENJURUSAN = PENJURUSAN;
    }
    public String getPENJURUSAN() {
        return PENJURUSAN;
    }
    public void setbuttontambah(UIComponent buttontambah){
       this.buttontambah=buttontambah;
   }
      public UIComponent getbuttontambah(){
       return buttontambah;
   }

   public void setbuttonupdate(UIComponent buttonupdate){
       this.buttonupdate=buttonupdate;
   }
       public UIComponent getbuttonupdate(){
       return buttonupdate;
   }
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 

    public String Edit_Mahasiswa(){
     FacesContext fc = FacesContext.getCurrentInstance();
     Map<String,String > params = fc.getExternalContext().getRequestParameterMap();
     String Field_NIM = params.get("action");
     try {
          Koneksi obj_koneksi = new Koneksi();
          Connection connection = obj_koneksi.get_connection();
          Statement st = connection.createStatement();
          ResultSet rs = st.executeQuery("select * from mahasiswa where NIM="+Field_NIM);
          Mahasiswa obj_Mahasiswa = new Mahasiswa();
          rs.next();
          obj_Mahasiswa.setNIM(rs.getString("NIM"));
          obj_Mahasiswa.setNAMA(rs.getString("Nama"));
          obj_Mahasiswa.setPENJURUSAN(rs.getString("Penjurusan"));
          sessionMap.put("EditMahasiswa", obj_Mahasiswa);  
      } catch (Exception e) {
            System.out.println(e);
      }
     return "/Edit.xhtml?faces-redirect=true";   
   }

  public String Delete_Mahasiswa(){
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
      String Field_NIM = params.get("action");
      try {
         Koneksi obj_koneksi = new Koneksi();
         Connection connection = obj_koneksi.get_connection();
         PreparedStatement ps = connection.prepareStatement("delete from mahasiswa where NIM=?");
         ps.setString(1, Field_NIM);
         System.out.println(ps);
         ps.executeUpdate();
        } catch (Exception e) {
         System.out.println(e);
        }
       return "/index.xhtml?faces-redirect=true";   
  }

  public String Update_Mahasiswa(){
    FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
      String Update_NIM= params.get("Update_NIM");
      
      try {       
          
          if (PENJURUSAN.equalsIgnoreCase("Software")){
               Koneksi obj_koneksi = new Koneksi();
          Connection connection = obj_koneksi.get_connection(); 
              PreparedStatement ps = connection.prepareStatement("update mahasiswa set NIM=?, nama=?, penjurusan='Software' where NIM=?");  
                ps.setString(1, NIM);
                ps.setString(2, NAMA);
                ps.setString(3, Update_NIM); 
                ps.executeUpdate(); 
               return "/index.xhtml?faces-redirect=true";
            }else if (PENJURUSAN.equalsIgnoreCase("Jaringan")){
                Koneksi obj_koneksi = new Koneksi();
          Connection connection = obj_koneksi.get_connection();
                PreparedStatement ps = connection.prepareStatement("update mahasiswa set NIM=?, nama=?, penjurusan='Jaringan' where NIM=?");  
                ps.setString(1, NIM);
                ps.setString(2, NAMA);
                ps.setString(3, Update_NIM); 
                ps.executeUpdate(); 
               return "/index.xhtml?faces-redirect=true";
            }else if (PENJURUSAN.equalsIgnoreCase("Multimedia")){
                Koneksi obj_koneksi = new Koneksi();
          Connection connection = obj_koneksi.get_connection();
                PreparedStatement ps = connection.prepareStatement("update mahasiswa set NIM=?, nama=?, penjurusan='Multimedia' where NIM=?");  
                ps.setString(1, NIM);
                ps.setString(2, NAMA);
                ps.setString(3, Update_NIM); 
                ps.executeUpdate(); 
               return "/index.xhtml?faces-redirect=true";
            }else if (PENJURUSAN.equalsIgnoreCase("Embedded")){
                Koneksi obj_koneksi = new Koneksi();
          Connection connection = obj_koneksi.get_connection();
                PreparedStatement ps = connection.prepareStatement("update mahasiswa set NIM=?, nama=?, penjurusan='Embedded' where NIM=?");  
                ps.setString(1, NIM);
                ps.setString(2, NAMA);
                ps.setString(3, Update_NIM); 
                ps.executeUpdate(); 
               return "/index.xhtml?faces-redirect=true";
            }else {
                
            return "/EditError.xhtml?faces-redirect=true";
            }
      } catch (Exception e) {
          System.out.println(e);
      }

      return "/index.xhtml?faces-redirect=true";   
  }
    
   public ArrayList getGet_all_mahasiswa() throws Exception{
        ArrayList list_of_mahasiswa=new ArrayList();
             Connection connection=null;
        try {
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from mahasiswa order by 'NIM' ASC");
            while(rs.next()){
                Mahasiswa obj_Mahasiswa = new Mahasiswa();
                obj_Mahasiswa.setNIM(rs.getString("NIM"));
                obj_Mahasiswa.setNAMA(rs.getString("Nama"));
                obj_Mahasiswa.setPENJURUSAN(rs.getString("Penjurusan"));
                list_of_mahasiswa.add(obj_Mahasiswa);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(connection!=null){
                connection.close();
            }
        }
        return list_of_mahasiswa;
    }
    
  public String Tambah_Mahasiswa(){
     try {
          Connection connection=null;
          Koneksi obj_koneksi = new Koneksi();
          connection = obj_koneksi.get_connection();
          PreparedStatement ps = connection.prepareStatement("insert into mahasiswa(NIM, Nama, penjurusan) value('" + NIM + "','" + NAMA + "','" + PENJURUSAN + "')");
            if (PENJURUSAN.equalsIgnoreCase("Software")){
               PreparedStatement pl = connection.prepareStatement("insert into mahasiswa(NIM, Nama, penjurusan) value('" + NIM + "','" + NAMA + "','Software')");
               pl.executeUpdate(); 
               return "/index.xhtml?faces-redirect=true";
            }else if (PENJURUSAN.equalsIgnoreCase("Multimedia")){
               PreparedStatement pl = connection.prepareStatement("insert into mahasiswa(NIM, Nama, penjurusan) value('" + NIM + "','" + NAMA + "','Multimedia')");
               pl.executeUpdate(); 
               return "/index.xhtml?faces-redirect=true";
            }else if (PENJURUSAN.equalsIgnoreCase("Jaringan")){
               PreparedStatement pl = connection.prepareStatement("insert into mahasiswa(NIM, Nama, penjurusan) value('" + NIM + "','" + NAMA + "','Jaringan')");
               pl.executeUpdate();
               return "/index.xhtml?faces-redirect=true";
            }else if (PENJURUSAN.equalsIgnoreCase("Embedded")){
               PreparedStatement pl = connection.prepareStatement("insert into mahasiswa(NIM, Nama, penjurusan) value('" + NIM + "','" + NAMA + "','Embedded')");
               pl.executeUpdate();
               return "/index.xhtml?faces-redirect=true";
            }else {
               return "/TambahError.xhtml?faces-redirect=true";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return PENJURUSAN;
  }

    
  public Mahasiswa() {}
    
}
