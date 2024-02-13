drop table if exists board_table;

create table board_table (
                             board_hits integer,
                             created_time datetime(6),
                             id bigint not null auto_increment,
                             updated_time datetime(6),
                             board_writer varchar(20) not null,
                             board_contents varchar(500),
                             board_pass varchar(255),
                             board_title varchar(255),
                             primary key (id)
)

DROP TABLE IF EXISTS comment_table;

create table comment_table (
                               board_id bigint,
                               created_time datetime(6),
                               id bigint not null auto_increment,
                               updated_time datetime(6),
                               comment_writer varchar(20) not null,
                               comment_contents varchar(255),
                               primary key (id)
);