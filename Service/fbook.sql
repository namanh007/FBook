-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 24, 2018 at 04:03 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 5.6.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fbook`
--

-- --------------------------------------------------------

--
-- Table structure for table `album`
--

CREATE TABLE `album` (
  `user_id` varchar(24) NOT NULL,
  `url` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `auth`
--

CREATE TABLE `auth` (
  `user_id` varchar(24) CHARACTER SET ascii NOT NULL,
  `password` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `auth`
--

INSERT INTO `auth` (`user_id`, `password`) VALUES
('username0', '305e4f55ce823e111a46a9d500bcb86c'),
('username1', '7c6a180b36896a0a8c02787eeafb0e4c'),
('username10', '87e897e3b54a405da144968b2ca19b45'),
('username11', '1e5c2776cf544e213c3d279c40719643'),
('username12', 'c24a542f884e144451f9063b79e7994e'),
('username13', 'ee684912c7e588d03ccb40f17ed080c9'),
('username2', '6cb75f652a9b52798eb6cf2201057c73'),
('username3', '819b0643d6b89dc9b579fdfc9094f28e'),
('username4', '34cc93ece0ba9e3f6f235d4af979b16c'),
('username5', 'db0edd04aaac4506f7edab03ac855d56'),
('username6', '218dd27aebeccecae69ad8408d9a36bf'),
('username7', '00cdb7bb942cf6b290ceb97d6aca64a3'),
('username8', 'b25ef06be3b6948c0bc431da46c2c738'),
('username9', '5d69dd95ac183c9643780ed7027d128a');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `code` tinytext CHARACTER SET ascii NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`code`, `name`) VALUES
('AF', 'Afghanistan'),
('AX', 'Åland Islands');

-- --------------------------------------------------------

--
-- Table structure for table `friend`
--

CREATE TABLE `friend` (
  `user_id` varchar(24) CHARACTER SET ascii NOT NULL,
  `friend_id` varchar(24) CHARACTER SET ascii NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `invite`
--

CREATE TABLE `invite` (
  `user_id` varchar(24) CHARACTER SET ascii NOT NULL,
  `invite_id` varchar(24) CHARACTER SET ascii NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `invite`
--

INSERT INTO `invite` (`user_id`, `invite_id`) VALUES
('username1', 'username2'),
('username1', 'username3');

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE `profile` (
  `user_id` varchar(24) CHARACTER SET ascii NOT NULL,
  `first_name` varchar(28) NOT NULL,
  `last_name` varchar(28) NOT NULL,
  `sex` tinyint(4) NOT NULL,
  `birth` smallint(4) NOT NULL,
  `country` varchar(2) NOT NULL,
  `city` varchar(32) NOT NULL,
  `photo_display` varchar(240) DEFAULT NULL,
  `status` varchar(120) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `profile`
--

INSERT INTO `profile` (`user_id`, `first_name`, `last_name`, `sex`, `birth`, `country`, `city`, `photo_display`, `status`) VALUES
('username0', 'Phú', 'Què', 1, 1996, 'VN', 'Hồ Chí Minh', NULL, NULL),
('username1', 'Vũ Quốc', 'Huy', 1, 1990, 'VN', 'Lạng Sơn', NULL, NULL),
('username10', 'Nguyễn Đình', 'Thộn', 4, 1992, 'VN', 'Hồ Chí Minh', NULL, NULL),
('username11', 'Quân', 'Kun', 4, 1996, 'VN', 'Đà Lạt', NULL, NULL),
('username12', 'Hi', 'Pin', 4, 1996, 'VN', 'Hồ Chí Minh', NULL, NULL),
('username13', 'Trí', 'Mập', 1, 1996, 'VN', 'Hồ Chí Minh', NULL, NULL),
('username2', 'Đoàn Tiến', 'Nam Anh', 2, 1996, 'VN', 'Gia Lai', NULL, NULL),
('username3', 'Hoàng Quốc', 'Thịnh', 1, 1996, 'VN', 'Hồ Chí Minh', NULL, NULL),
('username4', 'Phú', 'Em', 1, 1996, 'US', 'NewYork', NULL, NULL),
('username5', 'Phát', 'Mx', 1, 1996, 'VN', 'Hồ Chí Minh', NULL, NULL),
('username6', 'Nguyễn Đặng', 'Thiên', 1, 1996, 'VN', 'Pleiku', NULL, NULL),
('username7', 'Phú', 'Đĩ', 2, 1996, 'VN', 'Hồ Chí Minh', NULL, NULL),
('username8', 'Nguyễn Hoàng', 'Phúc', 3, 1996, 'VN', 'Long An', NULL, NULL),
('username9', 'Nguyễn Đình', 'Nhi', 0, 1996, 'VN', 'Hồ Chí Minh', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auth`
--
ALTER TABLE `auth`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `invite`
--
ALTER TABLE `invite`
  ADD PRIMARY KEY (`user_id`,`invite_id`);

--
-- Indexes for table `profile`
--
ALTER TABLE `profile`
  ADD PRIMARY KEY (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
