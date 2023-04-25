-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Tempo de geração: 25-Abr-2023 às 14:41
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `game`
--

CREATE DATABASE game;
USE game;

-- --------------------------------------------------------

--
-- Estrutura da tabela `loja`
--

CREATE TABLE `loja` (
  `cod_loja` int(11) NOT NULL,
  `nome` varchar(30) DEFAULT NULL,
  `cod_mapa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `mapas`
--

CREATE TABLE `mapas` (
  `cod_mapa` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `missao` text NOT NULL,
  `clima` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `npc`
--

CREATE TABLE `npc` (
  `cod_npc` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `elemento` varchar(20) NOT NULL,
  `dano` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `npc_mapas`
--

CREATE TABLE `npc_mapas` (
  `cod_npc_mapas` int(11) NOT NULL,
  `cod_npc` int(11) NOT NULL,
  `cod_mapa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `loja`
--
ALTER TABLE `loja`
  ADD PRIMARY KEY (`cod_loja`),
  ADD KEY `cod_mapa` (`cod_mapa`);

--
-- Índices para tabela `mapas`
--
ALTER TABLE `mapas`
  ADD PRIMARY KEY (`cod_mapa`);

--
-- Índices para tabela `npc`
--
ALTER TABLE `npc`
  ADD PRIMARY KEY (`cod_npc`);

--
-- Índices para tabela `npc_mapas`
--
ALTER TABLE `npc_mapas`
  ADD PRIMARY KEY (`cod_npc_mapas`),
  ADD KEY `cod_npc` (`cod_npc`),
  ADD KEY `cod_mapa` (`cod_mapa`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `loja`
--
ALTER TABLE `loja`
  MODIFY `cod_loja` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `mapas`
--
ALTER TABLE `mapas`
  MODIFY `cod_mapa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `npc`
--
ALTER TABLE `npc`
  MODIFY `cod_npc` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `npc_mapas`
--
ALTER TABLE `npc_mapas`
  MODIFY `cod_npc_mapas` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `loja`
--
ALTER TABLE `loja`
  ADD CONSTRAINT `loja_ibfk_1` FOREIGN KEY (`cod_mapa`) REFERENCES `mapas` (`cod_mapa`);

--
-- Limitadores para a tabela `npc_mapas`
--
ALTER TABLE `npc_mapas`
  ADD CONSTRAINT `npc_mapas_ibfk_1` FOREIGN KEY (`cod_npc`) REFERENCES `npc` (`cod_npc`),
  ADD CONSTRAINT `npc_mapas_ibfk_2` FOREIGN KEY (`cod_mapa`) REFERENCES `mapas` (`cod_mapa`);
COMMIT;

--
-- Inserindo dados nas tabelas
--

INSERT INTO `mapas`(`nome`, `missao`, `clima`)
VALUES ('SanAndreas','Derrubar Nexus Inimigo','Ensolarado'),
('Vice City','Explodir Metrô','Chuvoso'),
('Las Vegas','Trapacear no Cassino','Nublado'),
('Los Santos','Sequestrar avião','Ventoso');

INSERT INTO `loja`( `nome`, `cod_mapa`)
VALUES ('Armamento', 1),
('Padaria', 1),
('Construção', 1),
('Pescaria', 2),
('Aviamentos', 2),
('Eletrônica', 3),
('Informática', 4);

INSERT INTO `npc`(`nome`, `elemento`, `dano`)
VALUES ('George','terra', 2),
('Peppa', 'terra', 9999),
('Naruto','ar', 10),
('Goku','fogo', 8000),
('Pocoiô','água', 1);

INSERT INTO `npc_mapas`(`cod_npc`, `cod_mapa`)
VALUES (1,1),
(1,2),
(1,3),
(1,4),
(2,2),
(2,3),
(3,1),
(3,2),
(4,1),
(4,2),
(4,3),
(4,4),
(5,4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
