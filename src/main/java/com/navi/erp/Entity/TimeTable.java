package com.navi.erp.Entity;

import java.time.LocalTime;

import com.navi.erp.Enum.Days;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "timetable")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Days day;

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    private Programs program;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Courses course;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Sections section;

    @Column(name = "start_from", nullable = false)
    private LocalTime startFrom;

    @Column(name = "end_to", nullable = false)
    private LocalTime endTo;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teachers teacher;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subjects subject;
}