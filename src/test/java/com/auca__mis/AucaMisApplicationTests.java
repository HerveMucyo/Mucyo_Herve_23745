package com.auca__mis;

import com.auca__mis.dao.ISemesterDao;
import com.auca__mis.model.Semester;
import com.auca__mis.service.ISemesterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AucaMisApplicationTests {
	@Autowired
	private ISemesterService ISemesterService;

	@Autowired
	private ISemesterDao semesterDao;

	/*@Test
	public void testInsertSemester() {
		// Create a new Semester
		Semester semester = new Semester();
		semester.setName("Spring 2023");
		semester.setStartDate(LocalDate.of(2023, 3, 1));
		semester.setEndDate(LocalDate.of(2023, 6, 30));

		// Save the Semester
		ISemesterService.saveSemester(semester);

		// Retrieve the saved Semester from the database
		Semester savedSemester = ISemesterService.getSemesterById(semester);

		// Verify that the retrieved Semester matches the one we saved
		assertNotNull(savedSemester);
		assertEquals("Spring 2023", savedSemester.getName());
		assertEquals(LocalDate.of(2023, 3, 1), savedSemester.getStartDate());
		assertEquals(LocalDate.of(2023, 6, 30), savedSemester.getEndDate());
	}

	@Test
	public void testUpdateSemester() {
		// Create a new Semester
		Semester semester = new Semester();
		semester.setName("Fall 2023");
		semester.setStartDate(LocalDate.of(2023, 9, 1));
		semester.setEndDate(LocalDate.of(2023, 12, 31));

		// Save the Semester
		ISemesterService.saveSemester(semester);

		// Modify the Semester attributes
		semester.setName("Updated Fall 2023");
		semester.setStartDate(LocalDate.of(2023, 8, 30));

		// Update the Semester
		ISemesterService.updateSemester(semester);

		// Retrieve the updated Semester from the database
		Semester updatedSemester = ISemesterService.getSemesterById(semester);

		// Verify that the Semester was successfully updated
		assertNotNull(updatedSemester);
		assertEquals("Updated Fall 2023", updatedSemester.getName());
		assertEquals(LocalDate.of(2023, 8, 30), updatedSemester.getStartDate());
		// You can add more assertions as needed
	}
*/
	/*@Test
	public void testDeleteSemester() {
		// Create a new Semester
		Semester semester = new Semester();
		semester.setName("Winter 2024");
		semester.setStartDate(LocalDate.of(2024, 1, 1));
		semester.setEndDate(LocalDate.of(2024, 3, 31));

		// Save the Semester
		ISemesterService.saveSemester(semester);

		// Delete the Semester
		ISemesterService.deleteSemester(semester);

		// Attempt to retrieve the deleted Semester

		// Verify that the Semester was successfully deleted
		assertNull(deletedSemester);
	}
*/


}
