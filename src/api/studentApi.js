import axios from "axios";

const API_URL = "http://localhost:8080/api/v1/students";

// Get all students
export const getStudents = () => {
  return axios.get(API_URL);
};

// Add a new student
export const addStudent = (student) => {
  return axios.post(API_URL, student);
};

// Delete student by roll number
export const deleteStudent = (roll) => {
  return axios.delete(`${API_URL}/${roll}`);
};

// Search students by name
export const searchStudents = (name) => {
  return axios.get(`${API_URL}/search`, {
    params: { name }
  });
};