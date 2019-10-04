CREATE TABLE `access` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agent` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `device` varchar(255) DEFAULT NULL,
  `os` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;