DROP TABLE IF EXISTS boy_names;

CREATE TABLE boy_names_temp(
  first_name VARCHAR(250) NOT NULL PRIMARY KEY
);

  INSERT INTO boy_names_temp (first_name) VALUES
  ('Aliko'),
  ('Bill'),
  ('Folrunsho');