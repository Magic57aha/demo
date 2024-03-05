CREATE TABLE USERTABLE(
                          id INT AUTO_INCREMENT,
                          account_id VARCHAR(100),
                          name VARCHAR(50),
                          token CHAR(36),
                          gmt_create BIGINT,
                          gmt_modified BIGINT,
                          CONSTRAINT pk_table PRIMARY KEY (id)
);
