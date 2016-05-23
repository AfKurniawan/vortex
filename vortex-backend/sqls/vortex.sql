-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 20, 2016 at 08:05 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eventhub`
--

-- --------------------------------------------------------

--
-- Table structure for table `artists`
--

CREATE TABLE `artists` (
  `id` double NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `description_source` varchar(50) NOT NULL,
  `familiarity` varchar(50) NOT NULL,
  `hotttnesss` varchar(50) NOT NULL,
  `discovery` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artists`
--

INSERT INTO `artists` (`id`, `name`, `description`, `description_source`, `familiarity`, `hotttnesss`, `discovery`) VALUES
(1, 'Coldplay', '<p>\r\n	<span style="color: rgb(11, 117, 0); font-family: monospace; font-size: 13px; line-height: 18px; white-space: pre-wrap;">Coldplay is an English alternative rock band formed in 1996 by lead vocalist Chris Martin and lead guitarist Jonny Buckland at University College London. Guy Berryman joined the group as a bassist and they changed their name to Starfish. Will Champion joined as a drummer, backing vocalist, and multi-instrumentalist, completing the lineup. Manager Phil Harvey is often considered an unofficial fifth member. \\nThe band renamed themselves &ldquo;Coldplay&rdquo; in 1998, before recording and releasing three EPs, &ldquo;Safety&rdquo; in 1998, &ldquo;Brothers &amp; Sisters&rdquo; as a single in 1999 and &ldquo;The Blue Room&rdquo; in the same year. The latter was their first release on a major label, after signing to Parlophone. \\nThey achieved worldwide fame with the release of the single &ldquo;Yellow&rdquo; in 2000, followed by their debut album released in the same year. &ldquo;Parachutes,&rdquo; was nominated for the Mercury Prize and won the Grammy Award for Best Alternative Album. Upon release, the album quickly reached #1 in the United Kingdom, and has since been certified 7x platinum. In the United States, the album peaked at #51 on the Billboard 200 Albums chart, and has since been certified 2x platinum.\\nThe band&#39;s second album, 2002&rsquo;s &ldquo;A Rush of Blood to the Head,&rdquo; won multiple awards, and it won the 2003 Grammy for Best Alternative Album for the second time in a row. It has since been certified 8x platinum. The album spawned the hit singles &ldquo;In My Place,&rdquo; &ldquo;The Scientist,&rdquo; &ldquo;Clocks&rdquo; and &ldquo;God Put a Smile upon Your Face.&rdquo; They also won the 2004 Grammy for Record of the Year for the song &ldquo;Clocks.&rdquo;\\nTheir next release, &ldquo;X&amp;Y,&rdquo; received a slightly less enthusiastic yet still generally positive reception upon its release in 2005. The album spawned the singles &ldquo;Speed of Sound,&rdquo; &ldquo;Fix You,&rdquo; &ldquo;Talk,&rdquo; &ldquo;The Hardest Part,&rdquo; &ldquo;What If&rdquo; and &ldquo;White Shadows.&rdquo; The album has been considered a landmark achievement of the band, topping many charts worldwide, including in the U.K. and U.S. with the latter being their first. With accumulated sales of over 11 million units, &ldquo;X&amp;Y&rdquo; was the best-selling album released in 2005 worldwide. &ldquo;X&amp;Y&rdquo; scored Coldplay their third consecutive Mercury Prize nomination. It was also nominated for Best Rock Album at the 48th Grammy Awards.\\nThe band&#39;s fourth studio album, 2008&rsquo;s &ldquo;Viva la Vida or Death and All His Friends,&rdquo; was produced by Brian Eno and Markus Dravs. Five singles were released in promotion of the album, &ldquo;Violet Hill&rdquo; and &ldquo;Viva la Vida&rdquo; in May 2008, &ldquo;Lovers in Japan&rdquo; and &ldquo;Lost!&rdquo; in November 2008 and &ldquo;Strawberry Swing&rdquo; in September 2009. &ldquo;Viva la Vida&rdquo; became the band&#39;s first song to reach #1 in both the U.S. and the U.K. It won Best Rock Album at the 2009 Grammy Awards and globally was the best-selling album of 2008. By September 2009 the album became the most paid-for downloaded album of all time. In the U.S. it peaked at the #1 spot for two weeks.\\nAs one of the world&#39;s best-selling music artists, Coldplay has sold over 50 million records worldwide.</span></p>\r\n', 'MediaNet', '1', '1', '1'),
(2, 'Nicki Minaj', '<p>\r\n	<strong style="color: rgb(0, 0, 0); font-family: Arial, Helvetica, sans; font-size: 11px; line-height: 14px; text-align: justify;">Lorem Ipsum</strong><span style="color: rgb(0, 0, 0); font-family: Arial, Helvetica, sans; font-size: 11px; line-height: 14px; text-align: justify;">&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry&#39;s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</span></p>\r\n', 'wikipedia', '2', '4', '2'),
(3, 'Westlife', '<p>\r\n	<span style="color: rgb(0, 0, 0); font-family: Arial, Helvetica, sans; font-size: 11px; line-height: 14px; text-align: justify;">It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using &#39;Content here, content here&#39;, making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for &#39;lorem ipsum&#39; will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).</span></p>\r\n', 'wikipedia', '5', '3', '1'),
(4, 'Rabbit', '<div>\r\n	Lorem ipsum dolor sit amet, duo iusto oportere mediocrem eu. Pro volumus sapientem ea. Qui ex tamquam molestiae, id his impetus intellegat inciderint. Id alii quas vel.</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Soleat accusata evertitur in sit, vel quaeque delicata eu. Ut per accusam philosophia. Per regione electram id, id est brute temporibus appellantur. Duis omittam gloriatur pri an, duo ex dicat legimus menandri, ea ius harum quodsi saperet. Purto graeco et eos, id alia ubique senserit per, alii tollit intellegat per et. Modo nibh saepe ex ius, modo sale option no pri.</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Ut iracundia dissentias pro. Cum ei nonumy constituto. Ne pri consequat intellegat repudiandae. Vide nonumes intellegam ut pri, laboramus quaerendum pri ex. Labitur appellantur id mel, his mazim indoctum an.</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Veri cetero dissentiunt et nec. Ut cum dolor dictas meliore. Eam dicant graeco probatus at, fabellas assueverit at qui. Ex nobis signiferumque sit, vim in enim elit movet.</div>\r\n<div>\r\n	&nbsp;</div>\r\n<div>\r\n	Eum oporteat qualisque persecuti ex, eum posse repudiare vituperata ea, te homero moderatius interpretaris per. In erat definiebas neglegentur nec, cu eam placerat quaestio. Sit ut mundi repudiare, vim ex viderer expetenda. Quidam corpora mel et, perpetua conclusionemque ei mei, quas voluptaria appellantur no eam. Omnesque lucilius recteque per no, ad dicat ubique liberavisse sit, aperiri tamquam ne qui. Mel sumo efficiantur intellegebat ne, vide tibique qui eu. Minim dolor dissentiet ex sea, eos hinc albucius ad.</div>\r\n', 'wikipedia', '2', '4', '2'),
(5, 'Ross', '<p style="box-sizing: border-box; margin: 0px 0px 1.42857em; padding: 0px; direction: ltr; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; font-size: 20px; line-height: 1.6; text-rendering: optimizeLegibility; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	asically, I&#39;m trying to call data from 2 tables and join them together.</p>\r\n<p style="box-sizing: border-box; margin: 0px 0px 1.42857em; padding: 0px; direction: ltr; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; font-size: 20px; line-height: 1.6; text-rendering: optimizeLegibility; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	Here&#39;s my scenario.</p>\r\n<ul style="box-sizing: border-box; margin: 0px 0px 1.42857em 2.14286em; padding-right: 0px; padding-left: 0px; direction: ltr; font-size: 20px; line-height: 1.6; list-style-position: outside; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	<li style="box-sizing: border-box; margin: 0px; padding: 0px; direction: ltr;">\r\n		<em style="box-sizing: border-box; line-height: inherit;">user</em>&nbsp;table contains a list of users (...duh)</li>\r\n	<li style="box-sizing: border-box; margin: 0px; padding: 0px; direction: ltr;">\r\n		<em style="box-sizing: border-box; line-height: inherit;">categories</em>&nbsp;contains a list of categories</li>\r\n	<li style="box-sizing: border-box; margin: 0px; padding: 0px; direction: ltr;">\r\n		<em style="box-sizing: border-box; line-height: inherit;">user_cats</em>&nbsp;table contains the user_id and category_id</li>\r\n</ul>\r\n<p style="box-sizing: border-box; margin: 0px 0px 1.42857em; padding: 0px; direction: ltr; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; font-size: 20px; line-height: 1.6; text-rendering: optimizeLegibility; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	In other words, one user can have many categories associated.</p>\r\n<p style="box-sizing: border-box; margin: 0px 0px 1.42857em; padding: 0px; direction: ltr; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; font-size: 20px; line-height: 1.6; text-rendering: optimizeLegibility; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	For some reason, I can&#39;t for the life of me write scripts for the model and controller that calls data from all 3 tables, and joins them in the relevant way and stores them into an array so I can echo out into a table, with headings&nbsp;<span style="box-sizing: border-box; font-weight: 700; line-height: inherit;">User</span>,&nbsp;<span style="box-sizing: border-box; font-weight: 700; line-height: inherit;">Categories</span>.</p>\r\n<p style="box-sizing: border-box; margin: 0px 0px 1.42857em; padding: 0px; direction: ltr; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; font-size: 20px; line-height: 1.6; text-rendering: optimizeLegibility; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	If anyone could help out that would be great.</p>\r\n<p style="box-sizing: border-box; margin: 0px 0px 1.42857em; padding: 0px; direction: ltr; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; font-size: 20px; line-height: 1.6; text-rendering: optimizeLegibility; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	Cheers in advance.</p>\r\n', 'Wikileaks', '5', '3', '1'),
(6, 'Ross', '<p style="box-sizing: border-box; margin: 0px 0px 1.42857em; padding: 0px; direction: ltr; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; font-size: 20px; line-height: 1.6; text-rendering: optimizeLegibility; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	asically, I&#39;m trying to call data from 2 tables and join them together.</p>\r\n<p style="box-sizing: border-box; margin: 0px 0px 1.42857em; padding: 0px; direction: ltr; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; font-size: 20px; line-height: 1.6; text-rendering: optimizeLegibility; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	Here&#39;s my scenario.</p>\r\n<ul style="box-sizing: border-box; margin: 0px 0px 1.42857em 2.14286em; padding-right: 0px; padding-left: 0px; direction: ltr; font-size: 20px; line-height: 1.6; list-style-position: outside; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	<li style="box-sizing: border-box; margin: 0px; padding: 0px; direction: ltr;">\r\n		<em style="box-sizing: border-box; line-height: inherit;">user</em>&nbsp;table contains a list of users (...duh)</li>\r\n	<li style="box-sizing: border-box; margin: 0px; padding: 0px; direction: ltr;">\r\n		<em style="box-sizing: border-box; line-height: inherit;">categories</em>&nbsp;contains a list of categories</li>\r\n	<li style="box-sizing: border-box; margin: 0px; padding: 0px; direction: ltr;">\r\n		<em style="box-sizing: border-box; line-height: inherit;">user_cats</em>&nbsp;table contains the user_id and category_id</li>\r\n</ul>\r\n<p style="box-sizing: border-box; margin: 0px 0px 1.42857em; padding: 0px; direction: ltr; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; font-size: 20px; line-height: 1.6; text-rendering: optimizeLegibility; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	In other words, one user can have many categories associated.</p>\r\n<p style="box-sizing: border-box; margin: 0px 0px 1.42857em; padding: 0px; direction: ltr; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; font-size: 20px; line-height: 1.6; text-rendering: optimizeLegibility; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	For some reason, I can&#39;t for the life of me write scripts for the model and controller that calls data from all 3 tables, and joins them in the relevant way and stores them into an array so I can echo out into a table, with headings&nbsp;<span style="box-sizing: border-box; font-weight: 700; line-height: inherit;">User</span>,&nbsp;<span style="box-sizing: border-box; font-weight: 700; line-height: inherit;">Categories</span>.</p>\r\n<p style="box-sizing: border-box; margin: 0px 0px 1.42857em; padding: 0px; direction: ltr; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; font-size: 20px; line-height: 1.6; text-rendering: optimizeLegibility; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	If anyone could help out that would be great.</p>\r\n<p style="box-sizing: border-box; margin: 0px 0px 1.42857em; padding: 0px; direction: ltr; font-family: ''Proxima Nova'', ''Helvetica Neue'', Helvetica, Helvetica, Arial, sans-serif; font-size: 20px; line-height: 1.6; text-rendering: optimizeLegibility; color: rgb(102, 102, 102); background-color: rgb(251, 248, 245);">\r\n	Cheers in advance.</p>\r\n', 'Wikileaks', '5', '3', '1'),
(7, 'Jerry 2', '<h6 id="sowhatsdagger" style="-webkit-font-feature-settings: ''dlig'' 1, ''liga'' 1, ''lnum'' 1, ''kern'' 1; color: rgb(46, 46, 46); line-height: 1.15em; margin: 0px 0px 0.4em; font-family: ''Open Sans'', sans-serif; text-rendering: geometricPrecision; font-size: 2rem; letter-spacing: 0.1px;">\r\n	So what&#39;s Dagger?</h6>\r\n<p style="-webkit-font-feature-settings: ''liga'' 1, ''onum'' 1, ''kern'' 1; margin: 0px 0px 1.75em; text-rendering: geometricPrecision; color: rgb(58, 65, 69); font-family: Merriweather, serif; font-size: 18px; letter-spacing: 0.1px; line-height: 31.5px;">\r\n	<a href="http://google.github.io/dagger/" style="color: rgb(74, 74, 74); transition: color 0.3s ease; background: transparent;">Dagger</a>&nbsp;has become a pretty standard tool in many Android developers&#39; arsenals, however, for those who haven&#39;t heard - it&#39;s a fast&nbsp;<a href="https://en.wikipedia.org/wiki/Dependency_injection" style="color: rgb(74, 74, 74); transition: color 0.3s ease; background: transparent;">dependency injection</a>&nbsp;framework, developed by&nbsp;<a href="https://squareup.com/" style="color: rgb(74, 74, 74); transition: color 0.3s ease; background: transparent;">Square</a>, and specifically optimized for Android. Unlike some of the other popular dependency injectors, Dagger doesn&#39;t use reflection and relies on generated code for speed. We&#39;ll use Dagger in our app to be able to substitute our dependencies with test doubles in a clean way, without breaking encapsulation or writing unnecessary code that will only be used by tests. So let&#39;s get going!</p>\r\n', 'Google', '5', '4', '6'),
(8, 'Tom Cruiz', '<h6 id="openweathermapapi" style="-webkit-font-feature-settings: ''dlig'' 1, ''liga'' 1, ''lnum'' 1, ''kern'' 1; color: rgb(46, 46, 46); line-height: 1.15em; margin: 0px 0px 0.4em; font-family: ''Open Sans'', sans-serif; text-rendering: geometricPrecision; font-size: 2rem; letter-spacing: 0.1px;">\r\n	OpenWeatherMap API</h6>\r\n<p style="-webkit-font-feature-settings: ''liga'' 1, ''onum'' 1, ''kern'' 1; margin: 0px 0px 1.75em; text-rendering: geometricPrecision; color: rgb(58, 65, 69); font-family: Merriweather, serif; font-size: 18px; letter-spacing: 0.1px; line-height: 31.5px;">\r\n	We&#39;ll use the&nbsp;<a href="http://openweathermap.org/api" style="color: rgb(74, 74, 74); transition: color 0.3s ease; background: transparent;">OpenWeatherMap API</a>&nbsp;to access weather data. The API is free, however you&#39;ll need to sign up for an API key if you want to download the code and compile the app on your machine.</p>\r\n<h6 id="restapiclientsetup" style="-webkit-font-feature-settings: ''dlig'' 1, ''liga'' 1, ''lnum'' 1, ''kern'' 1; color: rgb(46, 46, 46); line-height: 1.15em; margin: 0px 0px 0.4em; font-family: ''Open Sans'', sans-serif; text-rendering: geometricPrecision; font-size: 2rem; letter-spacing: 0.1px;">\r\n	REST API client setup</h6>\r\n<p style="-webkit-font-feature-settings: ''liga'' 1, ''onum'' 1, ''kern'' 1; margin: 0px 0px 1.75em; text-rendering: geometricPrecision; color: rgb(58, 65, 69); font-family: Merriweather, serif; font-size: 18px; letter-spacing: 0.1px; line-height: 31.5px;">\r\n	Let&#39;s start with setting up the REST API client that will implement data fetching. We&#39;ll be using&nbsp;<a href="http://square.github.io/retrofit/" style="color: rgb(74, 74, 74); transition: color 0.3s ease; background: transparent;">Retrofit</a>&nbsp;along with&nbsp;<a href="https://github.com/ReactiveX/RxJava" style="color: rgb(74, 74, 74); transition: color 0.3s ease; background: transparent;">RxJava</a>, so the following dependencies go to our&nbsp;<code style="font-family: Inconsolata, monospace, sans-serif; font-size: 0.85em; padding: 1px 3px; white-space: pre-wrap; border: 1px solid rgb(227, 237, 243); border-radius: 2px; background: rgb(247, 250, 251);">build.gradle</code>&nbsp;file:</p>\r\n', 'medium.com', '9', '7', '6');

-- --------------------------------------------------------

--
-- Table structure for table `artist_genres`
--

CREATE TABLE `artist_genres` (
  `id` int(11) NOT NULL,
  `artist_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(20, 1, 9);

-- --------------------------------------------------------

--
-- Table structure for table `artist_images`
--

CREATE TABLE `artist_images` (
  `id` int(11) NOT NULL,
  `artist_id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `distance` varchar(50) NOT NULL,
  `imageUrl` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `venue_id`, `ticketinfo_id`, `name`, `eventDateLocal`, `distance`, `imageUrl`) VALUES
(1, 2, 2, 'Rumba Night', '2016-01-07 00:00:00', '3', 'a8f27-news.png'),
(2, 1, 2, 'Rumba Night', '2016-01-07 00:00:00', '3', 'b08e7-news.png'),
(3, 2, 2, 'Rumba Night', '2016-01-07 00:00:00', '3', '71db1-t-shirt.jpg'),
(4, 1, 2, 'Test', '2016-01-07 00:25:00', '3', 'e10be-yuo.png'),
(5, 2, 2, 'Woo T Shirts', '2016-01-13 00:00:00', '20', '6e29b-rihanna-08.jpeg');

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
(0, 2, 1),
(1, 3, 1),
(6, 4, 4),
(11, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `event_images`
--

CREATE TABLE `event_images` (
  `id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_images`
--

INSERT INTO `event_images` (`id`, `event_id`, `image_id`) VALUES
(0, 0, 0),
(1, 1, 3),
(2, 0, 0),
(3, 0, 3),
(4, 0, 2),
(7, 0, 4),
(10, 0, 1),
(12, 0, 5),
(15, 1, 4),
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(9, 'Blues');

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Table structure for table `venues`
--

CREATE TABLE `venues` (
  `id` double NOT NULL,
  `name` varchar(100) NOT NULL,
  `latitude` varchar(50) NOT NULL,
  `longitude` varchar(50) NOT NULL,
  `timezone` varchar(50) NOT NULL,
  `address1` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `postalCode` double NOT NULL,
  `country` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `venues`
--

INSERT INTO `venues` (`id`, `name`, `latitude`, `longitude`, `timezone`, `address1`, `city`, `state`, `postalCode`, `country`) VALUES
(1, 'KICC Nairobi', '12.218512', '02.215555', '+3', '0100', 'Nairobi', 'Nairobi', 254, 'Kenya'),
(2, 'Mombasa', '02.152455', '03.22254', '+3', '362 Mombasas', 'Mombasasa', 'Mombasa', 254, 'Kenya');

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
  MODIFY `id` double NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `artist_genres`
--
ALTER TABLE `artist_genres`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `artist_images`
--
ALTER TABLE `artist_images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `event_artists`
--
ALTER TABLE `event_artists`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `event_images`
--
ALTER TABLE `event_images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `genres`
--
ALTER TABLE `genres`
  MODIFY `id` double NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `id` double NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `ticketinfos`
--
ALTER TABLE `ticketinfos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `venues`
--
ALTER TABLE `venues`
  MODIFY `id` double NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
