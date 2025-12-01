CREATE TABLE student_groups (
    student_id BIGINT NOT NULL,
    groups_id BIGINT NOT NULL,
    PRIMARY KEY (student_id, groups_id),
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
    FOREIGN KEY (groups_id) REFERENCES groups(id) ON DELETE CASCADE
);

CREATE TABLE student_lectures (
    student_id BIGINT NOT NULL,
    lectures_id BIGINT NOT NULL,
    PRIMARY KEY (student_id, lectures_id),
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
    FOREIGN KEY (lectures_id) REFERENCES t_lectures(id) ON DELETE CASCADE
);