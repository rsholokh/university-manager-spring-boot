DROP TABLE IF EXISTS departments;

CREATE TABLE departments (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    head_of_department_id INT NOT NULL
);

DROP TABLE IF EXISTS lectors;

CREATE TABLE lectors (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    degree VARCHAR(45) NOT NULL,
    salary INT NOT NULL
);

DROP TABLE IF EXISTS departments_lectors;

CREATE TABLE departments_lectors (
    departments_id INT NOT NULL,
    lectors_id INT NOT NULL
);

ALTER TABLE departments ADD CONSTRAINT head_of_department_id_fk FOREIGN KEY (head_of_department_id) REFERENCES lectors(id);
ALTER TABLE departments_lectors ADD CONSTRAINT departments_id_fk FOREIGN KEY (departments_id) REFERENCES departments(id);
ALTER TABLE departments_lectors ADD CONSTRAINT lectors_id_fk FOREIGN KEY (lectors_id) REFERENCES lectors(id);


