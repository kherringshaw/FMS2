"# FMS2" 

Database setup:



mysql> use fms;
Database changed
mysql> show tables;
+----------------------+
| Tables_in_fms        |
+----------------------+
| facility             |
| facility_use         |
| inspections          |
| maintenance_request  |
| maintenance_schedule |
| users                |
+----------------------+
7 rows in set (0.06 sec)



mysql> describe facility;
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| facilityId | int(11)      | YES  |     | NULL    |       |
| owner      | varchar(255) | YES  |     | NULL    |       |
| address1   | varchar(255) | YES  |     | NULL    |       |
| address2   | varchar(255) | YES  |     | NULL    |       |
| city       | varchar(255) | YES  |     | NULL    |       |
| state      | varchar(255) | YES  |     | NULL    |       |
| zip        | varchar(255) | YES  |     | NULL    |       |
| rate       | double       | YES  |     | NULL    |       |
| capacity   | int(11)      | YES  |     | NULL    |       |
| details    | varchar(255) | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+
10 rows in set (0.00 sec)

mysql> describe facility_use;
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| facilityId | int(11)      | YES  |     | NULL    |       |
| useId      | int(11)      | YES  |     | NULL    |       |
| tenant     | varchar(255) | YES  |     | NULL    |       |
| startDate  | date         | YES  |     | NULL    |       |
| endDate    | date         | YES  |     | NULL    |       |
| status     | varchar(255) | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+
6 rows in set (0.00 sec)

mysql> describe inspections;
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| facilityId   | int(11)      | YES  |     | NULL    |       |
| inspectId    | int(11)      | YES  |     | NULL    |       |
| description  | varchar(255) | YES  |     | NULL    |       |
| assignedTo   | varchar(255) | YES  |     | NULL    |       |
| status       | varchar(255) | YES  |     | NULL    |       |
| dateAssigned | date         | YES  |     | NULL    |       |
| dateClosed   | date         | YES  |     | NULL    |       |
+--------------+--------------+------+-----+---------+-------+
7 rows in set (0.00 sec)

mysql> describe maintenance_request;
+----------------+--------------+------+-----+---------+-------+
| Field          | Type         | Null | Key | Default | Extra |
+----------------+--------------+------+-----+---------+-------+
| facilityId     | int(11)      | YES  |     | NULL    |       |
| maintenanceId  | int(11)      | YES  |     | NULL    |       |
| maint_descript | varchar(255) | YES  |     | NULL    |       |
| status         | varchar(255) | YES  |     | NULL    |       |
| cost           | double       | YES  |     | NULL    |       |
+----------------+--------------+------+-----+---------+-------+
5 rows in set (0.00 sec)

mysql> describe maintenance_schedule;
+-------------------+--------------+------+-----+---------+-------+
| Field             | Type         | Null | Key | Default | Extra |
+-------------------+--------------+------+-----+---------+-------+
| facilityId        | int(11)      | YES  |     | NULL    |       |
| start_date        | date         | YES  |     | NULL    |       |
| end_date          | date         | YES  |     | NULL    |       |
| maint_description | varchar(255) | YES  |     | NULL    |       |
| maintenance_id    | int(11)      | YES  |     | NULL    |       |
+-------------------+--------------+------+-----+---------+-------+
5 rows in set (0.00 sec)

mysql>
