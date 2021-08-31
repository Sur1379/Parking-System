create table community
(
    id             bigint       not null auto_increment,
    name varchar(255) not null,
    primary key (id)
) engine = InnoDB;
create table parking_space
(
    id           bigint not null auto_increment,
    community_id bigint,
    primary key (id)
) engine = InnoDB;
create table user
(
    id                         bigint       not null auto_increment,
    username                  varchar(255) not null,
    primary key (id)
) engine = InnoDB;
create table user_community
(
    user_id      bigint not null,
    community_id bigint not null
) engine = InnoDB;

create table user_parking_space
(
    id               bigint      not null auto_increment,
    end              datetime(6),
    start            datetime(6) not null,
    parking_space_id bigint,
    user_id          bigint,
    primary key (id)
) engine = InnoDB;

alter table user
    drop index if exists UK_lqjrcobrh9jc8wpcar64q1bfh;
alter table user
    add constraint UK_lqjrcobrh9jc8wpcar64q1bfh unique (username);
alter table parking_space
    add constraint FKmkb68uf2wsgh0sofb6ux5oof3 foreign key (community_id) references community (id);
alter table user_community
    add constraint FKjaf72a6cqil9j5qqwhwu9twb5 foreign key (community_id) references community (id);
alter table user_community
    add constraint FKb2odx6thr0g92toooamkf96ig foreign key (user_id) references user (id);
alter table user_parking_space
    add constraint FK5sg37nwe1y75qphnaxm3djsc2 foreign key (parking_space_id) references parking_space (id);
alter table user_parking_space
    add constraint FKlsdrnxl5c75k8mg3odj44wavy foreign key (user_id) references user (id);
