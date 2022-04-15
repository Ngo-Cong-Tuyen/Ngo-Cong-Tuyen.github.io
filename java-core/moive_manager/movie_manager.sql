-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Apr 15, 2022 at 06:51 AM
-- Server version: 8.0.28
-- PHP Version: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movie_manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Adventure'),
(2, 'Epics'),
(3, 'Action'),
(4, 'Horror'),
(5, 'Comedy '),
(6, 'Animated cartoon');

-- --------------------------------------------------------

--
-- Table structure for table `cinemas`
--

CREATE TABLE `cinemas` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `city` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `hotline` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `cinemas`
--

INSERT INTO `cinemas` (`id`, `name`, `city`, `address`, `hotline`, `email`) VALUES
(1, 'CGV Vincom Center Bà Triệu\r\n', 'Hà Nội', 'Tầng 6, Toà nhà VinCom Center Hà Nội 191 đường Bà Triệu Quận Hai Bà Trưng Hà Nội', '1900 6017', NULL),
(2, 'CGV Hồ Gươm Plaza\r\n', 'Hà Nội', 'Tầng 3, TTTM Hồ Gươm Plaza, 110 Trần Phú, Phường Mỗ Lao, Quận Hà Đông, Hà Nội', '1900 6017', NULL),
(3, 'CGV Aeon Long Biên', 'Hà Nội', 'Tầng 4 - TTTM AEON Long Biên, Số 27 Cổ Linh, Quận Long Biên, Hà Nội', '1900 6017', NULL),
(4, 'CGV Hùng Vương Plaza', 'Hồ Chí Minh', 'Tầng 7 | Hùng Vương Plaza 126 Hùng Vương Quận 5 Tp. Hồ Chí Minh', '1900 6017', NULL),
(5, 'CGV Thảo Điền Pearl', 'Hồ Chí Minh', 'Tầng 2, Thảo Điền Mall, 12 Quốc Hương, Phường Thảo Điền, Quận 2, TP. Hồ Chí Minh', '1900 6017', NULL),
(6, 'CGV Vincom Thủ Đức', 'Hồ Chí Minh', 'Tầng 5, TTTM Vincom Thủ Đức, 216 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức', '1900 6017', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `formats`
--

CREATE TABLE `formats` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `picture` text COLLATE utf8mb4_unicode_ci,
  `description` text COLLATE utf8mb4_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `formats`
--

INSERT INTO `formats` (`id`, `name`, `picture`, `description`) VALUES
(1, '4DX', 'https://www.cgv.vn/default/theaters/special/4dx', '4DX®, một định dạng điện ảnh hoàn toàn mới đánh thức mọi giác quan của khán giả mang đến những trải nghiệm điện ảnh tuyệt đỉnh bằng công nghệ hiện đại nhất trên thế giới.'),
(2, 'IMAX', 'https://www.cgv.vn/default/theaters/special/imax', 'IMAX is a proprietary system of high-resolution cameras, film formats, film projectors, and theaters known for having very large screens with a tall aspect ratio and steep stadium seating'),
(3, 'ScreenX', 'https://www.cgv.vn/default/theaters/special/screenx', 'ScreenX vượt qua khuôn khổ giới hạn của màn hình chính và phóng đại không gian hình ảnh sang hai bên tường đến tận hàng ghế cuối cùng.'),
(4, 'STARIUM ', 'https://www.cgv.vn/default/theaters/special/starium', 'STARIUM là công nghệ chiếu phim do chính CGV sáng tạo ra để những trải nghiệm của khán giả vượt xa cả giới hạn chân thực.\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `moive_cinema`
--

CREATE TABLE `moive_cinema` (
  `id` int NOT NULL,
  `id_movie` int NOT NULL,
  `id_cinema` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `moive_cinema`
--

INSERT INTO `moive_cinema` (`id`, `id_movie`, `id_cinema`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 6),
(6, 2, 2),
(7, 2, 1),
(8, 3, 3),
(9, 3, 5),
(10, 3, 6),
(11, 4, 3),
(12, 4, 5),
(13, 5, 1),
(14, 5, 5),
(15, 6, 2),
(16, 6, 6);

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `id` int NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `picture` text COLLATE utf8mb4_unicode_ci,
  `id_director` int NOT NULL,
  `opening_day` date NOT NULL,
  `rungning_time` time NOT NULL,
  `tranlation` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rated` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`id`, `title`, `picture`, `id_director`, `opening_day`, `rungning_time`, `tranlation`, `rated`) VALUES
(1, 'SINH VẬT HUYỀN BÍ: NHỮNG BÍ MẬT CỦA DUMBLEDORE', 'https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/p/o/poster_fantastic_beasts_the_secrets_of_dumbledore_1_.jpg', 1, '2022-04-08', '01:23:00', 'Tiếng Anh - Phụ đề Tiếng Việt', 'C13 - PHIM CẤM KHÁN GIẢ DƯỚI 13 TUỔI'),
(2, 'MORBIUS', 'https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/m/o/morbius_montageposter_fb_4x5_1_.jpg', 7, '2022-04-01', '01:44:00', 'Tiếng Anh - Phụ đề Tiếng Việt', 'C16 - PHIM CẤM KHÁN GIẢ DƯỚI 16 TUỔI'),
(3, 'ÁC MỘNG', 'https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/t/h/the_free_fall_-_payoff_poster-nkc_08042022_1_.jpg', 11, '2022-04-08', '01:23:00', 'Tiếng Anh - Phụ đề Tiếng Việt', 'C18 - PHIM CẤM KHÁN GIẢ DƯỚI 18 TUỔI'),
(4, 'GÁNH NẶNG NGÀN CÂN CỦA TÀI NĂNG KIỆT XUẤT', 'https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/g/n/gnncctnkx_poster_1_.jpg', 15, '2022-04-22', '01:30:00', 'Tiếng Anh - Phụ đề Tiếng Việt', ''),
(5, 'PHÙ THỦY TỐI THƯỢNG TRONG ĐA VŨ TRỤ HỖN LOẠN', 'https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/d/r/dr-strange-payoff-poster_1_.jpg', 19, '2022-05-06', '01:30:00', 'Tiếng Anh - Phụ đề Tiếng Việt', 'C13'),
(6, 'BIỆT ĐỘI PHI HÀNH CÚN', 'https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/s/d/sd_main-poster_1_.jpg', 23, '2022-04-22', '01:30:00', 'Tiếng Anh - Phụ đề Tiếng Việt; Lồng tiếng', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `movie_actor`
--

CREATE TABLE `movie_actor` (
  `id` int NOT NULL,
  `id_movie` int NOT NULL,
  `id_actor` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `movie_actor`
--

INSERT INTO `movie_actor` (`id`, `id_movie`, `id_actor`) VALUES
(1, 1, 2),
(2, 1, 3),
(3, 1, 4),
(6, 1, 5),
(8, 1, 6),
(9, 2, 8),
(10, 2, 9),
(11, 2, 10),
(12, 3, 12),
(13, 3, 13),
(14, 3, 14),
(15, 4, 16),
(16, 4, 17),
(17, 4, 18),
(18, 5, 20),
(19, 5, 21),
(20, 5, 22);

-- --------------------------------------------------------

--
-- Table structure for table `movie_category`
--

CREATE TABLE `movie_category` (
  `id` int NOT NULL,
  `id_movie` int NOT NULL,
  `id_category` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `movie_category`
--

INSERT INTO `movie_category` (`id`, `id_movie`, `id_category`) VALUES
(1, 1, 2),
(2, 1, 1),
(3, 2, 3),
(4, 2, 1),
(5, 3, 4),
(6, 4, 5),
(7, 4, 3),
(8, 5, 1),
(9, 5, 3),
(10, 5, 2),
(11, 6, 6);

-- --------------------------------------------------------

--
-- Table structure for table `movie_format`
--

CREATE TABLE `movie_format` (
  `id` int NOT NULL,
  `id_movie` int NOT NULL,
  `id_format` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `movie_format`
--

INSERT INTO `movie_format` (`id`, `id_movie`, `id_format`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 2, 1),
(6, 2, 3),
(7, 3, 4),
(8, 3, 1),
(9, 4, 4),
(10, 5, 1),
(11, 5, 3),
(12, 6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `persons`
--

CREATE TABLE `persons` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `discription` text COLLATE utf8mb4_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `persons`
--

INSERT INTO `persons` (`id`, `name`, `discription`) VALUES
(1, 'David Yates', 'Đạo diễn phim sinh vật huyền bí: bí mật cảu dumbledore.'),
(2, 'Eddie Redmayne', 'Edward John David Redmayne OBE is an English actor. Known for his roles in biopics and blockbusters, he has received various accolades.'),
(3, 'Mads Mikkelsen', 'Mads Mikkelsen\'s great successes parallel those achieved by the Danish film industry since the mid-1990s. He was born in Østerbro, Copenhagen, to Bente Christiansen, a nurse, and Henning Mikkelsen, a banker. Starting out as a low-life pusher/junkie in the 1996 success Pusher (1996), he slowly grew to become one of Denmark\'s biggest movie actors. ...'),
(4, ' Ezra Miller', 'Ezra Matthew Miller is an American actor. Miller\'s feature film debut was in Afterschool. They starred as Kevin in the drama We Need to Talk About Kevin and co-starred in the film adaptation of The Perks of Being a Wallflower.'),
(5, ' Katherine Waterston', 'Katherine Boyer Waterston is a British-American actress. She made her feature film debut in Michael Clayton. She had supporting roles in films including Robot & Frank, Being Flynn and The Disappearance of Eleanor Rigby, before her breakthrough performance in Inherent Vice'),
(6, 'Jude Law', 'David Jude Heyworth Law is an English actor. He has received several accolades throughout his career, including a British Academy Film Award, as well as nominations for two Academy Awards, two Tony Awards, and four Golden Globe Awards.'),
(7, 'Daniel Espinosa', 'Đạo diễn phim morbius'),
(8, 'Jared Leto', 'Jared Joseph Leto is an American actor and musician. Known for his method acting in a variety of roles, he received numerous accolades throughout his career which spanned over three decades, including an Academy Award, a Screen Actors Guild Award, a Golden Globe Award, and a Critics\' Choice Movie Award'),
(9, 'Michael Keaton', 'Michael John Douglas, professionally known as Michael Keaton, is an American actor. He is best known for portraying the DC Comics superhero Bruce Wayne / Batman in the films Batman and Batman Returns, and is set to reprise the role in the DC Extended Universe films The Flash and Batgirl.'),
(10, 'Adria Arjona', 'Adria Arjona Torres is a Puerto Rican actress. She played the role of Dorothy Gale in the Oz book adaptation Emerald City and the role of Anathema Device in the TV adaptation of Good Omens.'),
(11, 'Adam Stilwell', 'Đạo diễn phim ác mộng'),
(12, 'Andrea Londo', 'Andrea Londo is a Mexican-American actress. She is known for portraying Maria Salazar in Narcos Season'),
(13, 'Shawn Ashmore', 'Shawn Robert Ashmore is a Canadian actor. He is known for his roles as Bobby Drake / Iceman in the X-Men film series, Jake Berenson in the television series Animorphs, Agent Mike Weston in the television'),
(14, 'Jane Badler', 'Jane Badler is an American-Australian actress and singer. She is known for her role as Diana, the main antagonist in NBC\'s science fiction series V between 1983 and 1985.'),
(15, 'Tom Gormican', 'Đạo diễn phim GÁNH NẶNG NGÀN CÂN CỦA TÀI NĂNG KIỆT XUẤT'),
(16, 'Nicolas Cage', 'Nicolas Kim Coppola, known professionally as Nicolas Cage, is an American actor and filmmaker. Born into the Coppola family, Cage is the recipient of various accolades, including an Academy Award, a Screen Actors Guild Award, and a Golden Globe Award.'),
(17, 'Pedro Pascal', 'José Pedro Balmaceda Pascal is a Chilean and American actor. He began his career guest starring on various television shows before rising to prominence for portraying Oberyn Martell on the fourth season of the HBO fantasy series Game of Thrones and Javier Peña on the Netflix biographic crime series Narcos.'),
(18, 'Neil Patrick Harris', 'Neil Patrick Harris is an American actor, singer, writer, producer, and television host. Primarily known for his comedic television roles and dramatic and musical stage roles, he has received multiple '),
(19, 'Sam Raimi', 'Đạo điễn phù thủy tối thượng trong đa vũ trụ rối loạn.'),
(20, 'Benedict Cumberbatch', 'Benedict Timothy Carlton Cumberbatch CBE is an English actor. Known for his roles on the screen and stage, he has received various accolades throughout his career, including a British Academy Television Award, a Primetime Emmy Award and a Laurence Olivier Award.'),
(21, 'Elizabeth Olsen', 'Elizabeth Chase Olsen is an American actress. Born in Sherman Oaks, California, Olsen began acting at age four. '),
(22, 'Rachel McAdams', 'Rachel Anne McAdams is a Canadian actress. After graduating from a theatre degree program at York University in 2001, she worked in Canadian television and film productions, such as the drama film ...'),
(23, 'Inna Evlannikova', 'Đạo diễn phim biệt dội phi hành cún');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cinemas`
--
ALTER TABLE `cinemas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `formats`
--
ALTER TABLE `formats`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `moive_cinema`
--
ALTER TABLE `moive_cinema`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_movie` (`id_movie`),
  ADD KEY `id_cinema` (`id_cinema`);

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_director` (`id_director`);

--
-- Indexes for table `movie_actor`
--
ALTER TABLE `movie_actor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_movie` (`id_movie`),
  ADD KEY `id_actor` (`id_actor`);

--
-- Indexes for table `movie_category`
--
ALTER TABLE `movie_category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_movie` (`id_movie`),
  ADD KEY `id_category` (`id_category`);

--
-- Indexes for table `movie_format`
--
ALTER TABLE `movie_format`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_movie` (`id_movie`),
  ADD KEY `id_format` (`id_format`);

--
-- Indexes for table `persons`
--
ALTER TABLE `persons`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `cinemas`
--
ALTER TABLE `cinemas`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `formats`
--
ALTER TABLE `formats`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `moive_cinema`
--
ALTER TABLE `moive_cinema`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `movie_actor`
--
ALTER TABLE `movie_actor`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `movie_category`
--
ALTER TABLE `movie_category`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `movie_format`
--
ALTER TABLE `movie_format`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `persons`
--
ALTER TABLE `persons`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `moive_cinema`
--
ALTER TABLE `moive_cinema`
  ADD CONSTRAINT `moive_cinema_ibfk_1` FOREIGN KEY (`id_movie`) REFERENCES `movies` (`id`),
  ADD CONSTRAINT `moive_cinema_ibfk_2` FOREIGN KEY (`id_cinema`) REFERENCES `cinemas` (`id`);

--
-- Constraints for table `movies`
--
ALTER TABLE `movies`
  ADD CONSTRAINT `movies_ibfk_1` FOREIGN KEY (`id_director`) REFERENCES `persons` (`id`);

--
-- Constraints for table `movie_actor`
--
ALTER TABLE `movie_actor`
  ADD CONSTRAINT `movie_actor_ibfk_1` FOREIGN KEY (`id_movie`) REFERENCES `movies` (`id`),
  ADD CONSTRAINT `movie_actor_ibfk_2` FOREIGN KEY (`id_actor`) REFERENCES `persons` (`id`);

--
-- Constraints for table `movie_category`
--
ALTER TABLE `movie_category`
  ADD CONSTRAINT `movie_category_ibfk_1` FOREIGN KEY (`id_movie`) REFERENCES `movies` (`id`),
  ADD CONSTRAINT `movie_category_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`);

--
-- Constraints for table `movie_format`
--
ALTER TABLE `movie_format`
  ADD CONSTRAINT `movie_format_ibfk_1` FOREIGN KEY (`id_movie`) REFERENCES `movies` (`id`),
  ADD CONSTRAINT `movie_format_ibfk_2` FOREIGN KEY (`id_format`) REFERENCES `formats` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
