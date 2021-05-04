INSERT INTO customers_db.customers_address(customer_address_id, street, number, complement postal_code, neighborhood, city, state)
VALUES(1, 'Rua Vergueiro', '100', 'apt 10', '04104-001', 'Vila Mariana', 'São Paulo', 'SP');

INSERT INTO customers_db.customers_address(customer_address_id, street, number, complement postal_code, neighborhood, city, state)
VALUES(2, 'Rua Rio de Janeiro', '77', 'casas A', '04171-099', 'Santa Cruz', 'São Paulo', 'SP');

INSERT INTO customers_db.customers_address(customer_address_id, street, number, complement postal_code, neighborhood, city, state)
VALUES(3, 'Av Paulista', '500', '3º andar', '04111-100', 'Cerqueira César', 'São Paulo', 'SP');

INSERT INTO customers_db.customers(customer_id, first_name, last_name, document, mobile, email, total_debt_value, debit_start_date, description, customer_address_id)
VALUES(1, 'Edson', 'Costa', '98765432100', '(13)987654321', 'edsoncosa.jr89@gmail.com', 100, 2020-12-01, 'Débitos relativos a financiamento de veículo', 1);

INSERT INTO customers_db.customers(customer_id, first_name, last_name, document, mobile, email, total_debt_value, debit_start_date, description, customer_address_id)
VALUES(2, 'Costa', 'Junior', '778765432111', '(21)987654321', 'teste@teste.com.br', 9000, 2020-02-23, 'Débitos relativos a financiamento imobiliário', 2);

INSERT INTO customers_db.customers(customer_id, first_name, last_name, document, mobile, email, total_debt_value, debit_start_date, description, customer_address_id)
VALUES(3, 'Junior', 'Edson', '33765432122', '(11)987654321', 'teste@teste.com', 3500, 2020-12-01, 'Débitos relativos a cartão de crédito', 3);

