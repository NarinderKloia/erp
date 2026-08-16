package com.navi.erp.Service;

import java.util.List;

import com.navi.erp.Dto.CreateTimetableDto;
import com.navi.erp.Entity.TimeTable;

/**
 * TimetableService
 */
public interface TimetableService {

     public TimeTable createTimetable(CreateTimetableDto dto) ;
     List<TimeTable> getAllTimetables();
}