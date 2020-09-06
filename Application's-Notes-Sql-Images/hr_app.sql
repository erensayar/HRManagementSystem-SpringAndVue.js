-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 05 Eyl 2020, 20:24:19
-- Sunucu sürümü: 10.4.13-MariaDB
-- PHP Sürümü: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `hr_app`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `applicant`
--

CREATE TABLE `applicant` (
  `id` int(11) NOT NULL,
  `git_link` varchar(100) COLLATE utf8_turkish_ci DEFAULT NULL,
  `linked_in_link` varchar(100) COLLATE utf8_turkish_ci DEFAULT NULL,
  `mail` varchar(70) COLLATE utf8_turkish_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_turkish_ci DEFAULT NULL,
  `residence` varchar(50) COLLATE utf8_turkish_ci DEFAULT NULL,
  `surname` varchar(20) COLLATE utf8_turkish_ci DEFAULT NULL,
  `telephone` varchar(13) COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `applicant`
--

INSERT INTO `applicant` (`id`, `git_link`, `linked_in_link`, `mail`, `name`, `residence`, `surname`, `telephone`) VALUES
(5, 'github.com/erensayar', 'linkedin.com/in/erensayar', 'erensayar@yandex.com', 'Eren', 'İstanbul', 'Sayar', '+905333333333'),
(6, 'gitlab.com/murtaza', 'linkedin.com/in/murtazaarmut', 'murtazaarmut@mail.com', 'Murtaza', 'Ankara', 'Armut', '05330909090'),
(7, 'github.com/jackie', 'linkedin.com/in/jackie', 'jackie@mail.com', 'Jackie', 'Toronto', 'Smith', '2029129'),
(8, 'github.com/mervekara', 'linkedin/in/mervekara', 'mervekara@mail.com', 'Merve', 'İstanbul', 'Kara', '05333333334');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `applicant_job`
--

CREATE TABLE `applicant_job` (
  `applicant_id` int(11) NOT NULL,
  `job_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `applicant_job`
--

INSERT INTO `applicant_job` (`applicant_id`, `job_id`) VALUES
(5, 4),
(6, 7),
(7, 6),
(8, 4);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hr_manager`
--

CREATE TABLE `hr_manager` (
  `id` int(11) NOT NULL,
  `mail` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
  `pass` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `job`
--

CREATE TABLE `job` (
  `id` int(11) NOT NULL,
  `job_descript` varchar(5000) COLLATE utf8_turkish_ci DEFAULT NULL,
  `job_title` varchar(100) COLLATE utf8_turkish_ci DEFAULT NULL,
  `last_application_date` date DEFAULT NULL,
  `number_of_hires` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `job`
--

INSERT INTO `job` (`id`, `job_descript`, `job_title`, `last_application_date`, `number_of_hires`) VALUES
(4, 'We are looking java developer,\r\nWe looking Java Developer\r\nWe want to skills like these:\r\nSpring Boot\r\nSpring Security\r\nJWT\r\nVue.js\r\nJava SE\r\nJava FX\r\nHibernate', 'Java Developer', '2020-09-05', 5),
(5, 'We are looking frontend developer,\r\nWe want to skills like these:\r\nHTML\r\nCSS\r\nJS\r\nVue.js\r\nUI/UX', 'Frontend Developer', '2020-09-10', 10),
(6, 'We are looking cyber security expert', 'Cyber Security Expert', '2020-09-15', 2),
(7, 'We are looking C++ developer for special embedded systems.', 'Embedded Software Expert', '2020-09-22', 2),
(8, 'We are looking python guru', 'Python Developer', '2020-09-30', 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `job_applicant`
--

CREATE TABLE `job_applicant` (
  `job_id` int(11) NOT NULL,
  `applicant_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `applicant`
--
ALTER TABLE `applicant`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `applicant_job`
--
ALTER TABLE `applicant_job`
  ADD PRIMARY KEY (`applicant_id`,`job_id`),
  ADD KEY `FKdba0alpwpc3ld9ox7vc1opf6r` (`job_id`);

--
-- Tablo için indeksler `hr_manager`
--
ALTER TABLE `hr_manager`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `job_applicant`
--
ALTER TABLE `job_applicant`
  ADD PRIMARY KEY (`job_id`,`applicant_id`),
  ADD KEY `FK3njcctaabjvtwyucpc45wsolb` (`applicant_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `applicant`
--
ALTER TABLE `applicant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `hr_manager`
--
ALTER TABLE `hr_manager`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `job`
--
ALTER TABLE `job`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `applicant_job`
--
ALTER TABLE `applicant_job`
  ADD CONSTRAINT `FK9wxajidy00yblklxm57llgpxv` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`id`),
  ADD CONSTRAINT `FKdba0alpwpc3ld9ox7vc1opf6r` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`);

--
-- Tablo kısıtlamaları `job_applicant`
--
ALTER TABLE `job_applicant`
  ADD CONSTRAINT `FK3njcctaabjvtwyucpc45wsolb` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`id`),
  ADD CONSTRAINT `FKgjecqbj3prcqp7bq8ri1spk7w` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
