import React, { useState } from "react";
import { Outlet } from "react-router-dom";
import Sidebar from "../components/Sidebar/Sidebar";
import Navbar from "../components/Navbar";

const AdminLayout = () => {
  //   const [open, setOpen] = useState();

  return (
    <div
      className={`grid gap-4  p-4 grid-cols-[220px,_1fr] bg-[#ffffff] text-stone-950 `}
    >
      <Sidebar />
      <div className="flex flex-col min-h-screen border-2  bg-white rounded-lg   pb-4 shadow-lg  h-[200vh]">
        <Navbar />
        <div className="p-8 bg-slate-50 h-[100%]">
          <Outlet />
        </div>
      </div>
    </div>
  );
};

export default AdminLayout;
