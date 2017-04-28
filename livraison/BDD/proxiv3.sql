-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 28 Avril 2017 à 12:50
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxiv3`
--

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `TYPE_COMPTE` varchar(31) NOT NULL,
  `idCompte` int(11) NOT NULL,
  `dateOuverture` int(11) NOT NULL,
  `numerocompte` int(11) NOT NULL,
  `solde` int(11) NOT NULL,
  `tauxRemuneration` int(11) DEFAULT NULL,
  `typeCompte` varchar(255) DEFAULT NULL,
  `decouverteAutorise` int(11) DEFAULT NULL,
  `client_idPersonne` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`TYPE_COMPTE`, `idCompte`, `dateOuverture`, `numerocompte`, `solde`, `tauxRemuneration`, `typeCompte`, `decouverteAutorise`, `client_idPersonne`) VALUES
('COMPTE_COURANT', 1, 28111984, 1000, 1000, NULL, 'courant', 1000, 1),
('COMPTE_EPARGNE', 2, 28111984, 1001, 500, 3, 'épargne', NULL, 1),
('COMPTE_COURANT', 3, 28111984, 1002, 2000, NULL, 'courant', 1000, 2),
('COMPTE_EPARGNE', 4, 28111984, 1003, 1000, 3, 'épargne', NULL, 2),
('COMPTE_COURANT', 5, 28111984, 1004, 3000, NULL, 'courant', 200, 5),
('COMPTE_EPARGNE', 6, 28111984, 1005, 4000, 3, 'épargne', NULL, 5),
('COMPTE_COURANT', 7, 28111984, 1006, 5000, NULL, 'courant', 100, 6),
('COMPTE_EPARGNE', 8, 28111984, 1007, 50, 3, 'épargne', NULL, 6);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `TYPE_PERSONNE` varchar(31) NOT NULL,
  `idPersonne` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `codePostal` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `typeClient` varchar(255) DEFAULT NULL,
  `dateCreation` varchar(255) DEFAULT NULL,
  `nomAgence` varchar(255) DEFAULT NULL,
  `gerant_idPersonne` int(11) DEFAULT NULL,
  `conseiller_idPersonne` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`TYPE_PERSONNE`, `idPersonne`, `adresse`, `codePostal`, `nom`, `prenom`, `telephone`, `ville`, `login`, `password`, `typeClient`, `dateCreation`, `nomAgence`, `gerant_idPersonne`, `conseiller_idPersonne`) VALUES
('CLIENT', 1, '7 rue amédée morel', '38000', 'salomon', 'vincent', '0630335411', 'Grenoble', NULL, NULL, 'particulier', NULL, NULL, NULL, 3),
('CLIENT', 2, '8 allée des chevreuils', '73100', 'bertrand', 'jean', '0654545454', 'aix-les-bains', NULL, NULL, 'particulier', NULL, NULL, NULL, 3),
('CONSEILLER', 3, 'centre', '69000', 'cons1', 'precons1', '0900000000', 'lyon', 'bourne', 'bourne', NULL, NULL, NULL, NULL, NULL),
('CONSEILLER', 4, 'loin', '69000', 'cons2', 'precons2', '099999999', 'Lyon', 'bourne2', 'bourne2', NULL, NULL, NULL, NULL, NULL),
('CLIENT', 5, 'centre', '69001', 'GOOGLE', 'secteur lyon centre', '0400000000', 'Lyon', NULL, NULL, 'entreprise', NULL, NULL, NULL, 4),
('CLIENT', 6, 'loin', '69012', 'GOOGLE', 'secteur lyon loin', '0444444444', 'lyon', NULL, NULL, 'entreprise', NULL, NULL, NULL, 4);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`idCompte`),
  ADD KEY `FK_1b66ossdbkhm0r1fjomaq3w2a` (`client_idPersonne`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`idPersonne`),
  ADD KEY `FK_97hs2ki1kf3t629fyvjieb08i` (`gerant_idPersonne`),
  ADD KEY `FK_cqwvt7lbjti4cxm4m9mkd0730` (`conseiller_idPersonne`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `idCompte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `idPersonne` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
