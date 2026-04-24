import React from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import Login from "../pages/auth/Login";
import Register from "../pages/auth/Register";
import AdminLayout from "../layout/AdminLayout";
import Grid from "../components/dashboard/Grid";
import Employees from "../pages/employees/Employees";
import TimeOff from "../pages/timeoff/TimeOff";
import Attendance from "../pages/attendance/Attendance";
import Payroll from "../pages/payroll/Payroll";
import Performance from "../pages/performance/Performance";
import Recruitment from "../pages/recruitment/Recruitment";
import Settings from "../pages/settings/Settings";

const AppRouter = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/dashboard" replace />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        
        <Route path="/dashboard" element={<AdminLayout />}>
          <Route index element={<Grid />} />
          <Route path="employees" element={<Employees />} />
          <Route path="timeoff" element={<TimeOff />} />
          <Route path="attendance" element={<Attendance />} />
          <Route path="payroll" element={<Payroll />} />
          <Route path="performance" element={<Performance />} />
          <Route path="recruitment" element={<Recruitment />} />
          <Route path="settings" element={<Settings />} />
        </Route>
      </Routes>
    </Router>
  );
};

export default AppRouter;
