create schema if not exists collection_emails_db;

create table collection_emails_db.emails(
  email_id bigint primary key AUTO_INCREMENT,
  email_customer varchar(100) NOT NULL,
  first_name_customer varchar(100) NOT NULL,
  last_name_customer varchar(100) NOT NULL,
  document_customer varchar(100) NOT NULL,
  total_debit_value bigint NOT NULL,
  debit_start_date  date NOT NULL,
  description varchar(100) NOT NULL
);

create table collection_emails_db.emails_confirmation(
  confirmation_id bigint primary key AUTO_INCREMENT,
  email_id bigint REFERENCES collection_emails_db.emails(email_id),
  was_sent bit(1) NOT NULL
);