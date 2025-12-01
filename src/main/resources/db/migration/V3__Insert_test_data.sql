INSERT INTO student (first_Name, last_Name, email, age) VALUES
('John', 'Smith', 'john@email.com', 20),
('Era', 'ZZZ', 'era@email.com', 22),
('Beka', 'K', 'mike@email.com', 21);

INSERT INTO groups (name, description) VALUES
('Computer Science', 'CS students group'),
('Mathematics', 'Math students group'),
('Physics', 'Physics students group');

INSERT INTO t_lectures (name, description) VALUES
('Java Programming', 'Introduction to Java'),
('Database Design', 'SQL and database concepts'),
('Algorithms', 'Data structures and algorithms');

INSERT INTO student_groups (student_id, groups_id) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 3);

INSERT INTO student_lectures (student_id, lectures_id) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 3);