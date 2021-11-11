-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: mysql
-- Tempo de geração: 10-Nov-2021 às 23:48
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
-- Estrutura da tabela `post`
--

CREATE TABLE `post` (
  `id` int UNSIGNED NOT NULL,
  `topic_id` int UNSIGNED NOT NULL,
  `title` varchar(300) NOT NULL,
  `text` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Extraindo dados da tabela `post`
--

INSERT INTO `post` (`id`, `topic_id`, `title`, `text`) VALUES
(1, 1, 'fist post in topic 1', 'this is the fist post in topic 1'),
(2, 1, 'second post in topic 1', 'this is the second post in topic 1'),
(3, 1, 'third post topic 1', 'this is the third post topic 1'),
(4, 1, 'last post topic 1', 'this is the last post topic 1'),
(5, 2, 'first post topic 2', 'this is the first post topic 2'),
(6, 2, 'second post topic 2', 'this is the second post topic 2'),
(7, 3, 'first post topic 3', 'this is the first post topic 3'),
(8, 4, 'first post topic 4', 'this is the first post topic 4');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`),
  ADD KEY `topic_id` (`topic_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `post`
--
ALTER TABLE `post`
  MODIFY `id` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `post_ibfk_1` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
