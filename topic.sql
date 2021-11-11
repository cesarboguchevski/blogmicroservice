-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: mysql
-- Tempo de geração: 10-Nov-2021 às 23:50
-- Versão do servidor: 8.0.26
-- versão do PHP: 7.4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `virtualmind`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `topic`
--

CREATE TABLE `topic` (
  `id` int UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Extraindo dados da tabela `topic`
--

INSERT INTO `topic` (`id`, `name`) VALUES
(1, 'updated new topic 1'),
(2, 'a topic 2'),
(3, 'c topic 3'),
(4, 'updated new topic 4'),
(5, 'topic 5');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `topic`
--
ALTER TABLE `topic`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `topic`
--
ALTER TABLE `topic`
  MODIFY `id` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
