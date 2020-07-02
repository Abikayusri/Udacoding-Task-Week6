<?php

$hostname = "localhost";
$username = "root";
$password = "";
$database = "kampus";

$connect = mysqli_connect($hostname, $username, $password, $database);

if (mysqli_connect_errno()) {
    echo "Failed connect to MySql: " . mysqli_connect_error();
    die;
} else {
    // echo "Success connect to MySql";
}
?>