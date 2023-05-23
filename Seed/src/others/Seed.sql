/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `seed` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `seed`;

CREATE TABLE IF NOT EXISTS `abonnement` (
  `id_compte` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `type_abonnement` enum('premium','standard') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '''premium'',''standard''',
  `durée` int DEFAULT NULL COMMENT 'Années',
  PRIMARY KEY (`id_compte`) USING BTREE,
  KEY `FK_abonnement_adherent` (`email`),
  CONSTRAINT `FK_abonnement_adherent` FOREIGN KEY (`email`) REFERENCES `adherent` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `adherent` (
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  `role` enum('user','admin') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'user',
  PRIMARY KEY (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `adherent` (`email`, `username`, `password`, `role`) VALUES
	('hugo@gmail.com', 'hugo', 'f4f263e439cf40925e6a412387a9472a6773c2580212a4fb50d224d3a817de17', 'user'),
	('test', 'test', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'user'),
	('trest', 'test', 'test', 'user');

CREATE TABLE IF NOT EXISTS `emprunts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_jeu` int DEFAULT NULL,
  `id_livre` int DEFAULT NULL,
  `id_film` int DEFAULT NULL,
  `item_type` enum('film','livre','jeu') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `utilisateur` varchar(50) NOT NULL DEFAULT '0',
  `date_emprunt` date NOT NULL,
  `date_retour` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_emprunts_adherent` (`utilisateur`),
  KEY `item_id` (`id_jeu`) USING BTREE,
  KEY `FK_emprunts_livre` (`id_livre`),
  KEY `FK_emprunts_films` (`id_film`),
  CONSTRAINT `FK_emprunts_adherent` FOREIGN KEY (`utilisateur`) REFERENCES `adherent` (`email`),
  CONSTRAINT `FK_emprunts_films` FOREIGN KEY (`id_film`) REFERENCES `films` (`id`),
  CONSTRAINT `FK_emprunts_jeux` FOREIGN KEY (`id_jeu`) REFERENCES `jeux` (`id`),
  CONSTRAINT `FK_emprunts_livre` FOREIGN KEY (`id_livre`) REFERENCES `livre` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `emprunts` (`id`, `id_jeu`, `id_livre`, `id_film`, `item_type`, `utilisateur`, `date_emprunt`, `date_retour`) VALUES
	(2, 1, NULL, NULL, 'jeu', 'hugo@gmail.com', '2023-05-15', '2023-05-29'),
	(3, 3, NULL, NULL, 'jeu', 'hugo@gmail.com', '2023-05-15', '2023-05-29'),
	(4, 3, NULL, NULL, 'jeu', 'hugo@gmail.com', '2023-05-15', '2023-06-05'),
	(5, 3, NULL, NULL, 'jeu', 'hugo@gmail.com', '2023-05-15', '2023-06-19'),
	(6, 3, NULL, NULL, 'jeu', 'hugo@gmail.com', '2023-05-15', '2023-06-12'),
	(7, NULL, 17, NULL, 'livre', 'hugo@gmail.com', '2023-05-23', '2023-10-23');

CREATE TABLE IF NOT EXISTS `films` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `annee` varchar(50) NOT NULL DEFAULT '',
  `genre` varchar(255) NOT NULL,
  `realisateur` varchar(255) NOT NULL,
  `acteurs` varchar(255) NOT NULL,
  `synopsis` text NOT NULL,
  `img_url` varchar(300) DEFAULT NULL,
  `prix` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `films` (`id`, `titre`, `annee`, `genre`, `realisateur`, `acteurs`, `synopsis`, `img_url`, `prix`) VALUES
	(1, 'Forrest Gump', '1994 | 2h10', 'Comédie dramatique', 'Robert Zemeckis', 'Tom Hanks, Robin Wright, Gary Sinise', 'Les péripéties d’un homme simple d’esprit dans l’Amérique des années 50 à 80.', 'https://fr.web.img4.acsta.net/pictures/15/10/13/15/12/514297.jpg', '2'),
	(2, 'La La Land', '2016 | 2h10', 'Comédie musicale, Romance', 'Damien Chazelle', 'Ryan Gosling, Emma Stone, John Legend', 'Deux artistes ambitieux tombent amoureux tout en poursuivant leurs rêves à Los Angeles.', 'https://fr.web.img4.acsta.net/pictures/16/11/10/13/52/169386.jpg', '4'),
	(3, 'Le Parrain 2', '1974 | 2h10', 'Drame, Policier', 'Francis Ford Coppola', 'Al Pacino, Robert De Niro, Robert Duvall', 'Le fils du Parrain tente de consolider son pouvoir à la tête de la famille.', 'https://fr.web.img6.acsta.net/medias/nmedia/18/35/24/16/18861226.jpg', '2'),
	(4, 'Fight Club', '1999 | 1h40', 'Thriller, Drame', 'David Fincher', 'Brad Pitt, Edward Norton, Helena Bonham Carter', 'Un homme souffrant d’insomnie et son nouveau ami charismatique créent un club de combats clandestins.', 'https://fr.web.img6.acsta.net/img/23/b7/23b757ce995171ae05ba7449c67a47dc.jpg', '5'),
	(5, 'Star Wars: Épisode IV ', '1977 | 2h30', 'Science-fiction, Aventure', 'George Lucas', 'Mark Hamill, Harrison Ford, Carrie Fisher', 'Un jeune fermier et ses amis s’allient pour sauver la galaxie de l’Empire.', 'https://fr.web.img6.acsta.net/medias/nmedia/18/35/41/59/18422600.jpg', '4'),
	(6, 'Inception', '2010 | 2h10', 'Science-fiction, Action', 'Christopher Nolan', 'Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page', 'Un voleur professionnel s’infiltre dans les rêves de ses cibles pour leur voler des secrets.', 'https://fr.web.img2.acsta.net/medias/nmedia/18/72/34/14/19476654.jpg', '5'),
	(7, 'Le Seigneur des Anneaux', '2003 | 2h10', 'Fantasy, Aventure', 'Peter Jackson', 'Elijah Wood, Ian McKellen, Viggo Mortensen', 'La guerre de l’Anneau atteint son point culminant.', 'https://fr.web.img3.acsta.net/medias/nmedia/18/35/14/33/18366630.jpg', '1'),
	(9, 'Blade Runner 2049', '2017 | 2h10', 'Science-fiction, Thriller', 'Denis Villeneuve', 'Ryan Gosling, Harrison Ford, Ana de Armas', 'Un agent spécial doit enquêter sur un mystérieux événement qui pourrait entraîner la fin de l’humanité.', 'https://fr.web.img4.acsta.net/pictures/17/08/24/15/18/597734.jpg', '5'),
	(10, 'Le Roi Lion', '1994 | 2h10', 'Animation, Aventure', 'Roger Allers, Rob Minkoff', 'Matthew Broderick, Jeremy Irons, James Earl Jones', 'Un jeune lion doit faire face à son destin en tant que roi de la savane.', 'https://fr.web.img3.acsta.net/pictures/19/02/25/12/06/2908996.jpg', '3'),
	(11, 'Inglourious Basterds', '2009 | 2h10', 'Guerre, Drame', 'Quentin Tarantino', 'Brad Pitt, Christoph Waltz, Mélanie Laurent', 'Un groupe de soldats juifs américains se lance dans une mission suicide pour tuer des nazis de haut rang.', 'https://fr.web.img2.acsta.net/medias/nmedia/18/70/45/22/19123474.jpg', '5');

CREATE TABLE IF NOT EXISTS `info_personnelles` (
  `id` int NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_info_personnelles_comptes` (`email`),
  CONSTRAINT `FK_info_personnelles_comptes` FOREIGN KEY (`email`) REFERENCES `comptes` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `jeux` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `prix` varchar(50) DEFAULT NULL,
  `studio` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `annee` date DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `resume` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `img_url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `jeux` (`id`, `nom`, `prix`, `studio`, `annee`, `type`, `resume`, `img_url`) VALUES
	(1, 'Minecraft', '7.8', 'Mojang Studios', '2011-11-18', 'Sandbox', 'Construisez et explorez un monde infini dans ce jeu de survie et de créativité.', 'https://image.api.playstation.com/vulcan/img/cfn/11307x4B5WLoVoIUtdewG4uJ_YuDRTwBxQy0qP8ylgazLLc01PBxbsFG1pGOWmqhZsxnNkrU3GXbdXIowBAstzlrhtQ4LCI4.png'),
	(2, 'Grand Theft Auto V', '8.4', 'Rockstar Games', '2013-09-17', 'Action-aventure', 'Plongez dans le crime organisé et l\'action explosive dans la ville fictive de Los Santos.', 'https://image.api.playstation.com/vulcan/ap/rnd/202202/2816/mYn2ETBKFct26V9mJnZi4aSS.png'),
	(3, 'The Legend of Zelda: Breath of the Wild', '9.6', 'Nintendo', '2017-03-03', 'Action-aventure', 'Explorez le royaume d\'Hyrule et affrontez des énigmes et des monstres dans cette aventure épique.', 'https://assets-prd.ignimgs.com/2022/09/14/zelda-tears-of-the-kingdom-button-2k-1663127818777.jpg'),
	(4, 'Fortnite', '5.5', 'Epic Games', '2017-07-25', 'Battle royale', 'Affrontez d\'autres joueurs dans un combat à mort en ligne dans ce jeu de survie populaire.', 'https://gmedia.playstation.com/is/image/SIEPDC/fortnite-chapter-4-season-2-keyart-01-en-09mar23?$native$'),
	(5, 'FIFA 21', '4.4', 'EA Sports', '2020-10-09', 'Sport', 'Jouez au football avec les équipes et les joueurs les plus célèbres du monde dans cette simulation réaliste.', 'https://image.api.playstation.com/vulcan/img/rnd/202009/2512/WhSINgL69hw3XyUFpah1jgmu.png'),
	(6, 'Call of Duty: Warzone', '4.1', 'Activision', '2020-03-10', 'FPS', 'Plongez dans des batailles en ligne intenses et devenez le dernier survivant dans ce jeu de tir multijoueur.', 'https://image.api.playstation.com/vulcan/ap/rnd/202211/1717/6Of7qTgej2FBAKH0xZ1ZFEi7.png'),
	(7, 'Among Us', '2.1', 'InnerSloth', '2018-06-15', 'Party', 'Découvrez qui est l\'imposteur parmi les membres de l\'équipage dans ce jeu de déduction en ligne.', 'https://image.api.playstation.com/vulcan/img/rnd/202107/0115/D5IIJwm65MLMPENwWzzO7rjd.png'),
	(8, 'Animal Crossing: New Horizons', '6.5', 'Nintendo', '2020-03-20', 'Simulation de vie', 'Créez votre île paradisiaque et interagissez avec des animaux adorables dans cette expérience relaxante.', 'https://www.geekjunior.fr/wp-content/uploads/2021/09/H2x1_NSwitch_AnimalCrossingNewHorizons_image1600w.jpg'),
	(9, 'Assassin\'s Creed Valhalla', '8.4', 'Ubisoft', '2020-11-10', 'Action-RPG', 'Incarnez un viking et explorez l\'Angleterre médiévale dans cette aventure pleine d\'action.', 'https://image.api.playstation.com/vulcan/ap/rnd/202007/0208/Ud7Ikvjoyev61bx3n1PTC9u8.png'),
	(10, 'Cyberpunk 2077', '4.5', 'CD Projekt', '2020-12-10', 'Action-RPG', 'Découvrez un futur sombre et dystopique où la technologie et la criminalité se rencontrent.', 'https://image.api.playstation.com/vulcan/ap/rnd/202111/3013/cKZ4tKNFj9C00giTzYtH8PF1.png'),
	(11, 'Outer wilds', '80.5', 'mobius digital', '2019-05-13', 'Simulation spacial', 'Outer Wilds est jeu d\'aventure dans un univers futuriste. Vous êtes le nouveau venu dans un programme spatial d\'Outer Wilds Ventures. L\'objectif est simple : enquêter sur un mystérieux système solaire en proie à une boucle temporelle infinie et à des planètes en constante évolution.', 'https://image.api.playstation.com/vulcan/ap/rnd/202208/1623/Zofebh60Ue7Zt5sC10UAtU3D.png');

CREATE TABLE IF NOT EXISTS `livre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` text,
  `prix` tinytext,
  `auteur` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `studio` date DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `resume` text,
  `img_url` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `livre` (`id`, `nom`, `prix`, `auteur`, `studio`, `type`, `resume`, `img_url`) VALUES
	(12, 'Le Petit Prince', '9.5', 'Antoine de Saint-Exupéry', '1943-04-06', 'Conte', 'Le Petit Prince raconte l\'histoire d\'un petit garçon venu d\'une autre planète.', 'https://m.media-amazon.com/images/I/71lyHAf7XXL.jpg'),
	(13, '1984', '12', 'George Orwell', '1949-06-08', 'Roman d\'anticipation', '1984 décrit une dystopie où les libertés individuelles sont supprimées.', 'https://m.media-amazon.com/images/I/71kxa1-0mfL.jpg'),
	(14, 'Le Seigneur des Anneaux', '20', 'J.R.R. Tolkien', '1954-07-29', 'Roman de fantasy', 'Le Seigneur des Anneaux raconte l\'histoire d\'un hobbit nommé Frodon qui part en quête pour détruire un anneau magique.', 'https://m.media-amazon.com/images/I/514+aP+SZ+L._SX349_BO1,204,203,200_.jpg'),
	(15, 'Orgueil et Préjugés', '8', 'Jane Austen', '1813-01-28', 'Roman romantique', 'Orgueil et Préjugés raconte l\'histoire d\'une famille anglaise bourgeoise dans les années 1800.', 'https://m.media-amazon.com/images/I/81nKAJtQ+uL.jpg'),
	(16, 'Les Misérables', '15', 'Victor Hugo', '1862-04-05', 'Roman historique', 'Les Misérables raconte l\'histoire d\'un homme appelé Jean Valjean qui doit faire face aux défis de la société française du XIXe siècle.', 'https://m.media-amazon.com/images/I/71lxLN4vorL.jpg'),
	(17, 'Le Crime de l\'Orient-Express', '10', 'Agatha Christie', '1934-01-01', 'Roman policier', 'Le Crime de l\'Orient-Express raconte l\'histoire d\'un meurtre qui se produit à bord de l\'Orient-Express.', 'https://m.media-amazon.com/images/I/71DYNs3ybnL.jpg'),
	(18, 'Moby Dick', '18', 'Herman Melville', '1851-10-18', 'Roman d\'aventure', 'Moby Dick raconte l\'histoire d\'un capitaine qui se lance à la poursuite d\'une baleine blanche.', 'https://m.media-amazon.com/images/I/81vjde0JFHL.jpg'),
	(19, 'Le Vieil Homme et la Mer', '6', 'Ernest Hemingway', '1952-09-01', 'Roman d\'aventure', 'Le Vieil Homme et la Mer raconte l\'histoire d\'un pêcheur cubain qui se lance dans une bataille contre un énorme poisson.', 'https://m.media-amazon.com/images/I/81bnd2bWlEL.jpg'),
	(20, 'Guerre et Paix', '25', 'Léon Tolstoï', '1869-01-01', 'Roman historique', 'Guerre et Paix raconte l\'histoire d\'une famille russe aristocratique pendant la guerre napoléonienne.', 'https://m.media-amazon.com/images/I/61v3P3KCNZL.jpg');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
