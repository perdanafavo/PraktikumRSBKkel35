/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasModul2;

import javax.ejb.Stateful;
import java.util.ArrayList;

@Stateful

public class cariMahasiswa implements cariMahasiswaLocal {
    ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<Mahasiswa>();
    public void cekMahasiswa(String nama,String nim){
        dataMahasiswa.add(new Mahasiswa(nama,nim));
    }
    
    public cariMahasiswa() {
          cekMahasiswa("Rio Kisna Eka Putra","21120116130060");
          cekMahasiswa("Alfian Aulia Firdaus","21120116130035");
          cekMahasiswa("Favo Perdana HS","21120116120015");
          cekMahasiswa("Farrell Denando","21120116120022");
          cekMahasiswa("Tendi Nugeraha","21120116140039");
    }

    private String checkNama(String param){
    for (int i = 0; i < dataMahasiswa.size(); i++){
        if(param.equals(dataMahasiswa.get(i).nama)){
            return "Nama Praktikan : " +dataMahasiswa.get(i).nama+" ("+dataMahasiswa.get(i).nim+")";
        }
    }
    return null;
}
private String checkNIM(String param){
    for (int i = 0; i < dataMahasiswa.size(); i++) {
        if(param.equals(dataMahasiswa.get(i).nim)){
            return "Nama Praktikan : " +dataMahasiswa.get(i).nama+" (" +dataMahasiswa.get(i).nim+")";
        }
    }
    return null;
}

public String search(String param){
    if (checkNama(param) != null) {
        return checkNama(param);
    }
    else if (checkNIM(param) !=null) {
        return checkNIM(param);
    }
    else {
        return "Mahasiswa Tidak Terdaftar";
    }
};
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
