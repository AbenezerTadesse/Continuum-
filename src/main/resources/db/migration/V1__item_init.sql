CREATE TABLE ITEM(
    ITEM_ID INT AUTO_INCREMENT,
    ITEM_NAME VARCHAR(255),
    SUB_ITEM_OF_ID INT,
    PRIMARY KEY (ITEM_ID),
    FOREIGN KEY (SUB_ITEM_OF_ID) REFERENCES (ITEM_ID)
);

INSERT INTO ITEM (ITEM_ID, ITEM_NAME, SUB_ITEM_OF_ID) VALUES
  ('1', 'Item1', null),
  ('2', 'Item2', null),
  ('3', 'Item3', null),
  ('4', 'Item10', '1'),
  ('5', 'Item11', '1'),  ('6', 'Item12', '1'),
  ('7', 'Item100', '4'),  ('8', 'Item101', '4'),
  ('9', 'Item102', '4'),  ('10', 'Item30', '3'),
  ('11', 'Item31', '3'),  ('12', 'Item32', '3')
  ;