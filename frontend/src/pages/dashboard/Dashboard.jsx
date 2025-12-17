import React from "react";
import Sidebar from "../../components/Sidebar";
import DashboardComponent from "../../components/DashboardComponent";

const Dashboard = () => {
  return (
    <div className="grid gap-4  p-4 grid-cols-[220px,_1fr] bg-stone-100 text-stone-950 ">
      <Sidebar />
      <DashboardComponent />
    </div>
  );
};

export default Dashboard;
