-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Mar 26, 2024 at 12:56 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bus_driver_management`
--
CREATE DATABASE IF NOT EXISTS `bus_driver_management` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bus_driver_management`;

-- --------------------------------------------------------

--
-- Table structure for table `auth`
--

CREATE TABLE `auth` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `auth`
--

INSERT INTO `auth` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `license_id` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`id`, `name`, `phone`, `license_id`) VALUES
(1, 'Nguyễn Văn An', '0912345678', 2),
(2, 'Trần Tuấn Sơn', '0912445678', 3),
(3, 'Phạm Tấn Tài', '0341082351', 1),
(6, 'Lương Văn Bình', '012345', 2),
(14, 'Vương Văn Nam', '01929292', 2);

-- --------------------------------------------------------

--
-- Table structure for table `driver_map_route`
--

CREATE TABLE `driver_map_route` (
  `driver_id` int(11) NOT NULL,
  `route_id` int(11) NOT NULL,
  `turn_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `driver_map_route`
--

INSERT INTO `driver_map_route` (`driver_id`, `route_id`, `turn_number`) VALUES
(1, 1, 6),
(1, 4, 7),
(2, 1, 3),
(3, 1, 11);

-- --------------------------------------------------------

--
-- Table structure for table `license`
--

CREATE TABLE `license` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `license`
--

INSERT INTO `license` (`id`, `name`, `level`) VALUES
(1, 'Bằng A', 1),
(2, 'Bằng B', 2),
(3, 'Bằng C', 3),
(4, 'Bằng D', 4);

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE `route` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`id`, `name`, `description`) VALUES
(1, 'Xe 03', 'Xe 03'),
(2, 'Xe 05', 'Xe 05'),
(3, 'Xe 06', 'Xe 06'),
(4, 'Xe 08', 'Xe 08'),
(5, 'Xe 10', 'Đây là tuyến xe số 10');

-- --------------------------------------------------------

--
-- Table structure for table `route_map_stopstation`
--

CREATE TABLE `route_map_stopstation` (
  `route_id` int(11) NOT NULL,
  `stop_station_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `route_map_stopstation`
--

INSERT INTO `route_map_stopstation` (`route_id`, `stop_station_id`) VALUES
(1, 1),
(1, 2),
(1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `stop_station`
--

CREATE TABLE `stop_station` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `address` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stop_station`
--

INSERT INTO `stop_station` (`id`, `name`, `address`) VALUES
(1, 'Đại học Bách Khoa Hà Nội', 'Số 1 Đường Giải Phóng'),
(2, 'BHD Phạm Ngọc Thạch', 'Phố Phạm Ngọc Thạch'),
(3, 'Đại học Y Hà Nội', 'Đường Tôn Thất Tùng');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auth`
--
ALTER TABLE `auth`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_2` (`id`),
  ADD KEY `id` (`id`,`license_id`);

--
-- Indexes for table `driver_map_route`
--
ALTER TABLE `driver_map_route`
  ADD PRIMARY KEY (`driver_id`,`route_id`),
  ADD KEY `driver_id` (`driver_id`,`route_id`);

--
-- Indexes for table `license`
--
ALTER TABLE `license`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_2` (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_2` (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `route_map_stopstation`
--
ALTER TABLE `route_map_stopstation`
  ADD PRIMARY KEY (`route_id`,`stop_station_id`),
  ADD KEY `route_id` (`route_id`,`stop_station_id`);

--
-- Indexes for table `stop_station`
--
ALTER TABLE `stop_station`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_2` (`id`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `auth`
--
ALTER TABLE `auth`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `driver`
--
ALTER TABLE `driver`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `license`
--
ALTER TABLE `license`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `route`
--
ALTER TABLE `route`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `stop_station`
--
ALTER TABLE `stop_station`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
