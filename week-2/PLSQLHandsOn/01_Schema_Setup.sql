CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name NVARCHAR(100),
    DOB DATE,
    Balance DECIMAL(18,2),
    LastModified DATETIME,
    IsVIP CHAR(1) NULL
);
-----------------------
CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR(20),
    Balance DECIMAL(18,2),
    LastModified DATETIME,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
-----------------------------
CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY,
    AccountID INT,
    TransactionDate DATE,
    Amount DECIMAL(18,2),
    TransactionType VARCHAR(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
----------------------------
CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT,
    LoanAmount DECIMAL(18,2),
    InterestRate FLOAT,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
-----------------------------------
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name NVARCHAR(100),
    Position NVARCHAR(50),
    Salary DECIMAL(18,2),
    Department NVARCHAR(50),
    HireDate DATE
);
------------------------------------
INSERT INTO Customers VALUES (1, 'John Doe', '1985-05-15', 1000, GETDATE(), NULL);
INSERT INTO Customers VALUES (2, 'Jane Smith', '1990-07-20', 1500, GETDATE(), NULL);

INSERT INTO Accounts VALUES (1, 1, 'Savings', 1000, GETDATE());
INSERT INTO Accounts VALUES (2, 2, 'Checking', 1500, GETDATE());

INSERT INTO Transactions VALUES (1, 1, GETDATE(), 200, 'Deposit');
INSERT INTO Transactions VALUES (2, 2, GETDATE(), 300, 'Withdrawal');

INSERT INTO Loans VALUES (1, 1, 5000, 5.0, GETDATE(), DATEADD(MONTH, 60, GETDATE()));

INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', '2015-06-15');
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', '2017-03-20');
---------------------------------------------------------
--Exe1 (Error Handling)
--Sce1(SafeTransferFunds)
IF OBJECT_ID('dbo.SafeTransferFunds', 'P') IS NOT NULL
    DROP PROCEDURE dbo.SafeTransferFunds;
GO

CREATE PROCEDURE SafeTransferFunds
  @fromAcc INT,
  @toAcc INT,
  @amount DECIMAL(18,2)
AS
BEGIN
  BEGIN TRY
    BEGIN TRANSACTION;

    DECLARE @fromBalance DECIMAL(18,2);

    -- Get balance of source account
    SELECT @fromBalance = Balance FROM Accounts WHERE AccountID = @fromAcc;

    -- Check if balance is sufficient
    IF @fromBalance < @amount
    BEGIN
      RAISERROR ('Insufficient funds', 16, 1);
    END

    -- Perform the transfer
    UPDATE Accounts SET Balance = Balance - @amount WHERE AccountID = @fromAcc;
    UPDATE Accounts SET Balance = Balance + @amount WHERE AccountID = @toAcc;

    COMMIT TRANSACTION;
    PRINT 'Transfer successful';
  END TRY
  BEGIN CATCH
    ROLLBACK TRANSACTION;
    PRINT 'Error: ' + ERROR_MESSAGE();
  END CATCH
END;
GO

EXEC SafeTransferFunds 1, 2, 100;
GO

SELECT * FROM Accounts;
-----------------------------------------------------------------------------
--Sce2(UpdateSalary)

IF OBJECT_ID('dbo.UpdateSalary', 'P') IS NOT NULL
    DROP PROCEDURE dbo.UpdateSalary;
GO

CREATE PROCEDURE UpdateSalary
  @empID INT,
  @percent FLOAT
AS
BEGIN
  BEGIN TRY
    BEGIN TRANSACTION;

    -- Increase salary
    UPDATE Employees
    SET Salary = Salary + (Salary * @percent / 100)
    WHERE EmployeeID = @empID;

    -- Check if the employee exists
    IF @@ROWCOUNT = 0
    BEGIN
      RAISERROR('Employee not found', 16, 1);
    END

    COMMIT TRANSACTION;
    PRINT 'Salary updated successfully.';
  END TRY
  BEGIN CATCH
    ROLLBACK TRANSACTION;
    PRINT 'Error: ' + ERROR_MESSAGE();
  END CATCH
END;
GO

-- Increase salary of employee 1 by 10%
EXEC UpdateSalary 1, 10;
GO

-- Try with a non-existent employee (e.g., ID 999)
EXEC UpdateSalary 999, 10;
GO

SELECT * FROM Employees;

----------------------------------------------------------------------------------------
--Sce3(AddNewCustomer)
IF OBJECT_ID('dbo.AddNewCustomer', 'P') IS NOT NULL
    DROP PROCEDURE dbo.AddNewCustomer;
GO

CREATE PROCEDURE AddNewCustomer
  @id INT,
  @name NVARCHAR(100),
  @dob DATE,
  @balance DECIMAL(18,2)
AS
BEGIN
  BEGIN TRY
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (@id, @name, @dob, @balance, GETDATE());

    PRINT 'Customer added successfully.';
  END TRY
  BEGIN CATCH
    PRINT 'Error: ' + ERROR_MESSAGE();
  END CATCH
END;
GO
-- Add a new customer (ID must not exist)
EXEC AddNewCustomer 3, 'Suresh Kumar', '1980-01-01', 8000;
GO

-- Try adding the same ID again to trigger error
EXEC AddNewCustomer 3, 'Duplicate ID', '1990-01-01', 9000;
GO

SELECT * FROM Customers;
--------------------------------------
--EXE1(Control Structures)
--SCE1
-- Calculate age using DATEDIFF, loop through customers and apply 1% discount

DECLARE @CustomerID INT, @DOB DATE, @Age INT, @LoanID INT;

DECLARE CustomerCursor CURSOR FOR
SELECT c.CustomerID, c.DOB, l.LoanID
FROM Customers c
JOIN Loans l ON c.CustomerID = l.CustomerID;

OPEN CustomerCursor;
FETCH NEXT FROM CustomerCursor INTO @CustomerID, @DOB, @LoanID;

WHILE @@FETCH_STATUS = 0
BEGIN
    SET @Age = DATEDIFF(YEAR, @DOB, GETDATE());

    IF @Age > 60
    BEGIN
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = @LoanID;
    END;

    FETCH NEXT FROM CustomerCursor INTO @CustomerID, @DOB, @LoanID;
END;

CLOSE CustomerCursor;
DEALLOCATE CustomerCursor;

PRINT 'Interest rates updated for customers above 60.';
------------------------------------------
--SCE2

-- Update IsVIP to 'Y' if balance > 10000, else 'N'

DECLARE @CID INT, @BALANCE DECIMAL(18,2);

DECLARE VIPCursor CURSOR FOR
SELECT CustomerID, Balance FROM Customers;

OPEN VIPCursor;
FETCH NEXT FROM VIPCursor INTO @CID, @BALANCE;

WHILE @@FETCH_STATUS = 0
BEGIN
    IF @BALANCE > 10000
        UPDATE Customers SET IsVIP = 'Y' WHERE CustomerID = @CID;
    ELSE
        UPDATE Customers SET IsVIP = 'N' WHERE CustomerID = @CID;

    FETCH NEXT FROM VIPCursor INTO @CID, @BALANCE;
END;

CLOSE VIPCursor;
DEALLOCATE VIPCursor;

PRINT 'VIP status updated for customers.';

-----------------------------
--SCE3
-- Print reminder for loans that will end within 30 days

DECLARE @CustName NVARCHAR(100), @EndDate DATE;

DECLARE ReminderCursor CURSOR FOR
SELECT c.Name, l.EndDate
FROM Loans l
JOIN Customers c ON c.CustomerID = l.CustomerID
WHERE l.EndDate <= DATEADD(DAY, 30, GETDATE());

OPEN ReminderCursor;
FETCH NEXT FROM ReminderCursor INTO @CustName, @EndDate;

WHILE @@FETCH_STATUS = 0
BEGIN
    PRINT 'Reminder: Loan for ' + @CustName + ' is due on ' + CONVERT(VARCHAR, @EndDate, 106);
    FETCH NEXT FROM ReminderCursor INTO @CustName, @EndDate;
END;

CLOSE ReminderCursor;
DEALLOCATE ReminderCursor;

SELECT * FROM Loans;
SELECT * FROM Customers;
--------------------
--EXE3(STORED PROCEDURES)
--SCE1

IF OBJECT_ID('dbo.ProcessMonthlyInterest', 'P') IS NOT NULL
    DROP PROCEDURE dbo.ProcessMonthlyInterest;
GO

--STEP 2
CREATE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
  BEGIN TRY
    BEGIN TRANSACTION;

    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT TRANSACTION;
    PRINT 'Monthly interest applied to savings accounts.';
  END TRY
  BEGIN CATCH
    ROLLBACK TRANSACTION;
    PRINT 'Error: ' + ERROR_MESSAGE();
  END CATCH
END;
GO

--TEST IT
-- Run the procedure
EXEC ProcessMonthlyInterest;

-- Check the result
SELECT * FROM Accounts WHERE AccountType = 'Savings';
------------------------
--SCE2
IF OBJECT_ID('dbo.UpdateEmployeeBonus', 'P') IS NOT NULL
    DROP PROCEDURE dbo.UpdateEmployeeBonus;
GO

CREATE PROCEDURE UpdateEmployeeBonus
  @department NVARCHAR(50),
  @bonusPercent FLOAT
AS
BEGIN
  BEGIN TRY
    BEGIN TRANSACTION;

    UPDATE Employees
    SET Salary = Salary + (Salary * @bonusPercent / 100)
    WHERE Department = @department;

    IF @@ROWCOUNT = 0
      PRINT 'No employees found in specified department.';
    ELSE
      PRINT 'Bonus applied successfully to employees in ' + @department + '.';

    COMMIT TRANSACTION;
  END TRY
  BEGIN CATCH
    ROLLBACK TRANSACTION;
    PRINT 'Error: ' + ERROR_MESSAGE();
  END CATCH
END;
GO

-- Apply 15% bonus to HR department
EXEC UpdateEmployeeBonus 'HR', 15;

-- Apply 10% bonus to IT department
EXEC UpdateEmployeeBonus 'IT', 10;

-- View results
SELECT * FROM Employees;

---------------------------
--SCE3
IF OBJECT_ID('dbo.TransferFunds', 'P') IS NOT NULL
    DROP PROCEDURE dbo.TransferFunds;
GO

CREATE PROCEDURE TransferFunds
  @fromAccountID INT,
  @toAccountID INT,
  @amount DECIMAL(18,2)
AS
BEGIN
  BEGIN TRY
    BEGIN TRANSACTION;

    DECLARE @fromBalance DECIMAL(18,2);

    -- Get balance of source account
    SELECT @fromBalance = Balance FROM Accounts WHERE AccountID = @fromAccountID;

    -- Check if account exists and has sufficient balance
    IF @fromBalance IS NULL
    BEGIN
      RAISERROR('Source account not found.', 16, 1);
    END
    ELSE IF @fromBalance < @amount
    BEGIN
      RAISERROR('Insufficient balance in source account.', 16, 1);
    END

    -- Deduct from source
    UPDATE Accounts
    SET Balance = Balance - @amount
    WHERE AccountID = @fromAccountID;

    -- Add to destination
    UPDATE Accounts
    SET Balance = Balance + @amount
    WHERE AccountID = @toAccountID;

    COMMIT TRANSACTION;
    PRINT 'Transfer completed successfully.';
  END TRY
  BEGIN CATCH
    ROLLBACK TRANSACTION;
    PRINT 'Error: ' + ERROR_MESSAGE();
  END CATCH
END;
GO

-- Transfer 200 from Account 1 to Account 2
EXEC TransferFunds 1, 2, 200;
-- Attempt to transfer too much
EXEC TransferFunds 1, 2, 100000;
-- Try from non-existing account
EXEC TransferFunds 999, 2, 50;

SELECT * FROM Accounts;

--------------------------
---EXE 4
--SCE1
IF OBJECT_ID('dbo.CalculateAge', 'FN') IS NOT NULL
    DROP FUNCTION dbo.CalculateAge;
GO

CREATE FUNCTION CalculateAge (@dob DATE)
RETURNS INT
AS
BEGIN
    RETURN DATEDIFF(YEAR, @dob, GETDATE()) -
           CASE WHEN MONTH(@dob) > MONTH(GETDATE()) 
                 OR (MONTH(@dob) = MONTH(GETDATE()) AND DAY(@dob) > DAY(GETDATE()))
                THEN 1 ELSE 0 END;
END;
GO

SELECT Name, DOB, dbo.CalculateAge(DOB) AS Age FROM Customers;
--------------------
--SCE2(CalculateMonthlyInstallment)

IF OBJECT_ID('dbo.CalculateMonthlyInstallment', 'FN') IS NOT NULL
    DROP FUNCTION dbo.CalculateMonthlyInstallment;
GO

CREATE FUNCTION CalculateMonthlyInstallment (
  @loanAmount DECIMAL(18,2),
  @annualInterestRate FLOAT,
  @loanDurationYears INT
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    DECLARE @monthlyRate FLOAT = @annualInterestRate / 12 / 100;
    DECLARE @months INT = @loanDurationYears * 12;

    IF @monthlyRate = 0
        RETURN @loanAmount / @months;

    RETURN (@loanAmount * @monthlyRate * POWER(1 + @monthlyRate, @months)) /
           (POWER(1 + @monthlyRate, @months) - 1);
END;
GO

-- Example: Loan 5000, 5% annual interest, 5 years
SELECT dbo.CalculateMonthlyInstallment(5000, 5, 5) AS EMI;
----------------------------------------
--SCE3
IF OBJECT_ID('dbo.HasSufficientBalance', 'FN') IS NOT NULL
    DROP FUNCTION dbo.HasSufficientBalance;
GO

CREATE FUNCTION HasSufficientBalance (
  @accountID INT,
  @amount DECIMAL(18,2)
)
RETURNS BIT
AS
BEGIN
    DECLARE @balance DECIMAL(18,2);

    SELECT @balance = Balance FROM Accounts WHERE AccountID = @accountID;

    IF @balance IS NULL OR @balance < @amount
        RETURN 0;

    RETURN 1;
END;
GO

SELECT dbo.HasSufficientBalance(1, 500) AS IsAllowed;
SELECT dbo.HasSufficientBalance(1, 100000) AS IsAllowed;
----------------------












