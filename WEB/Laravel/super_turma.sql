-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14-Maio-2024 às 16:59
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `super_turma`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cache`
--

CREATE TABLE `cache` (
  `key` varchar(255) NOT NULL,
  `value` mediumtext NOT NULL,
  `expiration` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `cache`
--

INSERT INTO `cache` (`key`, `value`, `expiration`) VALUES
('767e075ac856a2608d060b86ce30e93f', 'i:2;', 1715695002),
('767e075ac856a2608d060b86ce30e93f:timer', 'i:1715695002;', 1715695002),
('c6be2cf7c13d9a527ee2fe401bbae3c7', 'i:2;', 1715097287),
('c6be2cf7c13d9a527ee2fe401bbae3c7:timer', 'i:1715097287;', 1715097287);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cache_locks`
--

CREATE TABLE `cache_locks` (
  `key` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `expiration` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `failed_jobs`
--

CREATE TABLE `failed_jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `connection` text NOT NULL,
  `queue` text NOT NULL,
  `payload` longtext NOT NULL,
  `exception` longtext NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `flights`
--

CREATE TABLE `flights` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `voo_nr` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `gifts`
--

CREATE TABLE `gifts` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `descricao` text DEFAULT NULL,
  `valor_previsto` double NOT NULL,
  `valor_gasto` double DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `gifts`
--

INSERT INTO `gifts` (`id`, `name`, `user_id`, `descricao`, `valor_previsto`, `valor_gasto`, `created_at`, `updated_at`) VALUES
(1, 'Moto', 5, 'yamaha 365x', 2500, 2510, NULL, NULL),
(2, 'Galaxy Fold Z', 1, 'Galaxy Fold Z com IA', 1100, 1125, NULL, NULL),
(3, 'Computador DELL', 4, 'OptiPlex 5400 AIO', 700, 700, NULL, NULL),
(4, 'printer 3d', 3, 'Prusa i4', 470, 450, NULL, NULL),
(5, 'Portatil ASUS', 5, 'Portátil Gamer', 1650, 1500, NULL, NULL),
(6, 'teste', 2, 'teste apaga', 666, 999, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `jobs`
--

CREATE TABLE `jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `queue` varchar(255) NOT NULL,
  `payload` longtext NOT NULL,
  `attempts` tinyint(3) UNSIGNED NOT NULL,
  `reserved_at` int(10) UNSIGNED DEFAULT NULL,
  `available_at` int(10) UNSIGNED NOT NULL,
  `created_at` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `job_batches`
--

CREATE TABLE `job_batches` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `total_jobs` int(11) NOT NULL,
  `pending_jobs` int(11) NOT NULL,
  `failed_jobs` int(11) NOT NULL,
  `failed_job_ids` longtext NOT NULL,
  `options` mediumtext DEFAULT NULL,
  `cancelled_at` int(11) DEFAULT NULL,
  `created_at` int(11) NOT NULL,
  `finished_at` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(4, '0001_01_01_000000_create_users_table', 1),
(5, '0001_01_01_000001_create_cache_table', 1),
(6, '0001_01_01_000002_create_jobs_table', 1),
(8, '2024_04_09_135743_create_flights_table', 2),
(10, '2024_04_09_141706_create_tasks_table', 3),
(12, '2024_04_09_150509_add_items_to_users_table', 4),
(13, '2024_04_09_153041_add_fk_users_id_to_tasks_table', 5),
(16, '2024_04_30_082719_create_gifts_table', 6),
(17, '2024_05_07_151939_add_two_factor_columns_to_users_table', 7),
(19, '2024_05_14_093019_add_user_type_to_users_table', 8);

-- --------------------------------------------------------

--
-- Estrutura da tabela `password_reset_tokens`
--

CREATE TABLE `password_reset_tokens` (
  `email` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `password_reset_tokens`
--

INSERT INTO `password_reset_tokens` (`email`, `token`, `created_at`) VALUES
('teste@teste.test', '$2y$12$kTsYaU5hfLcpLJMntQVjGugR41oQSx1eZkYkYYL6MICxuYiwZet66', '2024-05-14 13:16:20');

-- --------------------------------------------------------

--
-- Estrutura da tabela `sessions`
--

CREATE TABLE `sessions` (
  `id` varchar(255) NOT NULL,
  `user_id` bigint(20) UNSIGNED DEFAULT NULL,
  `ip_address` varchar(45) DEFAULT NULL,
  `user_agent` text DEFAULT NULL,
  `payload` longtext NOT NULL,
  `last_activity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `sessions`
--

INSERT INTO `sessions` (`id`, `user_id`, `ip_address`, `user_agent`, `payload`, `last_activity`) VALUES
('CacB5UzVd6hpqCQCUaFUqiLjYYvGvguez75E0jZe', NULL, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36', 'YTozOntzOjY6Il90b2tlbiI7czo0MDoiMm5FaG9CWTIwVTA2V0xnWGhxMEJ2TkhnV0hBZWZvQXEyTjkyZnV3aSI7czo2OiJfZmxhc2giO2E6Mjp7czozOiJvbGQiO2E6MDp7fXM6MzoibmV3IjthOjA6e319czo5OiJfcHJldmlvdXMiO2E6MTp7czozOiJ1cmwiO3M6MTI2OiJodHRwOi8vMTI3LjAuMC4xOjgwMDAvcmVzZXQtcGFzc3dvcmQvOTEwN2RmODk0OGMyM2E5MzI3NTU4YjhkNDEyODE1ZGE2YzFjNTkzOTQxNTc3NTMwMjcyN2E1MzVhNTNjNmE0ZT9lbWFpbD10ZXN0ZSU0MHRlc3RlLnRlc3QiO319', 1715696304);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tasks`
--

CREATE TABLE `tasks` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `due_at` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `user_id` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `tasks`
--

INSERT INTO `tasks` (`id`, `name`, `description`, `due_at`, `status`, `created_at`, `updated_at`, `user_id`) VALUES
(1, 'ct', 'create table', NULL, 0, NULL, NULL, 1),
(2, 'estudar', 'estudar laravel', NULL, NULL, NULL, '2024-04-23 15:03:25', NULL),
(3, 'trabalhar', 'trabalhar no webserverside', NULL, NULL, NULL, '2024-04-23 15:02:55', NULL),
(4, 'typescript', 'fazer fichas do typescript', NULL, NULL, NULL, '2024-04-23 15:03:10', NULL),
(5, 'teste', 'teste', NULL, NULL, NULL, '2024-05-07 12:34:30', NULL),
(6, 'test', 'tete', NULL, NULL, NULL, NULL, 5),
(7, 'teste1', 'teste', NULL, NULL, NULL, NULL, NULL),
(8, 'teste', 'teste', NULL, NULL, NULL, NULL, NULL),
(9, 'teste1', 'teste', NULL, NULL, NULL, NULL, NULL),
(10, 'teste3', 'teste', NULL, NULL, NULL, '2024-05-07 12:47:02', 6),
(11, 'teste11', NULL, NULL, NULL, NULL, '2024-05-07 13:13:02', 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `user_type` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `two_factor_secret` text DEFAULT NULL,
  `two_factor_recovery_codes` text DEFAULT NULL,
  `two_factor_confirmed_at` timestamp NULL DEFAULT NULL,
  `remember_token` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `user_type`, `address`, `zip_code`, `email_verified_at`, `password`, `two_factor_secret`, `two_factor_recovery_codes`, `two_factor_confirmed_at`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'Sara', 'sara@gmail.com', NULL, NULL, NULL, NULL, '153355', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Luís', 'luis@gmail.com', NULL, NULL, NULL, NULL, '1255564', NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'Liliana', 'liliana@gmail.com', NULL, NULL, NULL, NULL, '1255154', NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'João', 'joao@gmail.com', NULL, NULL, NULL, NULL, '21561332', NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'Gonçalo', 'gonçalo@example.com', NULL, NULL, NULL, NULL, '1837294605', NULL, NULL, NULL, NULL, NULL, NULL),
(6, 'Joaquim', 'joaquim@exemple.pt', NULL, NULL, NULL, NULL, '$2y$12$/CSQ2H1zrzrv7C2kiqZEq.6KB1mvkLqWL1j6mhzJFKF/sDe8qm9W2', NULL, NULL, NULL, NULL, NULL, NULL),
(7, 'Jessica', 'jessica@gmail.com', NULL, NULL, NULL, NULL, '111565656151', NULL, NULL, NULL, NULL, NULL, NULL),
(8, 'fgdfg', 'fgdfg@nfdjdns.fjnsj', NULL, 'asdsakdsnadnn dsandkn', '4444-444', NULL, '$2y$12$OXH04B6fbrw8jp5e75JqmevncdPzlgzA8SSN6cTthBNOIOvm/jicO', NULL, NULL, NULL, NULL, NULL, '2024-05-07 09:44:31'),
(9, 'Teste', 'teste@test.test', NULL, NULL, NULL, NULL, '$2y$12$cefmDWIpaMGVRtoo8F5uv.FfnIMR2dtq1TfSSI9ouvRmPx8bnfEpa', NULL, NULL, NULL, NULL, NULL, NULL),
(10, 'test2', 'fgdfgfsdfsdf@nfdjdns.fjnsj', NULL, 'Ciriaco Cardos', '4444-444', NULL, '$2y$12$jGk7Pn89djzgca7LHjuaNex483woISNF8foA9OshhD29vVxV1kdPa', NULL, NULL, NULL, NULL, '2024-05-07 09:56:18', '2024-05-07 13:53:28'),
(11, 'teste_auth', 'teste@teste.test', 1, NULL, NULL, NULL, '$2y$12$CxRWOr3qBvxOHZ4S7hEN9OkhI83CcuFkfJDpGqnnTb7GUXT1raeXS', NULL, NULL, NULL, 'HomsN08b7cO7CTIHOOlF62B9umHODDPLDYxBUZzfPWZIWbK88mrzO4jliaJV', '2024-05-07 14:47:46', '2024-05-14 12:55:30');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cache`
--
ALTER TABLE `cache`
  ADD PRIMARY KEY (`key`);

--
-- Índices para tabela `cache_locks`
--
ALTER TABLE `cache_locks`
  ADD PRIMARY KEY (`key`);

--
-- Índices para tabela `failed_jobs`
--
ALTER TABLE `failed_jobs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `failed_jobs_uuid_unique` (`uuid`);

--
-- Índices para tabela `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `gifts`
--
ALTER TABLE `gifts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `gifts_user_id_foreign` (`user_id`);

--
-- Índices para tabela `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `jobs_queue_index` (`queue`);

--
-- Índices para tabela `job_batches`
--
ALTER TABLE `job_batches`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `password_reset_tokens`
--
ALTER TABLE `password_reset_tokens`
  ADD PRIMARY KEY (`email`);

--
-- Índices para tabela `sessions`
--
ALTER TABLE `sessions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sessions_user_id_index` (`user_id`),
  ADD KEY `sessions_last_activity_index` (`last_activity`);

--
-- Índices para tabela `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tasks_user_id_foreign` (`user_id`);

--
-- Índices para tabela `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `failed_jobs`
--
ALTER TABLE `failed_jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `flights`
--
ALTER TABLE `flights`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `gifts`
--
ALTER TABLE `gifts`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `jobs`
--
ALTER TABLE `jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de tabela `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `gifts`
--
ALTER TABLE `gifts`
  ADD CONSTRAINT `gifts_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Limitadores para a tabela `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `tasks_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
