create schema if not exists emails_confirmation;

create table emails_confirmation.emails_confirmation(
  confirmation_id bigint primary key,
  email_id bigint REFERENCES emails.email(email_id),
  was_sent bit(1) NOT NULL
);