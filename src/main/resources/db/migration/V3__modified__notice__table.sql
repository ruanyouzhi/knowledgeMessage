alter table notice modify id bigint auto_increment;

alter table notice change creator_id notifier bigint null;

alter table notice
    add receiver bigint null after notifier;

alter table notice change card_url card_id bigint null;

alter table notice change notice card_name varchar(500) null after card_id;

alter table notice
    add notifier_name varchar(50) null after card_name;

alter table notice change is_read status int null;

alter table notice
    add gmtCreate bigint null;
