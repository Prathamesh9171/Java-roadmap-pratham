import React, { useEffect, useState } from "react";
import {
  getStudents,
  addStudent,
  deleteStudent,
  searchStudents,
} from "./api/studentApi";

function App() {
  const [students, setStudents] = useState([]);

  const [form, setForm] = useState({
    roll: "",
    name: "",
    marks: "",
  });

  const [search, setSearch] = useState("");

  // Fetch all students
  const fetchStudents = () => {
    getStudents()
      .then((res) => setStudents(res.data.content))
      .catch((err) => console.error(err));
  };

  useEffect(() => {
    fetchStudents();
  }, []);

  // Handle form change
  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
  };

  // Submit form
  const handleSubmit = (e) => {
    e.preventDefault();

    addStudent(form)
      .then(() => {
        fetchStudents();
        setForm({ roll: "", name: "", marks: "" });
      })
      .catch((err) => console.error(err));
  };

  // Delete student
  const handleDelete = (roll) => {
    deleteStudent(roll)
      .then(() => fetchStudents())
      .catch((err) => console.error(err));
  };

  // Search students
  const handleSearch = () => {
    if (search === "") {
      fetchStudents();
      return;
    }

    searchStudents(search)
      .then((res) => setStudents(res.data))
      .catch((err) => console.error(err));
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>Student Management System</h1>

      {/* ADD FORM */}
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          name="roll"
          placeholder="Roll"
          value={form.roll}
          onChange={handleChange}
        />

        <input
          type="text"
          name="name"
          placeholder="Name"
          value={form.name}
          onChange={handleChange}
        />

        <input
          type="number"
          name="marks"
          placeholder="Marks"
          value={form.marks}
          onChange={handleChange}
        />

        <button type="submit">Add Student</button>
      </form>

      <br />

      {/* SEARCH */}
      <input
        type="text"
        placeholder="Search by name"
        value={search}
        onChange={(e) => setSearch(e.target.value)}
      />

      <button onClick={handleSearch}>Search</button>

      <br /><br />

      {/* LIST */}
      <ul>
        {students.map((s) => (
          <li key={s.roll}>
            {s.name} - {s.marks}

            <button
              style={{ marginLeft: "10px" }}
              onClick={() => handleDelete(s.roll)}
            >
              Delete
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;