use classicmodels;
show databases;
USE classicmodels;
SELECT * FROM customers;
SELECT lastName
FROM employees;
SELECT lastname, firstname, jobtitle
FROM employees;
SELECT * 
FROM employees;
SELECT
	contactLastname,
	contactFirstname
FROM
	customers
ORDER BY /* 데이터 정렬, default 값은 오름차순(asc), 내림차순은 (desc) */
	contactLastname;
SELECT
	contactLastname,
	contactFirstname
FROM
	customers;
SELECT
	contactLastname,
	contactFirstname
FROM
	customers
ORDER BY
	contactLastname DESC;
SELECT
	contactLastname,
	contactFirstname
FROM
	customers
ORDER BY
	contactLastname DESC,
	contactFirstname ASC;
SELECT 
    orderNumber, 
    orderlinenumber, 
    quantityOrdered * priceEach
FROM
    orderdetails
ORDER BY 
   quantityOrdered * priceEach DESC;
SELECT /* 테이블 이름을 임의의 함수명으로 지정해서 사용할 때 : 테이블명(or 계산식) as 함수명. as 생략 가능 */
    orderNumber, 
    orderlinenumber, 
    quantityOrdered * priceEach as subtotal
FROM
    orderdetails
ORDER BY 
   subtotal DESC;
SELECT 
    orderNumber, 
    status
FROM
    orders
ORDER BY /*FIELD(속성, '') 의 경우, 사용자가 지정하는 ''의 순서대로 변수 출력 */
    FIELD(status,
        'In Process',
        'On Hold',
        'Cancelled',
        'Resolved',
        'Disputed',
        'Shipped');
SELECT 
    lastname, 
    firstname, 
    jobtitle
FROM
    employees
WHERE /* 속성 jobtitle 값이 'sales rep'인 것만 출력 */
    jobtitle = 'Sales Rep';
SELECT 
    lastname, 
    firstname, 
    jobtitle,
    officeCode
FROM
    employees
WHERE /* 속성 jobtitle의 값이 'sales rep' 이고, officeCode가 '1'인 것만 출력 */
    jobtitle = 'Sales Rep' AND 
    officeCode = 1;
SELECT 
    lastName, 
    firstName, 
    jobTitle, 
    officeCode
FROM
    employees
WHERE
    jobtitle = 'Sales Rep' OR 
    officeCode = 1
ORDER BY 
    officeCode, 
    jobTitle;
SELECT 
    firstName, 
    lastName, 
    officeCode
FROM
    employees
WHERE /* 속성 between A and B : 속성 중에서 A에서 B까지 */
    officeCode BETWEEN 1 AND 3
ORDER BY officeCode;
SELECT 
    firstName, 
    lastName
FROM
    employees
WHERE /* 속성 like '%~~' : 속성 중에서 '~~'라는 값을 포함한 것들 출력 (%son의 경우, son, wilson, thopmson, patterson 등등 son이 포함되면 다 출력 가능). 속성 like _~~ ~~라는 값은 정확히 포함하면서 _의 한 글자가 다른 값 */
    lastName LIKE '%son'
ORDER BY firstName;
SELECT 
    firstName, 
    lastName, 
    officeCode
FROM
    employees
WHERE /* 속성 IN (값) : 속성에 (값)을 포함하면 TRUE */
    officeCode IN (1 , 2, 3)
ORDER BY 
    officeCode;
SELECT 
    lastname, 
    firstname, 
    jobtitle
FROM
    employees
WHERE /* <>는 !=와 같은 의미 */
    jobtitle <> 'Sales Rep';
SELECT /* distinct 중복된 값들은 하나만 출력. 속성명 앞에 쓰기 */
    DISTINCT lastname
FROM
    employees
ORDER BY 
    lastname;
SELECT DISTINCT state
FROM customers;
SELECT DISTINCT /* distinct 뒤에 여러 값이 있는 경우, state가 중복이어도 city 값이 다르면 출력 */
    state, city
FROM
    customers
WHERE /* 조건절, state 값이 null이 아닌 것들만 출력 */
    state IS NOT NULL
ORDER BY 
    state, 
    city;
SELECT 
    state
FROM
    customers
GROUP BY state; /* state 속성의 값을 그룹지어서 출력. 8.0 버전 이상에서는 distinct와 차이 없음 */

SELECT /* 중복을 제외한 state의 개수 출력 */
    COUNT(DISTINCT state)
FROM
    customers
WHERE
    country = 'USA';
SELECT 
    DISTINCT state
FROM
    customers
WHERE
    country = 'USA';
SELECT DISTINCT
    state
FROM
    customers
WHERE
    state IS NOT NULL
LIMIT 5; /* 갯수 제한 */

SELECT /* concat_ws 문자속성을 결합하여 출력 */
    CONCAT_WS(', ', lastName, firstname) AS 'Full name'
FROM
    employees;
SELECT
	orderNumber `Order no.`,
	SUM(priceEach * quantityOrdered) total
FROM
	orderDetails
GROUP BY
	`Order no.`
HAVING /* 그룹의 조건. total이 60000이 넘는 것들만 order no로 그룹짓겠다 */
	total > 60000;
    
SELECT
	priceEach * quantityOrdered
FROM
	orderDetails
WHERE
	orderNumber = 10165;
SELECT
	SUM(priceEach * quantityOrdered)
FROM
	orderDetails
WHERE
	orderNumber = 10165;
    
SELECT
	customerName,
	COUNT(o.orderNumber) total
FROM
	customers c
INNER JOIN orders o ON c.customerNumber = o.customerNumber
GROUP BY
	customerName
ORDER BY
	total DESC;



CREATE TABLE members (
    member_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (member_id)
);

CREATE TABLE committees (
    committee_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (committee_id)
);
INSERT INTO members(name)
VALUES('John'),('Jane'),('Mary'),('David'),('Amelia');

INSERT INTO committees(name)
VALUES('John'),('Mary'),('Amelia'),('Joe');

SELECT * FROM members;
SELECT * FROM committees;

/* 테이블 결합시 JOIN을 사용. JOIN 사용하는 테이블 간에 같은 속성이 존재해야 결합 가능. */
/* INNER JOIN은 두 테이블 간의 공통 속성 출력 */
SELECT 
    m.member_id, 
    m.name as member,
    c.committee_id, 
    c.name as committee
FROM
    members m
INNER JOIN committees c USING(name);
/* LEFT JOIN, RIGHT JOIN의 경우, 테이블1과 테이블2를 결합하는데 LEFT는 테이블1의 값을 전부 출력&테이블2는 테이블1과의 공통값만 출력, RIGHT는 테이블2의 값을 전부 출력&테이블1은 테이블2와의 공통값만 출력 */
SELECT 
    m.member_id, 
    m.name as member, 
    c.committee_id, 
    c.name as committee
FROM
    members m
LEFT JOIN committees c USING(name);

select * from products;
select * from productlines;


SELECT /* products 테이블t1과 productlines 테이블 t2을 결합하여, productline 값이 같은 것들의 productcode, productname, textdescription을 출력*/
    productCode, 
    productName, 
    textDescription
FROM
    products t1
INNER JOIN productlines t2 
    ON t1.productline = t2.productline;


select * from orders;
select * from orderdetails;

SELECT 
    t1.orderNumber,
    t1.status,
    SUM(quantityOrdered * priceEach) total
FROM
    orders t1
INNER JOIN orderdetails t2 
    ON t1.orderNumber = t2.orderNumber
GROUP BY orderNumber;

SELECT 
    orderNumber,
    status,
    SUM(quantityOrdered * priceEach) total
FROM
    orders
INNER JOIN orderdetails USING (orderNumber)
GROUP BY orderNumber;


SELECT 
    orderNumber,
    orderDate,
    orderLineNumber,
    productName,
    quantityOrdered,
    priceEach
FROM
    orders
INNER JOIN
    orderdetails USING (orderNumber)
INNER JOIN
    products USING (productCode)
ORDER BY  /* orderNumber를 오름차순으로 정렬하고, orderNumber 값이 같은 것들은 orderLineNumber로 다시 오름차순 정렬. */
    orderNumber, 
    orderLineNumber;
        
SELECT 
    status, COUNT(*)
FROM
    orders
GROUP BY status;

SELECT /* ordernumber를 매개로 orders와 orderdetails를 결합하고, status를 기준으로 그룹을 지어서, status와 amount를 출력 */
    status, 
    SUM(quantityOrdered * priceEach) AS amount
FROM
    orders
INNER JOIN orderdetails 
    USING (orderNumber)
GROUP BY 
    status;

SELECT 
    orderNumber,
    SUM(quantityOrdered * priceEach) AS total
FROM
    orderdetails
GROUP BY 
    orderNumber;
    
SELECT  /* ordernumber를 매개로 orders와 orderdetails를 결합하고, status가 shipped인 것들 중에서 year를 기준으로 그룹을 지어서, year와 total를 출력 */
    YEAR(orderDate) AS year,
    SUM(quantityOrdered * priceEach) AS total
FROM
    orders
INNER JOIN orderdetails 
    USING (orderNumber)
WHERE
    status = 'Shipped'
GROUP BY 
    YEAR(orderDate);
    
SELECT 
    YEAR(orderDate) AS year,
    SUM(quantityOrdered * priceEach) AS total
FROM
    orders
INNER JOIN orderdetails 
    USING (orderNumber)
WHERE
    status = 'Shipped'
GROUP BY 
    year
HAVING 
    year > 2003;
/* WHERE와 HAVING의 차이
WHERE : FROM 뒤에 위치, 모든 필드에 조건을 둘 수 있음
HAVING : GROUP BY 뒤에 위치, GROUP화된 새 테이블 내에서 조건을 둘 수 있음 */    
    

SELECT * FROM employees;

SELECT /* CONCAT (A,',',B) AS C : C라는 속성명으로 A값과 B값을 A,B라는 형태로 결합해서 출력.*/
    CONCAT(m.lastName, ', ', m.firstName) AS Manager,
    CONCAT(e.lastName, ', ', e.firstName) AS 'Direct report'
FROM
    employees e
INNER JOIN employees m ON /*  */
    m.employeeNumber = e.reportsTo
ORDER BY /* Manager 가 있는 사람들만 출력 */
    Manager;

SELECT /* 1002의 reportsTo 값이 null인 경우, inner join을 쓰면 출력되지 않음. left join과 ifnull을 통해서 1002를 top manager로 출력 */
    IFNULL(CONCAT(m.lastname, ', ', m.firstname),
            'Top Manager') AS 'Manager',
    CONCAT(e.lastname, ', ', e.firstname) AS 'Direct report'
FROM
    employees e
LEFT JOIN employees m ON 
    m.employeeNumber = e.reportsto
ORDER BY 
    manager DESC;
    
SELECT /* subquery : select 안에 또 select가 있는 경우. offices 테이블에서 country=usa인 officecode만을 가지고 employees 테이블의 last name, first name을 출력  */
    lastName, firstName
FROM
    employees
WHERE
    officeCode IN (SELECT 
            officeCode
        FROM
            offices
        WHERE
            country = 'USA');
            
SELECT /* ROUND () : 소수점 이하는 반올림 */
    productCode, 
    ROUND(SUM(quantityOrdered * priceEach)) sales
FROM 
    orderdetails
        INNER JOIN
    orders USING (orderNumber)
WHERE
    YEAR(shippedDate) = 2003
GROUP BY productCode
ORDER BY sales DESC
LIMIT 5;

SELECT 
    productName, sales
FROM /* (SELECT ~ LIMIT 까지를 DERIVED TABLE=파생테이블이라 하고, 파생테이블은 반드시 () 후에 임의의 이름으로 명명해야함) */
    (SELECT 
        productCode, 
        ROUND(SUM(quantityOrdered * priceEach)) sales
    FROM
        orderdetails
    INNER JOIN orders USING (orderNumber)
    WHERE
        YEAR(shippedDate) = 2003
    GROUP BY productCode
    ORDER BY sales DESC
    LIMIT 5) top5products2003
INNER JOIN
    products USING (productCode);
    
/* 2003년 중에서 orderNumber를 매개로 orderdetails와 orders 테이블을 결합하고,
customerNumber 로 그룹지어서 customerNumber, sales, customerGroup 값을 출력. */
/* 보통 전년도의 구매금액을 가지고 다음 해의 고객 등급을 정할 때 사용 */
SELECT /* customerNumber, sales, customerGroup 값을 출력 */
    customerNumber,
    ROUND(SUM(quantityOrdered * priceEach)) sales,
    (CASE /* 자바의 IF/SWITCH CASE 구문과 동일. WHEN의 조건에 해당하면 THEN ~~ 로 출력.*/
        WHEN SUM(quantityOrdered * priceEach) < 10000 THEN 'Silver'
        WHEN SUM(quantityOrdered * priceEach) BETWEEN 10000 AND 100000 THEN 'Gold'
        WHEN SUM(quantityOrdered * priceEach) > 100000 THEN 'Platinum'
    END) customerGroup
FROM
    orderdetails
        INNER JOIN
    orders USING (orderNumber)
WHERE
    YEAR(shippedDate) = 2003
GROUP BY customerNumber;

select * from orders;
select * from customers;

SELECT 
    customerNumber, 
    customerName
FROM
    customers
WHERE
    EXISTS(
	SELECT 
            1
        FROM
            orders
        WHERE
            orders.customernumber 
		= customers.customernumber);
        
/* UNION (합집합) : T1 (1,2,3) T2(2,3,4) 가 있는 경우, 결과값을 중복을 제외하고 출력.(1,2,3,4)  UNIONALL : 결과값을 중복을 포함해서 모두 출력.(1,2,3,2,3,4) */
/* MINUS : T1-T2 = T1에서 T2와의 중복값을 제외하고 남아있는 값만 출력 (1) */
/* INTERSECT(교집합) : T1과 T2의 중복값만 출력 (2,3) */

CREATE TABLE IF NOT EXISTS tasks (
    task_id INT AUTO_INCREMENT, /* 자동으로 증가하며 생성. 자동으로 증가하며 생성되므로 NOT NULL 속성을 가짐. 테이블에는 1개만 존재할 수 있고, DATATYPE은 INT. 오라클에서는 SEQUENCE로 사용 */
    title VARCHAR(255) NOT NULL,
    start_date DATE,
    due_date DATE,
    priority TINYINT NOT NULL DEFAULT 3, /* 작은 정수값, NOT NULL, NULL이면 DEFAULT는 3 */
    description TEXT,
    PRIMARY KEY (task_id)
);

SHOW INDEX FROM tasks;

INSERT INTO tasks(title,priority)
VALUES('Learn MySQL INSERT Statement',1);
SELECT * FROM tasks;

INSERT INTO tasks(title,priority)
VALUES('Understanding DEFAULT keyword in INSERT statement',DEFAULT);
SELECT * FROM tasks;

INSERT INTO tasks(title, start_date, due_date)
VALUES('Insert date into table','2018-01-09','2018-09-15');
SELECT * FROM tasks;

INSERT INTO tasks(title,start_date,due_date)
VALUES('Use current date for the task',CURRENT_DATE(),CURRENT_DATE());
SELECT * FROM tasks;

INSERT INTO tasks(title, priority)
VALUES
	('My first task', 1),
	('It is the second task',2),
	('This is the third task of the week',3);
    SELECT * FROM tasks;
    
SHOW VARIABLES LIKE 'max_allowed_packet';

/* INSERT INTO tablename
SELECT ~ FROM ~ : SELECT에서 출력된 출력값을 tablename(새로운 table)에 INSERT 함 */

INSERT INTO devices(id,name) 
VALUES 
   (4,'Printer') 
ON DUPLICATE KEY UPDATE name = 'Central Printer'; /* 덮어쓰기 */



SELECT 
    firstname, 
    lastname, 
    email
FROM
    employees
WHERE
    employeeNumber = 1056;
/* WHERE절이 필수. WHERE 절을 안쓰면, 모든 email 값이 바뀜. 모든 속성값을 다 바꾸는 경우에만 WHERE 생략 */   
UPDATE employees 
SET 
    email = 'mary.patterson@classicmodelcars.com'
WHERE
    employeeNumber = 1056;
    
SELECT 
    firstname, 
    lastname, 
    email
FROM
    employees
WHERE
    employeeNumber = 1056;

/* REPLACE(속성, '변경 전 값 A-A1', '변경 후 값 A-B') : 속성의 A1값을 B값로 변경. email의 도메인처럼 특정문자만 변경 시 */    
UPDATE employees
SET email = REPLACE(email,'@classicmodelcars.com','@mysqltutorial.org')
WHERE
   jobTitle = 'Sales Rep' AND
   officeCode = 6;
   
/* DELETE도 UPDATE와 마찬가지로 WHERE절이 없으면 전체 삭제됨 */
DELETE FROM customers /* DELETE FROM 까지만 하면 해당 테이블 전부 삭제 */
WHERE country = 'France' /* DELETE FROM~ WHERE ~~ 까지 하면 ~테이블의 ~~조건인 것만 삭제 */
ORDER BY creditLimit
LIMIT 5;



use classicmodels;
select database();
drop database if exists testdb;


use classicmodels;
CREATE TABLE IF NOT EXISTS checklists (
    todo_id INT AUTO_INCREMENT,
    task_id INT,
    todo VARCHAR(255) NOT NULL,
    is_completed BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (todo_id , task_id), /* 유니크한 값이어야 하고, NOT NULL이어야 하고, 테이블 당 PRIMARY KEY는 반드시 하나 이상 존재해야함 */
    FOREIGN KEY (task_id) /* CASCADE : T2테이블에서 자동적으로 업데이트나 삭제할 경우, T1에도 적용하는 방식. SET NULL : T1에서 삭제가 되거나 업데이트가 된 경우 T2에서는 NULL 값으로.
						 RESTRICT : T1에서 업데이트나 삭제하면 T2도 영향을 받는 것을 제한하는. = NO ACTION
                         SET DEFAULT */
        REFERENCES tasks (task_id) /* tasks 테이블의 task_id 속성 */
        ON UPDATE RESTRICT /* 업데이트 제한하여 모테이블에서 task_id를 변경하더라도 같이 영향을 받아 변경되지 않도록 함 */
        ON DELETE CASCADE /* task_id를 포함하는 모테이블에서 task_id를 삭제할 경우 같이 영향을 받아 삭제됨 */
);

ALTER TABLE pkdemos /* 테이블 구조 변경 */
ADD PRIMARY KEY(id); /* 테이블에 PRIMARY KEY 추가하는 방법 */

CREATE TABLE categories(
    categoryId INT AUTO_INCREMENT PRIMARY KEY,
    categoryName VARCHAR(100) NOT NULL
)ENGINE=INNODB;

CREATE TABLE products(
    productId INT AUTO_INCREMENT PRIMARY KEY,
    productName varchar(100) not null,
    categoryId INT,
    CONSTRAINT fk_category
    FOREIGN KEY (categoryId) 
        REFERENCES categories(categoryId)
        ON UPDATE SET NULL /* 모테이블에서 categoryID를 변경할 경우, 자식테이블에서는 NULL 값으로 변경됨 */
        ON DELETE SET NULL /* 모테이블에서 categoryID를 삭제할 경우, 자식테이블에서는 NULL 값으로 변경됨 */
)ENGINE=INNODB;

CREATE TABLE suppliers (
    supplier_id INT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(15) NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL,
    PRIMARY KEY (supplier_id),
    CONSTRAINT uc_name_address UNIQUE (name , address) /* name과 address가 결합된 상태의 레코드는 유일해야하므로 묶어서 따로 네이밍하여 UNIQUE 처리 */
);

SHOW INDEX FROM suppliers;

DROP INDEX uc_name_address ON suppliers; /* suppliers 테이블에서 uc_name_address에 준 UNIQUE 속성을 지우기 */

ALTER TABLE suppliers
ADD CONSTRAINT uc_name_address 
UNIQUE (name,address); /* name과 address를 결합한 레코드인 uc_name_address를 UNIQUE 속성으로 추가하기 */

CREATE TABLE parts (
    part_no VARCHAR(18) PRIMARY KEY,
    description VARCHAR(40),
    cost DECIMAL(10,2) NOT NULL CHECK (cost >= 0), /* 따로 네이밍하지 않아도 테이블명_chk_숫자 로 네이밍됨 */
    price DECIMAL(10,2) NOT NULL CHECK (price >= 0)
);

CREATE TABLE parts (
    part_no VARCHAR(18) PRIMARY KEY,
    description VARCHAR(40),
    cost DECIMAL(10,2 ) NOT NULL CHECK (cost >= 0),
    price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
    CONSTRAINT parts_chk_price_gt_cost 
        CHECK(price >= cost) /* 공급가가 판매가보다 커야한다는 제약조건을 추가 */
);

ALTER TABLE tasks 
CHANGE 
    end_date 
    end_date DATE NOT NULL; /* 이미 만들어진 tasks라는 테이블의 end_date 레코드의 속성에 NOT NULL을 추가하고 싶을 때, 레코드명 DATATYPE NOT NULL */
    
ALTER TABLE tasks 
MODIFY 
    end_date 
    end_date DATE NOT NULL; /* 이미 만들어진 tasks라는 테이블의 end_date 레코드의 NOT NULL 속성을 없애고 싶을 때 */
    
ALTER TABLE vehicles
ADD model VARCHAR(100) NOT NULL;
    [FIRST | AFTER column_name] /* 맨처음에 추가 | column_name 이후에 추가 */

   
ALTER TABLE vehicles 
MODIFY year SMALLINT NOT NULL,
MODIFY color VARCHAR(20) NULL AFTER make; /* 기존에 만들어져있는 year, color를 수정하기 */

ALTER TABLE vehicles 
CHANGE COLUMN note vehicleCondition VARCHAR(100) NOT NULL; /* note라는 속성명을 vehicleCondition으로 바꾸기 */

ALTER TABLE vehicles
DROP COLUMN vehicleCondition; /* vehicleCondition을 지우기 */

ALTER TABLE vehicles 
RENAME TO cars; /* 테이블명을 vehicles에서 cars로 바꾸기 */



SELECT @@autocommit;
SET autocommit=off;

START TRANSACTION;

SELECT
	@orderNumber:=MAX(orderNumber)+1 /* @: 변수선언 */
FROM
	orders;
    
INSERT INTO orders(orderNumber,
                   orderDate,
                   requiredDate,
                   shippedDate,
                   status,
                   customerNumber)
VALUES(@orderNumber,
       '2005-05-31',
       '2005-06-10',
       '2005-06-11',
       'In Process',
        145);

ROLLBACK;

INSERT INTO orderdetails(orderNumber,
                         productCode,
                         quantityOrdered,
                         priceEach,
                         orderLineNumber)
VALUES(@orderNumber,'S18_1749', 30, '136', 1),
      (@orderNumber,'S18_2248', 50, '55.09', 2);

COMMIT;

SET autocommit=ON;

CREATE TABLE messages ( 
    id INT NOT NULL AUTO_INCREMENT, 
    message VARCHAR(100) NOT NULL, 
    PRIMARY KEY (id) 
);

SELECT CONNECTION_ID();

INSERT INTO messages(message) 
VALUES('Hello');

LOCK TABLE messages READ;

INSERT INTO messages(message) 
VALUES('Hi');

UNLOCK tables;

LOCK TABLE messages WRITE;

INSERT INTO messages(message) 
VALUES('Good Moring');

UNLOCK TABLES;

SELECT * FROM messages;

SELECT 
    customerName, 
    checkNumber, 
    paymentDate, 
    amount
FROM
    customers
INNER JOIN
    payments USING (customerNumber);
    

CREATE VIEW customerPayments /* SELECT 이하의 결합한 두 테이블의 결과를 자주 참조해야 할 경우, customerPayments라는 이름으로 가상의 'VIEW 테이블'을 만들어 쉽게 참조 가능. */
AS 
SELECT 
    customerName, 
    checkNumber, 
    paymentDate, 
    amount
FROM
    customers
INNER JOIN
    payments USING (customerNumber);
    
SELECT * FROM customerPayments;

EXPLAIN SELECT 
    employeeNumber, 
    lastName, 
    firstName
FROM
    employees
WHERE
    jobTitle = 'Sales Rep';

   
SHOW INDEXES FROM employees;

SHOW GRANTS FOR CURRENT_USER;