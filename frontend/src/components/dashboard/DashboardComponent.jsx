import React from "react";
import TopBar from "./TopBar";
import Grid from "./Grid";
import Navbar from "../Navbar";

const DashboardComponent = () => {
  return (
    <div className="border-2  bg-white rounded-lg   pb-4 shadow-lg  h-[200vh]   ">
      <Navbar />
      <Grid />
    </div>
  );
};

export default DashboardComponent;
