CREATE TABLE IF NOT EXISTS Accounts (
    number TEXT PRIMARY KEY,           -- Номер счета (12 цифр)
    pin_code TEXT NOT NULL,            -- PIN-код (4 цифры)
    balance REAL NOT NULL,             -- Баланс счета
    deposit_interest REAL NOT NULL     -- Процент по депозиту
);

INSERT INTO Accounts (number, pin_code, balance, deposit_interest)
VALUES ('123456789012', '1234', 1000.00, 5.0);
