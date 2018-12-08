CREATE TABLE IF NOT EXISTS t_record(
  id INTEGER AUTO_INCREMENT PRIMARY KEY ,
  subject VARCHAR(255) NOT NULL COMMENT '主题',
  type VARCHAR(255) NOT NULL COMMENT '类型，收入/支出',
  amount DOUBLE COMMENT '金额',
  remarks VARCHAR(512) NULL DEFAULT NULL COMMENT '备注',
  occurrence_time DATETIME COMMENT '发生时间',
  occurrence_member INTEGER COMMENT '发生人Id',
  del TINYINT DEFAULT FALSE ,
  createOn DATETIME DEFAULT CURRENT_TIMESTAMP,
  updateOn DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)DEFAULT CHARSET 'utf8mb4' ENGINE 'InnoDB';