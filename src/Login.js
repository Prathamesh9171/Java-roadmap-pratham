import React, { useState } from "react";
import { login } from "./api/studentApi";

function Login({ setToken }) {

  const [form, setForm] = useState({
    username: "",
    password: ""
  });

  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    login(form)
      .then((res) => {
        const token = res.data.token;
        localStorage.setItem("token", token);
        setToken(token);
      })
      .catch(() => alert("Invalid login"));
  };

  return (
    <div>
      <h2>Login</h2>

      <form onSubmit={handleSubmit}>
        <input
          name="username"
          placeholder="Username"
          onChange={handleChange}
        />

        <input
          name="password"
          placeholder="Password"
          type="password"
          onChange={handleChange}
        />

        <button type="submit">Login</button>
      </form>
    </div>
  );
}

export default Login;