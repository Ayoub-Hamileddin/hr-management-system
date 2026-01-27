import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import ProtectedRoutes from "./ProtectedRoutes";
import Profile from "../pages/auth/Profile";
import Login from "../pages/auth/Login";
import Register from "../pages/auth/Register";
import Dashboard from "../pages/dashboard/Dashboard";
import { Admin } from "./Admin";
import AdminLayout from "../layout/AdminLayout";
import Employees from "../pages/employees/Employees";

const AppRouter = () => {
  return (
    <Router>
      <Routes>
        {/* public routes */}
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />

        <Route element={<ProtectedRoutes />}>
          <Route path="/profile" element={<Profile />} />
        </Route>

        {/* Route Admin */}
        <Route element={<Admin />}></Route>
        <Route path="/dashboard" element={<AdminLayout />}>
          <Route index element={<Dashboard />} />
          <Route path="employees" element={<Employees />} />
        </Route>
      </Routes>
    </Router>
  );
};

export default AppRouter;
