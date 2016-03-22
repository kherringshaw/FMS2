"# FMS2" 

Database setup:<br>



mysql> use fms;<br>
Database changed<br>
mysql> show tables;<br>
+----------------------+<br>
| Tables_in_fms        |<br>
+----------------------+<br>
| facility             |<br>
| facility_use         |<br>
| inspections          |<br>
| maintenance_request  |<br>
| maintenance_schedule |<br>
| users                |<br>
+----------------------+<br>
7 rows in set (0.06 sec)<br>



mysql> describe facility;<br>
+------------+--------------+------+-----+---------+-------+<br>
| Field      | Type         | Null | Key | Default | Extra |<br>
+------------+--------------+------+-----+---------+-------+<br>
| facilityId | int(11)      | YES  |     | NULL    |       |<br>
| owner      | varchar(255) | YES  |     | NULL    |       |<br>
| address1   | varchar(255) | YES  |     | NULL    |       |<br>
| address2   | varchar(255) | YES  |     | NULL    |       |<br>
| city       | varchar(255) | YES  |     | NULL    |       |<br>
| state      | varchar(255) | YES  |     | NULL    |       |<br>
| zip        | varchar(255) | YES  |     | NULL    |       |<br>
| rate       | double       | YES  |     | NULL    |       |<br>
| capacity   | int(11)      | YES  |     | NULL    |       |<br>
| details    | varchar(255) | YES  |     | NULL    |       |<br>
+------------+--------------+------+-----+---------+-------+<br>
10 rows in set (0.00 sec)<br>

mysql> describe facility_use;<br>
+------------+--------------+------+-----+---------+-------+<br>
| Field      | Type         | Null | Key | Default | Extra |<br>
+------------+--------------+------+-----+---------+-------+<br>
| facilityId | int(11)      | YES  |     | NULL    |       |<br>
| useId      | int(11)      | YES  |     | NULL    |       |<br>
| tenant     | varchar(255) | YES  |     | NULL    |       |<br>
| startDate  | date         | YES  |     | NULL    |       |<br>
| endDate    | date         | YES  |     | NULL    |       |<br>
| status     | varchar(255) | YES  |     | NULL    |       |<br>
+------------+--------------+------+-----+---------+-------+<br>
6 rows in set (0.00 sec)<br>

mysql> describe inspections;<br>
+--------------+--------------+------+-----+---------+-------+<br>
| Field        | Type         | Null | Key | Default | Extra |<br>
+--------------+--------------+------+-----+---------+-------+<br>
| facilityId   | int(11)      | YES  |     | NULL    |       |<br>
| inspectId    | int(11)      | YES  |     | NULL    |       |<br>
| description  | varchar(255) | YES  |     | NULL    |       |<br>
| assignedTo   | varchar(255) | YES  |     | NULL    |       |<br>
| status       | varchar(255) | YES  |     | NULL    |       |<br>
| dateAssigned | date         | YES  |     | NULL    |       |<br>
| dateClosed   | date         | YES  |     | NULL    |       |<br>
+--------------+--------------+------+-----+---------+-------+<br>
7 rows in set (0.00 sec)<br>

mysql> describe maintenance_request;<br>
+----------------+--------------+------+-----+---------+-------+<br>
| Field          | Type         | Null | Key | Default | Extra |<br>
+----------------+--------------+------+-----+---------+-------+<br>
| facilityId     | int(11)      | YES  |     | NULL    |       |<br>
| maintenanceId  | int(11)      | YES  |     | NULL    |       |<br>
| maint_descript | varchar(255) | YES  |     | NULL    |       |<br>
| status         | varchar(255) | YES  |     | NULL    |       |<br>
| cost           | double       | YES  |     | NULL    |       |<br>
+----------------+--------------+------+-----+---------+-------+<br>
5 rows in set (0.00 sec)<br>

mysql> describe maintenance_schedule;<br>
+-------------------+--------------+------+-----+---------+-------+<br>
| Field             | Type         | Null | Key | Default | Extra |<br>
+-------------------+--------------+------+-----+---------+-------+<br>
| facilityId        | int(11)      | YES  |     | NULL    |       |<br>
| start_date        | date         | YES  |     | NULL    |       |<br>
| end_date          | date         | YES  |     | NULL    |       |<br>
| maint_description | varchar(255) | YES  |     | NULL    |       |<br>
| maintenance_id    | int(11)      | YES  |     | NULL    |       |<br>
+-------------------+--------------+------+-----+---------+-------+<br>
5 rows in set (0.00 sec)<br>

mysql><br>
