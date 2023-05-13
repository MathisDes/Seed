/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

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
  `password` varchar(50) NOT NULL,
  `role` enum('user','admin') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'user',
  PRIMARY KEY (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `emprunts` (
  `id` int NOT NULL,
  `item_id` int NOT NULL,
  `item_type` enum('film','livre','jeu_video') NOT NULL,
  `utilisateur` varchar(50) NOT NULL DEFAULT '0',
  `date_emprunt` date NOT NULL,
  `date_retour` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`),
  KEY `FK_emprunts_adherent` (`utilisateur`),
  CONSTRAINT `emprunts_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `films` (`id`),
  CONSTRAINT `emprunts_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `livres` (`id`),
  CONSTRAINT `emprunts_ibfk_3` FOREIGN KEY (`item_id`) REFERENCES `jeux_videos` (`id`),
  CONSTRAINT `FK_emprunts_adherent` FOREIGN KEY (`utilisateur`) REFERENCES `adherent` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `films` (
  `id` int NOT NULL,
  `titre` varchar(255) NOT NULL,
  `annee` int NOT NULL,
  `genre` varchar(255) NOT NULL,
  `realisateur` varchar(255) NOT NULL,
  `acteurs` varchar(255) NOT NULL,
  `synopsis` text NOT NULL,
  `img_url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `films` (`id`, `titre`, `annee`, `genre`, `realisateur`, `acteurs`, `synopsis`, `img_url`) VALUES
	(1, 'Forrest Gump', 1994, 'Comédie dramatique', 'Robert Zemeckis', 'Tom Hanks, Robin Wright, Gary Sinise', 'Les péripéties d’un homme simple d’esprit dans l’Amérique des années 50 à 80.', 'https://fr.web.img4.acsta.net/pictures/15/10/13/15/12/514297.jpg'),
	(2, 'The Dark Knight', 2008, 'Super-héros, Thriller', 'Christopher Nolan', 'Christian Bale, Heath Ledger, Aaron Eckhart', 'Batman doit affronter un criminel redoutable, le Joker, qui plonge Gotham City dans le chaos.', 'https://fr.web.img2.acsta.net/medias/nmedia/18/63/97/89/18949761.jpg'),
	(3, 'Le Parrain 2', 1974, 'Drame, Policier', 'Francis Ford Coppola', 'Al Pacino, Robert De Niro, Robert Duvall', 'Le fils du Parrain tente de consolider son pouvoir à la tête de la famille.', 'https://fr.web.img6.acsta.net/medias/nmedia/18/35/24/16/18861226.jpg'),
	(4, 'Fight Club', 1999, 'Thriller, Drame', 'David Fincher', 'Brad Pitt, Edward Norton, Helena Bonham Carter', 'Un homme souffrant d’insomnie et son nouveau ami charismatique créent un club de combats clandestins.', 'https://fr.web.img6.acsta.net/img/23/b7/23b757ce995171ae05ba7449c67a47dc.jpg'),
	(5, 'Star Wars: Épisode IV - Un Nouvel Espoir', 1977, 'Science-fiction, Aventure', 'George Lucas', 'Mark Hamill, Harrison Ford, Carrie Fisher', 'Un jeune fermier et ses amis s’allient pour sauver la galaxie de l’Empire.', 'https://fr.web.img6.acsta.net/medias/nmedia/18/35/41/59/18422600.jpg'),
	(6, 'Inception', 2010, 'Science-fiction, Action', 'Christopher Nolan', 'Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page', 'Un voleur professionnel s’infiltre dans les rêves de ses cibles pour leur voler des secrets.', 'https://fr.web.img2.acsta.net/medias/nmedia/18/72/34/14/19476654.jpg'),
	(7, 'Le Seigneur des Anneaux: Le Retour du Roi', 2003, 'Fantasy, Aventure', 'Peter Jackson', 'Elijah Wood, Ian McKellen, Viggo Mortensen', 'La guerre de l’Anneau atteint son point culminant.', 'https://fr.web.img3.acsta.net/medias/nmedia/18/35/14/33/18366630.jpg'),
	(8, 'La La Land', 2016, 'Comédie musicale, Romance', 'Damien Chazelle', 'Ryan Gosling, Emma Stone, John Legend', 'Deux artistes ambitieux tombent amoureux tout en poursuivant leurs rêves à Los Angeles.', 'https://fr.web.img4.acsta.net/pictures/16/11/10/13/52/169386.jpg'),
	(9, 'Blade Runner 2049', 2017, 'Science-fiction, Thriller', 'Denis Villeneuve', 'Ryan Gosling, Harrison Ford, Ana de Armas', 'Un agent spécial doit enquêter sur un mystérieux événement qui pourrait entraîner la fin de l’humanité.', 'https://fr.web.img4.acsta.net/pictures/17/08/24/15/18/597734.jpg'),
	(10, 'Le Roi Lion', 1994, 'Animation, Aventure', 'Roger Allers, Rob Minkoff', 'Matthew Broderick, Jeremy Irons, James Earl Jones', 'Un jeune lion doit faire face à son destin en tant que roi de la savane.', 'https://fr.web.img3.acsta.net/pictures/19/02/25/12/06/2908996.jpg'),
	(11, 'Inglourious Basterds', 2009, 'Guerre, Drame', 'Quentin Tarantino', 'Brad Pitt, Christoph Waltz, Mélanie Laurent', 'Un groupe de soldats juifs américains se lance dans une mission suicide pour tuer des nazis de haut rang.', 'https://fr.web.img2.acsta.net/medias/nmedia/18/70/45/22/19123474.jpg');

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
  `prix` int DEFAULT NULL,
  `auteur` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `annee` date DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `resume` text,
  `disponibilite` binary(1) DEFAULT NULL,
  `img_url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `livre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` text,
  `prix` int DEFAULT NULL,
  `auteur` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `annee` date DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `resume` text,
  `disponibilite` binary(1) DEFAULT NULL,
  `img_url` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `livre` (`id`, `nom`, `prix`, `auteur`, `annee`, `type`, `resume`, `disponibilite`, `img_url`) VALUES
	(12, 'Le Petit Prince', 10, 'Antoine de Saint-Exupéry', '1943-04-06', 'Conte', 'Le Petit Prince raconte l\'histoire d\'un petit garçon venu d\'une autre planète.', _binary 0x01, 'https://example.com/le-petit-prince.jpg'),
	(13, '1984', 12, 'George Orwell', '1949-06-08', 'Roman d\'anticipation', '1984 décrit une dystopie où les libertés individuelles sont supprimées.', _binary 0x01, 'https://example.com/1984.jpg'),
	(14, 'Le Seigneur des Anneaux', 20, 'J.R.R. Tolkien', '1954-07-29', 'Roman de fantasy', 'Le Seigneur des Anneaux raconte l\'histoire d\'un hobbit nommé Frodon qui part en quête pour détruire un anneau magique.', _binary 0x01, 'https://example.com/le-seigneur-des-anneaux.jpg'),
	(15, 'Orgueil et Préjugés', 8, 'Jane Austen', '1813-01-28', 'Roman romantique', 'Orgueil et Préjugés raconte l\'histoire d\'une famille anglaise bourgeoise dans les années 1800.', _binary 0x01, 'https://example.com/orgueil-et-prejuges.jpg'),
	(16, 'Les Misérables', 15, 'Victor Hugo', '1862-04-05', 'Roman historique', 'Les Misérables raconte l\'histoire d\'un homme appelé Jean Valjean qui doit faire face aux défis de la société française du XIXe siècle.', _binary 0x01, 'https://example.com/les-miserables.jpg'),
	(17, 'Le Crime de l\'Orient-Express', 10, 'Agatha Christie', '1934-01-01', 'Roman policier', 'Le Crime de l\'Orient-Express raconte l\'histoire d\'un meurtre qui se produit à bord de l\'Orient-Express.', _binary 0x01, 'https://example.com/le-crime-de-l-orient-express.jpg'),
	(18, 'Moby Dick', 18, 'Herman Melville', '1851-10-18', 'Roman d\'aventure', 'Moby Dick raconte l\'histoire d\'un capitaine qui se lance à la poursuite d\'une baleine blanche.', _binary 0x01, 'https://example.com/moby-dick.jpg'),
	(19, 'Le Vieil Homme et la Mer', 6, 'Ernest Hemingway', '1952-09-01', 'Roman d\'aventure', 'Le Vieil Homme et la Mer raconte l\'histoire d\'un pêcheur cubain qui se lance dans une bataille contre un énorme poisson.', _binary 0x01, 'https://example.com/le-vieil-homme-et-la-mer.jpg'),
	(20, 'Guerre et Paix', 25, 'Léon Tolstoï', '1869-01-01', 'Roman historique', 'Guerre et Paix raconte l\'histoire d\'une famille russe aristocratique pendant la guerre napoléonienne.', _binary 0x01, 'https://example.com/guerre-et-paix.jpg');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
