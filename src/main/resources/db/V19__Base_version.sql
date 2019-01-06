CREATE TABLE IF NOT EXISTS t_finance_expend
(
  id              INTEGER AUTO_INCREMENT PRIMARY KEY,
  subject         varchar(255) not null,
  description     text,
  amount          double      default 0,
  frequency_count integer      default 1,
  frequency_unit  varchar(255) default 'Moth',
  del             TINYINT      DEFAULT FALSE,
  createOn        DATETIME     DEFAULT CURRENT_TIMESTAMP,
  updateOn        DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) DEFAULT CHARSET 'utf8mb4'
  ENGINE 'InnoDB';