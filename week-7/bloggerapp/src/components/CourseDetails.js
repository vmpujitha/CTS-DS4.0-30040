const CourseDetails = ({ courses }) => {
  return (
    <div className="course-list">
      {courses && courses.length > 0 ? (
        <ul>
          {courses.map((course) => (
            <li key={course.id} className="course-item">
              <h3>{course.name}</h3>
              <p>Date: {course.date}</p>
              <p>Rating: {course.rating}</p>
            </li>
          ))}
        </ul>
      ) : (
        <p className="no-courses">No courses available</p>
      )}
    </div>
  );
};

export default CourseDetails;