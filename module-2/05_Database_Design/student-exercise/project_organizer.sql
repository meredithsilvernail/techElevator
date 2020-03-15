BEGIN TRANSACTION;

CREATE TABLE employee
(
	employee_number serial,
	job_title varchar(100) not null,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	gender varchar(20) null,
	birth_date date,
	hire_date date,
	department_ID int not null,
	
	constraint pk_employee primary key (employee_number)

);

CREATE TABLE department
(
        department_id serial,
        department_name varchar(100),
        
        constraint pk_department primary key (department_id)
);

CREATE TABLE project
(
        project_number serial,
        project_name varchar(100),
        start_date date,
        
        constraint pk_project primary key (project_number)

);

CREATE TABLE project_employee
(
        employee_number int not null,
        project_number int not null,
        
        constraint pk_project_employee primary key (employee_number, project_number)
);

ALTER TABLE employee
ADD FOREIGN KEY (department_id)
REFERENCES department (department_id);

COMMIT;

INSERT INTO department(department_name)
VALUES ('Marketing');

INSERT INTO department(department_name)
VALUES ('Sales');

INSERT INTO department(department_name)
VALUES ('HR');

INSERT INTO employee (job_title, first_name, last_name, gender, department_id)
VALUES ('Associate I', 'Steve', 'Jobs', 'male', 1);
INSERT INTO employee (job_title, first_name, last_name, gender, department_id)
VALUES ('Supervisor', 'Rory', 'Gilmore', 'female', 2);
INSERT INTO employee (job_title, first_name, last_name, gender, department_id)
VALUES ('Partner', 'Luke', 'Danes', 'male', 3);
INSERT INTO employee (job_title, first_name, last_name, gender, department_id)
VALUES ('Associate II', 'Dany', 'Targaryen', 'female', 1);
INSERT INTO employee (job_title, first_name, last_name, gender, department_id)
VALUES ('Advisor', 'Bilbo', 'Baggins', 'male', 2);
INSERT INTO employee (job_title, first_name, last_name, gender, department_id)
VALUES ('Junior Partner', 'Peter', 'Jackson', 'male', 3);
INSERT INTO employee (job_title, first_name, last_name, gender, department_id)
VALUES ('Copywriter', 'Samantha', 'Cook', 'female', 1);
INSERT INTO employee (job_title, first_name, last_name, gender, department_id)
VALUES ('Clerk', 'Wade', 'Watts', 'male', 2);

INSERT INTO project (project_name)
VALUES ('Spring ad campaign');

INSERT INTO project (project_name)
VALUES ('New financing app');

INSERT INTO project (project_name)
VALUES ('Employee portal');

INSERT INTO project_employee(employee_number, project_number)
VALUES ((SELECT employee_number FROM employee WHERE first_name = 'Steve'), 1);
INSERT INTO project_employee(employee_number, project_number)
VALUES ((SELECT employee_number FROM employee WHERE first_name = 'Rory'), 1);
INSERT INTO project_employee(employee_number, project_number)
VALUES ((SELECT employee_number FROM employee WHERE first_name = 'Luke'), 1);

INSERT INTO project_employee(employee_number, project_number)
VALUES ((SELECT employee_number FROM employee WHERE first_name = 'Dany'), (SELECT project_number FROM project WHERE project_name = 'New financing app'));
INSERT INTO project_employee(employee_number, project_number)
VALUES ((SELECT employee_number FROM employee WHERE first_name = 'Bilbo'), (SELECT project_number FROM project WHERE project_name = 'New financing app'));
INSERT INTO project_employee(employee_number, project_number)
VALUES ((SELECT employee_number FROM employee WHERE first_name = 'Peter'), (SELECT project_number FROM project WHERE project_name = 'New financing app'));

INSERT INTO project_employee(employee_number, project_number)
VALUES ((SELECT employee_number FROM employee WHERE first_name = 'Samantha'), (SELECT project_number FROM project WHERE project_name = 'Employee portal'));
INSERT INTO project_employee(employee_number, project_number)
VALUES ((SELECT employee_number FROM employee WHERE first_name = 'Wade'), (SELECT project_number FROM project WHERE project_name = 'Employee portal'));
INSERT INTO project_employee(employee_number, project_number)
VALUES ((SELECT employee_number FROM employee WHERE first_name = 'Steve'), (SELECT project_number FROM project WHERE project_name = 'Employee portal'));
