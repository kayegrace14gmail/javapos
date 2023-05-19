-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2023 at 09:01 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `productID` bigint(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(200) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(10) NOT NULL,
  `category` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productID`, `name`, `description`, `price`, `quantity`, `category`) VALUES
(1002232212144, 'TV', '32-inch TV set', 420000, 33, 'Electronics'),
(1002232212145, 'Manu Jersy', 'Cotton Man-u Jersy ', 20000, 45, 'Cosmetics'),
(1002232212146, 'Darling braids', 'Long tail braids from Italy', 4000, 22, 'Cosmetics'),
(1002232212147, 'Dress', 'Cotton dress', 40000, 23, 'Clothing'),
(1002232212148, 'Hijack Woofer', 'A high quality sound equipment', 150000, 17, 'Electronics'),
(1002232212149, 'Denovo cake', 'sugarless cake for diabetics', 20000, 51, 'Bakery'),
(1002232212150, 'Fresh cut sausages', 'Meat sausages, freshly packaged', 5000, 68, 'Grocery'),
(1002232212152, 'cake', 'Good cake', 3000, 198, 'Bakery'),
(1002232212153, 'Frozen chicken', 'Frozen pieces of a full chicken', 25000, 100, 'Grocery'),
(1002232212154, 'Soda', 'SOda', 1000, 198, 'Beverage'),
(1002232212155, 'Tiptop bread', 'sweet bread', 3000, 200, 'Bakery');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `transactionID` int(11) NOT NULL,
  `amount` double NOT NULL,
  `date_time` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`transactionID`, `amount`, `date_time`) VALUES
(35, 6000, '20230426_162126'),
(36, 6000, '20230511_183729'),
(37, 99000, '20230512_081547'),
(38, 70000, '20230512_125831');

-- --------------------------------------------------------

--
-- Table structure for table `transaction_quantity`
--

CREATE TABLE `transaction_quantity` (
  `transactionID` int(10) NOT NULL,
  `productID` bigint(20) NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction_quantity`
--

INSERT INTO `transaction_quantity` (`transactionID`, `productID`, `quantity`) VALUES
(35, 1002232212152, 2),
(36, 1002232212154, 2),
(37, 1002232212147, 2),
(37, 1002232212150, 3),
(38, 1002232212146, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`transactionID`);

--
-- Indexes for table `transaction_quantity`
--
ALTER TABLE `transaction_quantity`
  ADD PRIMARY KEY (`transactionID`,`productID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `productID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1002232212156;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `transactionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
