/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasModul2;

import javax.ejb.Local;

@Local
public interface cariMahasiswaLocal {
    String search(String param);
    void cekMahasiswa(String nama,String nim);
}
