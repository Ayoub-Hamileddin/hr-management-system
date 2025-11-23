import React from "react";
import { useSelector } from "react-redux";
import { selectcurrentAccessToken } from "../features/auth/authSlice";
import { Navigate, Outlet } from "react-router-dom";

const ProtectedRoutes = () => {
  const token = useSelector(selectcurrentAccessToken);
  if (!token) {
    return <Navigate to="/login" replace />;
  }
  return <Outlet />;
};

export default ProtectedRoutes;
