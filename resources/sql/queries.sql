-- :name test-create-test-table! :!
-- :command :execute
-- :result :raw
-- :doc creates a test table
CREATE TABLE
IF NOT EXISTS test_table
(
    id INTEGER PRIMARY KEY,
    test TEXT
);

-- :name test-create-test-table-two! :!
-- :command :execute
-- :result :raw
-- :doc creates a test table
CREATE TABLE
IF NOT EXISTS test_table_two
(
    id INTEGER PRIMARY KEY,
    test TEXT
);