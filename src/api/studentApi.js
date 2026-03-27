import axios from "axios";

const API_URL = "http://localhost:8080/api/v1/students";

// GET all students
export const getStudents = () => {
  return axios.get(API_URL);
};

// ADD student
export const addStudent = (student) => {
  return axios.post(API_URL, student);
};

// DELETE student
export const deleteStudent = (roll) => {
  return axios.delete(`${API_URL}/${roll}`);
};

// SEARCH student
export const searchStudents = (name) => {
  return axios.get(`${API_URL}/search?name=${name}`);
};