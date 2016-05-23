-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: May 23, 2016 at 01:20 PM
-- Server version: 5.5.38
-- PHP Version: 5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `vortex`
--

-- --------------------------------------------------------

--
-- Table structure for table `artists`
--

CREATE TABLE `artists` (
`id` double NOT NULL,
  `artist_name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `description_source` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artists`
--

INSERT INTO `artists` (`id`, `artist_name`, `description`, `description_source`) VALUES
(1, 'Coldplay', '', 'MediaNet'),
(2, 'Nicki Minaj', '', 'wikipedia'),
(3, 'Westlife', '', 'wikipedia'),
(4, 'Rabbit', '', 'wikipedia'),
(5, 'Ross', '', 'Wikileaks'),
(6, 'Ross', '', 'Wikileaks'),
(7, 'Jerry 2', '', 'Google'),
(8, 'Tom Cruiz', '', 'medium.com'),
(9, 'Isaiah Katumwa', '', 'http://www.isaiahkatumwa.com/bio');

-- --------------------------------------------------------

--
-- Table structure for table `artist_genres`
--

CREATE TABLE `artist_genres` (
`id` int(11) NOT NULL,
  `artist_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artist_genres`
--

INSERT INTO `artist_genres` (`id`, `artist_id`, `genre_id`) VALUES
(0, 0, 2),
(1, 2, 3),
(2, 3, 9),
(3, 3, 8),
(9, 0, 6),
(12, 0, 4),
(13, 0, 1),
(16, 0, 5),
(17, 7, 0),
(18, 8, 1),
(19, 6, 9),
(20, 1, 9),
(21, 9, 10);

-- --------------------------------------------------------

--
-- Table structure for table `artist_images`
--

CREATE TABLE `artist_images` (
`id` int(11) NOT NULL,
  `artist_id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artist_images`
--

INSERT INTO `artist_images` (`id`, `artist_id`, `image_id`) VALUES
(0, 0, 1),
(1, 1, 4),
(2, 1, 2),
(3, 0, 3),
(6, 0, 4),
(9, 0, 2),
(10, 0, 5),
(11, 8, 4),
(12, 1, 3),
(13, 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` double NOT NULL,
  `url` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
`id` int(11) NOT NULL,
  `venue_id` double NOT NULL,
  `ticketinfo_id` double NOT NULL,
  `name` varchar(100) NOT NULL,
  `eventDateLocal` datetime NOT NULL,
  `distance` double NOT NULL,
  `imageUrl` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `venue_id`, `ticketinfo_id`, `name`, `eventDateLocal`, `distance`, `imageUrl`) VALUES
(2, 4, 2, 'Jazz and Beats Africa Tour (Concert)', '2016-05-20 20:00:00', 0.4872824443740141, 'cecad-jazz.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `event_artists`
--

CREATE TABLE `event_artists` (
`id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `artist_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_artists`
--

INSERT INTO `event_artists` (`id`, `event_id`, `artist_id`) VALUES
(0, 2, 9);

-- --------------------------------------------------------

--
-- Table structure for table `event_images`
--

CREATE TABLE `event_images` (
`id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_images`
--

INSERT INTO `event_images` (`id`, `event_id`, `image_id`) VALUES
(0, 0, 0),
(2, 0, 0),
(3, 0, 3),
(4, 0, 2),
(7, 0, 4),
(10, 0, 1),
(12, 0, 5),
(19, 2, 3),
(20, 2, 4),
(21, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `event_venues`
--

CREATE TABLE `event_venues` (
  `id` int(10) NOT NULL,
  `event_id` int(10) NOT NULL,
  `venue_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `genres`
--

CREATE TABLE `genres` (
`id` double NOT NULL,
  `genre` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genres`
--

INSERT INTO `genres` (`id`, `genre`) VALUES
(1, 'Pop'),
(2, 'Rock'),
(3, 'Hip Hop'),
(4, 'Rock'),
(5, 'Gospel'),
(6, 'Crank'),
(7, 'Soul'),
(8, 'RnB'),
(9, 'Blues'),
(10, 'Jazz');

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
`id` double NOT NULL,
  `url` varchar(100) NOT NULL,
  `type` varchar(50) NOT NULL,
  `resizableInd` varchar(50) NOT NULL,
  `credit` varchar(50) NOT NULL,
  `primaryInd` varchar(50) NOT NULL,
  `height` double NOT NULL,
  `width` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `images`
--

INSERT INTO `images` (`id`, `url`, `type`, `resizableInd`, `credit`, `primaryInd`, `height`, `width`) VALUES
(2, 'dbbbd-t-shirt-2.jpg', 'jpg', '1', 'dfdf', '2', 200, 300),
(3, '82d19-6.png', 'jpg', '1', 'dfdf', '2', 200, 300),
(4, 'aec4f-5.png', 'jpg', '1', 'dfdf', '2', 200, 300),
(5, 'ea886-news.png', 'jpg', '1', 'dfdf', '2', 200, 300);

-- --------------------------------------------------------

--
-- Table structure for table `performers`
--

CREATE TABLE `performers` (
  `id` double NOT NULL,
  `name` varchar(50) NOT NULL,
  `url` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ticketinfos`
--

CREATE TABLE `ticketinfos` (
`id` int(11) NOT NULL,
  `minPrice` double NOT NULL,
  `maxPrice` double NOT NULL,
  `minListPrice` double NOT NULL,
  `maxListPrice` double NOT NULL,
  `totalTickets` double NOT NULL,
  `totalPostings` double NOT NULL,
  `totalListings` double NOT NULL,
  `popularity` double NOT NULL,
  `currencyCode` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ticketinfos`
--

INSERT INTO `ticketinfos` (`id`, `minPrice`, `maxPrice`, `minListPrice`, `maxListPrice`, `totalTickets`, `totalPostings`, `totalListings`, `popularity`, `currencyCode`) VALUES
(2, 0, 12.052, 12.02, 0.2, 20, 0.2, 120, 21.3, 'USD'),
(3, 0, 2, 1, 20, 0, 20, 120, 2, 'USD');

-- --------------------------------------------------------

--
-- Table structure for table `urls`
--

CREATE TABLE `urls` (
  `id` double NOT NULL,
  `artist_id` double NOT NULL,
  `official_url` varchar(50) NOT NULL,
  `lastfm_url` varchar(50) NOT NULL,
  `twitter_url` varchar(50) NOT NULL,
  `myspace_url` varchar(50) NOT NULL,
  `wikipedia_url` varchar(50) NOT NULL,
  `mb_url` varchar(100) NOT NULL,
  `facebook_url` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
`id` int(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` enum('user','admin') NOT NULL DEFAULT 'user'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `role`) VALUES
(1, 'Bryan Lamtoo', 'bryanlamtoo@gmail.com', 'bryan', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `venues`
--

CREATE TABLE `venues` (
`id` double NOT NULL,
  `name` varchar(100) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `timezone` varchar(50) NOT NULL,
  `address1` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `postalCode` double NOT NULL,
  `country` varchar(50) NOT NULL,
  `url` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `venues`
--

INSERT INTO `venues` (`id`, `name`, `latitude`, `longitude`, `timezone`, `address1`, `city`, `state`, `postalCode`, `country`, `url`) VALUES
(1, 'KICC Nairobi', 12.218512, 2.215555, '+3', '0100', 'Nairobi', 'Nairobi', 254, 'Kenya', ''),
(2, 'Mombasa', 2.152455, 3.22254, '+3', '362 Mombasas', 'Mombasasa', 'Mombasa', 254, 'Kenya', ''),
(3, 'Kampala', 0.3476, 32.5825, '+3', 'Lumumba Avenue', 'Kampala', 'Wandegeya', 256, 'Uganda', ''),
(4, 'Golf Course Hotel ', 0.3206519, 32.520077, '+3', ' Plot 64-88 Yusuf Lule Road', 'Kampala', 'Central Region', 256, 'Uganda', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artists`
--
ALTER TABLE `artists`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `artist_genres`
--
ALTER TABLE `artist_genres`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `artist_images`
--
ALTER TABLE `artist_images`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `event_artists`
--
ALTER TABLE `event_artists`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `event_images`
--
ALTER TABLE `event_images`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `genres`
--
ALTER TABLE `genres`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `performers`
--
ALTER TABLE `performers`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ticketinfos`
--
ALTER TABLE `ticketinfos`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `urls`
--
ALTER TABLE `urls`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venues`
--
ALTER TABLE `venues`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artists`
--
ALTER TABLE `artists`
MODIFY `id` double NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `artist_genres`
--
ALTER TABLE `artist_genres`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `artist_images`
--
ALTER TABLE `artist_images`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `event_artists`
--
ALTER TABLE `event_artists`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `event_images`
--
ALTER TABLE `event_images`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `genres`
--
ALTER TABLE `genres`
MODIFY `id` double NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
MODIFY `id` double NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `ticketinfos`
--
ALTER TABLE `ticketinfos`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
MODIFY `id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `venues`
--
ALTER TABLE `venues`
MODIFY `id` double NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
