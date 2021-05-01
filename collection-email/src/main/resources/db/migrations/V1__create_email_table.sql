create schema if not exists emails;

create table emails.email(
  email_id            bigint primary key,
  email_customer      varchar(100) NOT NULL,
  first_name_customer varchar(100) NOT NULL,
  last_name_customer  varchar(100) NOT NULL,
  document_customer   varchar(100) NOT NULL,
  total_debt_value    bigint NOT NULL,
  debt_start_date     date NOT NULL,
  description         varchar(100) NOT NULL
);

