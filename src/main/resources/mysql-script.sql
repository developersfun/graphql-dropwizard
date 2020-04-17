CREATE TABLE device
( 	device_id VARCHAR(20) PRIMARY KEY NOT NULL,
	device_name VARCHAR(20),
	device_brand VARCHAR(20),
	serial_number VARCHAR(20) UNIQUE,
	model VARCHAR(20) );

INSERT INTO device
(device_id,
device_name,
device_brand,
serial_number,
model)
VALUES
( ‘MOB20200001’,
	“S7 Edge”,
	‘Samsung’,
	‘DEV001’,
	‘M001’);

INSERT INTO device VALUES
( ‘MOB20200002’,S7’,‘Samsung’,‘BIDB997F,’‘M001’);

INSERT INTO device VALUES
( ‘MOB20200003,
	‘iPhone 11 Pro’,
	’Apple’,
	‘DEV600’,
	‘M002’);

INSERT INTO device VALUES
( ‘MOB20200004’,
	‘K20 Pro’,
	‘Xiaomi’,
	‘DEV061’,
	‘M004’);

INSERT INTO device VALUES
( ‘MOB202000015,
	‘iPhone XR’,
	’Samsung’,
	‘DEV601’,
	‘M005’);