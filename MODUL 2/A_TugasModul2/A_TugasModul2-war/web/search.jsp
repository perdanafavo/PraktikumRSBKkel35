<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Mesin Pencari Mahasiswa</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  </head>
  <body style="background: #5DADE2">
    <header>
      <h1 style="text-align:center">DATA PENCARIAN MAHASISWA KELOMPOK 35</h1>
    </header>
    <main style="display:flex;justify-content:center;flex-direction: column;">
            <form action="search" method="post" style="display:flex;justify-content:center;flex-direction: column;align-items: center;">
                <label for="nama" style="margin-bottom:5px; font-size: 23px">Cari Mahasiswa</label>
                <input id="nama" type="text" name="param" placeholder="Masukan Nama / NIM" style="width:50%; height: 50px; font-size: 20px; text-align: center">
                <span style="color:#641E16; font-size: 25px; margin-top: 15px;">${show}</span>
                <br>
                <input type="submit" name="submit" value="Cari" style="width:50%; height: 50px; font-size: 20px; background-color: #FFC300 ">
            </form>
    </main><br>
    <main style="display:flex;justify-content:center;flex-direction: column;">
            <form action="search" method="get" style="display:flex;justify-content:center;flex-direction: column;align-items: center;">
                <label for="nama" style="margin-bottom:5px; font-size: 23px">Nama Mahasiswa</label>
                <input id="nama" type="text" name="nama" placeholder="Masukkan Nama" style="width:50%; height: 50px; font-size: 20px; text-align: center">
                <br>
                <label for="nim" style="margin-bottom:5px; font-size: 23px">NIM Mahasiswa</label>
                <input id="nim" type="text" name="nim" placeholder="Masukkan NIM" style="width:50%; height: 50px; font-size: 20px; text-align: center">
                <br>
                <input type="submit" name="submit" value="Tambah" style="width:50%; height: 50px; font-size: 20px; background-color: #FFC300">
            </form>
    </main><br>
    <footer style="text-align:center; font-size: 18px">&copy; Copyright Praktikum Rekayasa Perangkat Lunak 2019</footer>
  </body>
</html>
