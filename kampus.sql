-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 02 Jul 2020 pada 17.52
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kampus`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id_mahasiswa` int(11) NOT NULL,
  `mahasiswa_nama` varchar(200) NOT NULL,
  `mahasiswa_nohp` varchar(12) NOT NULL,
  `mahasiswa_jurusan` varchar(200) NOT NULL,
  `mahasiswa_nim` int(10) NOT NULL,
  `mahasiswa_semester` int(2) NOT NULL,
  `mahasiswa_alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `mahasiswa`
--

INSERT INTO `mahasiswa` (`id_mahasiswa`, `mahasiswa_nama`, `mahasiswa_nohp`, `mahasiswa_jurusan`, `mahasiswa_nim`, `mahasiswa_semester`, `mahasiswa_alamat`) VALUES
(20, 'M. Nur Fazrin', '123456789012', 'Teknik Informatika', 1121400590, 5, 'Bektim'),
(21, 'Adam Levigne', '081234567890', 'Teknik Pertambangan', 1111400590, 10, 'Kerawang'),
(22, 'John Lennon', '080987654321', 'Teknik Permrinyakan', 1131400590, 8, 'Margonda'),
(23, 'M. Toha', '081234567890', 'Teknik Informatika', 1111400590, 12, 'Cikarang'),
(26, 'Ahmad Abdurrohman', '081234567890', 'Teknik Kelautan', 1131400590, 3, 'Karawang'),
(29, 'Eko Nugroho', '081234578901', 'Teknik Kelautan', 1151400590, 7, 'Cibitung');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_nama` varchar(50) NOT NULL,
  `user_email` varchar(60) NOT NULL,
  `user_password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`user_id`, `user_nama`, `user_email`, `user_password`) VALUES
(1, 'abika1', 'abika1@gmail.com', 'c10edb36c52047768ac2ef0ee6712c24'),
(2, 'abika2', 'abika2@gmail.com', '902ffa607478641a9ff86c470ef9b289'),
(3, 'abika3', 'abika3@gmail.com', '73673424b758f5bb34cce2be34830de2'),
(4, 'abika4', 'abika4@gmail.com', '73673424b758f5bb34cce2be34830de2'),
(5, 'Abikayusri', 'abikagmai', '73673424b758f5bb34cce2be34830de2'),
(6, 'Abikayusri', 'abikayusri1@gmail.com', '73673424b758f5bb34cce2be34830de2'),
(10, 'Udacoding1', 'udacoding1@gmail.com', '110ba5022e72359ab172ac360242a8cf'),
(11, 'Testing1', 'testing1@gmail.com', 'e10adc3949ba59abbe56e057f20f883e');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id_mahasiswa`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id_mahasiswa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
