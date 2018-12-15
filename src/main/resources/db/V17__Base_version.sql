
CREATE TABLE IF NOT EXISTS t_voice_clock_message
(
  id          INTEGER AUTO_INCREMENT PRIMARY KEY,
  vol_tex         text,
  vol_cuid    varchar(255),
  vol_lan     varchar(255),
  vol_ctp     varchar(255),
  vol_pdt     varchar(255),
  vol_vol     varchar(255),
  vol_spd     varchar(255),
  count       integer,
  del         TINYINT  DEFAULT FALSE,
  createOn    DATETIME DEFAULT CURRENT_TIMESTAMP,
  updateOn    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) DEFAULT CHARSET 'utf8mb4'
  ENGINE 'InnoDB';