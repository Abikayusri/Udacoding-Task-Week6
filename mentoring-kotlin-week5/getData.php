<?php 
    include_once('koneksi.php');

    if(!empty($_GET['id'])){
        $id = $_GET['id'];
        $query = "SELECT * FROM mahasiswa WHERE id_mahasiswa = '$id'";

    } else {
        $query = "SELECT * FROM mahasiswa";
    }

    $get = mysqli_query($connect, $query);
    $data = array();

    if(mysqli_num_rows($get) > 0){
        while ($row = mysqli_fetch_assoc($get)) {
            $data [] = $row;
        }
        set_response(true, "Data ditemukan", $data);
    } else {
        set_response(false, "Data tidak ditemukan", $data);
    }

    function set_response($isSuccess, $message, $data){
        $result = array(
            'isSuccess' => $isSuccess,
            'message' => $message,
            'data' => $data
        );

        echo json_encode($result);
    }
