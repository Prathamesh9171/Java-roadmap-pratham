import { useEffect, useState } from "react";
import {
  getStudents,
  deleteStudent,
  searchStudents,
} from "./api/studentApi";

function App() {
  const [students, setStudents] = useState([]);
  const [search, setSearch] = useState("");

  useEffect(() => {
    fetchStudents();
  }, []);

  const fetchStudents = async () => {
    try {
      const response = await getStudents();
      setStudents(response.data);
    } catch (error) {
      console.error("Error fetching students:", error);
    }
  };

  // 🔍 Search handler
  const handleSearch = () => {
    if (search.trim() === "") {
      fetchStudents();
      return;
    }

    searchStudents(search)
      .then((res) => setStudents(res.data))
      .catch((err) => console.error(err));
  };

  // ❌ Delete handler
  const handleDelete = (roll) => {
    deleteStudent(roll)
      .then(() => fetchStudents())
      .catch((err) => console.error(err));
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Student List</h2>

      {/* 🔍 Search UI */}
      <input
        type="text"
        placeholder="Search by name"
        value={search}
        onChange={(e) => setSearch(e.target.value)}
      />
      <button onClick={handleSearch}>Search</button>

      {students.length === 0 ? (
        <p>No students found</p>
      ) : (
        <table border="1" cellPadding="10">
          <thead>
            <tr>
              <th>Roll</th>
              <th>Name</th>
              <th>Marks</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {students.map((student) => (
              <tr key={student.roll}>
                <td>{student.roll}</td>
                <td>{student.name}</td>
                <td>{student.marks}</td>
                <td>
                  <button onClick={() => handleDelete(student.roll)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default App;