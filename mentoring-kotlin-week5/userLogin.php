<?php
include_once('koneksi.php');

if (
    !empty($_POST['email']) && !empty($_POST['password'])
) {

    $email = $_POST['email'];
    $password = md5($_POST['password']);

    $query = "SELECT * FROM User WHERE user_email = '$email' AND user_password = '$password'";
    $get = mysqli_query($connect, $query);
    $data = array();

    if (mysqli_num_rows($get) > 0) {
        while ($row = mysqli_fetch_assoc($get)) {
            $data[] = $row;
        }

        set_response(true, "Login Berhasil", $data);
    } else {
        set_response(false, "Login Gagal", $data);
    }
} else {
    set_response(false, "Email dan password harus diisi");
}

function set_response($isSuccess, $message, $data)
{
    $result = array(
        'isSuccess' => $isSuccess,
        'message' => $message,
        'data'  => $data
    );
    echo json_encode($result);
}
?>