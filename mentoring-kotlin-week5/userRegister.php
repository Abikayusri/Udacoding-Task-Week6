<?php 
    include_once('koneksi.php');

    if(!empty($_POST['nama']) && !empty($_POST['password']) && !empty($_POST['email'])) {

        $nama = $_POST['nama'];
        $email = $_POST['email'];
        $password = md5($_POST['password']);

        $query = "SELECT * FROM User WHERE user_email = '$email'";
        $get = mysqli_query($connect, $query);
        $data = array();

        if(mysqli_num_rows($get) > 0){
            set_response(false, "Email sudah terdaftar", $data);
        } else {
            $query = "INSERT INTO User(user_nama, user_email, user_password) VALUES ('$nama', '$email',
                    '$password')";
            $insert = mysqli_query($connect, $query);

            if($insert) {
                set_response(true, "Register success");
            } else {
                set_response(false, "Register Failed");
            }
        }
    } else {
        set_response(false, "Data tidak boleh kosong");
    }

    function set_response($isSuccess, $message){
        $result = array(
            'isSuccess' => $isSuccess,
            'message' => $message
        );
        echo json_encode($result);
    }
