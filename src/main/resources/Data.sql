CREATE TABLE user_tbl (
    id serial primary key,
    user_name text,
    user_login text,
    user_pass text
);

CREATE TABLE document (
    id serial primary key,
    doc_date date,
    origin_docname text,
    doc_number bigint,
    doc_sum bigint,
    user_id int,
    comment text,
    direction text,
	file_data bytea
);