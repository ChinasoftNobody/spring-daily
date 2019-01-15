# noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE IF NOT EXISTS t_library_classify
(
  id              INTEGER AUTO_INCREMENT PRIMARY KEY,
  `number`        INTEGER not null comment '分类编号',
  parentNumber    integer not null default 0 comment '父类编号',
  name            varchar(255) comment '分类名称',
  description     varchar(255) comment '分类描述',
  source          varchar(255) not null comment '源',
  del             TINYINT      DEFAULT FALSE,
  createOn        DATETIME     DEFAULT CURRENT_TIMESTAMP,
  updateOn        DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) DEFAULT CHARSET 'utf8mb4'
  ENGINE 'InnoDB';