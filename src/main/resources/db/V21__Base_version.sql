# noinspection SqlNoDataSourceInspectionForFile
CREATE TABLE IF NOT EXISTS t_library_resource
(
  id                     INTEGER AUTO_INCREMENT PRIMARY KEY,
  resourceId             varchar(255),
  `name`                 varchar(255),
  description            text,
  homePageLink           varchar(255),
  interlibSsoSysId       integer,
  isNeedParseDetailPage  boolean,
  `show`                 integer,
  `state`                varchar(255),
  prior                  integer,
  redirectInterlibSsoUrl varchar(255),
  resourceGroupName      varchar(255),
  del                    TINYINT  DEFAULT FALSE,
  createOn               DATETIME DEFAULT CURRENT_TIMESTAMP,
  updateOn               DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) DEFAULT CHARSET 'utf8mb4'
  ENGINE 'InnoDB';