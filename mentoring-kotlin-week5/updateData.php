<?php 
    include_once('koneksi.php');

    if (
        !empty($_POST['id']) && !empty($_POST['nama']) && !empty($_POST['nohp']) && !empty($_POST['jurusan'])
        && !empty($_POST['nim']) && !empty($_POST['semester']) && !empty($_POST['alamat'])
    ) {

        $id = $_POST['id'];
        $nama = $_POST['nama'];
        $nohp = $_POST['nohp'];
        $jurusan = $_POST['jurusan'];
        $nim = $_POST['nim'];
        $semester = $_POST['semester'];
        $alamat = $_POST['alamat'];

        $query = "UPDATE mahasiswa SET mahasiswa_nama = '$nama', mahasiswa_nohp = '$nohp', mahasiswa_jurusan = '$jurusan',
                 mahasiswa_nim = '$nim', mahasiswa_semester = '$semester', mahasiswa_alamat = '$alamat' 
                 WHERE id_mahasiswa = '$id'";

        $update = mysqli_query($connect, $query);

        if($update) {
            set_response(true, "Success update data");
        } else {
            set_response(false, "Failed update data");
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
