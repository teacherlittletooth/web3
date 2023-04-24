-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Tempo de geração: 24-Abr-2023 às 21:56
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
-- Banco de dados: `clube`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `titulares`
--

CREATE TABLE `titulares` (
  `id_titular` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `titulares`
--

INSERT INTO `titulares` (`id_titular`, `nome`, `nascimento`, `cpf`, `cep`) VALUES
(1, 'Josivaldson Gustamante', '1996-05-30', '123.456.789-10', '99880-000'),
(2, 'Filada Mãe Juca', '1988-06-03', '456.789.123-11', '85600-100'),
(3, 'Clementina Filomena', '1957-01-29', '001.020.060-50', '48999-001'),
(100, 'Dionísio Veras', '2011-11-02', '456.456.456-45', '97785-020');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `titulares`
--
ALTER TABLE `titulares`
  ADD PRIMARY KEY (`id_titular`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `titulares`
--
ALTER TABLE `titulares`
  MODIFY `id_titular` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
