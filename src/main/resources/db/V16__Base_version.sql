CREATE TABLE IF NOT EXISTS t_plan
(
  id          INTEGER AUTO_INCREMENT PRIMARY KEY,
  subject     VARCHAR(255) NOT NULL COMMENT 'subject',
  status      VARCHAR(255) NOT NULL COMMENT 'status',
  loop_type      VARCHAR(255) NOT NULL COMMENT 'loopType',
  remarks text COMMENT 'description',
  del         TINYINT  DEFAULT FALSE,
  createOn    DATETIME DEFAULT CURRENT_TIMESTAMP,
  updateOn    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) DEFAULT CHARSET 'utf8mb4'
  ENGINE 'InnoDB';

CREATE TABLE IF NOT EXISTS t_plan_fragment
(
  id          INTEGER AUTO_INCREMENT PRIMARY KEY,
  plan_id     integer not null ,
  subject     VARCHAR(255) NOT NULL COMMENT 'subject',
  time_start  VARCHAR(255) NOT NULL COMMENT 'time_start',
  time_end    VARCHAR(255) NOT NULL COMMENT 'time_end',
  up          tinyint not null default 0,
  del         TINYINT  DEFAULT FALSE,
  createOn    DATETIME DEFAULT CURRENT_TIMESTAMP,
  updateOn    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) DEFAULT CHARSET 'utf8mb4'
  ENGINE 'InnoDB';