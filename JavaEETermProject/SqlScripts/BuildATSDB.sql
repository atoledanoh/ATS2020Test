	CREATE DATABASE ATS;

USE ATS;

-- Create Address Table
CREATE TABLE Address (
	AddressID		INT PRIMARY KEY AUTO_INCREMENT,
    StreetAddress	VARCHAR(255) NOT NULL,
    City			VARCHAR(255) NOT NULL,
    State			VARCHAR(255) NOT NULL,
    Zip				VARCHAR(255) NOT NULL,
    Created_On		timestamp
);

-- Create Client Table
CREATE TABLE Client (
	ClientID		INT PRIMARY KEY AUTO_INCREMENT,
    Name			VARCHAR(255) NOT NULL,
    Address			INT NOT NULL,
    Phone			VARCHAR(255) NULL,
    Created_On		timestamp,
    FOREIGN KEY(Address) REFERENCES Address(AddressID)
);

-- Create Team Table
CREATE TABLE Team (
	TeamID			INT PRIMARY KEY AUTO_INCREMENT,
    TeamName		VARCHAR(255) NOT NULL,
    IsOnCallTeam	BIT NOT NULL,
    IsDeleted		BIT NOT NULL,
    Created_On		timestamp
);

-- Create Client Table
CREATE TABLE Job (
	JobID			INT PRIMARY KEY AUTO_INCREMENT,
    Client			INT NOT NULL,
    StartTime		TIMESTAMP NOT NULL,
    EndTime			TIMESTAMP NULL,
    IsOnSite		BIT NOT NULL,
    IsCompleted		BIT NOT NULL,
    Team			INT NULL,
    Created_On		timestamp,
    FOREIGN KEY(Client) REFERENCES Client(ClientID),
    FOREIGN KEY(Team) REFERENCES Team(TeamID)
);

-- Create Employee Table
CREATE TABLE Employee (
	EmployeeID		INT PRIMARY KEY AUTO_INCREMENT,
    FirstName		VARCHAR(255) NOT NULL,
	LastName		VARCHAR(255) NOT NULL,
    SIN				INT NOT NULL,
    PayRate			FLOAT NOT NULL,
    Created_On		timestamp
);

-- Populating Employee Table
INSERT INTO Employee (FirstName, LastName, SIN, PayRate, Created_On)
VALUES
	('Gonzalo', 'Collantes', 741258963, 12.34, current_timestamp()),
    ('Pedro', 'Paramo', 987456321, 98.56, current_timestamp()),
    ('Paquita', 'Barrio', 258963147, 45.74, current_timestamp()),
    ('Adonay', 'Gonzalez', 147963258, 85.41, current_timestamp())
;

-- Create Task Table
CREATE TABLE Task (
	TaskID			INT PRIMARY KEY AUTO_INCREMENT,
    TaskName		VARCHAR(255) NOT NULL,
    Description		VARCHAR(255) NOT NULL,
    TimeToComplete	INT NOT NULL,
    Created_On		timestamp
);

-- Insert Known Values Into Task Table --  TODO: Find the actual time in minutes for these tasks or set null
INSERT INTO Task (TaskName, Description, TimeToComplete, Created_On)
VALUES
	('Network Design', 'Designing Networks', 60, current_timestamp()),
    ('Network Security', 'Securing Networks', 60, current_timestamp()),
    ('Router Configuration', 'Configuring Routers', 60, current_timestamp()),
    ('Switch Configuration', 'Configuring Switches', 60, current_timestamp()),
    ('Server Build and Repair', 'Building and Repairing Servers', 60, current_timestamp()),
    ('Server OS Installations', 'Installing Server OS', 60, current_timestamp()),
    ('Server OS Support', 'Supporting Server OS', 60, current_timestamp()),
    ('DevOps', 'DevOping', 60, current_timestamp()),
    ('Desktop and Mobile hardware build and repair', 'Building and Repairing Desktop and Mobile Hardware', 60, current_timestamp())
;

-- Create Team_Employee Linking Table
CREATE TABLE Team_Employee (
	Employee		INT,
    Team			INT,
    Created_On		timestamp,
    PRIMARY KEY(Employee, Team),
    FOREIGN KEY(Employee) REFERENCES Employee(EmployeeID),
    FOREIGN KEY(Team) REFERENCES Team(TeamID)
);

-- Create Employee_Skill Linking Table
CREATE TABLE Employee_Skill (
	Employee		INT,
    Skill			INT,
    Created_On		timestamp,
    PRIMARY KEY(Employee, Skill),
    FOREIGN KEY(Employee) REFERENCES Employee(EmployeeID),
    FOREIGN KEY(Skill) REFERENCES Task(TaskID)
);

-- Create Job_Task Linking Table
CREATE TABLE Job_Task (
	Job				INT,
    Task			INT,
    Employee		INT,
    Created_On		timestamp,
    PRIMARY KEY(Job, Task),
    FOREIGN KEY(Job) REFERENCES Job(JobID),
    FOREIGN KEY(Task) REFERENCES Task(TaskID),
    FOREIGN KEY(Employee) REFERENCES Employee(EmployeeID)
);

-- Beware! There Be Stored Procedures Beyond This Point...

-- Simple Test Stored Procedure To Make Sure its Working
DELIMITER //
CREATE PROCEDURE spTask_ListAllTasks()
BEGIN
    SELECT * FROM Task;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE spEmployee_ListAllEmployees()
BEGIN
    SELECT * FROM Employee;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE spTask_AddTask(
	IN taskName VARCHAR(255),
    IN description VARCHAR(255),
    IN timeToComplete INT
)
BEGIN
    INSERT INTO Task (TaskName, Description, TimeToComplete, Created_On)
    VALUES (taskName, description, timeToComplete, current_timestamp());
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE spEmployee_AddEmployee(
	IN firstName VARCHAR(255),
    IN lastName VARCHAR(255),
    IN SIN INT,
	IN payRate FLOAT
)
BEGIN
    INSERT INTO Employee (FirstName, LastName, SIN, PayRate, Created_On)
    VALUES (firstName, lastName, SIN, payRate, current_timestamp());
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE spEmployee_ListUnassignedEmployees()
BEGIN
    select * from employee
		where employee.employeeID not in (
				select employeeID from employee inner join team_employee
					on employee.EmployeeID = team_employee.employee
						inner join team
							on team_employee.team = team.teamID
							where team.teamID in (select TeamID from team where IsDeleted is false)
		);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE spTask_GetTask(
	IN taskID INT
)
BEGIN
    SELECT * FROM Task
    WHERE Task.TaskID = taskID;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE spEmployee_GetEmployee(
	IN employeeID INT
)
BEGIN
    SELECT * FROM Employee
    WHERE Employee.EmployeeID = employeeID;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE spEmployee_GetEmployeesOnTeam(
	IN TeamID INT
)
BEGIN
    select
		Employee.EmployeeID,
		Employee.FirstName,
		Employee.LastName,
		Employee.SIN,
		Employee.PayRate
	from Employee inner join Team_Employee
		on Employee.EmployeeID = Team_Employee.Employee
			inner join Team
				ON Team_Employee.Team = Team.TeamID
	where Team.TeamID = TeamID;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE spTeam_ListAllTeams()
BEGIN
    SELECT * FROM Team;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE spTeam_GetTeam(
	IN teamID INT
)
BEGIN
    SELECT * FROM Team
    WHERE Team.TeamID = teamID;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE spTeam_AddTeam(
	IN teamName VARCHAR(255),
    IN isOnCall BIT,
    IN isDeleted BIT
)
BEGIN
    INSERT INTO Team (TeamName, IsOnCallTeam, IsDeleted, Created_On)
    VALUES (teamName, isOnCall, isDeleted, current_timestamp());
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE spTeamEmployee_AddEmployeeToTeam(
	IN employeeID INT,
    IN teamID INT
)
BEGIN
    INSERT INTO Team_Employee (Employee, Team, Created_On)
    VALUES (employeeID, teamID, current_timestamp());
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE spTask_DeleteTask(
	IN task INT
)
BEGIN
    delete from Task 
	where Task.TaskID = task
	AND Task.TaskID not in (
		select task from Job_Task
    )
    AND Task.TaskID not in (
		select skill from Employee_Skill
    );
END //
DELIMITER ;

-- CALL spTeam_ListAllTeams();
-- call spEmployee_ListAllEmployees();
-- call spEmployee_ListUnassignedEmployees();
-- call spEmployee_GetEmployeesOnTeam(32);



-- call spTask_DeleteTask(5);


