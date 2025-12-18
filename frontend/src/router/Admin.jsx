import React from "react";
import { useMeQuery } from "../features/auth/authApi";
import { Navigate, Outlet } from "react-router-dom";

export function Admin() {
  const { data, isError, isLoading } = useMeQuery();

  console.log(data);

  if (isLoading) {
    <p>loading ...</p>;
  }

  if (isError) {
    <Navigate to="/login" replace />;
  }

  if (data.role === "ROLE_ADMIN" || data.role === "ROLE_HR_MANAGER") {
    return <Outlet />;
  }

  return <Navigate to="/profile" />;
}
