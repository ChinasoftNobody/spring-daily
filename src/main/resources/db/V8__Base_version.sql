CREATE TABLE IF NOT EXISTS t_template(
  id INTEGER AUTO_INCREMENT PRIMARY KEY ,
  feature_id INTEGER NOT NULL ,
  name VARCHAR(64) NOT NULL COMMENT '名称',
  description VARCHAR(512) COMMENT '描述',
  del TINYINT DEFAULT FALSE ,
  createOn DATETIME DEFAULT CURRENT_TIMESTAMP,
  updateOn DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)DEFAULT CHARSET 'utf8mb4' ENGINE 'InnoDB';

CREATE TABLE IF NOT EXISTS t_template_property(
  id INTEGER AUTO_INCREMENT PRIMARY KEY ,
  feature_id INTEGER NOT NULL ,
  tmplate_id INTEGER NOT NULL ,
  name VARCHAR(64) NOT NULL COMMENT '名称',
  type INTEGER NOT NULL COMMENT '类型',
  value TEXT COMMENT '值',
  default_value TEXT COMMENT '默认值',
  description VARCHAR(512) COMMENT '描述',
  del TINYINT DEFAULT FALSE ,
  createOn DATETIME DEFAULT CURRENT_TIMESTAMP,
  updateOn DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)DEFAULT CHARSET 'utf8mb4' ENGINE 'InnoDB';