CREATE DATABASE The_DropWizards_DallanM;

USE The_DropWizards_DallanM;

CREATE TABLE Team (
	team_id MEDIUMINT PRIMARY KEY AUTO_INCREMENT,
    team_type VARCHAR(255)
    );
    
CREATE TABLE Employee (
	employee_id MEDIUMINT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(255),
    salary DECIMAL(10,2),
    bank_account_number CHAR(8),
    national_insurance_number CHAR(9),
    team_id MEDIUMINT,
    FOREIGN KEY (team_id) REFERENCES Team(team_id)
	);   

-- Insert fake data into the Team table
INSERT INTO Team (team_type)
VALUES
    ('HR'),
    ('Delivery');
    
    -- Insert fake data into the Employee table
INSERT INTO Employee (employee_name, salary, bank_account_number, national_insurance_number, team_id)
VALUES
    ('John Doe', 60000, '12345678', 'AB123456C', 1),
    ('Jane Smith', 55000, '23456789', 'CD234567D', 2),
    ('David Johnson', 70000, '34567890', 'EF345678E', 2),
    ('Emily Davis', 48000, '45678901', 'GH456789F', 2);