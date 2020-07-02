<?php

    include_once('koneksi.php');

    if (
        !empty($_POST['nama']) && !empty($_POST['nohp']) && !empty($_POST['jurusan'])
        && !empty($_POST['nim']) && !empty($_POST['semester']) && !empty($_POST['alamat'])
    ) {

        $nama = $_POST['nama'];
        $nohp = $_POST['nohp'];
        $jurusan = $_POST['jurusan'];
        $nim = $_POST['nim'];
        $semester = $_POST['semester'];
        $alamat = $_POST['alamat'];

        $query = "INSERT INTO mahasiswa(mahasiswa_nama, mahasiswa_nohp, mahasiswa_jurusan, 
                  mahasiswa_nim, mahasiswa_semester, mahasiswa_alamat) 
                  VALUES ('$nama', '$nohp', '$jurusan', '$nim', '$semester', '$alamat')";

        $insert = mysqli_query($connect, $query);

        if ($insert) {
            set_response(true, "Success insert data");
        } else {
            set_response(false, "Failed insert data");
        }
    } else {
        set_response(false, "Data tidak boleh kosong");
    }

    function set_response($isSuccess, $message)
    {
        $result = array(
            'isSuccess' => $isSuccess,
            'message' => $message
        );

        echo json_encode($result);
    }
